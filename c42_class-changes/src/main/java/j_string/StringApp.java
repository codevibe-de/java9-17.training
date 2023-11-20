package j_string;

import utils.MethodLogger;

import java.util.stream.Stream;

// todo
public class StringApp {

    public static void main(String[] args) {
        demoRepeat();
        demoStrip();
        demoLines();
        demoIsBlank();
        demoCharactorToString();
    }

    static void demoRepeat() {
        MethodLogger.logMethodCall();
        String s1 = "Hello".repeat(5);
        System.out.println(s1);
        String s2 = "-".repeat(50);
        System.out.println(s2);
    }

    static void demoStrip() {
        MethodLogger.logMethodCall();

        // trim() removes all characters <= 0x20 but not modern Unicode chars like \u2000
        var text = "\t Hello\u2000 \n\r";
        System.out.printf("'%s'\n", text.trim());

        System.out.printf("'%s'\n", text.strip());
        System.out.printf("'%s'\n", text.stripLeading());
        System.out.printf("'%s'\n", text.stripTrailing());
    }

    static void demoLines() {
        MethodLogger.logMethodCall();
        String s = "red\ngreen\nblue";
        Stream<String> stream = s.lines();
        stream.forEach(System.out::println);
    }

    static void demoIsBlank() {
        MethodLogger.logMethodCall();
        System.out.println("".isBlank());
        System.out.println("   ".isBlank());
        System.out.println("   \n \t ".isBlank());
        System.out.println("   n t ".isBlank());
    }

    static void demoCharactorToString() {
        MethodLogger.logMethodCall();
        String s = Character.toString(65);
        System.out.println(s);  // A
    }
}

