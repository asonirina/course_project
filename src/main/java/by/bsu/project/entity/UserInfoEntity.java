package by.bsu.project.entity;

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

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "SecondName")
    private String secondName;

    @Column(name = "Form")
    private String form;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<ProgramFilesEntity> programFiles;

    public List<ProgramFilesEntity> getProgramFiles() {
        return programFiles;
    }

    public void setProgramFiles(List<ProgramFilesEntity> programFiles) {
        this.programFiles = programFiles;
    }
}
