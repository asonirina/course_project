package by.bsu.project.scheduller;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.service.UserInfoService;
import by.bsu.project.utils.ProgramFilesUtil;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * User: iason
 * Date: 19.03.15
 */
public class TestsRunnerCron extends QuartzJobBean {
    private static final Logger logger = Logger.getLogger(TestsRunnerCron.class);
    private UserInfoService userInfoService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
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
