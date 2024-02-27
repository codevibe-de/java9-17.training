package a_optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static utils.MethodLogger.logMethodCall;

public class Optional1App {

    @Test
    void demoStream1() {
        logMethodCall();

        Optional<String> s1 = Optional.empty();
        s1.stream().forEach(System.out::println);   // no output

        Optional<String> s2 = Optional.of("Hello");
        s2.stream().forEach(System.out::println);
    }


    @Test
    void demoStream2() {
        logMethodCall();

        Stream.of(Optional.of("red"), Optional.empty(), Optional.of("blue"))
                .flatMap(Optional::stream)
                .forEach(System.out::println);
    }


    @Test
    void demoOr() {
        logMethodCall();

        Optional<String> optional1 = Optional.empty();
        optional1 = optional1.or(() -> Optional.of("Hello"));
        System.out.println(optional1);

        Optional<String> optional2 = Optional.of("World").or(() -> Optional.of("Hello"));
        System.out.println(optional2);

        var emptyOrEmpty = Optional.empty().or(Optional::empty);
        System.out.println(emptyOrEmpty.isPresent());
    }


    static void demoIfPresentOrElse() {
        logMethodCall();

        Optional<String> o1 = Optional.of("Hello");
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("not present"));

        Optional<String> o2 = Optional.empty();
        o2.ifPresentOrElse(System.out::println, () -> System.out.println("not present"));
    }
}
