package by.bsu.project.javacc.parser.pascal;

import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.general.TokenMgrError;
import by.bsu.project.javacc.model.Token;

@SuppressWarnings("unused")
public class JPascalTokenManager implements JPascalConstants {

    /**
     * Debug output.
     */
    public static java.io.PrintStream debugStream = System.out;

    /**
     * Set debug output.
     */
    public static void setDebugStream(java.io.PrintStream ds) {
        debugStream = ds;
    }

    private static final int jjStopStringLiteralDfa_0(int pos, long active0, long active1) {
        switch (pos) {
            case 0:
                if ((active1 & 0x400000L) != 0L)
                    return 32;
                if ((active0 & 0x1800000L) != 0L) {
                    jjmatchedKind = 60;
                    return 24;
                }
                if ((active0 & 0xffffffffc7f0000L) != 0L) {
                    jjmatchedKind = 60;
                    return 18;
                }
                return -1;
            case 1:
                if ((active0 & 0xffdfe7d3d9f0000L) != 0L) {
                    if (jjmatchedPos != 1) {
                        jjmatchedKind = 60;
                        jjmatchedPos = 1;
                    }
                    return 18;
                }
                if ((active0 & 0x20182c0600000L) != 0L)
                    return 18;
                return -1;
            case 2:
                if ((active0 & 0xfbdfe2730ce0000L) != 0L) {
                    if (jjmatchedPos != 2) {
                        jjmatchedKind = 60;
                        jjmatchedPos = 2;
                    }
                    return 18;
                }
                if ((active0 & 0x4000580d110000L) != 0L)
                    return 18;
                return -1;
            case 3:
                if ((active0 & 0x12d000020840000L) != 0L)
                    return 18;
                if ((active0 & 0xe90fe27184a0000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 3;
                    return 18;
                }
                return -1;
            case 4:
                if ((active0 & 0x908001000a0000L) != 0L)
                    return 18;
                if ((active0 & 0xe007e2618400000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 4;
                    return 18;
                }
                return -1;
            case 5:
                if ((active0 & 0x4001a0618000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 5;
                    return 18;
                }
                if ((active0 & 0xa00642000400000L) != 0L)
                    return 18;
                return -1;
            case 6:
                if ((active0 & 0x400100008000000L) != 0L)
                    return 18;
                if ((active0 & 0xa0610000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 6;
                    return 18;
                }
                return -1;
            case 7:
                if ((active0 & 0x10000000L) != 0L)
                    return 18;
                if ((active0 & 0xa0600000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 7;
                    return 18;
                }
                return -1;
            case 8:
                if ((active0 & 0x400000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 8;
                    return 18;
                }
                if ((active0 & 0xa0200000000L) != 0L)
                    return 18;
                return -1;
            case 9:
                if ((active0 & 0x400000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 9;
                    return 18;
                }
                return -1;
            case 10:
                if ((active0 & 0x400000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 10;
                    return 18;
                }
                return -1;
            case 11:
                if ((active0 & 0x400000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 11;
                    return 18;
                }
                return -1;
            case 12:
                if ((active0 & 0x400000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 12;
                    return 18;
                }
                return -1;
            default:
                return -1;
        }
    }

    private static final int jjStartNfa_0(int pos, long active0, long active1) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
    }

    static private int jjStopAtPos(int pos, int kind) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        return pos + 1;
    }

    static private int jjMoveStringLiteralDfa0_0() {
        switch (curChar) {
            case 34:
                return jjStopAtPos(0, 87);
            case 39:
                return jjStartNfaWithStates_0(0, 86, 32);
            case 40:
                jjmatchedKind = 63;
                return jjMoveStringLiteralDfa1_0(0x20L, 0x0L);
            case 41:
                return jjStopAtPos(0, 64);
            case 42:
                jjmatchedKind = 72;
                return jjMoveStringLiteralDfa1_0(0x0L, 0x200L);
            case 43:
                return jjStopAtPos(0, 70);
            case 44:
                return jjStopAtPos(0, 68);
            case 45:
                return jjStopAtPos(0, 71);
            case 46:
                jjmatchedKind = 75;
                return jjMoveStringLiteralDfa1_0(0x0L, 0x1000L);
            case 47:
                return jjStopAtPos(0, 74);
            case 58:
                jjmatchedKind = 69;
                return jjMoveStringLiteralDfa1_0(0x0L, 0x2000L);
            case 59:
                return jjStopAtPos(0, 67);
            case 60:
                jjmatchedKind = 83;
                return jjMoveStringLiteralDfa1_0(0x0L, 0x28000L);
            case 61:
                return jjStopAtPos(0, 78);
            case 62:
                jjmatchedKind = 82;
                return jjMoveStringLiteralDfa1_0(0x0L, 0x10000L);
            case 64:
                return jjStopAtPos(0, 84);
            case 91:
                return jjStopAtPos(0, 65);
            case 93:
                return jjStopAtPos(0, 66);
            case 94:
                return jjStopAtPos(0, 85);
            case 65:
            case 97:
                return jjMoveStringLiteralDfa1_0(0x10000L, 0x0L);
            case 66:
            case 98:
                return jjMoveStringLiteralDfa1_0(0x20000L, 0x0L);
            case 67:
            case 99:
                return jjMoveStringLiteralDfa1_0(0xc0000L, 0x0L);
            case 68:
            case 100:
                return jjMoveStringLiteralDfa1_0(0x700000L, 0x0L);
            case 69:
            case 101:
                return jjMoveStringLiteralDfa1_0(0x1800000L, 0x0L);
            case 70:
            case 102:
                return jjMoveStringLiteralDfa1_0(0x1c000000L, 0x0L);
            case 71:
            case 103:
                return jjMoveStringLiteralDfa1_0(0x20000000L, 0x0L);
            case 73:
            case 105:
                return jjMoveStringLiteralDfa1_0(0x6c0000000L, 0x0L);
            case 76:
            case 108:
                return jjMoveStringLiteralDfa1_0(0x100000000L, 0x0L);
            case 77:
            case 109:
                return jjMoveStringLiteralDfa1_0(0x2800000000L, 0x0L);
            case 78:
            case 110:
                return jjMoveStringLiteralDfa1_0(0x5000000000L, 0x0L);
            case 79:
            case 111:
                return jjMoveStringLiteralDfa1_0(0x38000000000L, 0x0L);
            case 80:
            case 112:
                return jjMoveStringLiteralDfa1_0(0x4001c0000000000L, 0x0L);
            case 82:
            case 114:
                return jjMoveStringLiteralDfa1_0(0x600000000000L, 0x0L);
            case 83:
            case 115:
                return jjMoveStringLiteralDfa1_0(0xa00800000000000L, 0x0L);
            case 84:
            case 116:
                return jjMoveStringLiteralDfa1_0(0x7000000000000L, 0x0L);
            case 85:
            case 117:
                return jjMoveStringLiteralDfa1_0(0x38000000000000L, 0x0L);
            case 86:
            case 118:
                return jjMoveStringLiteralDfa1_0(0x40000000000000L, 0x0L);
            case 87:
            case 119:
                return jjMoveStringLiteralDfa1_0(0x180000000000000L, 0x0L);
            case 123:
                return jjStopAtPos(0, 6);
            default:
                return jjMoveNfa_0(6, 0);
        }
    }

    static private int jjMoveStringLiteralDfa1_0(long active0, long active1) {
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(0, active0, active1);
            return 1;
        }
        switch (curChar) {
            case 42:
                if ((active0 & 0x20L) != 0L)
                    return jjStopAtPos(1, 5);
                else if ((active1 & 0x200L) != 0L)
                    return jjStopAtPos(1, 73);
                break;
            case 46:
                if ((active1 & 0x1000L) != 0L)
                    return jjStopAtPos(1, 76);
                break;
            case 61:
                if ((active1 & 0x2000L) != 0L)
                    return jjStopAtPos(1, 77);
                else if ((active1 & 0x8000L) != 0L)
                    return jjStopAtPos(1, 79);
                else if ((active1 & 0x10000L) != 0L)
                    return jjStopAtPos(1, 80);
                break;
            case 62:
                if ((active1 & 0x20000L) != 0L)
                    return jjStopAtPos(1, 81);
                break;
            case 65:
            case 97:
                return jjMoveStringLiteralDfa2_0(active0, 0x40042100040000L, active1, 0L);
            case 69:
            case 101:
                return jjMoveStringLiteralDfa2_0(active0, 0xe00000020000L, active1, 0L);
            case 70:
            case 102:
                if ((active0 & 0x40000000L) != 0L)
                    return jjStartNfaWithStates_0(1, 30, 18);
                else if ((active0 & 0x8000000000L) != 0L)
                    return jjStartNfaWithStates_0(1, 39, 18);
                break;
            case 72:
            case 104:
                return jjMoveStringLiteralDfa2_0(active0, 0x81000000000000L, active1, 0L);
            case 73:
            case 105:
                return jjMoveStringLiteralDfa2_0(active0, 0x300001000100000L, active1, 0L);
            case 76:
            case 108:
                return jjMoveStringLiteralDfa2_0(active0, 0x800000L, active1, 0L);
            case 77:
            case 109:
                return jjMoveStringLiteralDfa2_0(active0, 0x400000000L, active1, 0L);
            case 78:
            case 110:
                if ((active0 & 0x80000000L) != 0L) {
                    jjmatchedKind = 31;
                    jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(active0, 0x18000201010000L, active1, 0L);
            case 79:
            case 111:
                if ((active0 & 0x200000L) != 0L) {
                    jjmatchedKind = 21;
                    jjmatchedPos = 1;
                } else if ((active0 & 0x2000000000000L) != 0L)
                    return jjStartNfaWithStates_0(1, 49, 18);
                return jjMoveStringLiteralDfa2_0(active0, 0x40000482c480000L, active1, 0L);
            case 82:
            case 114:
                if ((active0 & 0x10000000000L) != 0L)
                    return jjStartNfaWithStates_0(1, 40, 18);
                return jjMoveStringLiteralDfa2_0(active0, 0x180000000000L, active1, 0L);
            case 83:
            case 115:
                return jjMoveStringLiteralDfa2_0(active0, 0x20000000000000L, active1, 0L);
            case 84:
            case 116:
                return jjMoveStringLiteralDfa2_0(active0, 0x800020000000000L, active1, 0L);
            case 85:
            case 117:
                return jjMoveStringLiteralDfa2_0(active0, 0x10000000L, active1, 0L);
            case 89:
            case 121:
                return jjMoveStringLiteralDfa2_0(active0, 0x4000000000000L, active1, 0L);
            default:
                break;
        }
        return jjStartNfa_0(0, active0, active1);
    }

    static private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1) {
        if (((active0 &= old0) | (active1 &= old1)) == 0L)
            return jjStartNfa_0(0, old0, old1);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(1, active0, 0L);
            return 2;
        }
        switch (curChar) {
            case 66:
            case 98:
                return jjMoveStringLiteralDfa3_0(active0, 0x100000000L);
            case 67:
            case 99:
                return jjMoveStringLiteralDfa3_0(active0, 0x240000000000L);
            case 68:
            case 100:
                if ((active0 & 0x10000L) != 0L)
                    return jjStartNfaWithStates_0(2, 16, 18);
                else if ((active0 & 0x1000000L) != 0L)
                    return jjStartNfaWithStates_0(2, 24, 18);
                else if ((active0 & 0x800000000L) != 0L)
                    return jjStartNfaWithStates_0(2, 35, 18);
                break;
            case 69:
            case 101:
                return jjMoveStringLiteralDfa3_0(active0, 0x21000000000000L);
            case 71:
            case 103:
                return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
            case 72:
            case 104:
                return jjMoveStringLiteralDfa3_0(active0, 0x20000000000L);
            case 73:
            case 105:
                return jjMoveStringLiteralDfa3_0(active0, 0x488000000000000L);
            case 76:
            case 108:
                if ((active0 & 0x1000000000L) != 0L)
                    return jjStartNfaWithStates_0(2, 36, 18);
                break;
            case 78:
            case 110:
                return jjMoveStringLiteralDfa3_0(active0, 0x200000010080000L);
            case 79:
            case 111:
                return jjMoveStringLiteralDfa3_0(active0, 0x180000000000L);
            case 80:
            case 112:
                return jjMoveStringLiteralDfa3_0(active0, 0x4400400000000L);
            case 82:
            case 114:
                if ((active0 & 0x4000000L) != 0L) {
                    jjmatchedKind = 26;
                    jjmatchedPos = 2;
                } else if ((active0 & 0x40000000000000L) != 0L)
                    return jjStartNfaWithStates_0(2, 54, 18);
                return jjMoveStringLiteralDfa3_0(active0, 0x800000008000000L);
            case 83:
            case 115:
                return jjMoveStringLiteralDfa3_0(active0, 0x840000L);
            case 84:
            case 116:
                if ((active0 & 0x4000000000L) != 0L)
                    return jjStartNfaWithStates_0(2, 38, 18);
                return jjMoveStringLiteralDfa3_0(active0, 0x110800220000000L);
            case 86:
            case 118:
                if ((active0 & 0x100000L) != 0L)
                    return jjStartNfaWithStates_0(2, 20, 18);
                break;
            case 87:
            case 119:
                return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
            case 88:
            case 120:
                return jjMoveStringLiteralDfa3_0(active0, 0x2000000000L);
            default:
                break;
        }
        return jjStartNfa_0(1, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa3_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(1, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(2, active0, 0L);
            return 3;
        }
        switch (curChar) {
            case 67:
            case 99:
                return jjMoveStringLiteralDfa4_0(active0, 0x80010000000L);
            case 69:
            case 101:
                if ((active0 & 0x40000L) != 0L)
                    return jjStartNfaWithStates_0(3, 18, 18);
                else if ((active0 & 0x800000L) != 0L)
                    return jjStartNfaWithStates_0(3, 23, 18);
                else if ((active0 & 0x4000000000000L) != 0L)
                    return jjStartNfaWithStates_0(3, 50, 18);
                return jjMoveStringLiteralDfa4_0(active0, 0x420300000000L);
            case 71:
            case 103:
                return jjMoveStringLiteralDfa4_0(active0, 0x200100000000000L);
            case 72:
            case 104:
                if ((active0 & 0x100000000000000L) != 0L)
                    return jjStartNfaWithStates_0(3, 56, 18);
                break;
            case 73:
            case 105:
                return jjMoveStringLiteralDfa4_0(active0, 0x810002000020000L);
            case 75:
            case 107:
                return jjMoveStringLiteralDfa4_0(active0, 0x40000000000L);
            case 76:
            case 108:
                return jjMoveStringLiteralDfa4_0(active0, 0x80000400000000L);
            case 78:
            case 110:
                if ((active0 & 0x1000000000000L) != 0L)
                    return jjStartNfaWithStates_0(3, 48, 18);
                return jjMoveStringLiteralDfa4_0(active0, 0x400000000400000L);
            case 79:
            case 111:
                if ((active0 & 0x20000000L) != 0L)
                    return jjStartNfaWithStates_0(3, 29, 18);
                return jjMoveStringLiteralDfa4_0(active0, 0xa00000000000L);
            case 83:
            case 115:
                if ((active0 & 0x20000000000000L) != 0L)
                    return jjStartNfaWithStates_0(3, 53, 18);
                return jjMoveStringLiteralDfa4_0(active0, 0x80000L);
            case 84:
            case 116:
                if ((active0 & 0x8000000000000L) != 0L)
                    return jjStartNfaWithStates_0(3, 51, 18);
                break;
            case 87:
            case 119:
                return jjMoveStringLiteralDfa4_0(active0, 0x8000000L);
            default:
                break;
        }
        return jjStartNfa_0(2, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa4_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(2, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(3, active0, 0L);
            return 4;
        }
        switch (curChar) {
            case 65:
            case 97:
                return jjMoveStringLiteralDfa5_0(active0, 0x400008000000L);
            case 69:
            case 101:
                if ((active0 & 0x80000000000000L) != 0L)
                    return jjStartNfaWithStates_0(4, 55, 18);
                return jjMoveStringLiteralDfa5_0(active0, 0xc0400000000L);
            case 70:
            case 102:
                if ((active0 & 0x800000000000L) != 0L)
                    return jjStartNfaWithStates_0(4, 47, 18);
                break;
            case 76:
            case 108:
                if ((active0 & 0x100000000L) != 0L)
                    return jjStartNfaWithStates_0(4, 32, 18);
                else if ((active0 & 0x10000000000000L) != 0L)
                    return jjStartNfaWithStates_0(4, 52, 18);
                return jjMoveStringLiteralDfa5_0(active0, 0x200000000000000L);
            case 78:
            case 110:
                if ((active0 & 0x20000L) != 0L)
                    return jjStartNfaWithStates_0(4, 17, 18);
                return jjMoveStringLiteralDfa5_0(active0, 0x800002000000000L);
            case 82:
            case 114:
                return jjMoveStringLiteralDfa5_0(active0, 0x320200000000L);
            case 84:
            case 116:
                if ((active0 & 0x80000L) != 0L)
                    return jjStartNfaWithStates_0(4, 19, 18);
                return jjMoveStringLiteralDfa5_0(active0, 0x400000010400000L);
            default:
                break;
        }
        return jjStartNfa_0(3, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa5_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(3, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(4, active0, 0L);
            return 5;
        }
        switch (curChar) {
            case 65:
            case 97:
                return jjMoveStringLiteralDfa6_0(active0, 0x100000000000L);
            case 68:
            case 100:
                if ((active0 & 0x40000000000L) != 0L)
                    return jjStartNfaWithStates_0(5, 42, 18);
                else if ((active0 & 0x200000000000L) != 0L)
                    return jjStartNfaWithStates_0(5, 45, 18);
                return jjMoveStringLiteralDfa6_0(active0, 0x80000000000L);
            case 69:
            case 101:
                if ((active0 & 0x200000000000000L) != 0L)
                    return jjStartNfaWithStates_0(5, 57, 18);
                return jjMoveStringLiteralDfa6_0(active0, 0x400000000000000L);
            case 70:
            case 102:
                return jjMoveStringLiteralDfa6_0(active0, 0x200000000L);
            case 71:
            case 103:
                if ((active0 & 0x800000000000000L) != 0L)
                    return jjStartNfaWithStates_0(5, 59, 18);
                break;
            case 73:
            case 105:
                return jjMoveStringLiteralDfa6_0(active0, 0x10000000L);
            case 77:
            case 109:
                return jjMoveStringLiteralDfa6_0(active0, 0x400000000L);
            case 79:
            case 111:
                if ((active0 & 0x400000L) != 0L)
                    return jjStartNfaWithStates_0(5, 22, 18);
                break;
            case 82:
            case 114:
                return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
            case 84:
            case 116:
                if ((active0 & 0x2000000000L) != 0L)
                    return jjStartNfaWithStates_0(5, 37, 18);
                else if ((active0 & 0x400000000000L) != 0L)
                    return jjStartNfaWithStates_0(5, 46, 18);
                break;
            case 87:
            case 119:
                return jjMoveStringLiteralDfa6_0(active0, 0x20000000000L);
            default:
                break;
        }
        return jjStartNfa_0(4, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa6_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(4, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(5, active0, 0L);
            return 6;
        }
        switch (curChar) {
            case 65:
            case 97:
                return jjMoveStringLiteralDfa7_0(active0, 0x200000000L);
            case 68:
            case 100:
                if ((active0 & 0x8000000L) != 0L)
                    return jjStartNfaWithStates_0(6, 27, 18);
                break;
            case 69:
            case 101:
                return jjMoveStringLiteralDfa7_0(active0, 0x400000000L);
            case 73:
            case 105:
                return jjMoveStringLiteralDfa7_0(active0, 0x20000000000L);
            case 77:
            case 109:
                if ((active0 & 0x100000000000L) != 0L)
                    return jjStartNfaWithStates_0(6, 44, 18);
                break;
            case 79:
            case 111:
                return jjMoveStringLiteralDfa7_0(active0, 0x10000000L);
            case 82:
            case 114:
                if ((active0 & 0x400000000000000L) != 0L)
                    return jjStartNfaWithStates_0(6, 58, 18);
                break;
            case 85:
            case 117:
                return jjMoveStringLiteralDfa7_0(active0, 0x80000000000L);
            default:
                break;
        }
        return jjStartNfa_0(5, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa7_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(5, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(6, active0, 0L);
            return 7;
        }
        switch (curChar) {
            case 67:
            case 99:
                return jjMoveStringLiteralDfa8_0(active0, 0x200000000L);
            case 78:
            case 110:
                if ((active0 & 0x10000000L) != 0L)
                    return jjStartNfaWithStates_0(7, 28, 18);
                return jjMoveStringLiteralDfa8_0(active0, 0x400000000L);
            case 82:
            case 114:
                return jjMoveStringLiteralDfa8_0(active0, 0x80000000000L);
            case 83:
            case 115:
                return jjMoveStringLiteralDfa8_0(active0, 0x20000000000L);
            default:
                break;
        }
        return jjStartNfa_0(6, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa8_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(6, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(7, active0, 0L);
            return 8;
        }
        switch (curChar) {
            case 69:
            case 101:
                if ((active0 & 0x200000000L) != 0L)
                    return jjStartNfaWithStates_0(8, 33, 18);
                else if ((active0 & 0x20000000000L) != 0L)
                    return jjStartNfaWithStates_0(8, 41, 18);
                else if ((active0 & 0x80000000000L) != 0L)
                    return jjStartNfaWithStates_0(8, 43, 18);
                break;
            case 84:
            case 116:
                return jjMoveStringLiteralDfa9_0(active0, 0x400000000L);
            default:
                break;
        }
        return jjStartNfa_0(7, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa9_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(7, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(8, active0, 0L);
            return 9;
        }
        switch (curChar) {
            case 65:
            case 97:
                return jjMoveStringLiteralDfa10_0(active0, 0x400000000L);
            default:
                break;
        }
        return jjStartNfa_0(8, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa10_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(8, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(9, active0, 0L);
            return 10;
        }
        switch (curChar) {
            case 84:
            case 116:
                return jjMoveStringLiteralDfa11_0(active0, 0x400000000L);
            default:
                break;
        }
        return jjStartNfa_0(9, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa11_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(9, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(10, active0, 0L);
            return 11;
        }
        switch (curChar) {
            case 73:
            case 105:
                return jjMoveStringLiteralDfa12_0(active0, 0x400000000L);
            default:
                break;
        }
        return jjStartNfa_0(10, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa12_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(10, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(11, active0, 0L);
            return 12;
        }
        switch (curChar) {
            case 79:
            case 111:
                return jjMoveStringLiteralDfa13_0(active0, 0x400000000L);
            default:
                break;
        }
        return jjStartNfa_0(11, active0, 0L);
    }

    static private int jjMoveStringLiteralDfa13_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(11, old0, 0L);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(12, active0, 0L);
            return 13;
        }
        switch (curChar) {
            case 78:
            case 110:
                if ((active0 & 0x400000000L) != 0L)
                    return jjStartNfaWithStates_0(13, 34, 18);
                break;
            default:
                break;
        }
        return jjStartNfa_0(12, active0, 0L);
    }

    static private int jjStartNfaWithStates_0(int pos, int kind, int state) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            return pos + 1;
        }
        return jjMoveNfa_0(state, pos + 1);
    }

    static final long[] jjbitVec0 = {
            0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
    };

    static private int jjMoveNfa_0(int startState, int curPos) {
        int startsAt = 0;
        jjnewStateCnt = 32;
        int i = 1;
        jjstateSet[0] = startState;
        int kind = 0x7fffffff;
        for (; ; ) {
            if (++jjround == 0x7fffffff)
                ReInitRounds();
            if (curChar < 64) {
                long l = 1L << curChar;
                do {
                    switch (jjstateSet[--i]) {
                        case 24:
                        case 18:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 60)
                                kind = 60;
                        {
                            jjCheckNAdd(18);
                        }
                        break;
                        case 32:
                            if ((0xfffffffbffffdbffL & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            if (curChar == 39) {
                                if (kind > 15)
                                    kind = 15;
                            }
                            break;
                        case 6:
                            if ((0x3ff000000000000L & l) != 0L) {
                                if (kind > 11)
                                    kind = 11;
                                {
                                    jjCheckNAddStates(3, 5);
                                }
                            } else if (curChar == 39) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 0:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 11)
                                kind = 11;
                        {
                            jjCheckNAddStates(3, 5);
                        }
                        break;
                        case 1:
                            if (curChar == 46) {
                                jjCheckNAdd(2);
                            }
                            break;
                        case 2:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 11)
                                kind = 11;
                        {
                            jjCheckNAddTwoStates(2, 3);
                        }
                        break;
                        case 4:
                            if ((0x280000000000L & l) != 0L) {
                                jjCheckNAdd(5);
                            }
                            break;
                        case 5:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 11)
                                kind = 11;
                        {
                            jjCheckNAdd(5);
                        }
                        break;
                        case 7:
                            if ((0xfffffffbffffdbffL & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 9:
                            if ((0x8400002400L & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 10:
                            if (curChar == 39 && kind > 15)
                                kind = 15;
                            break;
                        case 11:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAddStates(6, 9);
                            }
                            break;
                        case 12:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 13:
                            if ((0xf000000000000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 14;
                            break;
                        case 14:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAdd(12);
                            }
                            break;
                        case 15:
                            if (curChar == 10) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 16:
                            if (curChar == 13)
                                jjstateSet[jjnewStateCnt++] = 15;
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            } else if (curChar < 128) {
                long l = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                        case 24:
                            if ((0x7fffffe87fffffeL & l) != 0L) {
                                if (kind > 60)
                                    kind = 60;
                                {
                                    jjCheckNAdd(18);
                                }
                            }
                            if ((0x100000001000000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 30;
                            if ((0x100000001000000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 23;
                            break;
                        case 32:
                            if ((0xffffffffefffffffL & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            } else if (curChar == 92) {
                                jjAddStates(10, 13);
                            }
                            break;
                        case 6:
                            if ((0x7fffffe87fffffeL & l) != 0L) {
                                if (kind > 60)
                                    kind = 60;
                                {
                                    jjCheckNAdd(18);
                                }
                            }
                            if ((0x2000000020L & l) != 0L) {
                                jjAddStates(14, 15);
                            }
                            break;
                        case 3:
                            if ((0x2000000020L & l) != 0L) {
                                jjAddStates(16, 17);
                            }
                            break;
                        case 7:
                            if ((0xffffffffefffffffL & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 8:
                            if (curChar == 92) {
                                jjAddStates(10, 13);
                            }
                            break;
                        case 9:
                            if ((0x14404410144044L & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 17:
                            if ((0x7fffffe87fffffeL & l) == 0L)
                                break;
                            if (kind > 60)
                                kind = 60;
                        {
                            jjCheckNAdd(18);
                        }
                        break;
                        case 18:
                            if ((0x7fffffe87fffffeL & l) == 0L)
                                break;
                            if (kind > 60)
                                kind = 60;
                        {
                            jjCheckNAdd(18);
                        }
                        break;
                        case 19:
                            if ((0x2000000020L & l) != 0L) {
                                jjAddStates(14, 15);
                            }
                            break;
                        case 20:
                            if ((0x400000004000L & l) != 0L && kind > 25)
                                kind = 25;
                            break;
                        case 21:
                            if ((0x4000000040000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 20;
                            break;
                        case 22:
                            if ((0x2000000020L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 21;
                            break;
                        case 23:
                            if ((0x10000000100000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 22;
                            break;
                        case 25:
                            if ((0x100000001000L & l) != 0L && kind > 25)
                                kind = 25;
                            break;
                        case 26:
                            if ((0x200000002L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 25;
                            break;
                        case 27:
                            if ((0x400000004000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 26;
                            break;
                        case 28:
                            if ((0x4000000040000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 27;
                            break;
                        case 29:
                            if ((0x2000000020L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 28;
                            break;
                        case 30:
                            if ((0x10000000100000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 29;
                            break;
                        case 31:
                            if ((0x100000001000000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 30;
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            } else {
                int i2 = (curChar & 0xff) >> 6;
                long l2 = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                        case 32:
                        case 7:
                            if ((jjbitVec0[i2] & l2) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            }
            if (kind != 0x7fffffff) {
                jjmatchedKind = kind;
                jjmatchedPos = curPos;
                kind = 0x7fffffff;
            }
            ++curPos;
            if ((i = jjnewStateCnt) == (startsAt = 32 - (jjnewStateCnt = startsAt)))
                return curPos;
            try {
                curChar = input_stream.readChar();
            } catch (java.io.IOException e) {
                return curPos;
            }
        }
    }

    static private int jjMoveStringLiteralDfa0_2() {
        switch (curChar) {
            case 125:
                return jjStopAtPos(0, 9);
            default:
                return 1;
        }
    }

    static private int jjMoveStringLiteralDfa0_1() {
        switch (curChar) {
            case 42:
                return jjMoveStringLiteralDfa1_1(0x80L);
            default:
                return 1;
        }
    }

    static private int jjMoveStringLiteralDfa1_1(long active0) {
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            return 1;
        }
        switch (curChar) {
            case 41:
                if ((active0 & 0x80L) != 0L)
                    return jjStopAtPos(1, 7);
                break;
            default:
                return 2;
        }
        return 2;
    }

    static final int[] jjnextStates = {
            7, 8, 10, 0, 1, 3, 7, 8, 12, 10, 9, 11, 13, 16, 24, 31,
            4, 5,
    };

    /**
     * Token literal values.
     */
    public static final String[] jjstrLiteralImages = {
            "", null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, "\50", "\51", "\133", "\135", "\73",
            "\54", "\72", "\53", "\55", "\52", "\52\52", "\57", "\56", "\56\56", "\72\75", "\75",
            "\74\75", "\76\75", "\74\76", "\76", "\74", "\100", "\136", "\47", "\42",};

    static protected Token jjFillToken() {
        final Token t;
        final String curTokenImage;
        final int beginLine;
        final int endLine;
        final int beginColumn;
        final int endColumn;
        String im = jjstrLiteralImages[jjmatchedKind];
        curTokenImage = (im == null) ? input_stream.GetImage() : im;
        beginLine = input_stream.getBeginLine();
        beginColumn = input_stream.getBeginColumn();
        endLine = input_stream.getEndLine();
        endColumn = input_stream.getEndColumn();
        t = Token.newToken(jjmatchedKind, curTokenImage);

        t.beginLine = beginLine;
        t.endLine = endLine;
        t.beginColumn = beginColumn;
        t.endColumn = endColumn;

        return t;
    }

    static int curLexState = 0;
    static int defaultLexState = 0;
    static int jjnewStateCnt;
    static int jjround;
    static int jjmatchedPos;
    static int jjmatchedKind;

    /**
     * Get the next Token.
     */
    public static Token getNextToken() {
        Token matchedToken;
        int curPos = 0;

        EOFLoop:
        for (; ; ) {
            try {
                curChar = input_stream.BeginToken();
                if (curChar == 13) JPascal.seenNewLine = true;
            } catch (java.io.IOException e) {
                jjmatchedKind = 0;
                jjmatchedPos = -1;
                matchedToken = jjFillToken();
                return matchedToken;
            }

            for (; ; ) {
                switch (curLexState) {
                    case 0:
                        try {
                            input_stream.backup(0);
                            while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L) {
                                curChar = input_stream.BeginToken();
                                if (curChar == 13) JPascal.seenNewLine = true;
                            }
                        } catch (java.io.IOException e1) {
                            continue EOFLoop;
                        }
                        jjmatchedKind = 0x7fffffff;
                        jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_0();
                        break;
                    case 1:
                        jjmatchedKind = 0x7fffffff;
                        jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_1();
                        if (jjmatchedPos == 0 && jjmatchedKind > 8) {
                            jjmatchedKind = 8;
                        }
                        break;
                    case 2:
                        jjmatchedKind = 0x7fffffff;
                        jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_2();
                        if (jjmatchedPos == 0 && jjmatchedKind > 10) {
                            jjmatchedKind = 10;
                        }
                        break;
                }
                if (jjmatchedKind != 0x7fffffff) {
                    if (jjmatchedPos + 1 < curPos)
                        input_stream.backup(curPos - jjmatchedPos - 1);
                    if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
                        matchedToken = jjFillToken();
                        TokenLexicalActions(matchedToken);
                        if (jjnewLexState[jjmatchedKind] != -1)
                            curLexState = jjnewLexState[jjmatchedKind];
                        return matchedToken;
                    } else //if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
                    {
                        if (jjnewLexState[jjmatchedKind] != -1)
                            curLexState = jjnewLexState[jjmatchedKind];
                        continue EOFLoop;
                    }
//      if (jjnewLexState[jjmatchedKind] != -1)
//        curLexState = jjnewLexState[jjmatchedKind];
//        curPos = 0;
//        jjmatchedKind = 0x7fffffff;
//        try {
//           curChar = input_stream.readChar();
//           continue;
//        }
//        catch (java.io.IOException e1) { }
                }
                int error_line = input_stream.getEndLine();
                int error_column = input_stream.getEndColumn();
                String error_after = null;
                boolean EOFSeen = false;
                try {
                    input_stream.readChar();
                    input_stream.backup(1);
                } catch (java.io.IOException e1) {
                    EOFSeen = true;
                    error_after = curPos <= 1 ? "" : input_stream.GetImage();
                    if (curChar == '\n' || curChar == '\r') {
                        error_line++;
                        error_column = 0;
                    } else
                        error_column++;
                }
                if (!EOFSeen) {
                    input_stream.backup(1);
                    error_after = curPos <= 1 ? "" : input_stream.GetImage();
                }
                throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
            }
        }
    }

    static private void jjCheckNAdd(int state) {
        if (jjrounds[state] != jjround) {
            jjstateSet[jjnewStateCnt++] = state;
            jjrounds[state] = jjround;
        }
    }

    static private void jjAddStates(int start, int end) {
        do {
            jjstateSet[jjnewStateCnt++] = jjnextStates[start];
        } while (start++ != end);
    }

    static private void jjCheckNAddTwoStates(int state1, int state2) {
        jjCheckNAdd(state1);
        jjCheckNAdd(state2);
    }

    static private void jjCheckNAddStates(int start, int end) {
        do {
            jjCheckNAdd(jjnextStates[start]);
        } while (start++ != end);
    }

    /**
     * Constructor.
     */
    public JPascalTokenManager(SimpleCharStream stream) {

        if (input_stream != null)
            throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

        input_stream = stream;
    }

    /**
     * Constructor.
     */
    public JPascalTokenManager(SimpleCharStream stream, int lexState) {
        ReInit(stream);
        SwitchTo(lexState);
    }

    /**
     * Reinitialise parser.
     */
    static public void ReInit(SimpleCharStream stream) {
        jjmatchedPos = jjnewStateCnt = 0;
        curLexState = defaultLexState;
        input_stream = stream;
        ReInitRounds();
    }

    static private void ReInitRounds() {
        int i;
        jjround = 0x80000001;
        for (i = 32; i-- > 0; )
            jjrounds[i] = 0x80000000;
    }

    /**
     * Reinitialise parser.
     */
    static public void ReInit(SimpleCharStream stream, int lexState) {
        ReInit(stream);
        SwitchTo(lexState);
    }

    /**
     * Switch to specified lex state.
     */
    static public void SwitchTo(int lexState) {
        if (lexState >= 3 || lexState < 0)
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
        else
            curLexState = lexState;
    }

    /**
     * Lexer state names.
     */
    public static final String[] lexStateNames = {
            "DEFAULT",
            "WithinComment0",
            "WithinComment1",
    };

    /**
     * Lex State array.
     */
    public static final int[] jjnewLexState = {
            -1, -1, -1, -1, -1, 1, 2, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    };
    static final long[] jjtoToken = {
            0x9fffffffffff8801L, 0xffffffL,
    };
    static final long[] jjtoSkip = {
            0x2feL, 0x0L,
    };
    static final long[] jjtoMore = {
            0x500L, 0x0L,
    };
    static protected SimpleCharStream input_stream;

    static private final int[] jjrounds = new int[32];
    static private final int[] jjstateSet = new int[2 * 32];


    static protected char curChar;
    private static int lengthOfMatch;

    static void SkipLexicalActions(Token matchedToken) {
        switch (jjmatchedKind) {
            case 5:
                JPascal.seenNewLine = true;
                break;
            case 6:
                break;
            default:
                break;
        }
    }

    static void TokenLexicalActions(Token matchedToken) {
        switch (jjmatchedKind) {

            case 0:
                //image.append(jjstrLiteralImages[3]);
                lengthOfMatch = jjstrLiteralImages[3].length();
                JPascal.out_syntax = true;
                JPascal.out("<EOF>");
                JPascal.out_syntax = false;
                break;
            case 11:
                JPascal.out_syntax = true;
                JPascal.out("<NUMBER>");
                JPascal.out_syntax = false;
                break;
            case 12:
                JPascal.out_syntax = true;
                JPascal.out("<DECIMAL>");
                JPascal.out_syntax = false;
                break;
            case 13:
                JPascal.out_syntax = true;
                JPascal.out("<FRAC>");
                JPascal.out_syntax = false;
                break;
            case 14:
                JPascal.out_syntax = true;
                JPascal.out("<EXP>");
                JPascal.out_syntax = false;
                break;
            case 15:
                JPascal.out_syntax = true;
                JPascal.out("<STRING_LITERAL>");
                JPascal.out_syntax = false;
                break;
            case 16:
                JPascal.out_syntax = true;
                JPascal.out("<AND>");
                JPascal.out_syntax = false;
                break;
            case 17:
                JPascal.out_syntax = true;
                JPascal.out("<BEGIN>");
                JPascal.out_syntax = false;
                break;
            case 18:
                JPascal.out_syntax = true;
                JPascal.out("<CASE>");
                JPascal.out_syntax = false;
                break;
            case 19:
                JPascal.out_syntax = true;
                JPascal.out("<CONST>");
                JPascal.out_syntax = false;
                break;
            case 20:
                JPascal.out_syntax = true;
                JPascal.out("<DIV>");
                JPascal.out_syntax = false;
                break;
            case 21:
                JPascal.out_syntax = true;
                JPascal.out("<DO>");
                JPascal.out_syntax = false;
                break;
            case 22:
                JPascal.out_syntax = true;
                JPascal.out("<DOWNTO>");
                JPascal.out_syntax = false;
                break;
            case 23:
                JPascal.out_syntax = true;
                JPascal.out("<ELSE>");
                JPascal.out_syntax = false;
                break;
            case 24:
                JPascal.out_syntax = true;
                JPascal.out("<END>");
                JPascal.out_syntax = false;
                break;
            case 25:
                JPascal.out_syntax = true;
                JPascal.out("<EXTERN>");
                JPascal.out_syntax = false;
                break;
            case 26:
                JPascal.out_syntax = true;
                JPascal.out("<FOR>");
                JPascal.out_syntax = false;
                break;
            case 27:
                JPascal.out_syntax = true;
                JPascal.out("<FORWARD>");
                JPascal.out_syntax = false;
                break;
            case 28:
                JPascal.out_syntax = true;
                JPascal.out("<FUNCTION>");
                JPascal.out_syntax = false;
                break;
            case 29:
                JPascal.out_syntax = true;
                JPascal.out("<GOTO>");
                JPascal.out_syntax = false;
                break;
            case 30:
                JPascal.out_syntax = true;
                JPascal.out("<IF>");
                JPascal.out_syntax = false;
                break;
            case 31:
                JPascal.out_syntax = true;
                JPascal.out("<IN>");
                JPascal.out_syntax = false;
                break;
            case 32:
                JPascal.out_syntax = true;
                JPascal.out("<LABEL>");
                JPascal.out_syntax = false;
                break;
            case 33:
                JPascal.out_syntax = true;
                JPascal.out("<INTERFACE>");
                JPascal.out_syntax = false;
                break;
            case 34:
                JPascal.out_syntax = true;
                JPascal.out("<IMPLEMENTATION>");
                JPascal.out_syntax = false;
                break;
            case 35:
                JPascal.out_syntax = true;
                JPascal.out("<MOD>");
                JPascal.out_syntax = false;
                break;
            case 36:
                JPascal.out_syntax = true;
                JPascal.out("<NIL>");
                JPascal.out_syntax = false;
                break;
            case 37:
                JPascal.out_syntax = true;
                JPascal.out("<MAXINT>");
                JPascal.out_syntax = false;
                break;
            case 38:
                JPascal.out_syntax = true;
                JPascal.out("<NOT>");
                JPascal.out_syntax = false;
                break;
            case 39:
                JPascal.out_syntax = true;
                JPascal.out("<OF>");
                JPascal.out_syntax = false;
                break;
            case 40:
                JPascal.out_syntax = true;
                JPascal.out("<OR>");
                JPascal.out_syntax = false;
                break;
            case 41:
                JPascal.out_syntax = true;
                JPascal.out("<OTHERWISE>");
                JPascal.out_syntax = false;
                break;
            case 42:
                JPascal.out_syntax = true;
                JPascal.out("<PACKED>");
                JPascal.out_syntax = false;
                break;
            case 43:
                JPascal.out_syntax = true;
                JPascal.out("<PROCEDURE>");
                JPascal.out_syntax = false;
                break;
            case 44:
                JPascal.out_syntax = true;
                JPascal.out("<PROGRAM>");
                JPascal.out_syntax = false;
                break;
            case 45:
                JPascal.out_syntax = true;
                JPascal.out("<RECORD>");
                JPascal.out_syntax = false;
                break;
            case 46:
                JPascal.out_syntax = true;
                JPascal.out("<REPEAT>");
                JPascal.out_syntax = false;
                break;
            case 47:
                JPascal.out_syntax = true;
                JPascal.out("<SETOF>");
                JPascal.out_syntax = false;
                break;
            case 48:
                JPascal.out_syntax = true;
                JPascal.out("<THEN>");
                JPascal.out_syntax = false;
                break;
            case 49:
                JPascal.out_syntax = true;
                JPascal.out("<TO>");
                JPascal.out_syntax = false;
                break;
            case 50:
                JPascal.out_syntax = true;
                JPascal.out("<TYPE>");
                JPascal.out_syntax = false;
                break;
            case 51:
                JPascal.out_syntax = true;
                JPascal.out("<UNIT>");
                JPascal.out_syntax = false;
                break;
            case 52:
                JPascal.out_syntax = true;
                JPascal.out("<UNTIL>");
                JPascal.out_syntax = false;
                break;
            case 53:
                JPascal.out_syntax = true;
                JPascal.out("<USES>");
                JPascal.out_syntax = false;
                break;
            case 54:
                JPascal.out_syntax = true;
                JPascal.out("<VAR>");
                JPascal.out_syntax = false;
                break;
            case 55:
                JPascal.out_syntax = true;
                JPascal.out("<WHILE>");
                JPascal.out_syntax = false;
                break;
            case 56:
                JPascal.out_syntax = true;
                JPascal.out("<WITH>");
                JPascal.out_syntax = false;
                break;
            case 57:
                JPascal.out_syntax = true;
                JPascal.out("<SINGLE>");
                JPascal.out_syntax = false;
                break;
            case 58:
                JPascal.out_syntax = true;
                JPascal.out("<POINTER>");
                JPascal.out_syntax = false;
                break;
            case 59:
                JPascal.out_syntax = true;
                JPascal.out("<STRING>");
                JPascal.out_syntax = false;
                break;
            case 60:
                JPascal.out_syntax = true;
                JPascal.out("<IDENTIFIER>");
                JPascal.out_syntax = false;
                break;
            case 61:
                JPascal.out_syntax = true;
                JPascal.out("<LETTER>");
                JPascal.out_syntax = false;
                break;
            case 62:
                JPascal.out_syntax = true;
                JPascal.out("<DIGIT>");
                JPascal.out_syntax = false;
                break;
            case 63:
                JPascal.out_syntax = true;
                JPascal.out("<LPAREN>");
                JPascal.out_syntax = false;
                break;
            case 64:
                JPascal.out_syntax = true;
                JPascal.out("<RPAREN>");
                JPascal.out_syntax = false;
                break;
            case 65:
                JPascal.out_syntax = true;
                JPascal.out("<LBRACKET>");
                JPascal.out_syntax = false;
                break;
            case 66:
                JPascal.out_syntax = true;
                JPascal.out("<RBRACKET>");
                JPascal.out_syntax = false;
                break;
            case 67:
                JPascal.out_syntax = true;
                JPascal.out("<SEMICOLON>"); //TODO: ; maybe should remove it?
                JPascal.out_syntax = false;
                break;
            case 68:
                JPascal.out_syntax = true;
                JPascal.out("<COMMA>");
                JPascal.out_syntax = false;
                break;
            case 69:
                JPascal.out_syntax = true;
                JPascal.out("<COLON>");
                JPascal.out_syntax = false;
                break;
            case 70:
                JPascal.out_syntax = true;
                JPascal.out("<PLUS>");
                JPascal.out_syntax = false;
                break;
            case 71:
                JPascal.out_syntax = true;
                JPascal.out("<MINUS>");
                JPascal.out_syntax = false;
                break;
            case 72:
                JPascal.out_syntax = true;
                JPascal.out("<MULTIPLY>");
                JPascal.out_syntax = false;
                break;
            case 73:
                JPascal.out_syntax = true;
                JPascal.out("<STARSTAR>");
                JPascal.out_syntax = false;
                break;
            case 74:
                JPascal.out_syntax = true;
                JPascal.out("<DIVIDE>");
                JPascal.out_syntax = false;
                break;
            case 75:
                JPascal.out_syntax = true;
                JPascal.out("<DOT>");
                JPascal.out_syntax = false;
                break;
            case 76:
                JPascal.out_syntax = true;
                JPascal.out("<DOTDOT>");
                JPascal.out_syntax = false;
                break;
            case 77:
                JPascal.out_syntax = true;
                JPascal.out("<ASSIGN>");
                JPascal.out_syntax = false;
                break;
            case 78:
                JPascal.out_syntax = true;
                JPascal.out("<EQ>");
                JPascal.out_syntax = false;
                break;
            case 79:
                JPascal.out_syntax = true;
                JPascal.out("<LE>");
                JPascal.out_syntax = false;
                break;
            case 80:
                JPascal.out_syntax = true;
                JPascal.out("<GE>");
                JPascal.out_syntax = false;
                break;
            case 81:
                JPascal.out_syntax = true;
                JPascal.out("<NE>");
                JPascal.out_syntax = false;
                break;
            case 82:
                JPascal.out_syntax = true;
                JPascal.out("<GT>");
                JPascal.out_syntax = false;
                break;
            case 83:
                JPascal.out_syntax = true;
                JPascal.out("<LT>");
                JPascal.out_syntax = false;
                break;
            case 84:
                JPascal.out_syntax = true;
                JPascal.out("<ADDR>");
                JPascal.out_syntax = false;
                break;
            case 85:
                JPascal.out_syntax = true;
                JPascal.out("<UPARROW>");
                JPascal.out_syntax = false;
                break;
            case 86:
                JPascal.out_syntax = true;
                JPascal.out("<SQOUTE>");
                JPascal.out_syntax = false;
                break;
            case 87:
                JPascal.out_syntax = true;
                JPascal.out("<DQOUTE>");
                JPascal.out_syntax = false;
                break;


            default:
                JPascal.out_syntax = true;
                JPascal.out("<***********>");
                JPascal.out_syntax = false;
                break;
        }
    }
}