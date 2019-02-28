package pl.threads.testy;

import java.io.Closeable;
import java.io.IOException;

public class ClosaBlesy {

    static class MyResource1 implements AutoCloseable {
        public void close() throws IOException {
            System.out.print("1 ");
            throw  new IOException();
        }
    }
    static class MyResource2 implements Closeable {
        public void close() throws IOException {
            System.out.println("2");
//            throw new IOException();
        }
    }

    public static void main(String[] args) {
            try( MyResource1 r1 = new MyResource1();
                 MyResource2 r2 = new MyResource2()) {
                System.out.print("T ");
            } catch (Exception e) {
            System.out.print("IOE ");
            } finally {
                System.out.println("F");
        }
    }

}
