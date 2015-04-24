package by.bsu.project.javacc.parser.cpp;

import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.general.TokenMgrError;
import by.bsu.project.javacc.model.Token;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class CPPTokenManager implements CPPConstants {

    List<String> nodes = new ArrayList<>();

    public List<String> getNodes() {
        return nodes;
    }

    private int jjStopStringLiteralDfa_2(int pos, long active0){
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
         return jjMoveStringLiteralDfa1_2(0x80L);
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
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(1, 7);
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
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
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
         if ((active0 & 0x1e000L) != 0L)
         {
            jjmatchedKind = 57;
            return 117;
         }
         if ((active1 & 0x10000005000L) != 0L)
            return 35;
         if ((active0 & 0x800L) != 0L)
         {
            jjmatchedKind = 57;
            return 19;
         }
         if ((active1 & 0x820000L) != 0L)
            return 151;
         if ((active0 & 0xfe0000000000L) != 0L)
         {
            jjmatchedKind = 57;
            return 135;
         }
         if ((active0 & 0xf800000L) != 0L)
         {
            jjmatchedKind = 57;
            return 24;
         }
         if ((active1 & 0x1c0c000000L) != 0L)
            return 58;
         if ((active0 & 0xe0000L) != 0L)
         {
            jjmatchedKind = 57;
            return 7;
         }
         if ((active0 & 0x40000000000000L) != 0L)
         {
            jjmatchedKind = 57;
            return 124;
         }
         if ((active0 & 0xf000000000000L) != 0L)
         {
            jjmatchedKind = 57;
            return 29;
         }
         if ((active0 & 0x1000L) != 0L)
         {
            jjmatchedKind = 57;
            return 111;
         }
         if ((active0 & 0x4L) != 0L)
         {
            jjmatchedKind = 114;
            return -1;
         }
         if ((active0 & 0x2000000000L) != 0L)
         {
            jjmatchedKind = 57;
            return 91;
         }
         if ((active1 & 0x1010000L) != 0L)
            return 156;
         if ((active0 & 0xb001dff0700200L) != 0L)
         {
            jjmatchedKind = 57;
            return 84;
         }
         return -1;
      case 1:
         if ((active0 & 0x80000L) != 0L)
            return 6;
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 114;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x300000000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 1;
            }
            return 134;
         }
         if ((active0 & 0xfccfffeef6fa00L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 1;
            }
            return 84;
         }
         if ((active0 & 0x3000000000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 1;
            }
            return 28;
         }
         if ((active0 & 0x10000000L) != 0L)
            return 84;
         if ((active0 & 0x10000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 1;
            }
            return 119;
         }
         if ((active0 & 0x1000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 1;
            }
            return 23;
         }
         return -1;
      case 2:
         if ((active0 & 0x200000000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 2;
            }
            return 133;
         }
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 114;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x2000000000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 2;
            }
            return 27;
         }
         if ((active0 & 0x1000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 2;
            }
            return 22;
         }
         if ((active0 & 0x8000b04000000L) != 0L)
            return 84;
         if ((active0 & 0x10000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 2;
            }
            return 118;
         }
         if ((active0 & 0xf5cff4eaf6fa00L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 2;
            }
            return 84;
         }
         if ((active0 & 0x100000000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 57;
               jjmatchedPos = 2;
            }
            return 137;
         }
         return -1;
      case 3:
         if ((active0 & 0x2000000000000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 3;
            return 26;
         }
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 114;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x1000000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 3;
            return 21;
         }
         if ((active0 & 0x4001000302a00L) != 0L)
            return 84;
         if ((active0 & 0x100000000000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 3;
            return 136;
         }
         if ((active0 & 0xf1efe6eac7d000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 3;
            return 84;
         }
         return -1;
      case 4:
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 114;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x1000000L) != 0L)
         {
            jjmatchedKind = 56;
            jjmatchedPos = 4;
            return 84;
         }
         if ((active0 & 0x60ade6e8470000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 4;
            return 84;
         }
         if ((active0 & 0x9242000280d000L) != 0L)
            return 84;
         if ((active0 & 0x100000000000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 4;
            return 160;
         }
         return -1;
      case 5:
         if ((active0 & 0x4L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 114;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x6000e221030000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 5;
            return 84;
         }
         if ((active0 & 0xbd04c8440000L) != 0L)
            return 84;
         return -1;
      case 6:
         if ((active0 & 0x40002001020000L) != 0L)
            return 84;
         if ((active0 & 0x2000c220010000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 6;
            return 84;
         }
         return -1;
      case 7:
         if ((active0 & 0x4220000000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 7;
            return 84;
         }
         if ((active0 & 0x20008000010000L) != 0L)
            return 84;
         return -1;
      case 8:
         if ((active0 & 0x4020000000L) != 0L)
         {
            jjmatchedKind = 57;
            jjmatchedPos = 8;
            return 84;
         }
         if ((active0 & 0x200000000L) != 0L)
            return 84;
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
         jjmatchedKind = 82;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x2000000L);
      case 35:
         return jjMoveStringLiteralDfa1_0(0x4L, 0x0L);
      case 37:
         jjmatchedKind = 101;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x800000000000L);
      case 38:
         jjmatchedKind = 98;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x8000000L);
      case 40:
         return jjStopAtPos(0, 68);
      case 41:
         return jjStopAtPos(0, 69);
      case 42:
         jjmatchedKind = 96;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x100000000000L);
      case 43:
         jjmatchedKind = 94;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x40010000000L);
      case 44:
         return jjStopAtPos(0, 75);
      case 45:
         jjmatchedKind = 95;
         return jjMoveStringLiteralDfa1_0(0x0L, 0xa8020000000L);
      case 46:
         jjmatchedKind = 76;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x10000004000L);
      case 47:
         jjmatchedKind = 97;
         return jjMoveStringLiteralDfa1_0(0x18L, 0x200000000000L);
      case 58:
         jjmatchedKind = 85;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x100000L);
      case 59:
         return jjStopAtPos(0, 74);
      case 60:
         jjmatchedKind = 81;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x800000L);
      case 61:
         jjmatchedKind = 79;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x400000L);
      case 62:
         jjmatchedKind = 80;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1000000L);
      case 63:
         return jjStopAtPos(0, 77);
      case 91:
         return jjStopAtPos(0, 72);
      case 93:
         return jjStopAtPos(0, 73);
      case 94:
         return jjStartNfaWithStates_0(0, 100, 58);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa1_0(0x800L, 0x0L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa1_0(0x1000L, 0x0L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa1_0(0x1e000L, 0x0L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa1_0(0xe0000L, 0x0L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa1_0(0x700000L, 0x0L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa1_0(0xf800000L, 0x0L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa1_0(0x200L, 0x0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_0(0x3f0000000L, 0x0L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa1_0(0x1c00000000L, 0x0L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa1_0(0x2000000000L, 0x0L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_0(0x1c000000000L, 0x0L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa1_0(0xfe0000000000L, 0x0L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa1_0(0xf000000000000L, 0x0L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa1_0(0x30000000000000L, 0x0L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa1_0(0x40000000000000L, 0x0L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa1_0(0x80000000000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 70);
      case 124:
         jjmatchedKind = 99;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x4000000L);
      case 125:
         return jjStopAtPos(0, 71);
      case 126:
         return jjStopAtPos(0, 83);
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
         if ((active1 & 0x8000000L) != 0L)
            return jjStopAtPos(1, 91);
         break;
      case 42:
         if ((active0 & 0x10L) != 0L)
            return jjStopAtPos(1, 4);
         else if ((active1 & 0x10000000000L) != 0L)
            return jjStopAtPos(1, 104);
         break;
      case 43:
         if ((active1 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 92);
         break;
      case 45:
         if ((active1 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 93);
         break;
      case 46:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x4000L);
      case 47:
         if ((active0 & 0x8L) != 0L)
            return jjStopAtPos(1, 3);
         break;
      case 58:
         if ((active1 & 0x100000L) != 0L)
            return jjStopAtPos(1, 84);
         break;
      case 61:
         if ((active1 & 0x400000L) != 0L)
            return jjStopAtPos(1, 86);
         else if ((active1 & 0x800000L) != 0L)
            return jjStopAtPos(1, 87);
         else if ((active1 & 0x1000000L) != 0L)
            return jjStopAtPos(1, 88);
         else if ((active1 & 0x2000000L) != 0L)
            return jjStopAtPos(1, 89);
         else if ((active1 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 106);
         else if ((active1 & 0x80000000000L) != 0L)
            return jjStopAtPos(1, 107);
         else if ((active1 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 108);
         else if ((active1 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 109);
         else if ((active1 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 111);
         break;
      case 62:
         if ((active1 & 0x8000000000L) != 0L)
         {
            jjmatchedKind = 103;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x20000000000L);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x2400806000L, active1, 0L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1c800060000L, active1, 0L);
      case 70:
      case 102:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(1, 28, 84);
         break;
      case 72:
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x83020000000000L, active1, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x400c0001000000L, active1, 0L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x2108004L, active1, 0L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x60000000L, active1, 0L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x30000380200000L, active1, 0L);
      case 79:
      case 111:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(1, 19, 6);
         return jjMoveStringLiteralDfa2_0(active0, 0x4010200L, active1, 0L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0xc000008001000L, active1, 0L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x300000000000L, active1, 0L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x401000000800L, active1, 0L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000000L, active1, 0L);
      case 88:
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L, active1, 0L);
      case 124:
         if ((active1 & 0x4000000L) != 0L)
            return jjStopAtPos(1, 90);
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
      jjStopStringLiteralDfa_0(1, active0, active1);
      return 2;
   }
   switch(curChar)
   {
      case 42:
         if ((active1 & 0x20000000000L) != 0L)
            return jjStopAtPos(2, 105);
         break;
      case 46:
         if ((active1 & 0x4000L) != 0L)
            return jjStopAtPos(2, 78);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000008000L, active1, 0L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000000L, active1, 0L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000L, active1, 0L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L, active1, 0L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L, active1, 0L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa3_0(active0, 0x48000000000L, active1, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x91800008000004L, active1, 0L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x1080840000L, active1, 0L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x1010000L, active1, 0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x20002000000L, active1, 0L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x400060000000L, active1, 0L);
      case 82:
      case 114:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(2, 26, 84);
         return jjMoveStringLiteralDfa3_0(active0, 0x42200000000000L, active1, 0L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000102000L, active1, 0L);
      case 84:
      case 116:
         if ((active0 & 0x100000000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x10600404a00L, active1, 0L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000200000L, active1, 0L);
      case 87:
      case 119:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(2, 35, 84);
         break;
      case 89:
      case 121:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 51, 84);
         break;
      case 90:
      case 122:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000000L, active1, 0L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0, active1);
}
 private int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1){
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(1, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x3021000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 69:
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 84);
         else if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 20, 84);
         else if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 50, 84);
         return jjMoveStringLiteralDfa4_0(active0, 0x484208440000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x20008480000000L);
      case 75:
      case 107:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000000L);
      case 76:
      case 108:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 36, 84);
         return jjMoveStringLiteralDfa4_0(active0, 0x80000020000000L);
      case 77:
      case 109:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(3, 21, 84);
         break;
      case 78:
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000004L);
      case 79:
      case 111:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(3, 9, 84);
         else if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 84);
         return jjMoveStringLiteralDfa4_0(active0, 0x12000040000000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000808000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x40900000010000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x210000000000L);
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
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStopAtPos(4, 48);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0xa04000000000L);
      case 69:
      case 101:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(4, 23, 84);
         else if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 55, 84);
         return jjMoveStringLiteralDfa5_0(active0, 0x40020000004L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000000000L);
      case 72:
      case 104:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(4, 14, 84);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000010000L);
      case 75:
      case 107:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(4, 12, 84);
         break;
      case 76:
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000L);
      case 78:
      case 110:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 52, 84);
         return jjMoveStringLiteralDfa5_0(active0, 0x88000000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000000L);
      case 82:
      case 114:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 46, 84);
         return jjMoveStringLiteralDfa5_0(active0, 0x10240400000L);
      case 83:
      case 115:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(4, 15, 84);
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000000L);
      case 84:
      case 116:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(4, 25, 84);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 41, 84);
         return jjMoveStringLiteralDfa5_0(active0, 0x40000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000000020000L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000000L);
      case 87:
      case 119:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 49, 84);
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
      case 65:
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000000000000L);
      case 67:
      case 99:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 44, 84);
         break;
      case 68:
      case 100:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(5, 27, 84);
         else if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 42, 84);
         break;
      case 69:
      case 101:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(5, 18, 84);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(5, 31, 84);
         else if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(5, 34, 84);
         break;
      case 70:
      case 102:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 43, 84);
         return jjMoveStringLiteralDfa6_0(active0, 0x200000000L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000000L);
      case 72:
      case 104:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 47, 84);
         break;
      case 76:
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x4001020000L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000000L);
      case 78:
      case 110:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(5, 22, 84);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 40, 84);
         return jjMoveStringLiteralDfa6_0(active0, 0x20000000010000L);
      case 84:
      case 116:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(5, 30, 84);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 45, 84);
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000000L);
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
      case 65:
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x4200000000L);
      case 69:
      case 101:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 37, 84);
         return jjMoveStringLiteralDfa7_0(active0, 0x20008020000000L);
      case 76:
      case 108:
         if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 54, 84);
         break;
      case 84:
      case 116:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(6, 17, 84);
         break;
      case 85:
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000L);
      case 89:
      case 121:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(6, 24, 84);
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
      case 67:
      case 99:
         return jjMoveStringLiteralDfa8_0(active0, 0x200000000L);
      case 68:
      case 100:
         if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 53, 84);
         break;
      case 69:
      case 101:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(7, 16, 84);
         break;
      case 78:
      case 110:
         return jjMoveStringLiteralDfa8_0(active0, 0x20000000L);
      case 82:
      case 114:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 39, 84);
         return jjMoveStringLiteralDfa8_0(active0, 0x4000000000L);
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
      case 69:
      case 101:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(8, 33, 84);
         return jjMoveStringLiteralDfa9_0(active0, 0x4000000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa9_0(active0, 0x20000000L);
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
      case 68:
      case 100:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 38, 84);
         break;
      case 83:
      case 115:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(9, 29, 84);
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
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
 private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 160;
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
               case 24:
               case 84:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 22:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 156:
                  if (curChar == 62)
                     jjstateSet[jjnewStateCnt++] = 158;
                  if (curChar == 62)
                     { jjCheckNAdd(152); }
                  if (curChar == 62)
                     { jjCheckNAdd(155); }
                  if (curChar == 62)
                  {
                     if (kind > 102)
                        kind = 102;
                  }
                  break;
               case 137:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 124:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 133:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 117:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 111:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 7:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 91:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 118:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 28:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 26:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 160:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 19:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 134:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 23:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 21:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 151:
                  if (curChar == 60)
                     { jjCheckNAdd(152); }
                  if (curChar == 60)
                  {
                     if (kind > 102)
                        kind = 102;
                  }
                  break;
               case 136:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 6:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 135:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 119:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 0:
                  if (kind > 114)
                     kind = 114;
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddStates(0, 6); }
                  else if ((0x100001200L & l) != 0L)
                  {
                     if (kind > 113)
                        kind = 113;
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
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  else if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 58;
                  else if (curChar == 34)
                     { jjCheckNAddStates(13, 15); }
                  else if (curChar == 39)
                     { jjAddStates(16, 17); }
                  else if (curChar == 46)
                     { jjCheckNAdd(35); }
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 60)
                        kind = 60;
                     { jjCheckNAddTwoStates(32, 33); }
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 60)
                        kind = 60;
                     { jjCheckNAddStates(18, 20); }
                  }
                  else if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 29:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 27:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 1:
                  if (curChar == 10 && kind > 1)
                     kind = 1;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 31:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  { jjCheckNAddTwoStates(32, 33); }
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  { jjCheckNAddTwoStates(32, 33); }
                  break;
               case 34:
                  if (curChar == 46)
                     { jjCheckNAdd(35); }
                  break;
               case 35:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 64)
                     kind = 64;
                  { jjCheckNAddStates(21, 23); }
                  break;
               case 37:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(38); }
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 64)
                     kind = 64;
                  { jjCheckNAddTwoStates(38, 39); }
                  break;
               case 40:
                  if (curChar == 39)
                     { jjAddStates(16, 17); }
                  break;
               case 41:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     { jjCheckNAdd(42); }
                  break;
               case 42:
                  if (curChar == 39 && kind > 66)
                     kind = 66;
                  break;
               case 44:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAdd(42); }
                  break;
               case 45:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(46, 42); }
                  break;
               case 46:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAdd(42); }
                  break;
               case 47:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 48;
                  break;
               case 48:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAdd(46); }
                  break;
               case 49:
                  if (curChar == 34)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 50:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 52:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 53:
                  if (curChar == 34 && kind > 67)
                     kind = 67;
                  break;
               case 54:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(24, 27); }
                  break;
               case 55:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 56:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 57;
                  break;
               case 57:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAdd(55); }
                  break;
               case 58:
                  if (curChar == 61 && kind > 110)
                     kind = 110;
                  break;
               case 59:
                  if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 58;
                  break;
               case 62:
                  if ((0x100001200L & l) != 0L && kind > 113)
                     kind = 113;
                  break;
               case 63:
                  if (kind > 114)
                     kind = 114;
                  break;
               case 64:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddStates(0, 6); }
                  break;
               case 65:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(65, 66); }
                  break;
               case 66:
                  if (curChar != 46)
                     break;
                  if (kind > 64)
                     kind = 64;
                  { jjCheckNAddStates(28, 30); }
                  break;
               case 67:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 64)
                     kind = 64;
                  { jjCheckNAddStates(28, 30); }
                  break;
               case 69:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(70); }
                  break;
               case 70:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 64)
                     kind = 64;
                  { jjCheckNAddTwoStates(70, 39); }
                  break;
               case 71:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(71, 72); }
                  break;
               case 73:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(74); }
                  break;
               case 74:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 64)
                     kind = 64;
                  { jjCheckNAddTwoStates(74, 39); }
                  break;
               case 75:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddStates(31, 33); }
                  break;
               case 77:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(78); }
                  break;
               case 78:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(78, 39); }
                  break;
               case 79:
                  if (curChar != 48)
                     break;
                  if (kind > 60)
                     kind = 60;
                  { jjCheckNAddStates(18, 20); }
                  break;
               case 81:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  { jjCheckNAddTwoStates(81, 33); }
                  break;
               case 82:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  { jjCheckNAddTwoStates(82, 33); }
                  break;
               case 83:
                  if (curChar != 36)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 150:
                  if (curChar == 60)
                     { jjAddStates(11, 12); }
                  break;
               case 152:
                  if (curChar == 61 && kind > 112)
                     kind = 112;
                  break;
               case 153:
                  if (curChar == 60)
                     { jjCheckNAdd(152); }
                  break;
               case 154:
                  if (curChar == 62)
                     { jjCheckNAddStates(7, 10); }
                  break;
               case 155:
                  if (curChar == 62 && kind > 102)
                     kind = 102;
                  break;
               case 157:
               case 158:
                  if (curChar == 62)
                     { jjCheckNAdd(152); }
                  break;
               case 159:
                  if (curChar == 62)
                     jjstateSet[jjnewStateCnt++] = 158;
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
               case 24:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 23;
                  break;
               case 22:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 137:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 136;
                  break;
               case 124:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 129;
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 123;
                  break;
               case 133:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 132;
                  break;
               case 117:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 119;
                  else if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 116;
                  break;
               case 111:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 112;
                  else if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 110;
                  break;
               case 7:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 91:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x20000000200000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 103;
                  else if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 98;
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 90;
                  break;
               case 118:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x8000000080000L & l) != 0L)
                     { jjCheckNAdd(13); }
                  break;
               case 28:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 26:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x80000000800000L & l) != 0L)
                  {
                     if (kind > 56)
                        kind = 56;
                  }
                  break;
               case 160:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x800000008L & l) != 0L)
                  {
                     if (kind > 56)
                        kind = 56;
                  }
                  break;
               case 19:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x400000004L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 134:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 137;
                  else if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 133;
                  break;
               case 23:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 21:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x100000001000L & l) != 0L)
                  {
                     if (kind > 56)
                        kind = 56;
                  }
                  break;
               case 136:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x20000000200L & l) != 0L)
                     { jjCheckNAdd(100); }
                  break;
               case 6:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x20000000200000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 135:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 148;
                  else if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 138;
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 134;
                  break;
               case 119:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 118;
                  break;
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  else if (curChar == 94)
                     { jjCheckNAdd(58); }
                  else if (curChar == 124)
                     { jjCheckNAdd(58); }
                  if ((0xf8000001f8000001L & l) != 0L)
                  {
                     if (kind > 114)
                        kind = 114;
                  }
                  else if ((0x8000000080000L & l) != 0L)
                     { jjAddStates(34, 36); }
                  else if ((0x40000000400000L & l) != 0L)
                     { jjAddStates(37, 38); }
                  else if ((0x800000008L & l) != 0L)
                     { jjAddStates(39, 40); }
                  else if ((0x400000004L & l) != 0L)
                     { jjAddStates(41, 42); }
                  else if ((0x1000000010000L & l) != 0L)
                     { jjAddStates(43, 45); }
                  else if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 29;
                  else if ((0x4000000040L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 24;
                  else if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 19;
                  else if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 11;
                  else if ((0x1000000010L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 29:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 27:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 57)
                        kind = 57;
                     { jjCheckNAdd(84); }
                  }
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 3:
                  if ((0x2000000020L & l) != 0L && kind > 10)
                     kind = 10;
                  break;
               case 4:
                  if ((0x100000001000L & l) != 0L)
                     { jjCheckNAdd(3); }
                  break;
               case 5:
                  if ((0x400000004L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 8:
                  if ((0x1000000010L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  if ((0x8000000080L & l) != 0L && kind > 10)
                     kind = 10;
                  break;
               case 10:
               case 132:
                  if ((0x400000004000L & l) != 0L)
                     { jjCheckNAdd(9); }
                  break;
               case 11:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 12:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 13:
                  if ((0x10000000100000L & l) != 0L && kind > 56)
                     kind = 56;
                  break;
               case 14:
                  if ((0x800000008L & l) != 0L)
                     { jjCheckNAdd(13); }
                  break;
               case 15:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 16:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 17:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 18:
                  if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 20:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 25:
                  if ((0x4000000040L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 30:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 33:
                  if ((0x100000001000L & l) != 0L && kind > 60)
                     kind = 60;
                  break;
               case 36:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(46, 47); }
                  break;
               case 39:
                  if ((0x5000000050L & l) != 0L && kind > 64)
                     kind = 64;
                  break;
               case 41:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAdd(42); }
                  break;
               case 43:
                  if (curChar == 92)
                     { jjAddStates(48, 50); }
                  break;
               case 44:
                  if ((0x14404410144044L & l) != 0L)
                     { jjCheckNAdd(42); }
                  break;
               case 50:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 51:
                  if (curChar == 92)
                     { jjAddStates(51, 53); }
                  break;
               case 52:
                  if ((0x14404410144044L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 60:
                  if (curChar == 124)
                     { jjCheckNAdd(58); }
                  break;
               case 61:
                  if (curChar == 94)
                     { jjCheckNAdd(58); }
                  break;
               case 63:
                  if ((0xf8000001f8000001L & l) != 0L && kind > 114)
                     kind = 114;
                  break;
               case 68:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(54, 55); }
                  break;
               case 72:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(56, 57); }
                  break;
               case 76:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(58, 59); }
                  break;
               case 80:
                  if ((0x100000001000000L & l) != 0L)
                     { jjCheckNAdd(81); }
                  break;
               case 81:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  { jjCheckNAddTwoStates(81, 33); }
                  break;
               case 83:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 84:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  { jjCheckNAdd(84); }
                  break;
               case 85:
                  if ((0x1000000010000L & l) != 0L)
                     { jjAddStates(43, 45); }
                  break;
               case 86:
                  if ((0x2000000020L & l) != 0L && kind > 56)
                     kind = 56;
                  break;
               case 87:
                  if ((0x10000000100000L & l) != 0L)
                     { jjCheckNAdd(86); }
                  break;
               case 88:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 87;
                  break;
               case 89:
                  if ((0x40000000400000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 88;
                  break;
               case 90:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 89;
                  break;
               case 92:
                  if ((0x1000000010L & l) != 0L && kind > 56)
                     kind = 56;
                  break;
               case 93:
               case 140:
                  if ((0x2000000020L & l) != 0L)
                     { jjCheckNAdd(92); }
                  break;
               case 94:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 93;
                  break;
               case 95:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 94;
                  break;
               case 96:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 95;
                  break;
               case 97:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 96;
                  break;
               case 98:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 97;
                  break;
               case 99:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 98;
                  break;
               case 100:
                  if ((0x800000008L & l) != 0L && kind > 56)
                     kind = 56;
                  break;
               case 101:
                  if ((0x20000000200L & l) != 0L)
                     { jjCheckNAdd(100); }
                  break;
               case 102:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 101;
                  break;
               case 103:
                  if ((0x400000004L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 102;
                  break;
               case 104:
                  if ((0x20000000200000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 103;
                  break;
               case 105:
                  if ((0x400000004L & l) != 0L)
                     { jjAddStates(41, 42); }
                  break;
               case 106:
                  if ((0x400000004000L & l) != 0L && kind > 10)
                     kind = 10;
                  break;
               case 107:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 106;
                  break;
               case 108:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 107;
                  break;
               case 109:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 108;
                  break;
               case 110:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 109;
                  break;
               case 112:
                  if ((0x10000000100000L & l) != 0L)
                     { jjCheckNAdd(3); }
                  break;
               case 113:
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 112;
                  break;
               case 114:
                  if ((0x800000008L & l) != 0L)
                     { jjAddStates(39, 40); }
                  break;
               case 115:
                  if ((0x4000000040000L & l) != 0L && kind > 10)
                     kind = 10;
                  break;
               case 116:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 115;
                  break;
               case 120:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 119;
                  break;
               case 121:
                  if ((0x40000000400000L & l) != 0L)
                     { jjAddStates(37, 38); }
                  break;
               case 122:
                  if ((0x1000000010L & l) != 0L && kind > 10)
                     kind = 10;
                  break;
               case 123:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 122;
                  break;
               case 125:
                  if ((0x100000001000L & l) != 0L)
                     { jjCheckNAdd(86); }
                  break;
               case 126:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 125;
                  break;
               case 127:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 126;
                  break;
               case 128:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 127;
                  break;
               case 129:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 128;
                  break;
               case 130:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 129;
                  break;
               case 131:
                  if ((0x8000000080000L & l) != 0L)
                     { jjAddStates(34, 36); }
                  break;
               case 138:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 137;
                  break;
               case 139:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 138;
                  break;
               case 141:
                  if ((0x400000004000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 140;
                  break;
               case 142:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 141;
                  break;
               case 143:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 142;
                  break;
               case 144:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 143;
                  break;
               case 145:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 144;
                  break;
               case 146:
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 145;
                  break;
               case 147:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 146;
                  break;
               case 148:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 147;
                  break;
               case 149:
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 148;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((jjbitVec0[i2] & l2) != 0L && kind > 114)
                     kind = 114;
                  break;
               case 41:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 42;
                  break;
               case 50:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(13, 15); }
                  break;
               default : break;
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
      if ((i = jjnewStateCnt) == (startsAt = 160 - (jjnewStateCnt = startsAt)))
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
                     if (kind > 5)
                        kind = 5;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if (curChar == 10 && kind > 5)
                     kind = 5;
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
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
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
   65, 66, 71, 72, 75, 76, 39, 155, 156, 157, 159, 151, 153, 50, 51, 53, 
   41, 43, 80, 82, 33, 35, 36, 39, 50, 51, 55, 53, 67, 68, 39, 75, 
   76, 39, 135, 139, 149, 124, 130, 117, 120, 111, 113, 91, 99, 104, 37, 38, 
   44, 45, 47, 52, 54, 56, 69, 70, 73, 74, 77, 78, 
};

/** Token literal values. */
public  String[] jjstrLiteralImages = {
"", null, null, "\57\57", "\57\52", null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
"\50", "\51", "\173", "\175", "\133", "\135", "\73", "\54", "\56", "\77", 
"\56\56\56", "\75", "\76", "\74", "\41", "\176", "\72\72", "\72", "\75\75", "\74\75", 
"\76\75", "\41\75", "\174\174", "\46\46", "\53\53", "\55\55", "\53", "\55", "\52", 
"\57", "\46", "\174", "\136", "\45", null, "\55\76", "\56\52", "\55\76\52", "\53\75", 
"\55\75", "\52\75", "\57\75", null, "\45\75", null, null, null, };
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
       if (jjmatchedPos == 0 && jjmatchedKind > 8)
       {
          jjmatchedKind = 8;
       }
       break;
     case 2:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_2();
       if (jjmatchedPos == 0 && jjmatchedKind > 8)
       {
          jjmatchedKind = 8;
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
      case 5 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
         break;
      case 6 :
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
    toPrint("<IN_LINE_COMMENT>");
         break;
      case 4 :
        image.append(jjstrLiteralImages[4]);
        lengthOfMatch = jjstrLiteralImages[4].length();
    toPrint("<MULTI_LINE_COMMENT>");
         break;
      case 9 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<RSVD>");
         break;
      case 10 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<TYPE>");
         break;
      case 11 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<AUTO>");
         break;
      case 12 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<BREAK>");
         break;
      case 13 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<CASE>");
         break;
      case 14 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<CATCH>");
         break;
      case 15 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<CLASS>");
         break;
      case 16 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<BREAK>");
         break;
      case 17 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<CASE>");
         break;
      case 18 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<DELETE>");
         break;
      case 19 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<LOOP>");
         break;
      case 20 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<IF>");
         break;
      case 21 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<ENUM>");
         break;
      case 22 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<EXTERN>");
         break;
      case 23 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<BOOL>");
         break;
      case 24 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<FINALLY>");
         break;
      case 25 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<TYPE>");
         break;
      case 26 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<LOOP>");
         break;
      case 27 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<FRIEND>");
         break;
      case 28 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<IF>");
         break;
      case 29 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<MODIFIER>");
         break;
      case 30 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<IMPORT>");
         break;
      case 31 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<INLINE>");
         break;
      case 32 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<TYPE>");
         break;
      case 33 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<MODIFIER>");
         break;
      case 34 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<NATIVE>");
         break;
      case 35 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<NEW>");
         break;
      case 36 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<NULL>");
         break;
      case 37 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<PACKAGE>");
         break;
      case 38 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<REDECLARED>");
         break;
      case 39 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<REGISTER>");
         break;
      case 40 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<RETURN>");
         break;
      case 41 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<TYPE>");
         break;
      case 42 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<SIGNED>");
         break;
      case 43 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<SIZEOF>");
         break;
      case 44 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<>");
         break;
      case 45 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<STRUCT>");
         break;
      case 46 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<SUPER>");
         break;
      case 47 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<CASE>");
         break;
      case 48 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("");
         break;
      case 49 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<TRY>");
         break;
      case 50 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<BOOL>");
         break;
      case 51 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<TRY>");
         break;
      case 52 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<UNION>");
         break;
      case 53 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<UNSIGNED>");
         break;
      case 54 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<VIRTUAL>");
         break;
      case 55 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<LOOP>");
         break;
      case 56 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<MODIFIER>");
         break;
      case 57 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<IDT>");
         break;
      case 60 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<VALUE>");
         break;
      case 64 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<VALUE>");
         break;
      case 66 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<VALUE>");
         break;
      case 67 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
          toPrint("<VALUE>");
         break;
      case 68 :
        image.append(jjstrLiteralImages[68]);
        lengthOfMatch = jjstrLiteralImages[68].length();
          toPrint("(");
         break;
      case 69 :
        image.append(jjstrLiteralImages[69]);
        lengthOfMatch = jjstrLiteralImages[69].length();
    toPrint(")");
         break;
      case 70 :
        image.append(jjstrLiteralImages[70]);
        lengthOfMatch = jjstrLiteralImages[70].length();
          toPrint("{");
         break;
      case 71 :
        image.append(jjstrLiteralImages[71]);
        lengthOfMatch = jjstrLiteralImages[71].length();
          toPrint("}");
         break;
      case 72 :
        image.append(jjstrLiteralImages[72]);
        lengthOfMatch = jjstrLiteralImages[72].length();
          toPrint("[");
         break;
      case 73 :
        image.append(jjstrLiteralImages[73]);
        lengthOfMatch = jjstrLiteralImages[73].length();
          toPrint("]");
         break;
      case 74 :
        image.append(jjstrLiteralImages[74]);
        lengthOfMatch = jjstrLiteralImages[74].length();
          toPrint("");
         break;
      case 75 :
        image.append(jjstrLiteralImages[75]);
        lengthOfMatch = jjstrLiteralImages[75].length();
          toPrint(",");
         break;
      case 76 :
        image.append(jjstrLiteralImages[76]);
        lengthOfMatch = jjstrLiteralImages[76].length();
          toPrint(".");
         break;
      case 77 :
        image.append(jjstrLiteralImages[77]);
        lengthOfMatch = jjstrLiteralImages[77].length();
          toPrint("?");
         break;
      case 78 :
        image.append(jjstrLiteralImages[78]);
        lengthOfMatch = jjstrLiteralImages[78].length();
          toPrint("...");
         break;
      case 79 :
        image.append(jjstrLiteralImages[79]);
        lengthOfMatch = jjstrLiteralImages[79].length();
          toPrint("=");
         break;
      case 80 :
        image.append(jjstrLiteralImages[80]);
        lengthOfMatch = jjstrLiteralImages[80].length();
          toPrint("==");
         break;
      case 81 :
        image.append(jjstrLiteralImages[81]);
        lengthOfMatch = jjstrLiteralImages[81].length();
          toPrint("==");
         break;
      case 82 :
        image.append(jjstrLiteralImages[82]);
        lengthOfMatch = jjstrLiteralImages[82].length();
          toPrint("");
         break;
      case 83 :
        image.append(jjstrLiteralImages[83]);
        lengthOfMatch = jjstrLiteralImages[83].length();
    toPrint("~");
         break;
      case 84 :
        image.append(jjstrLiteralImages[84]);
        lengthOfMatch = jjstrLiteralImages[84].length();
    toPrint("::");
         break;
      case 85 :
        image.append(jjstrLiteralImages[85]);
        lengthOfMatch = jjstrLiteralImages[85].length();
    toPrint(":");
         break;
      case 86 :
        image.append(jjstrLiteralImages[86]);
        lengthOfMatch = jjstrLiteralImages[86].length();
    toPrint("==");
         break;
      case 87 :
        image.append(jjstrLiteralImages[87]);
        lengthOfMatch = jjstrLiteralImages[87].length();
    toPrint("==");
         break;
      case 88 :
        image.append(jjstrLiteralImages[88]);
        lengthOfMatch = jjstrLiteralImages[88].length();
    toPrint("==");
         break;
      case 89 :
        image.append(jjstrLiteralImages[89]);
        lengthOfMatch = jjstrLiteralImages[89].length();
    toPrint("==");
         break;
      case 90 :
        image.append(jjstrLiteralImages[90]);
        lengthOfMatch = jjstrLiteralImages[90].length();
    toPrint("&&");
         break;
      case 91 :
        image.append(jjstrLiteralImages[91]);
        lengthOfMatch = jjstrLiteralImages[91].length();
    toPrint("&&");
         break;
      case 92 :
        image.append(jjstrLiteralImages[92]);
        lengthOfMatch = jjstrLiteralImages[92].length();
    toPrint("+=<NUM>");
         break;
      case 93 :
        image.append(jjstrLiteralImages[93]);
        lengthOfMatch = jjstrLiteralImages[93].length();
    toPrint("-=<NUM>");
         break;
      case 94 :
        image.append(jjstrLiteralImages[94]);
        lengthOfMatch = jjstrLiteralImages[94].length();
    toPrint("+");
         break;
      case 95 :
        image.append(jjstrLiteralImages[95]);
        lengthOfMatch = jjstrLiteralImages[95].length();
    toPrint("-");
         break;
      case 96 :
        image.append(jjstrLiteralImages[96]);
        lengthOfMatch = jjstrLiteralImages[96].length();
    toPrint("*");
         break;
      case 97 :
        image.append(jjstrLiteralImages[97]);
        lengthOfMatch = jjstrLiteralImages[97].length();
    toPrint("/");
         break;
      case 98 :
        image.append(jjstrLiteralImages[98]);
        lengthOfMatch = jjstrLiteralImages[98].length();
    toPrint("&");
         break;
      case 99 :
        image.append(jjstrLiteralImages[99]);
        lengthOfMatch = jjstrLiteralImages[99].length();
    toPrint("&");
         break;
      case 100 :
        image.append(jjstrLiteralImages[100]);
        lengthOfMatch = jjstrLiteralImages[100].length();
    toPrint("&");
         break;
      case 101 :
        image.append(jjstrLiteralImages[101]);
        lengthOfMatch = jjstrLiteralImages[101].length();
    toPrint("%");
         break;
      case 102 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<<");
         break;
      case 103 :
        image.append(jjstrLiteralImages[103]);
        lengthOfMatch = jjstrLiteralImages[103].length();
    toPrint("->");
         break;
      case 104 :
        image.append(jjstrLiteralImages[104]);
        lengthOfMatch = jjstrLiteralImages[104].length();
    toPrint("->");
         break;
      case 105 :
        image.append(jjstrLiteralImages[105]);
        lengthOfMatch = jjstrLiteralImages[105].length();
    toPrint("->");
         break;
      case 106 :
        image.append(jjstrLiteralImages[106]);
        lengthOfMatch = jjstrLiteralImages[106].length();
    toPrint("+=");
         break;
      case 107 :
        image.append(jjstrLiteralImages[107]);
        lengthOfMatch = jjstrLiteralImages[107].length();
    toPrint("-=");
         break;
      case 108 :
        image.append(jjstrLiteralImages[108]);
        lengthOfMatch = jjstrLiteralImages[108].length();
    toPrint("*=");
         break;
      case 109 :
        image.append(jjstrLiteralImages[109]);
        lengthOfMatch = jjstrLiteralImages[109].length();
    toPrint("/=");
         break;
      case 110 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("&=");
         break;
      case 111 :
        image.append(jjstrLiteralImages[111]);
        lengthOfMatch = jjstrLiteralImages[111].length();
    toPrint("%=");
         break;
      case 112 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
    toPrint("<<=");
         break;
      default :
         break;
   }
}
    
    private void toPrint(String message) {
        nodes.add(message);
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
    public CPPTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of  lexer. You must use ReInit() to initialize the  variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public CPPTokenManager (SimpleCharStream stream, int lexState){
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
    for (i = 160; i-- > 0;)
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
   -1, -1, -1, 1, 2, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
 long[] jjtoToken = {
   0x13fffffffffffe1fL, 0x5fffffffffffdL, 
};
 long[] jjtoSkip = {
   0x1e0L, 0x2000000000000L, 
};
     protected SimpleCharStream input_stream;

     private final int[] jjrounds = new int[160];
     private final int[] jjstateSet = new int[2 * 160];

    private  StringBuilder jjimage = new StringBuilder();
    private  StringBuilder image = jjimage;
    private  int jjimageLen;
    private  int lengthOfMatch;
    
     protected char curChar;
}
