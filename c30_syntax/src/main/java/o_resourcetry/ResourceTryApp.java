package o_resourcetry;

import utils.MethodLogger;

import java.io.*;

// todo
public class ResourceTryApp {

    public static final String FILENAME = "src/jj/appl/DefaultMethodsApp.java";

    public static void main(String[] args) throws Exception {
        demo1();
        demo2();
        demoCopy1();
        demoCopy2();
    }

    static void demo1() {
        MethodLogger.logMethodCall();
        try (FileInputStream in = new FileInputStream(FILENAME)) {
            final int first = in.read();
            System.out.println((char) first);
        } catch (final IOException e) {
            System.out.println(e);
        }
    }

    static void demo2() throws Exception {
        MethodLogger.logMethodCall();
        FileInputStream in = new FileInputStream(FILENAME);
        try (in) {
            final int first = in.read();
            System.out.println((char) first);
        } catch (final IOException e) {
            System.out.println(e);
        }
    }

    static void demoCopy1() throws Exception {
        MethodLogger.logMethodCall();
        OutputStream out = new ByteArrayOutputStream();
        copy1(new FileInputStream(FILENAME), out);
        System.out.println(out);
    }

    private static void copy1(InputStream in, OutputStream out) {
        try (InputStream i = in; OutputStream o = out) {
            int b;
            while ((b = i.read()) != -1) {
                o.write(b);
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void demoCopy2() throws Exception {
        MethodLogger.logMethodCall();
        OutputStream out = new ByteArrayOutputStream();
        copy2(new FileInputStream(FILENAME), out);
        System.out.println(out);
    }

    private static void copy2(InputStream in, OutputStream out) {
        try (in; out) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}