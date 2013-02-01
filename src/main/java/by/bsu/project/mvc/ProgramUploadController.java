package by.bsu.project.mvc;

import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
import by.bsu.project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alina Glumova
 */

@Controller
public class ProgramUploadController {

    @Autowired
    private UserInfoService userInfoService;

    private static List<ProgramFilesEntity> programFilesEntityList = new ArrayList<ProgramFilesEntity>();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @RequestMapping(value = "/UploadProgram")
    public ModelAndView displayUploadFile(@RequestParam(value = "id", required = false) Long id, UserInfoEntity userInfoEntity,
                                       ProgramFilesEntity programFilesEntity, Model model) throws Exception {
        userInfoEntity = userInfoService.getStudentById(id);
        programFilesEntity = new ProgramFilesEntity();
        model.addAttribute("student",userInfoEntity);
        return new ModelAndView("UploadProgram", "program", programFilesEntity);
    }

    @RequestMapping(value = "/SaveProgram")
    public String processUploadPreview(
            @RequestParam("file") MultipartFile file,@RequestParam(value = "id", required = false) Long id,
            @ModelAttribute("UploadProgram") ProgramFilesEntity programFilesEntity) throws Exception {

        String fileName = file.getOriginalFilename();
        programFilesEntity.setUserId(id);
        programFilesEntity.setFile(file.getBytes());
        programFilesEntity.setFileName(fileName);
        programFilesEntity.setContentType(file.getContentType());
        programFilesEntityList.add(programFilesEntity);

        UserInfoEntity userInfoEntity = userInfoService.getStudentById(id);
        userInfoEntity.setProgramFiles(programFilesEntityList);

        userInfoService.save(userInfoEntity);
        return "redirect:/e-Testing/UploadProgramStatus";
    }

    @RequestMapping(value = "/UploadProgramStatus")
    public ModelAndView processUploadPreview() {

        return new ModelAndView("UploadProgramStatus");
    }
}
