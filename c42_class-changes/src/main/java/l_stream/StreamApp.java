package l_stream;

import utils.MethodLogger;

import java.util.stream.Stream;

// todo
public class StreamApp {

    public static void main(String[] args) {
        demoDropWhile();
        demoTakeWhile();
        demoDropWhileTakeWhile();
        demoHtml();
        demoOfNullable();
        demoIterate();
    }

    static void demoDropWhile() {
        MethodLogger.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .dropWhile(v -> v < 13)
                .forEach(System.out::println);
    }

    static void demoTakeWhile() {
        MethodLogger.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .takeWhile(v -> v < 12)
                .forEach(System.out::println);
    }

    static void demoDropWhileTakeWhile() {
        MethodLogger.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .dropWhile(v -> v < 12)
                .takeWhile(v -> v < 15)
                .forEach(System.out::println);
    }

    static void demoHtml() {
        MethodLogger.logMethodCall();
        Stream.of(
                        "<html>",
                        "<head>",
                        "<title>Foo</title>",
                        "</head>",
                        "<body>",
                        "<h1>Foo</h1>",
                        "<p>Bar</p>",
                        "</body>",
                        "</html>")
                .dropWhile(s -> !s.equals("<body>"))
                .skip(1)
                .takeWhile(s -> !s.equals("</body>"))
                .forEach(System.out::println);
    }

    static void demoOfNullable() {
        MethodLogger.logMethodCall();
        Stream<String> s1 = Stream.ofNullable((String) null);
        s1.forEach(System.out::println);
        Stream<String> s2 = Stream.ofNullable("Hello");
        s2.forEach(System.out::println);
    }

    static void demoIterate() {
        MethodLogger.logMethodCall();
        Stream<Integer> s = Stream.iterate(5, i -> i < 10, i -> i + 2);
        s.forEach(System.out::println);
    }
}
