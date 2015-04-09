package by.bsu.project.scheduller;

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
public class NeuralRunnerCron {
    @Autowired
    private UserInfoService userInfoService;

    @Scheduled(fixedDelay = 20000)
    protected void executeInternal() {
        List<UserInfoEntity> users = userInfoService.studentsList();
        List<ProgramFilesEntity> programs = userInfoService.getReadyProgramFiles();
        for (ProgramFilesEntity programFilesEntity : programs) {

            AttributeCounting ac = programFilesEntity.getAc();
            UserInfoEntity winner = users.get(0);
            int measure = 10000;
            for (UserInfoEntity entity : users) {
                NeuralNode node = entity.getNeuralNode();
                int temp = Math.abs(node.getIfs() - ac.getIfs()) + Math.abs(node.getPluses() - ac.getPluses()) + Math.abs(node.getVariables() - ac.getVariables());
                if (temp <= measure) {
                    measure = temp;
                    winner = entity;
                }
            }

            int h = (int) (1.0 / ac.getId() * Math.exp(-measure / (2 * sigma(ac.getId()) * sigma(ac.getId()))));
            winner.getNeuralNode().setIfs(winner.getNeuralNode().getIfs() + h * (ac.getIfs() - winner.getNeuralNode().getIfs()));
            winner.getNeuralNode().setPluses(winner.getNeuralNode().getPluses() + h * (ac.getPluses() - winner.getNeuralNode().getPluses()));
            winner.getNeuralNode().setVariables(winner.getNeuralNode().getVariables() + h * (ac.getVariables() - winner.getNeuralNode().getVariables()));
            userInfoService.save(winner);

            programFilesEntity.setRunStatus(3);
            programFilesEntity.setCluster(winner.getNeuralNode().getId().intValue());
            userInfoService.save(programFilesEntity.getUser());
        }
    }

    private static long sigma(long t) {
        return 5 + 10 / t;
    }

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}
