package by.bsu.project.general.model;

import by.bsu.project.general.huffman.Huffman;
import by.bsu.project.general.lang.LangWrap;
import by.bsu.project.general.constants.ETestingConstants;

import javax.persistence.*;

import java.util.ArrayList;
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "ac_id")
    private AttributeCounting ac;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserTask userTask;

    @ManyToOne
    @JoinColumn(name="user_id", insertable=false, updatable=false, nullable=false)
    private UserInfoEntity user;

    @ManyToOne
    @JoinColumn(name = "matched_id", nullable = true)
    private ProgramFilesEntity matched;

    @Column(name = "status")
    private String status;

    @Column(name = "run_status")
    private int runStatus;

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
    private String testResults;

    @Column(name = "tree_content")
    private byte[] treeContent;

    @Column(name = "compare_map")
    private byte[] compareMap;

    @Column(name = "plagiat1")
    private Integer plagiat1;

    @Column(name = "plagiat2")
    private Integer plagiat2;

    @Column(name = "cluster")
    private Long cluster;

    public ProgramFilesEntity getMatched() {
        return matched;
    }

    public void setMatched(ProgramFilesEntity matched) {
        this.matched = matched;
    }

    public ProgramFilesEntity(){}

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

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
    }

    public UserInfoEntity getUser() {
        return user;
    }

    public void setUser(UserInfoEntity user) {
        this.user = user;
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
        return file == null ? null : Huffman.expand(file);
    }

    public void setFile(byte[] file) {
        this.file = file == null ? null : Huffman.compress(file);
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

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
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
        return treeContent == null ? null : Huffman.expand(treeContent);
    }

    public void setTreeContent(byte[] treeContent) {
        this.treeContent = treeContent == null ? null :Huffman.compress(treeContent);
    }

    public AttributeCounting getAc() {
        return ac;
    }

    public void setAc(AttributeCounting ac) {
        this.ac = ac;
    }

    public Long getCluster() {
        return cluster;
    }

    public void setCluster(Long cluster) {
        this.cluster = cluster;
    }


    public UserTask getUserTask() {
        return userTask;
    }

    public void setUserTask(UserTask userTask) {
        this.userTask = userTask;
    }

    public byte[] getCompareMap() {
        return compareMap;
    }

    public void setCompareMap(byte[] compareMap) {
        this.compareMap = compareMap;
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
