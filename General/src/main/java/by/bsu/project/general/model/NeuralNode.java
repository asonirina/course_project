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

    @Column(name = "pluses")
    private Integer pluses = 0;

    @Column(name = "variables")
    private Integer variables = 0;

    @Column(name = "ifs")
    private Integer ifs = 0;

    @Column(name = "spaces")
    private Integer spaces = 0;

    @Column(name = "tabs")
    private Integer tabs = 0;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfoEntity entity;

    public NeuralNode() {
    }

    public void incIfs() {
        this.ifs++;
    }

    public void incPlus() {
        this.pluses++;
    }

    public void incVar() {
        this.variables++;
    }

    public Integer getPluses() {
        return pluses;
    }

    public void setPluses(Integer pluses) {
        this.pluses = pluses;
    }

    public Integer getVariables() {
        return variables;
    }

    public void setVariables(Integer variables) {
        this.variables = variables;
    }

    public Integer getIfs() {
        return ifs;
    }

    public void setIfs(Integer ifs) {
        this.ifs = ifs;
    }

    public Long getId() {
        return id;
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

    public UserInfoEntity getEntity() {
        return entity;
    }

    public void setEntity(UserInfoEntity entity) {
        this.entity = entity;
    }

    public static NeuralNode createRandom() {
        NeuralNode res = new NeuralNode();
        res.setPluses(RandomUtils.nextInt(20));
        res.setIfs(RandomUtils.nextInt(20));
        res.setVariables(RandomUtils.nextInt(20));
        res.setSpaces(RandomUtils.nextInt(20));
        res.setTabs(RandomUtils.nextInt(20));
        return res;
    }
}
