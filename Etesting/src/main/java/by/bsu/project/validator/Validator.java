package by.bsu.project.validator;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.ErrorsMessages;
import by.bsu.project.service.UserInfoService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alina Glumova
 */

public class Validator {

    private static final Integer MAX_FILE_SIZE_KB = 200;

    private static List<String> errors = new ArrayList<>();

    public static List<String> validateFile(MultipartFile file, String programName) {
        errors.clear();

        if (file.getSize() == 0) {
            errors.add(ErrorsMessages.UNLOAD_FILE);
        } else {
            if (file.getSize()/1000 > MAX_FILE_SIZE_KB) {
                errors.add(ErrorsMessages.INVALID_SIZE_OF_FILE);
            }

            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));

            if (!(extension.equals(ETestingConstants.POSTFIX_JAVA) ||extension.equals(ETestingConstants.POSTFIX_C) || extension.equals(ETestingConstants.POSTFIX_CPP) ||
                    extension.equals(ETestingConstants.POSTFIX_PASCAL_P) || extension.equals(ETestingConstants.POSTFIX_PASCAL_PAS))) {
                errors.add(ErrorsMessages.VALID_OPTIONS);
            }
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
