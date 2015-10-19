package by.bsu.project.general.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Long tryNo;

    @Column(name = "status")
    private Long status;


    public UserTask() {
        tryNo = 0L;
        status = 0L;
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

    public Long getTryNo() {
        return tryNo;
    }

    public void setTryNo(Long tryNo) {
        this.tryNo = tryNo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void incTryNo() {
        tryNo++;
    }
}
