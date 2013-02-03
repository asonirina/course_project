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

/**
 * @author Alina Glumova
 */

@Controller
public class ProgramUploadController {

    @Autowired
    private UserInfoService userInfoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @RequestMapping(value = "/e-Testing/UploadProgram")
    public ModelAndView displayUploadFile(@RequestParam(value = "id", required = false) Long id, UserInfoEntity userInfoEntity,
                                       ProgramFilesEntity programFilesEntity, Model model) throws Exception {
        userInfoEntity = userInfoService.getStudentById(id);
        programFilesEntity = new ProgramFilesEntity();
        model.addAttribute("student",userInfoEntity);
        return new ModelAndView("UploadProgram", "program", programFilesEntity);
    }

    @RequestMapping(value = "/e-Testing/SaveProgram")
    public String processUploadPreview(
            @RequestParam("file") MultipartFile file,@RequestParam(value = "studentId", required = false) Long studentId,
            @ModelAttribute("UploadProgram") ProgramFilesEntity programFilesEntity) throws Exception {

        programFilesEntity.setFile(file.getBytes());
        programFilesEntity.setFileName(file.getOriginalFilename());
        programFilesEntity.setContentType(file.getContentType());
        UserInfoEntity userInfoEntity = userInfoService.getStudentById(studentId);
        userInfoEntity.getProgramFiles().add(programFilesEntity);

        userInfoService.save(userInfoEntity);
        return "redirect:/e-Testing/UploadProgramStatus.html";
    }

    @RequestMapping(value = "/e-Testing/UploadProgramStatus")
    public ModelAndView processUploadPreview() {
        return new ModelAndView("UploadProgramStatus");
    }
}
