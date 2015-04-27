package by.bsu.project.javacc.parser.java;

import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.general.TokenMgrError;
import by.bsu.project.javacc.model.Token;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class JavaTokenManager implements JavaConstants {

    List<String> nodes = new ArrayList<>();

    public List<String> getNodes() {
        return nodes;
    }

    void toPrint(String stringToPrint) {
        nodes.add(stringToPrint);
    }

private  int jjStopStringLiteralDfa_2(int pos, long active0){
   switch (pos)
   {
      default :
         return -1;
   }
}
private  int jjStartNfa_2(int pos, long active0){
   return jjMoveNfa_2(jjStopStringLiteralDfa_2(pos, active0), pos + 1);
}
 private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
 private int jjMoveStringLiteralDfa0_2(){
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_2(0x100L);
      default :
         return jjMoveNfa_2(0, 0);
   }
}
 private int jjMoveStringLiteralDfa1_2(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(1, 8);
         break;
      default :
         break;
   }
   return jjStartNfa_2(0, active0);
}
 private int jjMoveNfa_2(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 7)
                        kind = 7;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if (curChar == 10 && kind > 7)
                     kind = 7;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : if (i1 == 0 || l1 == 0 || i2 == 0 ||  l2 == 0) break; else break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private  int jjStopStringLiteralDfa_0(int pos, long active0, long active1){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x4L) != 0L)
         {
            jjmatchedKind = 98;
            return -1;
         }
         if ((active1 & 0x2L) != 0L)
            return 50;
         if ((active0 & 0x78000000000L) != 0L)
         {
            jjmatchedKind = 46;
            return 146;
         }
         if ((active0 & 0x1e00000L) != 0L)
         {
            jjmatchedKind = 46;
            return 44;
         }
         if ((active0 & 0x3c400L) != 0L)
         {
            jjmatchedKind = 46;
            return 9;
         }
         if ((active0 & 0xc0000L) != 0L)
         {
            jjmatchedKind = 46;
            return 15;
         }
         if ((active1 & 0x808L) != 0L)
            return 179;
         if ((active1 & 0x410L) != 0L)
            return 174;
         if ((active1 & 0xe06000L) != 0L)
            return 73;
         if ((active0 & 0x2000L) != 0L)
         {
            jjmatchedKind = 46;
            return 160;
         }
         if ((active0 & 0x7000000000L) != 0L)
         {
            jjmatchedKind = 46;
            return 124;
         }
         if ((active0 & 0x80bfe000800L) != 0L)
         {
            jjmatchedKind = 46;
            return 99;
         }
         if ((active0 & 0x18L) != 0L || (active1 & 0x20100000L) != 0L)
            return 5;
         if ((active0 & 0x100000000000L) != 0L)
         {
            jjmatchedKind = 46;
            return 32;
         }
         if ((active0 & 0x400000000L) != 0L)
         {
            jjmatchedKind = 46;
            return 106;
         }
         if ((active0 & 0x100000L) != 0L)
         {
            jjmatchedKind = 46;
            return 39;
         }
         return -1;
      case 1:
         if ((active0 & 0x18000000000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 1;
            return 145;
         }
         if ((active0 & 0x2000000L) != 0L)
            return 99;
         if ((active0 & 0x187ffdb7ec00L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 1;
            return 99;
         }
         if ((active0 & 0x400000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 1;
            return 43;
         }
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 98;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x60000000000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 1;
            return 152;
         }
         if ((active0 & 0x10L) != 0L)
            return 3;
         if ((active0 & 0x80000L) != 0L)
            return 14;
         return -1;
      case 2:
         if ((active0 & 0x10000000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 46;
               jjmatchedPos = 2;
            }
            return 144;
         }
         if ((active0 & 0x40161000000L) != 0L)
            return 99;
         if ((active0 & 0x400000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 46;
               jjmatchedPos = 2;
            }
            return 42;
         }
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 98;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x1afe9cb7ec00L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 46;
               jjmatchedPos = 2;
            }
            return 99;
         }
         return -1;
      case 3:
         if ((active0 & 0x400000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 3;
            return 41;
         }
         if ((active0 & 0x20200104800L) != 0L)
            return 99;
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 98;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x18fcdca7a400L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 3;
            return 99;
         }
         if ((active0 & 0x10000000000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 3;
            return 143;
         }
         return -1;
      case 4:
         if ((active0 & 0x83000a1a400L) != 0L)
            return 99;
         if ((active0 & 0x400000L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 4;
            return 99;
         }
         if ((active0 & 0x104cdc060000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 4;
            return 99;
         }
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 98;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x10000000000L) != 0L)
            return 183;
         return -1;
      case 5:
         if ((active0 & 0x104888000000L) != 0L)
            return 99;
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 98;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x454460000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 5;
            return 99;
         }
         return -1;
      case 6:
         if ((active0 & 0x400440000L) != 0L)
            return 99;
         if ((active0 & 0x54020000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 6;
            return 99;
         }
         return -1;
      case 7:
         if ((active0 & 0x54000000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 7;
            return 99;
         }
         if ((active0 & 0x20000L) != 0L)
            return 99;
         return -1;
      case 8:
         if ((active0 & 0x40000000L) != 0L)
            return 99;
         if ((active0 & 0x14000000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 8;
            return 99;
         }
         return -1;
      default :
         return -1;
   }
}
private  int jjStartNfa_0(int pos, long active0, long active1){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
 private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 69;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1000L);
      case 35:
         return jjMoveStringLiteralDfa1_0(0x4L, 0x0L);
      case 37:
         jjmatchedKind = 88;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x80000000L);
      case 38:
         jjmatchedKind = 85;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x4000L);
      case 40:
         return jjStopAtPos(0, 57);
      case 41:
         return jjStopAtPos(0, 58);
      case 42:
         jjmatchedKind = 83;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x10000000L);
      case 43:
         jjmatchedKind = 81;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x4008000L);
      case 44:
         return jjStopAtPos(0, 64);
      case 45:
         jjmatchedKind = 82;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x8010000L);
      case 46:
         return jjStartNfaWithStates_0(0, 65, 50);
      case 47:
         jjmatchedKind = 84;
         return jjMoveStringLiteralDfa1_0(0x18L, 0x20000000L);
      case 58:
         return jjStopAtPos(0, 72);
      case 59:
         return jjStopAtPos(0, 63);
      case 60:
         jjmatchedKind = 68;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x400L);
      case 61:
         jjmatchedKind = 66;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x200L);
      case 62:
         jjmatchedKind = 67;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x800L);
      case 63:
         return jjStopAtPos(0, 71);
      case 91:
         return jjStopAtPos(0, 61);
      case 93:
         return jjStopAtPos(0, 62);
      case 94:
         return jjStartNfaWithStates_0(0, 87, 73);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x100000000000L, 0x0L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x2000L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x3c400L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0xc0000L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x100000L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x1e00000L, 0x0L);
      case 103:
         return jjMoveStringLiteralDfa1_0(0x800L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x7e000000L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x380000000L, 0x0L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x400000000L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x800000000L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x7000000000L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x78000000000L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x80000000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 59);
      case 124:
         jjmatchedKind = 86;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x2000L);
      case 125:
         return jjStopAtPos(0, 60);
      case 126:
         return jjStopAtPos(0, 70);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
 private int jjMoveStringLiteralDfa1_0(long active0, long active1){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active1 & 0x4000L) != 0L)
            return jjStopAtPos(1, 78);
         break;
      case 42:
         if ((active0 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(1, 4, 3);
         break;
      case 43:
         if ((active1 & 0x8000L) != 0L)
            return jjStopAtPos(1, 79);
         break;
      case 45:
         if ((active1 & 0x10000L) != 0L)
            return jjStopAtPos(1, 80);
         break;
      case 47:
         if ((active0 & 0x8L) != 0L)
            return jjStopAtPos(1, 3);
         break;
      case 61:
         if ((active1 & 0x200L) != 0L)
            return jjStopAtPos(1, 73);
         else if ((active1 & 0x400L) != 0L)
            return jjStopAtPos(1, 74);
         else if ((active1 & 0x800L) != 0L)
            return jjStopAtPos(1, 75);
         else if ((active1 & 0x1000L) != 0L)
            return jjStopAtPos(1, 76);
         else if ((active1 & 0x4000000L) != 0L)
            return jjStopAtPos(1, 90);
         else if ((active1 & 0x8000000L) != 0L)
            return jjStopAtPos(1, 91);
         else if ((active1 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 92);
         else if ((active1 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 93);
         else if ((active1 & 0x80000000L) != 0L)
            return jjStopAtPos(1, 95);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x48020c000L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x900040000L, active1, 0L);
      case 102:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(1, 25, 99);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x99000000000L, active1, 0L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L, active1, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x910004L, active1, 0L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0xc000000L, active1, 0L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x70000000L, active1, 0L);
      case 111:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(1, 19, 14);
         return jjMoveStringLiteralDfa2_0(active0, 0x1020c00L, active1, 0L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x60000002000L, active1, 0L);
      case 115:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000000L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x2200000000L, active1, 0L);
      case 119:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000L, active1, 0L);
      case 124:
         if ((active1 & 0x2000L) != 0L)
            return jjStopAtPos(1, 77);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
 private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1){
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x8c000000004L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x200200000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x420400L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000800000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x200c000000L);
      case 114:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 99);
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x100010104000L);
      case 116:
         if ((active0 & 0x20000000L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x8c0008800L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000000L);
      case 119:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(2, 32, 99);
         break;
      case 121:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 42, 99);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
 private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0xc42000L);
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000L);
      case 101:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(3, 14, 99);
         else if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 20, 99);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 41, 99);
         return jjMoveStringLiteralDfa4_0(active0, 0x102040000000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      case 107:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000L);
      case 108:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(3, 33, 99);
         return jjMoveStringLiteralDfa4_0(active0, 0x80004000000L);
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x4L);
      case 111:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 99);
         return jjMoveStringLiteralDfa4_0(active0, 0x10008000000L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000210400L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x4010020000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
 private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 46:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(4, 39);
         break;
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x410000000L);
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000000L);
      case 101:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(4, 21, 99);
         else if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 43, 99);
         return jjMoveStringLiteralDfa5_0(active0, 0x4000004L);
      case 104:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(4, 15, 99);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
      case 107:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(4, 13, 99);
         break;
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000L);
      case 114:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 37, 99);
         return jjMoveStringLiteralDfa5_0(active0, 0x100848000000L);
      case 115:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(4, 16, 99);
         break;
      case 116:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 99);
         else if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(4, 23, 99);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 36, 99);
         break;
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000L);
      case 118:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      case 119:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 40, 183);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
 private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 32:
         if ((active0 & 0x4L) != 0L)
            return jjStopAtPos(5, 2);
         break;
      case 101:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(5, 31, 99);
         break;
      case 102:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000000L);
      case 103:
         return jjMoveStringLiteralDfa6_0(active0, 0x400000000L);
      case 104:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 38, 99);
         break;
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x440000L);
      case 109:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000000L);
      case 110:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(5, 35, 99);
         return jjMoveStringLiteralDfa6_0(active0, 0x10020000L);
      case 116:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(5, 27, 99);
         else if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 44, 99);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
 private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x40000000L);
      case 99:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000000L);
      case 101:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(6, 34, 99);
         return jjMoveStringLiteralDfa7_0(active0, 0x4000000L);
      case 116:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(6, 18, 99);
         break;
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x20000L);
      case 121:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(6, 22, 99);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
 private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa8_0(active0, 0x40000000L);
      case 101:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(7, 17, 99);
         return jjMoveStringLiteralDfa8_0(active0, 0x10000000L);
      case 110:
         return jjMoveStringLiteralDfa8_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L);
}
 private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(8, 30, 99);
         break;
      case 111:
         return jjMoveStringLiteralDfa9_0(active0, 0x10000000L);
      case 116:
         return jjMoveStringLiteralDfa9_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0, 0L);
}
 private int jjMoveStringLiteralDfa9_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 102:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(9, 28, 99);
         break;
      case 115:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(9, 26, 99);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0, 0L);
}
 private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
 long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
 long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
 long[] jjbitVec3 = {
   0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
};
 long[] jjbitVec4 = {
   0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
};
 long[] jjbitVec5 = {
   0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
 long[] jjbitVec6 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
};
 long[] jjbitVec7 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
};
 long[] jjbitVec8 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
 private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 183;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 44:
               case 99:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 42:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 152:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 174:
                  if (curChar == 60)
                     { jjCheckNAdd(175); }
                  if (curChar == 60)
                  {
                     if (kind > 89)
                        kind = 89;
                  }
                  break;
               case 144:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 14:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 0:
                  if (kind > 98)
                     kind = 98;
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddStates(0, 6); }
                  else if ((0x100001200L & l) != 0L)
                  {
                     if (kind > 97)
                        kind = 97;
                  }
                  else if ((0x2400L & l) != 0L)
                  {
                     if (kind > 1)
                        kind = 1;
                  }
                  else if (curChar == 62)
                     { jjCheckNAddStates(7, 10); }
                  else if (curChar == 60)
                     { jjAddStates(11, 12); }
                  else if (curChar == 36)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  else if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 73;
                  else if (curChar == 34)
                     { jjCheckNAddStates(13, 15); }
                  else if (curChar == 39)
                     { jjAddStates(16, 17); }
                  else if (curChar == 46)
                     { jjCheckNAdd(50); }
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 5;
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 49)
                        kind = 49;
                     { jjCheckNAddTwoStates(47, 48); }
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 49)
                        kind = 49;
                     { jjCheckNAddStates(18, 20); }
                  }
                  else if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 9:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 106:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 39:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 43:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 41:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 179:
                  if (curChar == 62)
                     jjstateSet[jjnewStateCnt++] = 181;
                  if (curChar == 62)
                     { jjCheckNAdd(175); }
                  if (curChar == 62)
                     { jjCheckNAdd(178); }
                  if (curChar == 62)
                  {
                     if (kind > 89)
                        kind = 89;
                  }
                  break;
               case 124:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 183:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 32:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 146:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 145:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 160:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 143:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 15:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 1:
                  if (curChar == 10 && kind > 1)
                     kind = 1;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 3:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 4:
                  if ((0xffff7fffffffffffL & l) != 0L && kind > 5)
                     kind = 5;
                  break;
               case 5:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 6:
                  if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 46:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  { jjCheckNAddTwoStates(47, 48); }
                  break;
               case 47:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  { jjCheckNAddTwoStates(47, 48); }
                  break;
               case 49:
                  if (curChar == 46)
                     { jjCheckNAdd(50); }
                  break;
               case 50:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 53)
                     kind = 53;
                  { jjCheckNAddStates(21, 23); }
                  break;
               case 52:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(53); }
                  break;
               case 53:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 53)
                     kind = 53;
                  { jjCheckNAddTwoStates(53, 54); }
                  break;
               case 55:
                  if (curChar == 39)
                     { jjAddStates(16, 17); }
                  break;
               case 56:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     { jjCheckNAdd(57); }
                  break;
               case 57:
                  if (curChar == 39 && kind > 55)
                     kind = 55;
                  break;
               case 59:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAdd(57); }
                  break;
               case 60:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(61, 57); }
                  break;
               case 61:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAdd(57); }
                  break;
               case 62:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 63:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAdd(61); }
                  break;
               case 64:
                  if (curChar == 34)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 65:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 67:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 68:
                  if (curChar == 34 && kind > 56)
                     kind = 56;
                  break;
               case 69:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(24, 27); }
                  break;
               case 70:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 71:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 72;
                  break;
               case 72:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAdd(70); }
                  break;
               case 73:
                  if (curChar == 61 && kind > 94)
                     kind = 94;
                  break;
               case 74:
                  if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 73;
                  break;
               case 77:
                  if ((0x100001200L & l) != 0L && kind > 97)
                     kind = 97;
                  break;
               case 78:
                  if (kind > 98)
                     kind = 98;
                  break;
               case 79:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddStates(0, 6); }
                  break;
               case 80:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(80, 81); }
                  break;
               case 81:
                  if (curChar != 46)
                     break;
                  if (kind > 53)
                     kind = 53;
                  { jjCheckNAddStates(28, 30); }
                  break;
               case 82:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 53)
                     kind = 53;
                  { jjCheckNAddStates(28, 30); }
                  break;
               case 84:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(85); }
                  break;
               case 85:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 53)
                     kind = 53;
                  { jjCheckNAddTwoStates(85, 54); }
                  break;
               case 86:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(86, 87); }
                  break;
               case 88:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(89); }
                  break;
               case 89:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 53)
                     kind = 53;
                  { jjCheckNAddTwoStates(89, 54); }
                  break;
               case 90:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddStates(31, 33); }
                  break;
               case 92:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(93); }
                  break;
               case 93:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(93, 54); }
                  break;
               case 94:
                  if (curChar != 48)
                     break;
                  if (kind > 49)
                     kind = 49;
                  { jjCheckNAddStates(18, 20); }
                  break;
               case 96:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  { jjCheckNAddTwoStates(96, 48); }
                  break;
               case 97:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  { jjCheckNAddTwoStates(97, 48); }
                  break;
               case 98:
                  if (curChar != 36)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 173:
                  if (curChar == 60)
                     { jjAddStates(11, 12); }
                  break;
               case 175:
                  if (curChar == 61 && kind > 96)
                     kind = 96;
                  break;
               case 176:
                  if (curChar == 60)
                     { jjCheckNAdd(175); }
                  break;
               case 177:
                  if (curChar == 62)
                     { jjCheckNAddStates(7, 10); }
                  break;
               case 178:
                  if (curChar == 62 && kind > 89)
                     kind = 89;
                  break;
               case 180:
               case 181:
                  if (curChar == 62)
                     { jjCheckNAdd(175); }
                  break;
               case 182:
                  if (curChar == 62)
                     jjstateSet[jjnewStateCnt++] = 181;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 44:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 43;
                  break;
               case 42:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 41;
                  break;
               case 152:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 151;
                  break;
               case 144:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 143;
                  break;
               case 14:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  else if (curChar == 94)
                     { jjCheckNAdd(73); }
                  else if (curChar == 124)
                     { jjCheckNAdd(73); }
                  if ((0xf8000001ffffffffL & l) != 0L)
                  {
                     if (kind > 98)
                        kind = 98;
                  }
                  else if (curChar == 118)
                     { jjAddStates(34, 35); }
                  else if (curChar == 98)
                     { jjAddStates(36, 37); }
                  else if (curChar == 116)
                     { jjAddStates(38, 39); }
                  else if (curChar == 115)
                     { jjAddStates(40, 42); }
                  else if (curChar == 112)
                     { jjAddStates(43, 45); }
                  else if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 44;
                  else if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 39;
                  else if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 32;
                  else if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 19;
                  else if (curChar == 100)
                     jjstateSet[jjnewStateCnt++] = 15;
                  else if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 9;
                  if (curChar == 83)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 9:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 104)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 106:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 118;
                  else if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 113;
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 105;
                  break;
               case 39:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 120)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 43:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 42;
                  break;
               case 41:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 108)
                  {
                     if (kind > 45)
                        kind = 45;
                  }
                  break;
               case 124:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 140;
                  else if (curChar == 121)
                     jjstateSet[jjnewStateCnt++] = 133;
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 123;
                  break;
               case 183:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 115)
                  {
                     if (kind > 45)
                        kind = 45;
                  }
                  break;
               case 32:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 31;
                  break;
               case 146:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 152;
                  else if (curChar == 104)
                     jjstateSet[jjnewStateCnt++] = 145;
                  break;
               case 145:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 144;
                  break;
               case 160:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 121)
                     jjstateSet[jjnewStateCnt++] = 161;
                  else if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 159;
                  break;
               case 143:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 119)
                     { jjCheckNAdd(34); }
                  break;
               case 15:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 4:
                  if (kind > 5)
                     kind = 5;
                  break;
               case 7:
                  if (curChar == 114 && kind > 12)
                     kind = 12;
                  break;
               case 8:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 10:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if (curChar == 101 && kind > 12)
                     kind = 12;
                  break;
               case 12:
                  if (curChar == 108)
                     { jjCheckNAdd(11); }
                  break;
               case 13:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 16:
                  if (curChar == 100)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 17:
                  if (curChar == 103 && kind > 12)
                     kind = 12;
                  break;
               case 18:
               case 21:
                  if (curChar == 110)
                     { jjCheckNAdd(17); }
                  break;
               case 19:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 20:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 22:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 23;
                  break;
               case 25:
                  if (curChar == 83)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 26:
                  if (curChar == 116 && kind > 45)
                     kind = 45;
                  break;
               case 27:
                  if (curChar == 99)
                     { jjCheckNAdd(26); }
                  break;
               case 28:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 29:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 30:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 33:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 32;
                  break;
               case 34:
                  if (curChar == 115 && kind > 45)
                     kind = 45;
                  break;
               case 35:
                  if (curChar == 100)
                     { jjCheckNAdd(34); }
                  break;
               case 36:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 35;
                  break;
               case 37:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 36;
                  break;
               case 38:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 40:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 45:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 48:
                  if ((0x100000001000L & l) != 0L && kind > 49)
                     kind = 49;
                  break;
               case 51:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(46, 47); }
                  break;
               case 54:
                  if ((0x5000000050L & l) != 0L && kind > 53)
                     kind = 53;
                  break;
               case 56:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAdd(57); }
                  break;
               case 58:
                  if (curChar == 92)
                     { jjAddStates(48, 50); }
                  break;
               case 59:
                  if ((0x14404410000000L & l) != 0L)
                     { jjCheckNAdd(57); }
                  break;
               case 65:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 66:
                  if (curChar == 92)
                     { jjAddStates(51, 53); }
                  break;
               case 67:
                  if ((0x14404410000000L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 75:
                  if (curChar == 124)
                     { jjCheckNAdd(73); }
                  break;
               case 76:
                  if (curChar == 94)
                     { jjCheckNAdd(73); }
                  break;
               case 78:
                  if ((0xf8000001ffffffffL & l) != 0L && kind > 98)
                     kind = 98;
                  break;
               case 83:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(54, 55); }
                  break;
               case 87:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(56, 57); }
                  break;
               case 91:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(58, 59); }
                  break;
               case 95:
                  if ((0x100000001000000L & l) != 0L)
                     { jjCheckNAdd(96); }
                  break;
               case 96:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  { jjCheckNAddTwoStates(96, 48); }
                  break;
               case 98:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 99:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 100:
                  if (curChar == 112)
                     { jjAddStates(43, 45); }
                  break;
               case 101:
                  if (curChar == 101 && kind > 45)
                     kind = 45;
                  break;
               case 102:
                  if (curChar == 116)
                     { jjCheckNAdd(101); }
                  break;
               case 103:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 102;
                  break;
               case 104:
                  if (curChar == 118)
                     jjstateSet[jjnewStateCnt++] = 103;
                  break;
               case 105:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 104;
                  break;
               case 107:
                  if (curChar == 100 && kind > 45)
                     kind = 45;
                  break;
               case 108:
               case 125:
                  if (curChar == 101)
                     { jjCheckNAdd(107); }
                  break;
               case 109:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 108;
                  break;
               case 110:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 109;
                  break;
               case 111:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 110;
                  break;
               case 112:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 111;
                  break;
               case 113:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 112;
                  break;
               case 114:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 113;
                  break;
               case 115:
                  if (curChar == 99 && kind > 45)
                     kind = 45;
                  break;
               case 116:
               case 121:
                  if (curChar == 105)
                     { jjCheckNAdd(115); }
                  break;
               case 117:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 116;
                  break;
               case 118:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 117;
                  break;
               case 119:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 118;
                  break;
               case 120:
                  if (curChar == 115)
                     { jjAddStates(40, 42); }
                  break;
               case 122:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 121;
                  break;
               case 123:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 122;
                  break;
               case 126:
                  if (curChar == 122)
                     jjstateSet[jjnewStateCnt++] = 125;
                  break;
               case 127:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 126;
                  break;
               case 128:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 127;
                  break;
               case 129:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 128;
                  break;
               case 130:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 129;
                  break;
               case 131:
                  if (curChar == 104)
                     jjstateSet[jjnewStateCnt++] = 130;
                  break;
               case 132:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 131;
                  break;
               case 133:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 132;
                  break;
               case 134:
                  if (curChar == 121)
                     jjstateSet[jjnewStateCnt++] = 133;
                  break;
               case 135:
                  if (curChar == 112 && kind > 45)
                     kind = 45;
                  break;
               case 136:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 135;
                  break;
               case 137:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 136;
                  break;
               case 138:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 137;
                  break;
               case 139:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 138;
                  break;
               case 140:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 139;
                  break;
               case 141:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 140;
                  break;
               case 142:
                  if (curChar == 116)
                     { jjAddStates(38, 39); }
                  break;
               case 147:
                  if (curChar == 110)
                     { jjCheckNAdd(26); }
                  break;
               case 148:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 147;
                  break;
               case 149:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 148;
                  break;
               case 150:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 149;
                  break;
               case 151:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 150;
                  break;
               case 153:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 152;
                  break;
               case 154:
                  if (curChar == 98)
                     { jjAddStates(36, 37); }
                  break;
               case 155:
                  if (curChar == 110 && kind > 12)
                     kind = 12;
                  break;
               case 156:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 155;
                  break;
               case 157:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 156;
                  break;
               case 158:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 157;
                  break;
               case 159:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 158;
                  break;
               case 161:
                  if (curChar == 116)
                     { jjCheckNAdd(11); }
                  break;
               case 162:
                  if (curChar == 121)
                     jjstateSet[jjnewStateCnt++] = 161;
                  break;
               case 163:
                  if (curChar == 118)
                     { jjAddStates(34, 35); }
                  break;
               case 164:
                  if (curChar == 100 && kind > 12)
                     kind = 12;
                  break;
               case 165:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 164;
                  break;
               case 166:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 165;
                  break;
               case 167:
                  if (curChar == 108)
                     { jjCheckNAdd(101); }
                  break;
               case 168:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 167;
                  break;
               case 169:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 168;
                  break;
               case 170:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 169;
                  break;
               case 171:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 170;
                  break;
               case 172:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 171;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 44:
               case 99:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 42:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 152:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 144:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 14:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 0:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 98)
                        kind = 98;
                  }
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 46)
                        kind = 46;
                     { jjCheckNAdd(99); }
                  }
                  break;
               case 9:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 106:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 39:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 43:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 41:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 124:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 183:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 32:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 146:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 145:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 160:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 143:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 15:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               case 4:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2) && kind > 5)
                     kind = 5;
                  break;
               case 56:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjstateSet[jjnewStateCnt++] = 57;
                  break;
               case 65:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     { jjAddStates(13, 15); }
                  break;
               case 78:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2) && kind > 98)
                     kind = 98;
                  break;
               case 98:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 46)
                     kind = 46;
                  { jjCheckNAdd(99); }
                  break;
               default : if (i1 == 0 || l1 == 0 || i2 == 0 ||  l2 == 0) break; else break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 183 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
 private int jjMoveStringLiteralDfa0_1()
{
   return jjMoveNfa_1(0, 0);
}
 private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : if (i1 == 0 || l1 == 0 || i2 == 0 ||  l2 == 0) break; else break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
 int[] jjnextStates = {
   80, 81, 86, 87, 90, 91, 54, 178, 179, 180, 182, 174, 176, 65, 66, 68, 
   56, 58, 95, 97, 48, 50, 51, 54, 65, 66, 70, 68, 82, 83, 54, 90, 
   91, 54, 166, 172, 160, 162, 146, 153, 124, 134, 141, 106, 114, 119, 52, 53, 
   59, 60, 62, 67, 69, 71, 84, 85, 88, 89, 92, 93, 
};
private  boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private  boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec6[i2] & l2) != 0L);
      case 51:
         return ((jjbitVec7[i2] & l2) != 0L);
      case 61:
         return ((jjbitVec8[i2] & l2) != 0L);
      default :
         if ((jjbitVec3[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public  String[] jjstrLiteralImages = {
"", null, "\43\154\151\156\145\40", "\57\57", "\57\52", null, null, null, null, 
null, "\143\157\156\163\164", "\147\157\164\157", null, "\142\162\145\141\153", 
"\143\141\163\145", "\143\141\164\143\150", "\143\154\141\163\163", 
"\143\157\156\164\151\156\165\145", "\144\145\146\141\165\154\164", "\144\157", "\145\154\163\145", 
"\146\141\154\163\145", "\146\151\156\141\154\154\171", "\146\154\157\141\164", "\146\157\162", 
"\151\146", "\151\155\160\154\145\155\145\156\164\163", "\151\155\160\157\162\164", 
"\151\156\163\164\141\156\143\145\157\146", "\151\156\164", "\151\156\164\145\162\146\141\143\145", 
"\156\141\164\151\166\145", "\156\145\167", "\156\165\154\154", "\160\141\143\153\141\147\145", 
"\162\145\164\165\162\156", "\163\150\157\162\164", "\163\165\160\145\162", "\163\167\151\164\143\150", 
"\164\150\151\163\56", "\164\150\162\157\167", "\164\162\165\145", "\164\162\171", 
"\167\150\151\154\145", "\141\163\163\145\162\164", null, null, null, null, null, null, null, null, 
null, null, null, null, "\50", "\51", "\173", "\175", "\133", "\135", "\73", "\54", 
"\56", "\75", "\76", "\74", "\41", "\176", "\77", "\72", "\75\75", "\74\75", 
"\76\75", "\41\75", "\174\174", "\46\46", "\53\53", "\55\55", "\53", "\55", "\52", 
"\57", "\46", "\174", "\136", "\45", null, "\53\75", "\55\75", "\52\75", "\57\75", 
null, "\45\75", null, null, null, };
 protected Token jjFillToken()
{
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

/** Get the next Token. */
public  Token getNextToken()
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   switch(curLexState)
   {
     case 0:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       break;
     case 1:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos == 0 && jjmatchedKind > 9)
       {
          jjmatchedKind = 9;
       }
       break;
     case 2:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_2();
       if (jjmatchedPos == 0 && jjmatchedKind > 9)
       {
          jjmatchedKind = 9;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           TokenLexicalActions(matchedToken);
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
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
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

 void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 6 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
         break;
      case 7 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
         break;
      default :
         break;
   }
}
 void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 1 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
         break;
      case 3 :
        image.append(jjstrLiteralImages[3]);
        lengthOfMatch = jjstrLiteralImages[3].length();
    toPrint("<SINGLE_LINE_COMMENT>");
         break;
      case 4 :
        image.append(jjstrLiteralImages[4]);
        lengthOfMatch = jjstrLiteralImages[4].length();
    toPrint("<MULTI_LINE_COMMENT>");
         break;
      case 5 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    input_stream.backup(1);
    toPrint("<FORMAL_COMMENT>");
         break;
      case 10 :
        image.append(jjstrLiteralImages[10]);
        lengthOfMatch = jjstrLiteralImages[10].length();
    toPrint("<RSVD>");
         break;
      case 11 :
        image.append(jjstrLiteralImages[11]);
        lengthOfMatch = jjstrLiteralImages[11].length();
    toPrint("<RSVD>");
         break;
      case 12 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<TYPE>");
         break;
      case 13 :
        image.append(jjstrLiteralImages[13]);
        lengthOfMatch = jjstrLiteralImages[13].length();
    toPrint("<BREAK>");
         break;
      case 14 :
        image.append(jjstrLiteralImages[14]);
        lengthOfMatch = jjstrLiteralImages[14].length();
    toPrint("<CASE>");
         break;
      case 15 :
        image.append(jjstrLiteralImages[15]);
        lengthOfMatch = jjstrLiteralImages[15].length();
    toPrint("<CATCH>");
         break;
      case 16 :
        image.append(jjstrLiteralImages[16]);
        lengthOfMatch = jjstrLiteralImages[16].length();
    toPrint("<CLASS>");
         break;
      case 17 :
        image.append(jjstrLiteralImages[17]);
        lengthOfMatch = jjstrLiteralImages[17].length();
    toPrint("<BREAK>");
         break;
      case 18 :
        image.append(jjstrLiteralImages[18]);
        lengthOfMatch = jjstrLiteralImages[18].length();
    toPrint("<CASE>");
         break;
      case 19 :
        image.append(jjstrLiteralImages[19]);
        lengthOfMatch = jjstrLiteralImages[19].length();
    toPrint("<LOOP>");
         break;
      case 20 :
        image.append(jjstrLiteralImages[20]);
        lengthOfMatch = jjstrLiteralImages[20].length();
    toPrint("<IF>");
         break;
      case 21 :
        image.append(jjstrLiteralImages[21]);
        lengthOfMatch = jjstrLiteralImages[21].length();
    toPrint("<BOOL>");
         break;
      case 22 :
        image.append(jjstrLiteralImages[22]);
        lengthOfMatch = jjstrLiteralImages[22].length();
    toPrint("<FINALLY>");
         break;
      case 23 :
        image.append(jjstrLiteralImages[23]);
        lengthOfMatch = jjstrLiteralImages[23].length();
    toPrint("<TYPE>");
         break;
      case 24 :
        image.append(jjstrLiteralImages[24]);
        lengthOfMatch = jjstrLiteralImages[24].length();
    toPrint("<LOOP>");
         break;
      case 25 :
        image.append(jjstrLiteralImages[25]);
        lengthOfMatch = jjstrLiteralImages[25].length();
    toPrint("<IF>");
         break;
      case 26 :
        image.append(jjstrLiteralImages[26]);
        lengthOfMatch = jjstrLiteralImages[26].length();
    toPrint("<MODIFIER>");
         break;
      case 27 :
        image.append(jjstrLiteralImages[27]);
        lengthOfMatch = jjstrLiteralImages[27].length();
    toPrint("<IMPORT>");
         break;
      case 28 :
        image.append(jjstrLiteralImages[28]);
        lengthOfMatch = jjstrLiteralImages[28].length();
    toPrint("==");
         break;
      case 29 :
        image.append(jjstrLiteralImages[29]);
        lengthOfMatch = jjstrLiteralImages[29].length();
    toPrint("<TYPE>");
         break;
      case 30 :
        image.append(jjstrLiteralImages[30]);
        lengthOfMatch = jjstrLiteralImages[30].length();
    toPrint("<MODIFIER>");
         break;
      case 31 :
        image.append(jjstrLiteralImages[31]);
        lengthOfMatch = jjstrLiteralImages[31].length();
    toPrint("<NATIVE>");
         break;
      case 32 :
        image.append(jjstrLiteralImages[32]);
        lengthOfMatch = jjstrLiteralImages[32].length();
    toPrint("<NEW>");
         break;
      case 33 :
        image.append(jjstrLiteralImages[33]);
        lengthOfMatch = jjstrLiteralImages[33].length();
    toPrint("<NULL>");
         break;
      case 34 :
        image.append(jjstrLiteralImages[34]);
        lengthOfMatch = jjstrLiteralImages[34].length();
    toPrint("<PACKAGE>");
         break;
      case 35 :
        image.append(jjstrLiteralImages[35]);
        lengthOfMatch = jjstrLiteralImages[35].length();
    toPrint("<RETURN>");
         break;
      case 36 :
        image.append(jjstrLiteralImages[36]);
        lengthOfMatch = jjstrLiteralImages[36].length();
    toPrint("<TYPE>");
         break;
      case 37 :
        image.append(jjstrLiteralImages[37]);
        lengthOfMatch = jjstrLiteralImages[37].length();
    toPrint("<SUPER>");
         break;
      case 38 :
        image.append(jjstrLiteralImages[38]);
        lengthOfMatch = jjstrLiteralImages[38].length();
    toPrint("<CASE>");
         break;
      case 39 :
        image.append(jjstrLiteralImages[39]);
        lengthOfMatch = jjstrLiteralImages[39].length();
    toPrint("");
         break;
      case 40 :
        image.append(jjstrLiteralImages[40]);
        lengthOfMatch = jjstrLiteralImages[40].length();
    toPrint("<TRY>");
         break;
      case 41 :
        image.append(jjstrLiteralImages[41]);
        lengthOfMatch = jjstrLiteralImages[41].length();
    toPrint("<BOOL>");
         break;
      case 42 :
        image.append(jjstrLiteralImages[42]);
        lengthOfMatch = jjstrLiteralImages[42].length();
    toPrint("<TRY>");
         break;
      case 43 :
        image.append(jjstrLiteralImages[43]);
        lengthOfMatch = jjstrLiteralImages[43].length();
    toPrint("<LOOP>");
         break;
      case 44 :
        image.append(jjstrLiteralImages[44]);
        lengthOfMatch = jjstrLiteralImages[44].length();
    toPrint("<ASSERT>");
         break;
      case 45 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<MODIFIER>");
         break;
      case 46 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<IDT>");
         break;
      case 49 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<VALUE>");
         break;
      case 53 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<VALUE>");
         break;
      case 55 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<VALUE>");
         break;
      case 56 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<VALUE>");
         break;
      case 57 :
        image.append(jjstrLiteralImages[57]);
        lengthOfMatch = jjstrLiteralImages[57].length();
         break;
      case 58 :
        image.append(jjstrLiteralImages[58]);
        lengthOfMatch = jjstrLiteralImages[58].length();
         break;
      case 59 :
        image.append(jjstrLiteralImages[59]);
        lengthOfMatch = jjstrLiteralImages[59].length();
         break;
      case 60 :
        image.append(jjstrLiteralImages[60]);
        lengthOfMatch = jjstrLiteralImages[60].length();
         break;
      case 61 :
        image.append(jjstrLiteralImages[61]);
        lengthOfMatch = jjstrLiteralImages[61].length();
         break;
      case 62 :
        image.append(jjstrLiteralImages[62]);
        lengthOfMatch = jjstrLiteralImages[62].length();
         break;
      case 63 :
        image.append(jjstrLiteralImages[63]);
        lengthOfMatch = jjstrLiteralImages[63].length();
         break;
      case 64 :
        image.append(jjstrLiteralImages[64]);
        lengthOfMatch = jjstrLiteralImages[64].length();
         break;
      case 65 :
        image.append(jjstrLiteralImages[65]);
        lengthOfMatch = jjstrLiteralImages[65].length();
         break;
      case 66 :
        image.append(jjstrLiteralImages[66]);
        lengthOfMatch = jjstrLiteralImages[66].length();
    toPrint("=");
         break;
      case 67 :
        image.append(jjstrLiteralImages[67]);
        lengthOfMatch = jjstrLiteralImages[67].length();
    toPrint("<GREATER>");
         break;
      case 68 :
        image.append(jjstrLiteralImages[68]);
        lengthOfMatch = jjstrLiteralImages[68].length();
    toPrint("<LESS>");
         break;
      case 69 :
        image.append(jjstrLiteralImages[69]);
        lengthOfMatch = jjstrLiteralImages[69].length();
    toPrint("");
         break;
      case 70 :
        image.append(jjstrLiteralImages[70]);
        lengthOfMatch = jjstrLiteralImages[70].length();
    toPrint("~");
         break;
      case 71 :
        image.append(jjstrLiteralImages[71]);
        lengthOfMatch = jjstrLiteralImages[71].length();
    toPrint("?");
         break;
      case 72 :
        image.append(jjstrLiteralImages[72]);
        lengthOfMatch = jjstrLiteralImages[72].length();
    toPrint(":");
         break;
      case 73 :
        image.append(jjstrLiteralImages[73]);
        lengthOfMatch = jjstrLiteralImages[73].length();
    toPrint("==");
         break;
      case 74 :
        image.append(jjstrLiteralImages[74]);
        lengthOfMatch = jjstrLiteralImages[74].length();
    toPrint("==");
         break;
      case 75 :
        image.append(jjstrLiteralImages[75]);
        lengthOfMatch = jjstrLiteralImages[75].length();
    toPrint("==");
         break;
      case 76 :
        image.append(jjstrLiteralImages[76]);
        lengthOfMatch = jjstrLiteralImages[76].length();
    toPrint("==");
         break;
      case 77 :
        image.append(jjstrLiteralImages[77]);
        lengthOfMatch = jjstrLiteralImages[77].length();
    toPrint("&&");
         break;
      case 78 :
        image.append(jjstrLiteralImages[78]);
        lengthOfMatch = jjstrLiteralImages[78].length();
    toPrint("&&");
         break;
      case 79 :
        image.append(jjstrLiteralImages[79]);
        lengthOfMatch = jjstrLiteralImages[79].length();
    toPrint("+=<NUM>");
         break;
      case 80 :
        image.append(jjstrLiteralImages[80]);
        lengthOfMatch = jjstrLiteralImages[80].length();
    toPrint("-=<NUM>");
         break;
      case 81 :
        image.append(jjstrLiteralImages[81]);
        lengthOfMatch = jjstrLiteralImages[81].length();
    toPrint("+");
         break;
      case 82 :
        image.append(jjstrLiteralImages[82]);
        lengthOfMatch = jjstrLiteralImages[82].length();
    toPrint("-");
         break;
      case 83 :
        image.append(jjstrLiteralImages[83]);
        lengthOfMatch = jjstrLiteralImages[83].length();
    toPrint("*");
         break;
      case 84 :
        image.append(jjstrLiteralImages[84]);
        lengthOfMatch = jjstrLiteralImages[84].length();
    toPrint("/");
         break;
      case 85 :
        image.append(jjstrLiteralImages[85]);
        lengthOfMatch = jjstrLiteralImages[85].length();
    toPrint("&");
         break;
      case 86 :
        image.append(jjstrLiteralImages[86]);
        lengthOfMatch = jjstrLiteralImages[86].length();
    toPrint("&");
         break;
      case 87 :
        image.append(jjstrLiteralImages[87]);
        lengthOfMatch = jjstrLiteralImages[87].length();
    toPrint("&");
         break;
      case 88 :
        image.append(jjstrLiteralImages[88]);
        lengthOfMatch = jjstrLiteralImages[88].length();
    toPrint("%");
         break;
      case 89 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<<");
         break;
      case 90 :
        image.append(jjstrLiteralImages[90]);
        lengthOfMatch = jjstrLiteralImages[90].length();
    toPrint("+=");
         break;
      case 91 :
        image.append(jjstrLiteralImages[91]);
        lengthOfMatch = jjstrLiteralImages[91].length();
    toPrint("-=");
         break;
      case 92 :
        image.append(jjstrLiteralImages[92]);
        lengthOfMatch = jjstrLiteralImages[92].length();
    toPrint("*=");
         break;
      case 93 :
        image.append(jjstrLiteralImages[93]);
        lengthOfMatch = jjstrLiteralImages[93].length();
    toPrint("/=");
         break;
      case 94 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("&=");
         break;
      case 95 :
        image.append(jjstrLiteralImages[95]);
        lengthOfMatch = jjstrLiteralImages[95].length();
    toPrint("%=");
         break;
      case 96 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<<=");
         break;
      default :
         break;
   }
}
 private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
 private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
 private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

 private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public JavaTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of  lexer. You must use ReInit() to initialize the  variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public JavaTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
   public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

   private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 183; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
   public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
   public void SwitchTo(int lexState)
  {
    if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public  String[] lexStateNames = {
   "DEFAULT",
   "inSingleLineComment",
   "inAnyMultiLineComment",
};

/** Lex State array. */
public  int[] jjnewLexState = {
   -1, -1, -1, 1, 2, 2, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
 long[] jjtoToken = {
   0xffa27ffffffffc3fL, 0x5ffffffffL, 
};
 long[] jjtoSkip = {
   0x3c0L, 0x200000000L, 
};
     protected SimpleCharStream input_stream;

     private final int[] jjrounds = new int[183];
     private final int[] jjstateSet = new int[2 * 183];

    private  StringBuilder jjimage = new StringBuilder();
    private  StringBuilder image = jjimage;
    private  int jjimageLen;
    private  int lengthOfMatch;
    
     protected char curChar;
}
