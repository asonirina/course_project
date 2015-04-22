package by.bsu.project.scheduller;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.service.UserInfoService;
import by.bsu.project.utils.ProgramFilesUtil;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * User: iason
 * Date: 19.03.15
 */
@Component
public class TestsRunner {
    private static final Logger logger = Logger.getLogger(TestsRunner.class);
    @Autowired
    private UserInfoService userInfoService;

    @Scheduled(fixedDelay = 20000)
    protected void executeInternal () {
        try {
            List<ProgramFilesEntity> programs = userInfoService.getUploadedProgramFiles();
            for (ProgramFilesEntity programFilesEntity : programs) {
                ProgramFilesUtil programFilesUtil = new ProgramFilesUtil(programFilesEntity);
                String programStatus = programFilesUtil.checkFile() ? ETestingConstants.PASSED_STATUS : ETestingConstants.FAILED_STATUS;
                programFilesEntity.setStatus(programStatus);
                programFilesEntity.setRunStatus(ETestingConstants.TESTED_FILE);
                programFilesEntity.setTestResults(programFilesUtil.getTestResults());
                userInfoService.save(programFilesEntity.getUser());
            }
        } catch (ConfigurationException | IOException | InterruptedException ex) {
            logger.error(ex.getMessage());
        }
    }

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}
