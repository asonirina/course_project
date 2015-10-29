package by.bsu.project.mvc;

import by.bsu.project.antlr.model.SerializableUtil;
import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.PageTitles;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.Task;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.general.model.UserTask;
import by.bsu.project.paging.Paging;
import by.bsu.project.utils.JsonHelper;
import by.bsu.project.utils.MatchedFileComparator;
import by.bsu.project.utils.SourceFileComparator;
import by.bsu.project.validator.Validator;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alina Glumova
 */

@Controller
public class ProgramUploadController extends BaseController {

    private Long currentFileId;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @RequestMapping(value = "/e-Testing/student/UploadProgram")
    public ModelAndView displayUploadFile(
            UserInfoEntity userInfoEntity,
            ProgramFilesEntity programFilesEntity,
            Model model) {
        try {
            userInfoEntity = userInfoService.getStudentById(getUser().getId());
            programFilesEntity = new ProgramFilesEntity();
            model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
            Map<String, Object> params = new HashMap<>();
            params.put(ETestingConstants.MODEL_PROGRAM, programFilesEntity);
            params.put(ETestingConstants.MODEL_TITLE, PageTitles.UPLOAD_PROGRAM);
            return new ModelAndView("UploadProgram", params);
        } catch (Exception ex) {
            logger.error("Unable to display upload file page " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/student/SaveProgram")
    public ModelAndView processUploadPreview(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "studentId", required = false) Long studentId,
            @ModelAttribute("UploadProgram") ProgramFilesEntity programFilesEntity,
            Model model) throws Exception{

        try {
            UserInfoEntity userInfoEntity = userInfoService.getStudentById(studentId);
            userInfoEntity.getProgramFiles().add(programFilesEntity);
            List<String> errors = Validator.validateFile(file, programFilesEntity.getProgramName());

            if (errors.size() != 0) {
                model.addAttribute(ETestingConstants.MODEL_ERRORS, errors);
                model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
                return new ModelAndView("UploadProgram", ETestingConstants.MODEL_PROGRAM, programFilesEntity);
            }

            programFilesEntity.setUser(userInfoEntity);
            programFilesEntity.setFile(file.getBytes());
            programFilesEntity.setFileName(file.getOriginalFilename());
            programFilesEntity.setContentType(file.getContentType());
            programFilesEntity.setUploadProgramTime(new Date(System.currentTimeMillis()));
            programFilesEntity.setRunStatus(ETestingConstants.UPLOADED_FILE);

            Task task = userInfoService.getTask(programFilesEntity);
            for (UserTask userTask : programFilesEntity.getUser().getUserTasks()) {
                if (userTask.getTask().getId().equals(task.getId())) {
                    programFilesEntity.setUserTask(userTask);
                    userTask.setLastProgram(programFilesEntity);
                    userTask.incTryNo();
                    break;
                }
            }

            userInfoService.save(userInfoEntity);
            currentFileId = programFilesEntity.getId();
            return new ModelAndView("redirect:/e-Testing/student/UploadProgramStatus.html", ETestingConstants.MODEL_TITLE, PageTitles.PROGRAM_STATUS);

        } catch (Exception ex) {
            logger.error("Unable to save entity " + ex.getMessage());
            return new ModelAndView("errors/error503", ETestingConstants.MODEL_ERRORS, ex.getMessage());
        }
    }

    @RequestMapping(value = "/e-Testing/student/UploadProgramStatus")
    public ModelAndView processUploadPreview(Model model) {
        model.addAttribute(ETestingConstants.MODEL_PROGRAM, userInfoService.getFileById(currentFileId));
        model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.PROGRAM_STATUS);
        return new ModelAndView("UploadProgramStatus");
    }

    @RequestMapping(value = "/e-Testing/student/UploadProgramsHistory")
    public ModelAndView processHistoryPreview(
            @RequestParam(value = "page", required = false) Integer page,
            UserInfoEntity userInfoEntity,
            Model model) {

        try {
            userInfoEntity = userInfoService.getStudentById(getUser().getId());
            Paging paging1 = new Paging(userInfoEntity.getProgramFiles().size());
            model.addAttribute(ETestingConstants.MODEL_PROGRAM_LIST, userInfoService.programsList(
                    userInfoService.setPage(page, paging1, model), getUser().getId()));
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.PROGRAM_HISTORY);

            return new ModelAndView("UploadProgramsHistory");

        } catch (Exception ex) {
            logger.error("Unable to display upload file history page " + ex.getMessage());
            return new ModelAndView("errors/error503", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/admin/ShowGraph")
    public ModelAndView showGraph(Model model) {
        try {
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.SHOW_GRAPH);
            return new ModelAndView("graph/showGraph");
        } catch (Exception ex) {
            return new ModelAndView("errors/error503", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping("/e-Testing/admin/GetGraph")
    public ModelAndView getGraph(HttpServletResponse response) {
        try {
            JsonHelper helper = new JsonHelper();
            String json =  helper.createJson(userInfoService.studentsList());
            response.setHeader("Content-Disposition", "inline;filename=\"flare.json\"");
            response.setContentType("application/json");

            byte[] file = json.getBytes();
            response.setContentLength(file.length);

            FileCopyUtils.copy(file, response.getOutputStream());
            return null;

        } catch (Exception ex) {
            logger.error("Unable to download test results file " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/error503")
    public ModelAndView errorPage() {
        return new ModelAndView("errors/error503", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
    }

    @RequestMapping(value = "/e-Testing/Run")
    public ModelAndView script(@RequestParam(value = "command", required = false) String command ) throws Exception {

        if (command != null) {
            Process process = Runtime.getRuntime().exec(command, null);
            int result = process.waitFor();
            return new ModelAndView("RunShell", ETestingConstants.MODEL_MESSAGE, String.valueOf(result));
        }
        return new ModelAndView("RunShell");
    }

    @RequestMapping("/e-Testing/admin/DiffCode")
    public ModelAndView download(@RequestParam(value = "programId", required = false) Long programId,
                                 Model model) {
        try {
            ProgramFilesEntity programFilesEntity = userInfoService.getFileById(programId);
            if(programFilesEntity.getMatched()==null) {
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.SHOW_DIFF);
                return new ModelAndView("DiffCode");
            }
            List<int[]> map = SerializableUtil.getMap(programFilesEntity.getCompareMap());
            Collections.sort(map, new SourceFileComparator());
            String file1  = new String(programFilesEntity.getFile());
            String file2  = new String(programFilesEntity.getMatched().getFile());


//            String file1 = "12331 123131 1231313 <span style='background-color:#FF9999;'>12222222222</span>\n gggg";
//            String file2 = "<span style='background-color:#99EBC2;'>12222222222 \n mmmm</span>";


            for (int[] arr : map) {
                if (arr[0] > 0) {
                    String before = file1.substring(0, arr[0]);
                    String diff = file1.substring(arr[0], arr[1] + 1);
                    String after = file1.substring(arr[1] + 1);

                    if(arr[3] == -1) {
                        diff = String.format("<span style='background-color:#99EBC2;'>%s</span>", diff);
                    } else if(arr[3] > 0) {
                        diff = String.format("<span style='background-color:#FFFFB2;'>%s</span>", diff);
                    }
                    file1 = before + diff + after;
                } else {
                    break;
                }
            }


            Collections.sort(map, new MatchedFileComparator());

            for (int[] arr : map) {
                if (arr[2] > 0) {
                    String before = file2.substring(0, arr[2]);
                    String diff = file2.substring(arr[2], arr[3] + 1);
                    String after = file2.substring(arr[3] + 1);

                    if(arr[0] == -1) {
                        diff = String.format("<span style='background-color:#FF9999;'>%s</span>", diff);
                    } else if(arr[0] > 0) {
                        diff = String.format("<span style='background-color:#FFFFB2;'>%s</span>", diff);
                    }
                    file2 = before + diff + after;
                } else {
                    break;
                }
            }

            int height = Math.max(StringUtils.countMatches(file1, "\n"),StringUtils.countMatches(file2, "\n")) * 23;

            model.addAttribute(ETestingConstants.MODEL_FILE1, file1);
            model.addAttribute(ETestingConstants.MODEL_FILE2, file2);

            model.addAttribute(ETestingConstants.MODEL_HEIGHT,  height);

            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.SOURCE_CODE);
            return new ModelAndView("DiffCode");
        } catch (Exception ex) {
            logger.error("Unable to show diff program file " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }
}
