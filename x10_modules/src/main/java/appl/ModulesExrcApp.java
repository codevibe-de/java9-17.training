package appl;

import org.apache.commons.lang3.StringUtils;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class ModulesExrcApp {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        ansi().eraseScreen();
        var cyan = ansi().fgCyan();
        cprintln(ansi().fgCyan(), "App starting...");
        cprintln(ansi().fgYellow(), StringUtils.repeat('-', 80));
        cprintln(ansi().fgDefault(), "");
    }

    public static void cprintln(Ansi ansiMode, String txt) {
        System.out.println(ansiMode.a(txt));
    }
}
