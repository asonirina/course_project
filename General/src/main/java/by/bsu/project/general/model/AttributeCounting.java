package by.bsu.project.general.model;

import javax.persistence.*;


/**
 * User: iason
 * Date: 16.03.14
 */
@Entity
@Table(name = "attribute_countings")
public class AttributeCounting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "input_data")
    private Long inputData = 0L;

    @Column(name = "angle")
    private Double angle = 0.0;

    @Column(name = "line_count")
    private Integer lines = 0;

    @Column(name = "methods")
    private Integer methods = 0;

    @Column(name = "spaces")
    private Integer spaces = 0;

    @Column(name = "tabs")
    private Integer tabs = 0;

    @Column(name = "ident")
    private Integer ident = 0;

    @Column(name = "comments")
    private Integer comments = 0;

    @Column(name = "tokens")
    private Integer tokens = 0;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "program_id")
    private ProgramFilesEntity entity;

    public AttributeCounting(){}

    public Integer getLines() {
        return lines;
    }

    public void setLines(Integer lines) {
        this.lines = lines;
    }

    public void incMethod() {
        this.methods++;
    }

    public Integer getMethods() {
        return methods;
    }

    public void setMethods(Integer methods) {
        this.methods = methods;
    }

    public Integer getSpaces() {
        return spaces;
    }

    public void setSpaces(Integer spaces) {
        this.spaces = spaces;
    }

    public Integer getTabs() {
        return tabs;
    }

    public void setTabs(Integer tabs) {
        this.tabs = tabs;
    }

    public Integer getIdent() {
        return ident;
    }

    public void setIdent(Integer ident) {
        this.ident = ident;
    }

    public void incIdent(int value) {
        ident += value;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public ProgramFilesEntity getEntity() {
        return entity;
    }

    public void setEntity(ProgramFilesEntity entity) {
        this.entity = entity;
    }

    public Integer getTokens() {
        return tokens;
    }

    public void setTokens(Integer tokens) {
        this.tokens = tokens;
    }

    public Long getInputData() {
        return inputData;
    }

    public void setInputData(Long inputData) {
        this.inputData = inputData;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public static int getDiff(AttributeCounting ac1, AttributeCounting ac2) {
        double size1 = ac1.getTokens();
        double size2 = ac2.getTokens();
        double diff = getAbsSub(ac1.getLines()/size1, ac2.getLines()/size2)
                + getAbsSub(ac1.getMethods()/size1, ac2.getMethods()/size2)
                + getAbsSub(ac1.getSpaces()/size1, ac2.getSpaces()/size2)
                + getAbsSub(ac1.getTabs()/size1, ac2.getTabs()/size2)
                + getAbsSub(ac1.getIdent()/size1, ac2.getIdent()/size2)
                + getAbsSub(ac1.getComments()/size1, ac2.getComments());
        return (int) (Math.exp(-diff / 4.0) * 100);
    }

    private static double getAbsSub(double i1, double i2) {
        return Math.abs(i1 - i2);
    }
}
