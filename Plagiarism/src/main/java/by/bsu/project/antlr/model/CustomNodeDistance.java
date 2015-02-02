package by.bsu.project.antlr.model;

import by.bsu.project.antlr.util.LevensteinDistanceHelper;
import org.apache.commons.lang.StringUtils;

/**
 * User: iason
 * Date: 02.02.15
 */
public class CustomNodeDistance implements NodeDistance {
    @Override
    public double rename(TreeNode n1, TreeNode n2) {
        if (!n1.getOperation().getType().equals(n2.getOperation().getType())) {
            return 1;
        }
        if (n1.getOperation().equals(n2.getOperation()))
            return calculate(n1, n2, 0.1);

        return calculate(n1, n2, 0.5);
    }

    private double calculate(TreeNode n1, TreeNode n2, double mult) {
        return 1 - Math.exp(-mult * LevensteinDistanceHelper.distance(
                StringUtils.split(n1.getName()),
                StringUtils.split(n2.getName())));
    }

    @Override
    public double delete(TreeNode n1, TreeNode n2) {
        return 1.0;
    }

    @Override
    public double insert(TreeNode n1, TreeNode n2) {
        return 1.0;
    }
}
