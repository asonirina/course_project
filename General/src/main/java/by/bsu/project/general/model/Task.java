package by.bsu.project.general.model;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Iryna Ason
 */

@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="task_id")
    @IndexColumn(name="idx")
    private List<SingleTest> tests;

    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="task_id")
    @IndexColumn(name="idx_2")
    private List<UserTask> userTasks;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "form")
    private String form;

    @Column(name = "description")
    private String description;

    public Task() {
        tests = new ArrayList<>();
        userTasks = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<SingleTest> getTests() {
        return tests;
    }

    public void setTests(List<SingleTest> tests) {
        this.tests = tests;
    }

    public List<UserTask> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<UserTask> userTasks) {
        this.userTasks = userTasks;
    }
}
