package by.bsu.project.scheduller;

import by.bsu.project.checker.ProgramsChecker;
import by.bsu.project.checker.ProgramsCheckerFactory;
import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.Task;
import by.bsu.project.general.model.UserTask;
import by.bsu.project.service.UserInfoService;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static by.bsu.project.general.constants.ETestingConstants.UserTaskStatus;

/**
 * User: iason
 * Date: 19.03.15
 */
@Component
public class TestsRunner {
    private static final Logger logger = Logger.getLogger(TestsRunner.class);
    @Autowired
    private UserInfoService userInfoService;

//    @Scheduled(cron = "0 0 * * * ?")
@Scheduled(cron = "0 * * * * ?")

    protected void executeInternal () {
        try {
            List<ProgramFilesEntity> programs = userInfoService.getUploadedProgramFiles();
            for (ProgramFilesEntity programFilesEntity : programs) {
                Task task = userInfoService.getTask(programFilesEntity);
                ProgramsChecker checker = ProgramsCheckerFactory.createChecker(programFilesEntity, task);
                UserTaskStatus programStatus = checker.check() ? UserTaskStatus.PASSED : UserTaskStatus.FAILED;
                programFilesEntity.setStatus(programStatus.getName());
                programFilesEntity.setRunStatus(ETestingConstants.TESTED_FILE);
                programFilesEntity.setTestResults(checker.getTestResults());
                for (UserTask userTask : programFilesEntity.getUser().getUserTasks()) {
                    if (userTask.getTask().getId().equals(task.getId())) {
                        userTask.setStatus(programStatus.getId());
                    }
                }
                userInfoService.save(programFilesEntity.getUser());
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}
