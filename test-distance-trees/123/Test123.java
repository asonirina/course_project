
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Test123 {
    public static void main(String[] args) {
int i = 0;
i++;
        Writer writer = null;

       try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("out.txt"), "utf-8"));
            writer.write("1 2 3");
        } catch (IOException ex) {
        } finally {
            try {writer.close();} catch (Exception ex) {}
        }
    }
}
