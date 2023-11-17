package d_predicate;

import utils.MethodLogger;

import java.util.function.Predicate;

import static utils.MethodLogger.logMethodCall;

public class PredicateApp {

    public static void main(String[] args) {
        demoOld();
        demoNew();
    }

    static void demoOld() {
        logMethodCall();
        final Predicate<String> isEmpty = String::isEmpty; // only required for negating in next line
        final Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));
    }

    static void demoNew() {
        logMethodCall();
        final Predicate<String> isNotEmpty = Predicate.not(String::isEmpty);

        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));
    }
}
