package by.bsu.project.plagiat.model;

import javax.persistence.*;


/**
 * User: iason
 * Date: 16.03.14
 */
@Entity
@Table(name = "attribute_countings")
public class AttributeCounting {
    public AttributeCounting() {

    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "progrName")
    private String progrName;


    @Column(name = "imports")
    private Integer imports;

    @Column(name = "functions")
    private Integer functions;

    @Column(name = "calls")
    private Integer calls;

    @Column(name = "assigns")
    private Integer assigns;

    @Column(name = "pluses")
    private Integer pluses;

    @Column(name = "minuses")
    private Integer minuses;

    @Column(name = "multiples")
    private Integer multiples;

    @Column(name = "divides")
    private Integer divides;

    @Column(name = "variables")
    private Integer variables;

    @Column(name = "ifs")
    private Integer ifs;

    @Column(name = "cycles")
    private Integer cycles;

    public AttributeCounting(String progrName) {
        this.progrName = progrName;
    }


    public Integer getImports() {
        return imports;
    }

    public void setImports(Integer imports) {
        this.imports = imports;
    }

    public Integer getFunctions() {
        return functions;
    }

    public void setFunctions(Integer functions) {
        this.functions = functions;
    }

    public Integer getCalls() {
        return calls;
    }

    public void setCalls(Integer calls) {
        this.calls = calls;
    }

    public Integer getAssigns() {
        return assigns;
    }

    public void setAssigns(Integer assigns) {
        this.assigns = assigns;
    }

    public Integer getPluses() {
        return pluses;
    }

    public void setPluses(Integer pluses) {
        this.pluses = pluses;
    }

    public Integer getMinuses() {
        return minuses;
    }

    public void setMinuses(Integer minuses) {
        this.minuses = minuses;
    }

    public Integer getMultiples() {
        return multiples;
    }

    public void setMultiples(Integer multiples) {
        this.multiples = multiples;
    }

    public Integer getDivides() {
        return divides;
    }

    public void setDivides(Integer divides) {
        this.divides = divides;
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

    public Integer getCycles() {
        return cycles;
    }

    public void setCycles(Integer cycles) {
        this.cycles = cycles;
    }

    public String getProgrName() {
        return progrName;
    }

    public void setProgrName(String progrName) {
        this.progrName = progrName;
    }
}
