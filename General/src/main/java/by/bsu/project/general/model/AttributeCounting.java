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

    public static int getDiff(AttributeCounting ac1, AttributeCounting ac2) {
         int diff = getAbsSub(ac1.getLines(), ac2.getLines())
                 +getAbsSub(ac1.getMethods(), ac2.getMethods())
                 +getAbsSub(ac1.getSpaces(), ac2.getSpaces())
                 +getAbsSub(ac1.getTabs(), ac2.getTabs())
                 +getAbsSub(ac1.getIdent(), ac2.getIdent())
                 +getAbsSub(ac1.getComments(), ac2.getComments());
        return (int)(Math.exp(-diff/4.0) * 100);
    }

    private static int getAbsSub(int i1, int i2) {
        return Math.abs(i1 - i2);
    }
}
