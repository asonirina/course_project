package by.bsu.project.validator;

import by.bsu.project.constants.ETestingConstants;
import by.bsu.project.constants.ErrorsMessages;
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
            errors.add(ErrorsMessages.UNLOAD_FILE);
        } else {
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));

            if (!(extension.equals(ETestingConstants.POSTFIX_C) || extension.equals(ETestingConstants.POSTFIX_CPP) ||
                    extension.equals(ETestingConstants.POSTFIX_PASCAL_P) || extension.equals(ETestingConstants.POSTFIX_PASCAL_PAS))) {
                errors.add(ErrorsMessages.VALID_OPTIONS);
            }
        }

        if (programName == null || programName.length() == 0) {
            errors.add(ErrorsMessages.PROGRAM_NAME_REQUIRED);
        }

        return errors;
    }

    public static List<String> validateLogin(String login, UserInfoService userInfoService) {
        errors.clear();

        if (userInfoService.findStudentByLogin(login) != null) {
            errors.add(ErrorsMessages.UNIQUE_LOGIN);
        }

        return errors;
    }
}
