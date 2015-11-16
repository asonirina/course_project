package by.bsu.project.scheduller;

import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.NeuralNode;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.neural.Node;
import by.bsu.project.service.UserInfoService;
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
            Node current = new Node(ac);
            ac.setAngle(current.getAngle());
            ac.setInputData((long)current.getWeight());

            UserInfoEntity winner = programFilesEntity.getUser();
            double measure = Math.PI / 18;
            for (UserInfoEntity entity : users) {
                NeuralNode node = entity.getNeuralNode();
                if (node != null) {
                    Node checkingNode = new Node(node);
                    double temp = Math.abs(checkingNode.getAngle() - current.getAngle());
                    if (temp <= measure) {
                        measure = temp;
                        winner = entity;
                    }
                }
            }

            if (winner.getNeuralNode() == null) {
                createNewNeuralNode(current, programFilesEntity);
            } else if (winner.getId().equals(programFilesEntity.getUser().getId())) {
                double h = Math.sqrt(1.0 / ac.getId()) * Math.exp(-measure * measure / (2 * sigma(ac.getId())));
                changeWinner(programFilesEntity.getUser().getNeuralNode(), current, h);
            }
            programFilesEntity.setRunStatus(3);
            programFilesEntity.setCluster(winner.getId());
            userInfoService.save(programFilesEntity.getUser());
        }
    }

    private void createNewNeuralNode(Node current, ProgramFilesEntity programFilesEntity) {
        NeuralNode nn = new NeuralNode();
        double m[] = current.getM();
        nn.setSpaces(m[0]);
        nn.setTabs(m[1]);
        nn.setIdent(m[2]);
        nn.setComments(m[3]);
        nn.setMethods(m[4]);
        nn.setEntity(programFilesEntity.getUser());
        programFilesEntity.getUser().setNeuralNode(nn);
    }

    private void changeWinner(NeuralNode winner, Node current, double h) {
        double m[] = current.getM();
        winner.incSpaces(h * (m[0] - winner.getSpaces()));
        winner.incTabs(h * (m[1] - winner.getTabs()));
        winner.incIdent(h * (m[2] - winner.getIdent()));
        winner.incComments(h * (m[3] - winner.getComments()));
        winner.incMethods(h * (m[4] - winner.getMethods()));
    }

    private static long sigma(long t) {
        return 5 + 10 / t;
    }
}
