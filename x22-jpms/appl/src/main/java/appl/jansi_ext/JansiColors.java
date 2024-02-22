package appl.jansi_ext;

import org.fusesource.jansi.Ansi;

import java.io.PrintStream;

public class JansiColors {

    public static final PrintingColor cyan = new PrintingColor(Ansi.ansi().fgCyan(), System.out);
    public static final PrintingColor yellow = new PrintingColor(Ansi.ansi().fgYellow(), System.out);

    public static class PrintingColor {

        private final Ansi color;
        private final PrintStream printStream;

        PrintingColor(Ansi color, PrintStream printStream) {
            this.color = color;
            this.printStream = printStream;
        }

        public void print(String txt) {
            printStream.print(createAnsiOutput(txt));
        }

        public void println(String txt) {
            printStream.println(createAnsiOutput(txt));
        }

        public void printf(String pattern, Object ...args) {
            printStream.print(createAnsiOutput(pattern.formatted(args)));
        }

        public void printfln(String pattern, Object ...args) {
            printStream.println(createAnsiOutput(pattern.formatted(args)));
        }

        private Ansi createAnsiOutput(String txt) {
            return this.color.a(txt).fgDefault().a("");
        }

    }

}
