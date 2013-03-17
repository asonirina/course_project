package by.bsu.project.huffman;


import java.io.ByteArrayInputStream;
import java.io.IOException;


public final class BinaryStdIn {
    private ByteArrayInputStream in;
    private final int EOF = -1;    // end of file

    private int buffer;            // one character buffer
    private int N;                 // number of bits left in buffer

    public BinaryStdIn(byte b[]) {
        in = new ByteArrayInputStream(b);
        fillBuffer();
    }

    private void fillBuffer() {
        buffer = in.read();
        N = 8;
        if (buffer == EOF) N = -1;
    }

    public void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not close BinaryStdIn");
        }
    }

    public boolean isEmpty() {
        return buffer == EOF;
    }


    public boolean readBoolean() {
        if (isEmpty()) throw new RuntimeException("Reading from empty input stream");
        N--;
        boolean bit = ((buffer >> N) & 1) == 1;
        if (N == 0) fillBuffer();
        return bit;
    }

    public char readChar() {
        if (isEmpty()) throw new RuntimeException("Reading from empty input stream");

        // special case when aligned byte
        if (N == 8) {
            int x = buffer;
            fillBuffer();
            return (char) (x & 0xff);
        }

        // combine last N bits of current buffer with first 8-N bits of new buffer
        int x = buffer;
        x <<= (8 - N);
        int oldN = N;
        fillBuffer();
        if (isEmpty()) throw new RuntimeException("Reading from empty input stream");
        N = oldN;
        x |= (buffer >>> N);
        return (char) (x & 0xff);
    }

    public char readChar(int r) {
        if (r < 1 || r > 16) throw new RuntimeException("Illegal value of r = " + r);

        // optimize r = 8 case
        if (r == 8) return readChar();

        char x = 0;
        for (int i = 0; i < r; i++) {
            x <<= 1;
            boolean bit = readBoolean();
            if (bit) x |= 1;
        }
        return x;
    }

    public String readString() {
        if (isEmpty()) throw new RuntimeException("Reading from empty input stream");

        StringBuilder sb = new StringBuilder();
        while (!isEmpty()) {
            char c = readChar();
            sb.append(c);
        }
        return sb.toString();
    }

    public short readShort() {
        short x = 0;
        for (int i = 0; i < 2; i++) {
            char c = readChar();
            x <<= 8;
            x |= c;
        }
        return x;
    }

    public int readInt() {
        int x = 0;
        for (int i = 0; i < 4; i++) {
            char c = readChar();
            x <<= 8;
            x |= c;
        }
        return x;
    }

    public int readInt(int r) {
        if (r < 1 || r > 32) throw new RuntimeException("Illegal value of r = " + r);

        // optimize r = 32 case
        if (r == 32) return readInt();

        int x = 0;
        for (int i = 0; i < r; i++) {
            x <<= 1;
            boolean bit = readBoolean();
            if (bit) x |= 1;
        }
        return x;
    }

    public long readLong() {
        long x = 0;
        for (int i = 0; i < 8; i++) {
            char c = readChar();
            x <<= 8;
            x |= c;
        }
        return x;
    }


    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public byte readByte() {
        char c = readChar();
        byte x = (byte) (c & 0xff);
        return x;
    }

}