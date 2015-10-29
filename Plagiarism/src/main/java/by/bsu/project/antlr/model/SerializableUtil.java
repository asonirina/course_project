package by.bsu.project.antlr.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * User: iason
 * Date: 28.10.15
 */
public class SerializableUtil {

    public static List<TreeNode> getTree(byte data[]) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        List<TreeNode> list = (List<TreeNode>) ois.readObject();
        ois.close();
        return list;
    }

    public static byte[] getTreeBytes(List<TreeNode> list) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(list);
        oos.close();
        return baos.toByteArray();
    }


    public static List<int[]> getMap(byte data[]) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        List<int[]> list = (List<int[]>) ois.readObject();
        ois.close();
        return list;
    }

    public static byte[] getMapBytes(List<int[]> list) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(list);
        oos.close();
        return baos.toByteArray();
    }
}
