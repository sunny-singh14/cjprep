package coder.shy.designpattern;

import java.io.*;

public class DecoratorDemo {
    public static void main(String[] args) {
        try (InputStream inputStream =
                     new LowerCaseInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(
                                             "src/main/java/coder/shy/designpattern/text.txt")))) {
            int c;
            while ((c = inputStream.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase((char) c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}
