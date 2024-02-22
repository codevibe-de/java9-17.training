package appl;

import org.apache.commons.lang3.StringUtils;
import org.fusesource.jansi.AnsiConsole;

import static appl.jansi_ext.JansiColors.cyan;
import static appl.jansi_ext.JansiColors.yellow;

public class ModulesExerciseApp {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        cyan.println("App starting...");
        yellow.println(StringUtils.repeat('-', 80));
    }

}
