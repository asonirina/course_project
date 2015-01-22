import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.String;

public class Test {
    int a;
    int b;

    public void x(int c) {
        a = 6;
        b = 8;
        double f = 1.2;
        if (a > 7 && false) {
            a--;
        } else  {
            a++;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        bw.write("1 2 3");
        bw.close();
    }
}