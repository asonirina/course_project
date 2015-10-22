package by.bsu.project.general.model;

import by.bsu.project.general.constants.ETestingConstants;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Iryna Ason
 */

@Entity
@Table(name = "user_task")
public class UserTask {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable=false, updatable=false, nullable=false)
    private UserInfoEntity user;

    @ManyToOne
    @JoinColumn(name = "task_id", insertable=false, updatable=false, nullable=false)
    private Task task;

    @Column(name = "try_no")
    private Integer tryNo;

    @Column(name = "status")
    private Integer status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "program_id")
    private ProgramFilesEntity lastProgram;


    public UserTask() {
        tryNo = 0;
        status = ETestingConstants.UserTaskStatus.IN_PROGRESS.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfoEntity getUser() {
        return user;
    }

    public void setUser(UserInfoEntity user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getTryNo() {
        return tryNo;
    }

    public void setTryNo(Integer tryNo) {
        this.tryNo = tryNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void incTryNo() {
        tryNo++;
    }

    public ProgramFilesEntity getLastProgram() {
        return lastProgram;
    }

    public void setLastProgram(ProgramFilesEntity lastProgram) {
        this.lastProgram = lastProgram;
    }

}
