package by.bsu.project.neural;

import by.bsu.project.general.model.NeuralNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iason
 * on 11/12/2015.
 */
public class Node {
    private double m[];
    private Integer x = 0;
    private Integer y = 0;

    public Node(NeuralNode nn) {
        m = new double[5];
        m[0] = nn.getComments();
        m[1] = nn.getIdent();
        m[2] = nn.getMethods();
        m[3] = nn.getSpaces();
        m[4] = nn.getTabs();
        Map<String, Double> params = getParams(m);
        double angle = params.get("angle");
        double radius = params.get("radius");
        x = (int)(radius* Math.cos(angle));
        y = (int)(radius* Math.sin(angle));
    }

    public Node(double m[]) {
        this.m = m;
        Map<String, Double> params = getParams(m);
        double angle = params.get("angle");
        double radius = params.get("radius");
        x = (int)(radius* Math.cos(angle));
        y = (int)(radius* Math.sin(angle));
    }

    private static double value(double r) {
       return (r > 0) ? 1 : r;
    }

    private static Map<String, Double> getParams(double m[]) {
        int mult = 1;
        double radius = 0;
        double weight = 0;
        for (int i = 0; i < 5; i++) {
            radius += m[i];
            weight += mult * m[i];
            mult *= 2;
        }

        double R = radius;
        double maxWeight = 0;
        while (R > 0) {
            mult /= 2;
            maxWeight += mult * value(R);
            R -= 1;
        }
        Map<String, Double> res = new HashMap<>();
        res.put("angle", (Math.PI * weight) / (2 * maxWeight));
        res.put("radius", radius * 100);
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
}
