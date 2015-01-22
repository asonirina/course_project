package by.bsu.project.huffman;

public class Huffman {

    private static final int R = 256;

    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        private boolean isLeaf() {
            assert (left == null && right == null) || (left != null && right != null);
            return (left == null && right == null);
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }


    public static byte[] compress(byte arr[]) {

        BinaryStdIn in = new BinaryStdIn(arr);
        BinaryStdOut out = new BinaryStdOut();
        String s = in.readString();
        char[] input = s.toCharArray();

        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;
        Node root = buildTree(freq);

        String[] st = new String[R];
        buildCode(st, root, "");

        writeTree(root, out);

        out.write(input.length);

        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    out.write(false);
                } else if (code.charAt(j) == '1') {
                    out.write(true);
                } else throw new RuntimeException("Illegal state");
            }
        }

        out.close();
        return out.getBytes();
    }

    private static Node buildTree(int[] freq) {

        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    private static void writeTree(Node x, BinaryStdOut out) {
        if (x.isLeaf()) {
            out.write(true);
            out.write(x.ch, 8);
            return;
        }
        out.write(false);
        writeTree(x.left, out);
        writeTree(x.right, out);
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + '0');
            buildCode(st, x.right, s + '1');
        } else {
            st[x.ch] = s;
        }
    }


    public static byte[] expand(byte arr[]) {

        BinaryStdIn in = new BinaryStdIn(arr);

        BinaryStdOut out = new BinaryStdOut();
        Node root = readTree(in);

        int length = in.readInt();

        for (int i = 0; i < length; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                boolean bit = in.readBoolean();
                if (bit) x = x.right;
                else x = x.left;
            }
            out.write(x.ch, 8);
        }
        out.close();
        return out.getBytes();
    }


    private static Node readTree(BinaryStdIn in) {
        boolean isLeaf = in.readBoolean();
        if (isLeaf) {
            return new Node(in.readChar(), -1, null, null);
        } else {
            return new Node('\0', -1, readTree(in), readTree(in));
        }
    }

}