package by.bsu.project.entity;

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
    private Integer imports = 0;

    @Column(name = "functions")
    private Integer functions = 0;

    @Column(name = "calls")
    private Integer calls = 0;

    @Column(name = "assigns")
    private Integer assigns = 0;

    @Column(name = "pluses")
    private Integer pluses = 0;

    @Column(name = "minuses")
    private Integer minuses = 0;

    @Column(name = "multiples")
    private Integer multiples = 0;

    @Column(name = "divides")
    private Integer divides = 0;

    @Column(name = "variables")
    private Integer variables = 0;

    @Column(name = "ifs")
    private Integer ifs = 0;

    @Column(name = "cycles")
    private Integer cycles = 0;

    public AttributeCounting(String progrName) {
        this.progrName = progrName;
    }

    public void incIfs() {
        this.ifs++;
    }

    public void incPlus() {
        this.pluses++;
    }

    public void incAssign() {
        this.assigns++;
    }

    public void incMinus() {
        this.minuses++;
    }

    public void incCall() {
        this.calls++;
    }

    public void incVar() {
        this.variables++;
    }

    public void incMethod() {
        this.functions++;
    }

    public void incCycle() {
        this.cycles++;
    }

    public String getProgrName() {
        return progrName;
    }

    public void setProgrName(String progrName) {
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

    public Long getId() {
        return id;
    }
}
