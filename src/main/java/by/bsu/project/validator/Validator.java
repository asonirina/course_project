package by.bsu.project.validator;

import by.bsu.project.service.UserInfoService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alina Glumova
 */

public class Validator {

    private static List<String> errors = new ArrayList<>();

    public static List<String> validateFile(MultipartFile file, String programName) {
        errors.clear();

        if (file.getSize() == 0) {
            errors.add("Загрузите файл на проверку!");
        } else {
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));

            if (!(extension.equals(".c") || extension.equals(".cpp") ||
                    extension.equals(".p") || extension.equals(".pas"))) {
                errors.add("Допустимые расширения файлов *.c, *.cpp, *.p или *.pas");
            }
        }

        if (programName == null || programName.length() == 0) {
            errors.add("Укажите название лабораторной.");
        }

        return errors;
    }

    public static List<String> validateLogin(String login, UserInfoService userInfoService) {
        errors.clear();

        if (userInfoService.findStudentByLogin(login) != null) {
            errors.add("Логин должен быть уникальным. Такой логин есть в базе.");
        }

        return errors;
    }
}
