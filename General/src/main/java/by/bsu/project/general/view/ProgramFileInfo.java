package by.bsu.project.general.view;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserTask;

/**
 * User: iason
 * Date: 22.10.15
 */
public class ProgramFileInfo {
    Long id;
    String plagiat1;
    String plagiat2;
    String tryNo;
    String isRightCluster;

    private ProgramFileInfo() {

    }
    public static ProgramFileInfo getInfo(UserTask userTask) {
        ProgramFilesEntity programFilesEntity = userTask.getLastProgram();
        if(programFilesEntity.getCluster() == null) {
            return getDefault(userTask.getTryNo());
        }
        ProgramFileInfo info = new ProgramFileInfo();
        info.setId(programFilesEntity.getId());
        info.setPlagiat1(programFilesEntity.getPlagiat1() + " %");
        info.setPlagiat2(programFilesEntity.getPlagiat2() + " %");
        info.setTryNo(userTask.getTryNo().toString());
        info.setRightCluster(programFilesEntity.getCluster().equals(programFilesEntity.getUser().getId()) ? "Да" : "Нет");
        return info;
    }

    private static ProgramFileInfo getDefault(Integer tryNo) {
        ProgramFileInfo info = new ProgramFileInfo();
        info.setId(-1L);
        info.setPlagiat1("Не рассчитан");
        info.setPlagiat2("Не рассчитан");
        info.setTryNo(tryNo.toString());
        info.setRightCluster("Не рассчитано");
        return info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlagiat1() {
        return plagiat1;
    }

    public void setPlagiat1(String plagiat1) {
        this.plagiat1 = plagiat1;
    }

    public String getPlagiat2() {
        return plagiat2;
    }

    public void setPlagiat2(String plagiat2) {
        this.plagiat2 = plagiat2;
    }

    public String getTryNo() {
        return tryNo;
    }

    public void setTryNo(String tryNo) {
        this.tryNo = tryNo;
    }

    public String getRightCluster() {
        return isRightCluster;
    }

    public void setRightCluster(String rightCluster) {
        isRightCluster = rightCluster;
    }
}
