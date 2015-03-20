package by.bsu.project.scheduller;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.service.UserInfoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;

/**
 * User: iason
 * Date: 19.03.15
 */
public class TestsRunnerCron extends QuartzJobBean {

    private UserInfoService userInfoService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<ProgramFilesEntity> programs = userInfoService.getUploadedProgramFiles();
    }

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}
