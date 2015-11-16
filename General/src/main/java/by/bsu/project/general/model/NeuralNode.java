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
    private Double methods = 0.;

    @Column(name = "spaces")
    private Double spaces = 0.;

    @Column(name = "tabs")
    private Double tabs = 0.;

    @Column(name = "ident")
    private Double ident = 0.;

    @Column(name = "comments")
    private Double comments = 0.;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfoEntity entity;

    public NeuralNode() {
    }

    public Long getId() {
        return id;
    }

    public Double getMethods() {
        return methods;
    }

    public void setMethods(Double methods) {
        this.methods = methods;
    }

    public Double getSpaces() {
        return spaces;
    }

    public Double getTabs() {
        return tabs;
    }

    public void setSpaces(Double spaces) {
        this.spaces = spaces;
    }

    public void setTabs(Double tabs) {
        this.tabs = tabs;
    }

    public Double getIdent() {
        return ident;
    }

    public void setIdent(Double ident) {
        this.ident = ident;
    }

    public Double getComments() {
        return comments;
    }

    public void setComments(Double comments) {
        this.comments = comments;
    }

    public void incSpaces(Double value) {
        spaces +=value;
    }
    public void incTabs(Double value) {
        tabs +=value;
    }
    public void incIdent(Double value) {
        ident +=value;
    }
    public void incComments(Double value) {
        comments +=value;
    }
    public void incMethods(Double value) {
        methods +=value;
    }

    public UserInfoEntity getEntity() {
        return entity;
    }

    public void setEntity(UserInfoEntity entity) {
        this.entity = entity;
    }
}
