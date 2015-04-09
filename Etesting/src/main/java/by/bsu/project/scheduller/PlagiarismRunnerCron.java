package by.bsu.project.scheduller;

import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.antlr.util.AttributeCountingUtil;
import by.bsu.project.antlr.util.TreeCompareUtil;
import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.service.UserInfoService;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * User: iason
 * Date: 19.03.15
 */
@Component
public class PlagiarismRunnerCron {
    private static final Logger logger = Logger.getLogger(PlagiarismRunnerCron.class);
    @Autowired
    private UserInfoService userInfoService;

    @Scheduled(fixedDelay = 20000)
    protected void executeInternal() {
        try {
            List<ProgramFilesEntity> programs = userInfoService.getTestedProgramFiles();
            for (ProgramFilesEntity programFilesEntity : programs) {
                TreeParser parser = new TreeParser(programFilesEntity.getLang());
                List<TreeNode> nodes = parser.getTree(programFilesEntity.getFile());
                AttributeCounting ac = parser.getAc();

                int plagiat1 = AttributeCountingUtil.checkAC(userInfoService.getProgramsByName(programFilesEntity), ac);
                programFilesEntity.setAc(ac);
                ac.setEntity(programFilesEntity);

                int plagiat2 = TreeCompareUtil.checkTrees(userInfoService.getProgramsByName(programFilesEntity), nodes);

                programFilesEntity.setPlagiat1(plagiat1);
                programFilesEntity.setPlagiat2(plagiat2);
                programFilesEntity.setTreeContent(TreeNode.getBytes(nodes));

                programFilesEntity.setRunStatus(2);
                userInfoService.save(programFilesEntity.getUser());
            }
        } catch (IOException ex) {
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
