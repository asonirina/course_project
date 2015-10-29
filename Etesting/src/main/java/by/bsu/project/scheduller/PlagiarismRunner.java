package by.bsu.project.scheduller;

import by.bsu.project.antlr.model.SerializableUtil;
import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.antlr.util.AttributeCountingUtil;
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
import java.util.Map;

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
                    int plagiat1 = AttributeCountingUtil.checkAttributes(programFilesEntities, ac);
                    programFilesEntity.setAc(ac);
                    ac.setEntity(programFilesEntity);

                    Map<String, Object> map = TreeCompareUtil.checkTrees(programFilesEntities, nodes);
                    int plagiat2 = (Integer) map.get("max");
                    List<int[]> compareMap = (List<int[]>) map.get("compare");
                    ProgramFilesEntity matched = (ProgramFilesEntity) map.get("matched");

                    programFilesEntity.setPlagiat1(plagiat1);
                    programFilesEntity.setPlagiat2(plagiat2);
                    programFilesEntity.setTreeContent(SerializableUtil.getTreeBytes(nodes));
                    programFilesEntity.setCompareMap(SerializableUtil.getMapBytes(compareMap));
                    programFilesEntity.setMatched(matched);

                    programFilesEntity.setRunStatus(ETestingConstants.READY_FILE);
                    userInfoService.save(programFilesEntity.getUser());
                } catch (ParseException | UnsupportedLanguageException ex) {
                    programFilesEntity.setRunStatus(ETestingConstants.FAILED_FILE);
                    userInfoService.save(programFilesEntity.getUser());
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}
