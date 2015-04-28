package by.bsu.project.scheduller;

import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.antlr.util.JavaCCNodesUtil;
import by.bsu.project.antlr.util.TreeCompareUtil;
import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.general.UnsupportedLanguageException;
import by.bsu.project.javacc.util.SpacesCommentExtractor;
import by.bsu.project.service.UserInfoService;
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
public class PlagiarismRunner {
    private static final Logger logger = Logger.getLogger(PlagiarismRunner.class);
    @Autowired
    private UserInfoService userInfoService;

//    @Scheduled(cron = "0 20 * * * ?")
    @Scheduled(cron = "20 * * * * ?")
    protected void executeInternal() {
        try {
            List<ProgramFilesEntity> programs = userInfoService.getTestedProgramFiles();
            for (ProgramFilesEntity programFilesEntity : programs) {
                try {
                TreeParser parser = new TreeParser(programFilesEntity.getLang());
                List<TreeNode> nodes = parser.getTree(programFilesEntity.getFile());
                AttributeCounting ac = parser.getAc();

                SpacesCommentExtractor spacesExtractor = new SpacesCommentExtractor(programFilesEntity.getFile());
                spacesExtractor.extractSpaces(ac);

                List<ProgramFilesEntity> programFilesEntities = userInfoService.getProgramsByName(programFilesEntity);
                int plagiat1 = JavaCCNodesUtil.checkNodes(programFilesEntities, programFilesEntity);
                programFilesEntity.setAc(ac);
                ac.setEntity(programFilesEntity);

                int plagiat2 = TreeCompareUtil.checkTrees(programFilesEntities, nodes);

                programFilesEntity.setPlagiat1(plagiat1);
                programFilesEntity.setPlagiat2(plagiat2);
                programFilesEntity.setTreeContent(TreeNode.getBytes(nodes));

                programFilesEntity.setRunStatus(ETestingConstants.READY_FILE);
                userInfoService.save(programFilesEntity.getUser());
                } catch (ParseException|UnsupportedLanguageException ex) {
                    programFilesEntity.setRunStatus(ETestingConstants.FAILED_FILE);
                    userInfoService.save(programFilesEntity.getUser());
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}
