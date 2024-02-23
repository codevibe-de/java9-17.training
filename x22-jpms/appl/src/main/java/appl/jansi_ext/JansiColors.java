package appl.jansi_ext;

import org.fusesource.jansi.Ansi;

import java.io.PrintStream;

public class JansiColors {

    public static final PrintingColor cyan = new PrintingColor(Ansi.Color.CYAN, false, System.out);
    public static final PrintingColor yellow = new PrintingColor(Ansi.Color.YELLOW, false, System.out);
    public static final PrintingColor green = new PrintingColor(Ansi.Color.GREEN, false, System.out);
    public static final PrintingColor regular = new PrintingColor(Ansi.Color.DEFAULT, false, System.out);
    public static final PrintingColor brightRegular = new PrintingColor(Ansi.Color.DEFAULT, true, System.out);

    public static class PrintingColor {

        private final Ansi.Color color;
        private final boolean bright;
        private final PrintStream printStream;

        PrintingColor(Ansi.Color color, boolean bright, PrintStream printStream) {
            this.color = color;
            this.bright = bright;
            this.printStream = printStream;
        }

        public void print(String txt) {
            printStream.print(createAnsiOutput(txt));
        }

        public void println(String txt) {
            printStream.println(createAnsiOutput(txt));
        }

        public void printf(String pattern, Object... args) {
            printStream.print(createAnsiOutput(pattern.formatted(args)));
        }

        public void printfln(String pattern, Object... args) {
            printStream.println(createAnsiOutput(pattern.formatted(args)));
        }

        private String createAnsiOutput(String txt) {
            var ansi = this.bright ?
                    Ansi.ansi().fg(this.color) :
                    Ansi.ansi().fgBright(this.color);
            return ansi.a(txt).fgDefault().a("").toString();
        }

    }

}
