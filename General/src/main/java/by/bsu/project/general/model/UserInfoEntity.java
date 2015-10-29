package by.bsu.project.general.model;

import by.bsu.project.general.constants.FieldToLoad;
import by.bsu.project.general.model.ProgramFilesEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alina Glumova
 */

@Entity
@Table(name = "user_info")
public class UserInfoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    @IndexColumn(name="idx")
    private List<ProgramFilesEntity> programFiles;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    @IndexColumn(name="idx_1")
    private List<UserTask> userTasks;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "SecondName")
    private String secondName;

    @Column(name = "Form")
    private String form;

    @Column(name = "Login", unique = true)
    private String login;

    @Column(name = "Password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "neuralNode_id")
    private NeuralNode neuralNode;

    public UserInfoEntity() {
        programFiles = new ArrayList<>();
        userTasks = new ArrayList<>();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<ProgramFilesEntity> getProgramFiles() {
        return programFiles;
    }

    public void setProgramFiles(List<ProgramFilesEntity> programFiles) {
        this.programFiles = programFiles;
    }

    public NeuralNode getNeuralNode() {
        return neuralNode;
    }

    public void setNeuralNode(NeuralNode neuralNode) {
        this.neuralNode = neuralNode;
    }

    public List<UserTask> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<UserTask> userTasks) {
        this.userTasks = userTasks;
    }

    public Object get(FieldToLoad field) {
        switch (field) {
            case NEURAL_NODE:
                return getNeuralNode();
            default:
                return null;
        }
    }
}
