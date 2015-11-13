package by.bsu.project.general.model;

import org.apache.commons.lang.math.RandomUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User: iason
 * Date: 07.04.15
 */
@Entity
@Table(name = "neural_node")
public class NeuralNode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

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
    @JoinColumn(name = "user_id")
    private UserInfoEntity entity;

    public NeuralNode() {
    }

    public Long getId() {
        return id;
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

    public Integer getTabs() {
        return tabs;
    }

    public void setSpaces(Integer spaces) {
        this.spaces = spaces;
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

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public void incSpaces(Integer value) {
        spaces +=value;
    }
    public void incTabs(Integer value) {
        tabs +=value;
    }
    public void incIdent(Integer value) {
        ident +=value;
    }
    public void incComments(Integer value) {
        comments +=value;
    }
    public void incMethods(Integer value) {
        methods +=value;
    }

    public UserInfoEntity getEntity() {
        return entity;
    }

    public void setEntity(UserInfoEntity entity) {
        this.entity = entity;
    }

    public static NeuralNode createDefault() {
        return new NeuralNode();
    }

    public boolean isEmpty() {
        return methods==0 && spaces==0 && tabs ==0 && ident==0 && comments ==0;
    }
}
