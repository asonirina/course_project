package by.bsu.project.mvc;

import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
import by.bsu.project.service.UserInfoService;
import by.bsu.project.validator.Validator;
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

import java.util.List;

/**
 * @author Alina Glumova
 */

@Controller
public class ProgramUploadController {

    @Autowired
    private UserInfoService userInfoService;
    private List<String>    errors;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @RequestMapping(value = "/e-Testing/UploadProgram")
    public ModelAndView displayUploadFile(
            @RequestParam(value = "id", required = false) Long id,
            UserInfoEntity userInfoEntity,
            ProgramFilesEntity programFilesEntity,
            Model model) throws Exception {

        userInfoEntity = userInfoService.getStudentById(id);
        programFilesEntity = new ProgramFilesEntity();
        model.addAttribute("student",userInfoEntity);
        return new ModelAndView("UploadProgram", "program", programFilesEntity);
    }

    @RequestMapping(value = "/e-Testing/SaveProgram")
    public ModelAndView processUploadPreview(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "studentId", required = false) Long studentId,
            @ModelAttribute("UploadProgram") ProgramFilesEntity programFilesEntity,
            Model model) throws Exception {

        UserInfoEntity userInfoEntity = userInfoService.getStudentById(studentId);
        errors = Validator.validate(file, programFilesEntity.getProgramName());

        if(errors.size() != 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("student", userInfoEntity);
            return new ModelAndView("UploadProgram", "program", programFilesEntity);
        }

        programFilesEntity.setFile(file.getBytes());
        programFilesEntity.setFileName(file.getOriginalFilename());
        programFilesEntity.setContentType(file.getContentType());
        userInfoEntity.getProgramFiles().add(programFilesEntity);

        userInfoService.save(userInfoEntity);
        return new ModelAndView("redirect:/e-Testing/UploadProgramStatus.html");
    }

    @RequestMapping(value = "/e-Testing/UploadProgramStatus")
    public ModelAndView processUploadPreview() {
        return new ModelAndView("UploadProgramStatus");
    }
}
