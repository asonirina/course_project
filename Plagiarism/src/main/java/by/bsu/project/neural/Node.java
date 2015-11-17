package by.bsu.project.neural;

import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.NeuralNode;
import org.apache.commons.lang.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by iason
 * on 11/12/2015.
 */
public class Node {
    private double m[];    // normalized input data
    private Integer x = 0;
    private Integer y = 0;
    private double angle = 0;
    private double weight = 0;

    boolean grid;
    private Long acId = 0L;
    private boolean right = true;

    public Node (NeuralNode nn) {
        this(nn, false, 1);
    }
    public Node (NeuralNode nn, boolean isGrid, double max) {
        this.grid = isGrid;
        m = new double[5];
        m[0] = nn.getSpaces();
        m[1] = nn.getTabs();
        m[2] = nn.getIdent();
        m[3] = nn.getComments();
        m[4] = nn.getMethods();

        Map<String, Double> params = getParams(m, max);
        double angle = params.get("angle");
        double radius = params.get("radius");
        double weight = params.get("weight");
        x = (int)(radius* Math.cos((Math.PI/2) * Math.pow(angle/(Math.PI/2), 1.)));
        y = (int)(radius* Math.sin((Math.PI / 2) * Math.pow(angle / (Math.PI / 2),  1.)));
        this.angle = angle;
        this.weight = weight;
    }

    public Node(AttributeCounting ac) {
        m = new double[5];
        m[0] = ac.getSpaces();
        m[1] = ac.getTabs();
        m[2] = ac.getIdent();
        m[3] = ac.getComments();
        m[4] = ac.getMethods();
        double max = NumberUtils.max(m);
        for (int i = 0; i < 5; i++) {
           m[i] =  new BigDecimal(m[i] / max ).setScale(1, RoundingMode.UP).doubleValue();
        }
        Map<String, Double> params = getParams(m, max);
        double angle = params.get("angle");
        double radius = params.get("radius");
        double weight = params.get("weight");
        x = (int)(radius* Math.cos((Math.PI/2) * Math.pow(angle/(Math.PI/2), 1.)));
        y = (int)(radius* Math.sin((Math.PI / 2) * Math.pow(angle / (Math.PI / 2), 1.)));
        this.angle = angle;
        this.weight = weight;
        this.acId = ac.getId();
        this.right = (ac.getEntity().getCluster()== null) ? true : ac.getEntity().getCluster().equals(ac.getEntity().getUser().getId());
    }

    /**
        Normalized vector is expected;
     */
    public Node(double m[]) {
        this.m = m;
        Map<String, Double> params = getParams(m, 100);
        double angle = params.get("angle");
        double radius = params.get("radius");
        double weight = params.get("weight");
        x = (int)(radius* Math.cos((Math.PI/2) * Math.pow(angle/(Math.PI/2), 2)));
        y = (int)(radius* Math.sin((Math.PI / 2) * Math.pow(angle / (Math.PI / 2), 2)));
        this.angle = angle;
        this.weight = weight;

    }

    private static double value(double r) {
       return (r > 0) ? 1 : r;
    }

    private static Map<String, Double> getParams(double m[], double max) {
        long mult = 10;
        double radius = 0;
        double weight = 0;
        for (int i = 0; i < 5; i++) {
            radius += m[i];
            weight += mult * m[i];
            mult *= 100;
        }

        double R = radius;
        double maxWeight = 0;
        while (R > 0) {
            mult /= 100;
            maxWeight += mult * value(R);
            R -= 1;
        }
        Map<String, Double> res = new HashMap<>();
        res.put("angle", (Math.PI * weight) / (2 * maxWeight));
        res.put("radius", radius * max);
        res.put("weight", weight);
        return res;
    }
    public double[] getM() {
        return m;
    }

    public void setM(double[] m) {
        this.m = m;
    }

    public Integer getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isGrid() {
        return grid;
    }

    public void setGrid(boolean grid) {
        this.grid = grid;
    }

    public long getAcId() {
        return acId;
    }

    public void setAcId(long acId) {
        this.acId = acId;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
