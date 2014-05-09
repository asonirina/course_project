package by.bsu.project.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Alina Glumova
 */

@Entity
@Table(name = "program_files")
public class ProgramFilesEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id",insertable = false,updatable = false)
    private Long userId;

    @Column(name = "status")
    private String status;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "file")
    private byte[] file;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "added_time")
    private Date uploadProgramTime;

    @Column(name = "testResults")
    private byte[] testResults;

    @Column(name = "plagiat")
    private Integer plagiat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Date getUploadProgramTime() {
        return uploadProgramTime;
    }

    public void setUploadProgramTime(Date uploadProgramTime) {
        this.uploadProgramTime = uploadProgramTime;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getTestResults() {
        return testResults;
    }

    public void setTestResults(byte[] testResults) {
        this.testResults = testResults;
    }

    public Integer getPlagiat() {
        return plagiat;
    }

    public void setPlagiat(Integer plagiat) {
        this.plagiat = plagiat;
    }
}
