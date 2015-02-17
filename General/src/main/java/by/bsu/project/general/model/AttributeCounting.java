package by.bsu.project.general.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


/**
 * User: iason
 * Date: 16.03.14
 */
@Entity
@Table(name = "attribute_countings")
public class AttributeCounting {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    @Column(name="id", unique=true, nullable=false)
//    @GeneratedValue(generator="gen")
//    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="program_files"))
//    @GenericGenerator(name = "generator", strategy = "foreign",
//            parameters = @Parameter(name = "property", value = "program_files"))
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

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

    @OneToOne(fetch = FetchType.EAGER)
//    @PrimaryKeyJoinColumn
    @JoinColumn(name = "program_id")
    private ProgramFilesEntity entity;

    public AttributeCounting(){}

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

    public ProgramFilesEntity getEntity() {
        return entity;
    }

    public void setEntity(ProgramFilesEntity entity) {
        this.entity = entity;
    }
}
