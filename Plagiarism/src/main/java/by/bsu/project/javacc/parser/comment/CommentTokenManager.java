package by.bsu.project.javacc.parser.comment;

import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.general.TokenMgrError;
import by.bsu.project.javacc.model.Token;

@SuppressWarnings("unused")
public class CommentTokenManager implements CommentConstants {
    private int commonCommentLength = 0;
    boolean justStartedComment = false;

    private int jjStopStringLiteralDfa_2(int pos, long active0) {
        switch (pos) {
            case 0:
                if ((active0 & 0x80L) != 0L) {
                    jjmatchedKind = 10;
                    return -1;
                }
                return -1;
            default:
                return -1;
        }
    }

    private int jjStartNfa_2(int pos, long active0) {
        return jjMoveNfa_2(jjStopStringLiteralDfa_2(pos, active0), pos + 1);
    }

    private int jjStopAtPos(int pos, int kind) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        return pos + 1;
    }

    private int jjMoveStringLiteralDfa0_2() {
        switch (curChar) {
            case 42:
                return jjMoveStringLiteralDfa1_2(0x80L);
            default:
                return jjMoveNfa_2(1, 0);
        }
    }

    private int jjMoveStringLiteralDfa1_2(long active0) {
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_2(0, active0);
            return 1;
        }
        switch (curChar) {
            case 47:
                if ((active0 & 0x80L) != 0L)
                    return jjStopAtPos(1, 7);
                break;
            default:
                break;
        }
        return jjStartNfa_2(0, active0);
    }

    final long[] jjbitVec0 = {
            0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
    };

    private int jjMoveNfa_2(int startState, int curPos) {
        int startsAt = 0;
        jjnewStateCnt = 7;
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
                        case 1:
                            if (kind > 10)
                                kind = 10;
                            if ((0x3ff200000000000L & l) != 0L) {
                                if (kind > 9)
                                    kind = 9;
                                {
                                    jjCheckNAddTwoStates(3, 4);
                                }
                            } else if ((0x2400L & l) != 0L) {
                                if (kind > 8)
                                    kind = 8;
                            }
                            if (curChar == 13)
                                jjstateSet[jjnewStateCnt++] = 0;
                            break;
                        case 0:
                            if (curChar == 10 && kind > 8)
                                kind = 8;
                            break;
                        case 2:
                            if ((0x2400L & l) != 0L && kind > 8)
                                kind = 8;
                            break;
                        case 3:
                            if ((0x3ff200000000000L & l) == 0L)
                                break;
                            if (kind > 9)
                                kind = 9;
                        {
                            jjCheckNAddTwoStates(3, 4);
                        }
                        break;
                        case 4:
                            if ((0x408000000000L & l) != 0L) {
                                jjCheckNAddTwoStates(4, 5);
                            }
                            break;
                        case 5:
                            if ((0x3ff200000000000L & l) == 0L)
                                break;
                            if (kind > 9)
                                kind = 9;
                        {
                            jjCheckNAddTwoStates(4, 5);
                        }
                        break;
                        case 6:
                            if (kind > 10)
                                kind = 10;
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            } else if (curChar < 128) {
                long l = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                        case 1:
                            if (kind > 10)
                                kind = 10;
                            if ((0x7fffffe07fffffeL & l) != 0L) {
                                if (kind > 9)
                                    kind = 9;
                                {
                                    jjCheckNAddTwoStates(3, 4);
                                }
                            }
                            break;
                        case 3:
                            if ((0x7fffffe07fffffeL & l) == 0L)
                                break;
                            if (kind > 9)
                                kind = 9;
                        {
                            jjCheckNAddTwoStates(3, 4);
                        }
                        break;
                        case 5:
                            if ((0x7fffffe07fffffeL & l) == 0L)
                                break;
                            if (kind > 9)
                                kind = 9;
                        {
                            jjCheckNAddTwoStates(4, 5);
                        }
                        break;
                        case 6:
                            if (kind > 10)
                                kind = 10;
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
                        case 1:
                            if ((jjbitVec0[i2] & l2) != 0L && kind > 10)
                                kind = 10;
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
            if ((i = jjnewStateCnt) == (startsAt = 7 - (jjnewStateCnt = startsAt)))
                return curPos;
            try {
                curChar = input_stream.readChar();
            } catch (java.io.IOException e) {
                return curPos;
            }
        }
    }

    private int jjStopStringLiteralDfa_0(int pos, long active0) {
        switch (pos) {
            case 0:
                if ((active0 & 0x1000L) != 0L) {
                    jjmatchedKind = 17;
                    return -1;
                }
                if ((active0 & 0x42L) != 0L) {
                    jjmatchedKind = 17;
                    return 2;
                }
                return -1;
            case 1:
                if ((active0 & 0x1000L) != 0L) {
                    if (jjmatchedPos == 0) {
                        jjmatchedKind = 17;
                        jjmatchedPos = 0;
                    }
                    return -1;
                }
                if ((active0 & 0x40L) != 0L)
                    return 0;
                return -1;
            case 2:
                if ((active0 & 0x1000L) != 0L) {
                    if (jjmatchedPos == 0) {
                        jjmatchedKind = 17;
                        jjmatchedPos = 0;
                    }
                    return -1;
                }
                return -1;
            case 3:
                if ((active0 & 0x1000L) != 0L) {
                    if (jjmatchedPos == 0) {
                        jjmatchedKind = 17;
                        jjmatchedPos = 0;
                    }
                    return -1;
                }
                return -1;
            case 4:
                if ((active0 & 0x1000L) != 0L) {
                    if (jjmatchedPos == 0) {
                        jjmatchedKind = 17;
                        jjmatchedPos = 0;
                    }
                    return -1;
                }
                return -1;
            default:
                return -1;
        }
    }

    private int jjStartNfa_0(int pos, long active0) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
    }

    private int jjMoveStringLiteralDfa0_0() {
        switch (curChar) {
            case 35:
                return jjMoveStringLiteralDfa1_0(0x1000L);
            case 47:
                return jjMoveStringLiteralDfa1_0(0x42L);
            default:
                return jjMoveNfa_0(3, 0);
        }
    }

    private int jjMoveStringLiteralDfa1_0(long active0) {
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(0, active0);
            return 1;
        }
        switch (curChar) {
            case 42:
                if ((active0 & 0x40L) != 0L)
                    return jjStartNfaWithStates_0(1, 6, 0);
                break;
            case 47:
                if ((active0 & 0x2L) != 0L)
                    return jjStopAtPos(1, 1);
                break;
            case 76:
            case 108:
                return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
            default:
                break;
        }
        return jjStartNfa_0(0, active0);
    }

    private int jjMoveStringLiteralDfa2_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(0, old0);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(1, active0);
            return 2;
        }
        switch (curChar) {
            case 73:
            case 105:
                return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
            default:
                break;
        }
        return jjStartNfa_0(1, active0);
    }

    private int jjMoveStringLiteralDfa3_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(1, old0);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(2, active0);
            return 3;
        }
        switch (curChar) {
            case 78:
            case 110:
                return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
            default:
                break;
        }
        return jjStartNfa_0(2, active0);
    }

    private int jjMoveStringLiteralDfa4_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(2, old0);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(3, active0);
            return 4;
        }
        switch (curChar) {
            case 69:
            case 101:
                return jjMoveStringLiteralDfa5_0(active0, 0x1000L);
            default:
                break;
        }
        return jjStartNfa_0(3, active0);
    }

    private int jjMoveStringLiteralDfa5_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(3, old0);
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(4, active0);
            return 5;
        }
        switch (curChar) {
            case 32:
                if ((active0 & 0x1000L) != 0L)
                    return jjStopAtPos(5, 12);
                break;
            default:
                break;
        }
        return jjStartNfa_0(4, active0);
    }

    private int jjStartNfaWithStates_0(int pos, int kind, int state) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            return pos + 1;
        }
        return jjMoveNfa_0(state, pos + 1);
    }

    private int jjMoveNfa_0(int startState, int curPos) {
        int startsAt = 0;
        jjnewStateCnt = 31;
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
                        case 3:
                            if (kind > 17)
                                kind = 17;
                            if ((0x3ff200000000000L & l) != 0L) {
                                if (kind > 14)
                                    kind = 14;
                                {
                                    jjCheckNAddTwoStates(8, 9);
                                }
                            } else if ((0x2400L & l) != 0L) {
                                if (kind > 11)
                                    kind = 11;
                            } else if (curChar == 34) {
                                jjCheckNAddStates(0, 2);
                            } else if (curChar == 39) {
                                jjAddStates(3, 4);
                            } else if (curChar == 32) {
                                if (kind > 16)
                                    kind = 16;
                                {
                                    jjCheckNAdd(11);
                                }
                            } else if (curChar == 47)
                                jjstateSet[jjnewStateCnt++] = 2;
                            if ((0x3ff000000000000L & l) != 0L) {
                                if (kind > 13)
                                    kind = 13;
                                {
                                    jjCheckNAdd(7);
                                }
                            } else if (curChar == 13)
                                jjstateSet[jjnewStateCnt++] = 4;
                            break;
                        case 0:
                            if (curChar == 42)
                                jjstateSet[jjnewStateCnt++] = 1;
                            break;
                        case 1:
                            if ((0xffff7fffffffffffL & l) != 0L && kind > 5)
                                kind = 5;
                            break;
                        case 2:
                            if (curChar == 42)
                                jjstateSet[jjnewStateCnt++] = 0;
                            break;
                        case 4:
                            if (curChar == 10 && kind > 11)
                                kind = 11;
                            break;
                        case 5:
                            if (curChar == 13)
                                jjstateSet[jjnewStateCnt++] = 4;
                            break;
                        case 6:
                            if ((0x2400L & l) != 0L && kind > 11)
                                kind = 11;
                            break;
                        case 7:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 13)
                                kind = 13;
                        {
                            jjCheckNAdd(7);
                        }
                        break;
                        case 8:
                            if ((0x3ff200000000000L & l) == 0L)
                                break;
                            if (kind > 14)
                                kind = 14;
                        {
                            jjCheckNAddTwoStates(8, 9);
                        }
                        break;
                        case 9:
                            if ((0x408000000000L & l) != 0L) {
                                jjCheckNAddTwoStates(9, 10);
                            }
                            break;
                        case 10:
                            if ((0x3ff200000000000L & l) == 0L)
                                break;
                            if (kind > 14)
                                kind = 14;
                        {
                            jjCheckNAddTwoStates(9, 10);
                        }
                        break;
                        case 11:
                            if (curChar != 32)
                                break;
                            if (kind > 16)
                                kind = 16;
                        {
                            jjCheckNAdd(11);
                        }
                        break;
                        case 12:
                            if (kind > 17)
                                kind = 17;
                            break;
                        case 13:
                            if (curChar == 39) {
                                jjAddStates(3, 4);
                            }
                            break;
                        case 14:
                            if ((0xffffff7fffffdbffL & l) != 0L) {
                                jjCheckNAdd(15);
                            }
                            break;
                        case 15:
                            if (curChar == 39 && kind > 18)
                                kind = 18;
                            break;
                        case 17:
                            if ((0x8400000000L & l) != 0L) {
                                jjCheckNAdd(15);
                            }
                            break;
                        case 18:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAddTwoStates(19, 15);
                            }
                            break;
                        case 19:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAdd(15);
                            }
                            break;
                        case 20:
                            if ((0xf000000000000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 21;
                            break;
                        case 21:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAdd(19);
                            }
                            break;
                        case 22:
                            if (curChar == 34) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 23:
                            if ((0xfffffffbffffdbffL & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 25:
                            if ((0x8400000000L & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 26:
                            if (curChar == 34 && kind > 19)
                                kind = 19;
                            break;
                        case 27:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAddStates(5, 8);
                            }
                            break;
                        case 28:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 29:
                            if ((0xf000000000000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 30;
                            break;
                        case 30:
                            if ((0xff000000000000L & l) != 0L) {
                                jjCheckNAdd(28);
                            }
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            } else if (curChar < 128) {
                long l = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                        case 3:
                            if (kind > 17)
                                kind = 17;
                            if ((0x7fffffe07fffffeL & l) != 0L) {
                                if (kind > 14)
                                    kind = 14;
                                {
                                    jjCheckNAddTwoStates(8, 9);
                                }
                            }
                            break;
                        case 1:
                            if (kind > 5)
                                kind = 5;
                            break;
                        case 8:
                            if ((0x7fffffe07fffffeL & l) == 0L)
                                break;
                            if (kind > 14)
                                kind = 14;
                        {
                            jjCheckNAddTwoStates(8, 9);
                        }
                        break;
                        case 10:
                            if ((0x7fffffe07fffffeL & l) == 0L)
                                break;
                            if (kind > 14)
                                kind = 14;
                        {
                            jjCheckNAddTwoStates(9, 10);
                        }
                        break;
                        case 12:
                            if (kind > 17)
                                kind = 17;
                            break;
                        case 14:
                            if ((0xffffffffefffffffL & l) != 0L) {
                                jjCheckNAdd(15);
                            }
                            break;
                        case 16:
                            if (curChar == 92) {
                                jjAddStates(9, 11);
                            }
                            break;
                        case 17:
                            if ((0x14404410144044L & l) != 0L) {
                                jjCheckNAdd(15);
                            }
                            break;
                        case 23:
                            if ((0xffffffffefffffffL & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
                            break;
                        case 24:
                            if (curChar == 92) {
                                jjAddStates(12, 14);
                            }
                            break;
                        case 25:
                            if ((0x14404410144044L & l) != 0L) {
                                jjCheckNAddStates(0, 2);
                            }
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
                        case 3:
                            if ((jjbitVec0[i2] & l2) != 0L && kind > 17)
                                kind = 17;
                            break;
                        case 1:
                            if ((jjbitVec0[i2] & l2) != 0L && kind > 5)
                                kind = 5;
                            break;
                        case 14:
                            if ((jjbitVec0[i2] & l2) != 0L)
                                jjstateSet[jjnewStateCnt++] = 15;
                            break;
                        case 23:
                            if ((jjbitVec0[i2] & l2) != 0L) {
                                jjAddStates(0, 2);
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
            if ((i = jjnewStateCnt) == (startsAt = 31 - (jjnewStateCnt = startsAt)))
                return curPos;
            try {
                curChar = input_stream.readChar();
            } catch (java.io.IOException e) {
                return curPos;
            }
        }
    }

    private int jjMoveStringLiteralDfa0_1() {
        return jjMoveNfa_1(1, 0);
    }

    private int jjMoveNfa_1(int startState, int curPos) {
        int startsAt = 0;
        jjnewStateCnt = 7;
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
                        case 1:
                            if (kind > 4)
                                kind = 4;
                            if ((0x3ff200000000000L & l) != 0L) {
                                if (kind > 3)
                                    kind = 3;
                                {
                                    jjCheckNAddTwoStates(3, 4);
                                }
                            } else if ((0x2400L & l) != 0L) {
                                if (kind > 2)
                                    kind = 2;
                            }
                            if (curChar == 13)
                                jjstateSet[jjnewStateCnt++] = 0;
                            break;
                        case 0:
                            if (curChar == 10 && kind > 2)
                                kind = 2;
                            break;
                        case 2:
                            if ((0x2400L & l) != 0L && kind > 2)
                                kind = 2;
                            break;
                        case 3:
                            if ((0x3ff200000000000L & l) == 0L)
                                break;
                            if (kind > 3)
                                kind = 3;
                        {
                            jjCheckNAddTwoStates(3, 4);
                        }
                        break;
                        case 4:
                            if ((0x408000000000L & l) != 0L) {
                                jjCheckNAddTwoStates(4, 5);
                            }
                            break;
                        case 5:
                            if ((0x3ff200000000000L & l) == 0L)
                                break;
                            if (kind > 3)
                                kind = 3;
                        {
                            jjCheckNAddTwoStates(4, 5);
                        }
                        break;
                        case 6:
                            if (kind > 4)
                                kind = 4;
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            } else if (curChar < 128) {
                long l = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                        case 1:
                            if (kind > 4)
                                kind = 4;
                            if ((0x7fffffe07fffffeL & l) != 0L) {
                                if (kind > 3)
                                    kind = 3;
                                {
                                    jjCheckNAddTwoStates(3, 4);
                                }
                            }
                            break;
                        case 3:
                            if ((0x7fffffe07fffffeL & l) == 0L)
                                break;
                            if (kind > 3)
                                kind = 3;
                        {
                            jjCheckNAddTwoStates(3, 4);
                        }
                        break;
                        case 5:
                            if ((0x7fffffe07fffffeL & l) == 0L)
                                break;
                            if (kind > 3)
                                kind = 3;
                        {
                            jjCheckNAddTwoStates(4, 5);
                        }
                        break;
                        case 6:
                            if (kind > 4)
                                kind = 4;
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
                        case 1:
                            if ((jjbitVec0[i2] & l2) != 0L && kind > 4)
                                kind = 4;
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
            if ((i = jjnewStateCnt) == (startsAt = 7 - (jjnewStateCnt = startsAt)))
                return curPos;
            try {
                curChar = input_stream.readChar();
            } catch (java.io.IOException e) {
                return curPos;
            }
        }
    }

    final int[] jjnextStates = {
            23, 24, 26, 14, 16, 23, 24, 28, 26, 17, 18, 20, 25, 27, 29,
    };

    public final String[] jjstrLiteralImages = {
            "", "\57\57", null, null, null, null, "\57\52", null, null, null, null, null,
            null, null, null, null, null, null, null, null,};

    protected Token jjFillToken() {
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

    int curLexState = 0;
    int defaultLexState = 0;
    int jjnewStateCnt;
    int jjround;
    int jjmatchedPos;
    int jjmatchedKind;

    public Token getNextToken() {
        Token matchedToken;
        int curPos = 0;

        EOFLoop:
        for (; ; ) {
            try {
                curChar = input_stream.BeginToken();
            } catch (java.io.IOException e) {
                jjmatchedKind = 0;
                jjmatchedPos = -1;
                matchedToken = jjFillToken();
                return matchedToken;
            }
            image = jjimage;
            image.setLength(0);
            jjimageLen = 0;

            switch (curLexState) {
                case 0:
                    jjmatchedKind = 0x7fffffff;
                    jjmatchedPos = 0;
                    curPos = jjMoveStringLiteralDfa0_0();
                    break;
                case 1:
                    jjmatchedKind = 0x7fffffff;
                    jjmatchedPos = 0;
                    curPos = jjMoveStringLiteralDfa0_1();
                    break;
                case 2:
                    jjmatchedKind = 0x7fffffff;
                    jjmatchedPos = 0;
                    curPos = jjMoveStringLiteralDfa0_2();
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
                } else {
                    SkipLexicalActions(null);
                    if (jjnewLexState[jjmatchedKind] != -1)
                        curLexState = jjnewLexState[jjmatchedKind];
                    continue EOFLoop;
                }
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

    void SkipLexicalActions(Token matchedToken) {
        switch (jjmatchedKind) {
            case 2:
                image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                break;
            case 3:
                image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                // A hashline only gets printed if there is a word in the comment.
                if (justStartedComment) {
                    justStartedComment = false;
                    //Comment.printLineNo();
                }
                commonCommentLength += image.length();
                break;
            case 8:
                image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                // by setting this to true we ensure that the line number is printed
                // when a word is parsed.
                justStartedComment = true;
                break;
            case 9:
                image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                if (justStartedComment) {
                    justStartedComment = false;
                }
                commonCommentLength += image.length();
                break;
            default:
                break;
        }
    }

    void TokenLexicalActions(Token matchedToken) {
        switch (jjmatchedKind) {
            case 1:
                image.append(jjstrLiteralImages[1]);
                lengthOfMatch = jjstrLiteralImages[1].length();
                justStartedComment = true;
                break;
            case 5:
                image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                justStartedComment = true;
                input_stream.backup(1);
                break;
            case 6:
                image.append(jjstrLiteralImages[6]);
                lengthOfMatch = jjstrLiteralImages[6].length();
                justStartedComment = true;
                break;
            default:
                break;
        }
    }

    private void jjCheckNAdd(int state) {
        if (jjrounds[state] != jjround) {
            jjstateSet[jjnewStateCnt++] = state;
            jjrounds[state] = jjround;
        }
    }

    private void jjAddStates(int start, int end) {
        do {
            jjstateSet[jjnewStateCnt++] = jjnextStates[start];
        } while (start++ != end);
    }

    private void jjCheckNAddTwoStates(int state1, int state2) {
        jjCheckNAdd(state1);
        jjCheckNAdd(state2);
    }

    private void jjCheckNAddStates(int start, int end) {
        do {
            jjCheckNAdd(jjnextStates[start]);
        } while (start++ != end);
    }

    public CommentTokenManager(SimpleCharStream stream) {

        if (input_stream != null)
            throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

        input_stream = stream;
    }

    public CommentTokenManager(SimpleCharStream stream, int lexState) {
        ReInit(stream);
        SwitchTo(lexState);
    }

    public void ReInit(SimpleCharStream stream) {
        jjmatchedPos = jjnewStateCnt = 0;
        curLexState = defaultLexState;
        input_stream = stream;
        ReInitRounds();
    }

    private void ReInitRounds() {
        int i;
        jjround = 0x80000001;
        for (i = 31; i-- > 0; )
            jjrounds[i] = 0x80000000;
    }

    public void ReInit(SimpleCharStream stream, int lexState) {
        ReInit(stream);
        SwitchTo(lexState);
    }

    public void SwitchTo(int lexState) {
        if (lexState >= 3 || lexState < 0)
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
        else
            curLexState = lexState;
    }

    public int getCommonCommentLength() {
        return commonCommentLength;
    }

    public final String[] lexStateNames = {
            "DEFAULT",
            "inSingleLineComment",
            "inFormalOrMultiLineComment",
    };

    public final int[] jjnewLexState = {
            -1, 1, 0, -1, -1, 2, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    };
    final long[] jjtoToken = {
            0xf7863L,
    };
    final long[] jjtoSkip = {
            0x79cL,
    };
    protected SimpleCharStream input_stream;

    private final int[] jjrounds = new int[31];
    private final int[] jjstateSet = new int[2 * 31];

    final StringBuilder jjimage = new StringBuilder();
    StringBuilder image = jjimage;
    int jjimageLen;
    int lengthOfMatch;

    protected char curChar;
}
