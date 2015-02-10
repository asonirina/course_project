package by.bsu.project.antlr.rted;

/**
 * User: iason
 * Date: 10.02.15
 */
public class RTEDConstants {
    public static final byte LEFT =             0;
    public static final byte RIGHT =            1;
    public static final byte HEAVY =            2;
    public static final byte BOTH =             3;
    public static final byte REVLEFT =          4;
    public static final byte REVRIGHT =         5;
    public static final byte REVHEAVY =         6;

    public static final byte POST2_SIZE =       0;
    public static final byte POST2_KR_SUM =     1;
    public static final byte POST2_REV_KR_SUM = 2;
    public static final byte POST2_DESC_SUM =   3;  // number of subforests in full decomposition
    public static final byte POST2_PRE =        4;
    public static final byte POST2_PARENT =     5;
    public static final byte POST2_LABEL =      6;
    public static final byte KR =               7;  // key root nodes (size of this array = leaf count)
    public static final byte POST2_LLD =        8;  // left-most leaf descendants
    public static final byte POST2_MIN_KR =     9;  // minimum key root nodes index in KR array
    public static final byte RKR =              10; // reversed key root nodes
    public static final byte RPOST2_RLD =       11; // reversed postorer 2 right-most leaf descendants
    public static final byte RPOST2_MIN_RKR =   12;
    public static final byte RPOST2_POST =      13; // reversed postorder -> postorder
    public static final byte POST2_STRATEGY =   14; // strategy for Demaine (is there sth on the left/right of the heavy node)
    public static final byte PRE2_POST =        15;
}
