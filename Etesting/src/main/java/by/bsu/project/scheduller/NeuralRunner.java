package by.bsu.project.scheduller;

import by.bsu.project.general.constants.FieldToLoad;
import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.NeuralNode;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: iason
 * Date: 19.03.15
 */
@Component
public class NeuralRunner {
    @Autowired
    private UserInfoService userInfoService;

    //    @Scheduled(cron = "0 40 * * * ?")
    @Scheduled(cron = "40 * * * * ?")
    protected void executeInternal() {
        List<UserInfoEntity> users = userInfoService.studentsList(FieldToLoad.NEURAL_NODE);
        List<ProgramFilesEntity> programs = userInfoService.getReadyProgramFiles();
        for (ProgramFilesEntity programFilesEntity : programs) {
            AttributeCounting ac = programFilesEntity.getAc();
            NeuralNode checkingNode = createNeuralNode(ac);
            UserInfoEntity winner = users.get(0);
            int measure = Integer.MAX_VALUE;
            for (UserInfoEntity entity : users) {
                NeuralNode node = entity.getNeuralNode();
                int temp = getDiff(node, checkingNode);
                if (temp <= measure) {
                    measure = temp;
                    winner = entity;
                }
            }
            if (winner.getId().equals(programFilesEntity.getUser().getId())) {
                double h = Math.sqrt(1.0 / ac.getId());
                changeWinner(winner.getNeuralNode(), checkingNode, h);
                userInfoService.save(winner);
            }
            programFilesEntity.setRunStatus(3);
            programFilesEntity.setCluster(winner.getNeuralNode().getId());
            userInfoService.save(programFilesEntity.getUser());
        }
    }

    private void changeWinner(NeuralNode winner, NeuralNode current, double h) {
        winner.incSpaces((int)h * (current.getSpaces() - winner.getSpaces()));
        winner.incTabs((int)h * (current.getTabs() - winner.getTabs()));
        winner.incIdent((int)h * (current.getIdent() - winner.getIdent()));
        winner.incComments((int)h * (current.getComments() - winner.getComments()));
        winner.incMethods((int)h * (current.getMethods() - winner.getMethods()));
    }

    private int getDiff(NeuralNode n1, NeuralNode n2) {
        return  Math.abs(n1.getSpaces() - n2.getSpaces())
                + Math.abs(n1.getTabs() - n2.getTabs())
                + Math.abs(n1.getIdent() - n2.getIdent())
                + Math.abs(n1.getComments() - n2.getComments())
                + Math.abs(n1.getMethods() - n2.getMethods());
    }

    private NeuralNode createNeuralNode(AttributeCounting ac) {
       NeuralNode node = new NeuralNode();
        int lines = ac.getLines();
        node.setTabs((100* ac.getTabs())/lines);
        node.setSpaces((100* ac.getSpaces())/lines);
        node.setIdent((100* ac.getIdent())/lines);
        node.setComments((100* ac.getComments())/lines);
        node.setMethods((100* ac.getMethods())/lines);
        return node;
    }

    private static long sigma(long t) {
        return 5 + 10 / t;
    }
}
