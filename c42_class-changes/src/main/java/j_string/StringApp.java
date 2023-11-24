package j_string;

import org.junit.jupiter.api.Test;
import utils.MethodLogger;

import java.util.function.Function;
import java.util.stream.Stream;

// todo
public class StringApp {

    @Test
    void demoRepeat() {
        MethodLogger.logMethodCall();
        String s1 = "Hello".repeat(5);
        System.out.println(s1);
        String s2 = "-".repeat(50);
        System.out.println(s2);
    }

    @Test
    void demoStrip() {
        MethodLogger.logMethodCall();

        // trim() removes all characters <= 0x20 but not modern Unicode chars like \u2000
        var text = "\t Hello\u2000 \n\r";
        System.out.printf("'%s'\n", text.trim());

        System.out.printf("'%s'\n", text.strip());
        System.out.printf("'%s'\n", text.stripLeading());
        System.out.printf("'%s'\n", text.stripTrailing());
    }


    @Test
    void indent() {
        System.out.print("New York\nRio\nTokio".indent(4));
    }


    @Test
    void transform() {
        Function<String,String> snakeCaseFct =
                (String s) -> String.join("-", s.toLowerCase().split("[\\s,.;]+"));
        System.out.println("Hello, dear Planet Earth".transform(snakeCaseFct));
    }


    @Test
    void demoLines() {
        MethodLogger.logMethodCall();
        String s = "red\ngreen\nblue";
        Stream<String> stream = s.lines();
        stream.forEach(System.out::println);
    }


    @Test
    void demoIsBlank() {
        MethodLogger.logMethodCall();
        System.out.println("".isBlank());
        System.out.println("   ".isBlank());
        System.out.println("   \n \t ".isBlank());
        System.out.println("   n t ".isBlank());
    }

    @Test
    void demoCharactorToString() {
        MethodLogger.logMethodCall();
        String s = Character.toString(65);
        System.out.println(s);  // A
    }
}

