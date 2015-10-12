package by.bsu.project.general.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Iryna Ason
 */

@Entity
@Table(name = "single_test")
public class SingleTest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name="task_id", insertable=false, updatable=false, nullable=false)
    private Task task;

    @Column(name = "test_no")
    private Integer testNum;

    @Column(name = "data_in")
    private byte[] dataIn;

    @Column(name = "data_out")
    private byte[] dataOut;

    public SingleTest(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public byte[] getDataIn() {
        return dataIn;
    }

    public String getDataInStr() {
        return dataIn==null ? "" : new String(dataIn);
    }

    public void setDataInStr(String dataInStr) {
        dataIn = dataInStr.getBytes();
    }

    public void setDataIn(byte[] dataIn) {
        this.dataIn = dataIn;
    }

    public byte[] getDataOut() {
        return dataOut;
    }

    public String getDataOutStr() {
        return new String(dataOut);
    }

    public void setDataOutStr(String dataOutStr) {
        dataOut = dataOutStr.getBytes();
    }

    public void setDataOut(byte[] dataOut) {
        this.dataOut = dataOut;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getTestNum() {
        return testNum;
    }

    public void setTestNum(Integer testNum) {
        this.testNum = testNum;
    }


}
