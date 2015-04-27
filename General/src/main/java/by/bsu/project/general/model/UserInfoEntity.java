package by.bsu.project.general.model;

import by.bsu.project.general.model.ProgramFilesEntity;

import javax.persistence.*;
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
    private List<ProgramFilesEntity> programFiles;

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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "neuralNode_id")
    private NeuralNode neuralNode;

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
}
