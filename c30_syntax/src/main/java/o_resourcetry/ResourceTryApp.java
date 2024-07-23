package o_resourcetry;

import org.junit.jupiter.api.Test;
import utils.MethodLogger;

import java.io.*;

public class ResourceTryApp {

    public static final String FILENAME = "src/main/java/o_resourcetry/data.txt";

    @Test
    void oldTryWithResource() {
        MethodLogger.logMethodCall();
        try (FileInputStream in = new FileInputStream(FILENAME)) {
            final int first = in.read();
            System.out.println((char) first);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void newTryWithResource() throws Exception {
        MethodLogger.logMethodCall();
        FileInputStream in = new FileInputStream(FILENAME);
        try (in) {
            final int first = in.read();
            System.out.println((char) first);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void oldTryWithResourceUsingHelperMethod() throws Exception {
        MethodLogger.logMethodCall();
        OutputStream out = new ByteArrayOutputStream();
        copy1(new FileInputStream(FILENAME), out);
        System.out.println(out);
    }

    private static void copy1(InputStream in, OutputStream out) {
        // before Java 9 we would need to reassign AutoClosables to achieve the desired auto-closing
        try (InputStream i = in; OutputStream o = out) {
            int b;
            while ((b = i.read()) != -1) {
                o.write(b);
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * This demo makes use of the LoggingOutputStream decorator to observe when the stream is being closed.
     * Note that a ByteArrayOutputStream can be used again even after it has been closed.
     */
    @Test
    void newTryWithResourceUsingHelperMethod() throws Exception {
        MethodLogger.logMethodCall();
        OutputStream out = new LoggingOutputStream(new ByteArrayOutputStream());
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


    /**
     * Decorator pattern for observing when this stream is being closed.
     */
    static class LoggingOutputStream extends OutputStream {
        private final OutputStream out;

        public LoggingOutputStream(OutputStream out) {
            this.out = out;
        }

        @Override
        public void write(int b) throws IOException {
            out.write(b);
        }

        @Override
        public void close() throws IOException {
            System.out.println("Closing stream");
            out.close();
        }

        @Override
        public String toString() {
            return out.toString();
        }
    }
}