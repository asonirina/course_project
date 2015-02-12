package by.bsu.project.general.model;

import by.bsu.project.general.lang.LangWrap;
import by.bsu.project.general.constants.ETestingConstants;

import javax.persistence.*;

import java.util.Date;

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

    @Column(name = "tree_content")
    private byte[] treeContent;

    @Column(name = "plagiat1")
    private Integer plagiat1;

    @Column(name = "plagiat2")
    private Integer plagiat2;

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

    public Integer getPlagiat1() {
        return plagiat1;
    }

    public void setPlagiat1(Integer plagiat1) {
        this.plagiat1 = plagiat1;
    }

    public Integer getPlagiat2() {
        return plagiat2;
    }

    public void setPlagiat2(Integer plagiat2) {
        this.plagiat2 = plagiat2;
    }

    public byte[] getTreeContent() {
        return treeContent;
    }

    public void setTreeContent(byte[] treeContent) {
        this.treeContent = treeContent;
    }

    public LangWrap.Lang getLang() {
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        switch (extension) {
            case ETestingConstants.POSTFIX_JAVA:
                return LangWrap.Lang.JAVA;
            case ETestingConstants.POSTFIX_C:
                return LangWrap.Lang.CPP;
            case ETestingConstants.POSTFIX_CPP:
                return LangWrap.Lang.CPP;
            case ETestingConstants.POSTFIX_PASCAL_P:
                return LangWrap.Lang.PASCAL;
            case ETestingConstants.POSTFIX_PASCAL_PAS:
                return LangWrap.Lang.PASCAL;
            default:
                return null;
        }

    }

}
