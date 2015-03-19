package by.bsu.project.scheduller;

import by.bsu.project.service.UserInfoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * User: iason
 * Date: 19.03.15
 */
public class TestsRunnerCron extends QuartzJobBean {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(userInfoService);

    }
}
