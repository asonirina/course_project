package by.bsu.project.scheduller;

import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.NeuralNode;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.neural.Node;
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
        List<UserInfoEntity> users = userInfoService.studentsList();
        List<ProgramFilesEntity> programs = userInfoService.getReadyProgramFiles();
        for (ProgramFilesEntity programFilesEntity : programs) {
            AttributeCounting ac = programFilesEntity.getAc();
            Node n = new Node(ac);
            ac.setAngle(n.getAngle());
            ac.setInputData((long)n.getWeight());

            UserInfoEntity winner = null;
            double measure = 2.0;
            for (UserInfoEntity entity : users) {
                NeuralNode node = entity.getNeuralNode();
                Node checkingNode = new Node(node);
                if (!node.isEmpty()) {
                    double temp = Math.abs(checkingNode.getAngle() - n.getAngle());
                    if (temp <= measure) {
                        measure = temp;
                        winner = entity;
                    }
                }
            }
            if (winner == null) {
                NeuralNode nn = programFilesEntity.getUser().getNeuralNode();
                double m[] = n.getM();
                nn.setSpaces((int)(10 * m[0]));
                nn.setTabs((int)(10 * m[1]));
                nn.setIdent((int)(10 * m[2]));
                nn.setComments((int)(10 * m[3]));
                nn.setMethods((int)(10 * m[4]));

            } else if (winner.getId().equals(programFilesEntity.getUser().getId())) {
//                double h = Math.sqrt(1.0 / ac.getId()) * Math.exp(-measure*measure);
//                changeWinner(winner.getNeuralNode(), checkingNode, h);
//                userInfoService.save(winner);
            }
            programFilesEntity.setRunStatus(3);
            programFilesEntity.setCluster(winner.getNeuralNode().getId());
            userInfoService.save(programFilesEntity.getUser());
        }
    }

    private void changeWinner(NeuralNode winner, NeuralNode current, double h) {
        winner.incSpaces((int)(h * (current.getSpaces() - winner.getSpaces())));
        winner.incTabs((int)(h * (current.getTabs() - winner.getTabs())));
        winner.incIdent((int)(h * (current.getIdent() - winner.getIdent())));
        winner.incComments((int)(h * (current.getComments() - winner.getComments())));
        winner.incMethods((int)(h * (current.getMethods() - winner.getMethods())));
    }


    private static long sigma(long t) {
        return 5 + 10 / t;
    }
}
