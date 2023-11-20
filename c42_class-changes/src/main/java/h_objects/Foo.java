package h_objects;

import java.util.Objects;

public class Foo {
    static void alpha(String s) {
        Objects.requireNonNull(s); // since 1.7
        System.out.println(s.toUpperCase());
    }

    static void beta(String s) {
        s = Objects.requireNonNullElse(s, "hello");
        System.out.println(s.toUpperCase());
    }

    static void gamma(String s) {
        s = Objects.requireNonNullElseGet(s, () -> "h" + "ello");
        System.out.println(s.toUpperCase());
    }
}
