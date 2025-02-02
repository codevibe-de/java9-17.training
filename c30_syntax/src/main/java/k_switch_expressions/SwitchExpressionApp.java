package k_switch_expressions;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;

import static utils.MethodLogger.logMethodCall;

@SuppressWarnings("UnnecessaryLocalVariable")
public class SwitchExpressionApp {

    @Test
    void oldMultipleCase() {
        logMethodCall();
        int day = getDayOfWeek();
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("workday");
                break;
            case 6:
                System.out.println("saturday");
                break;
            case 7:
                System.out.println("sunday");
                break;
        }
    }


    @Test
    void newMultiValueCase() {
        logMethodCall();
        int day = getDayOfWeek();
        switch (day) {
            case 1, 2, 3, 4, 5:
                System.out.println("workday");
                break;
            case 6:
                System.out.println("saturday");
                break;
            case 7:
                System.out.println("sunday");
                break;
        }
    }


    @Test
    void newArrowSyntax() {
        logMethodCall();
        int day = getDayOfWeek();
        switch (day) {
            case 6 -> System.out.println("saturday");
            case 7 -> System.out.println("sunday");
            default -> {
                System.out.println("workday");
            }
        }
    }


    @Test
    void newArrowSyntaxAsExpression() {
        logMethodCall();
        int day = getDayOfWeek();
        var dayDescriptor = switch (day) {
            case 1, 2, 3, 4, 5 -> "workday";
            case 6 -> "saturday";
            case 7 -> "sunday";
            default -> "???";
        };
        System.out.println(dayDescriptor);
    }


    /**
     * Demonstrates use of several calculation methods, which make use of switch
     * statements/expressions.
     */
    @Test
    void demo4() {
        logMethodCall();
        int result1 = calc1('+', 40, 2);
        System.out.println(result1);
        int result2 = calc2('+', 40, 2);
        System.out.println(result2);
        int result3 = calc3(Operator.PLUS, 40, 2);
        System.out.println(result3);
    }


    /**
     * Demonstrates that returning different types requires us to declare a common superclass for
     * the result.
     */
    @Test
    void commonSuperclassForYieldedTypes() {
        logMethodCall();
        int x = new Random().nextInt(0, 4);
        Number n = switch (x) {
            // Double n = (double)switch (x) {
            case 1 -> 42;
            case 2 -> 77L;
            case 3 -> 3.14;
            default -> 0;
        };
        System.out.println(n + " " + n.getClass().getName());
    }


    /**
     * Demonstrates what type is inferred when using "var"
     */
    @Test
    void inferredTypeForVar() {
        logMethodCall();
        int x = new Random().nextInt(0, 4);
        var v = switch (x) {
            case 1 -> 42;
            case 2 -> 77L;
            case 3 -> 3.14;
            default -> 0;
        };
        Number n = v;
        System.out.println(n + " " + n.getClass().getName());
    }


    @Test
    void useYieldAsReturnInSwitch() {
        logMethodCall();
        int x = 2;
        int n = switch (x) {
            case 1 -> {
                System.out.println("do this...");
                yield 42;
            }
            case 2 -> {
                System.out.println("do that...");
                yield 77;
            }
            default -> {
                System.out.println("default...");
                yield 33;
            }
        };
        System.out.println(n);
    }


    /**
     * Demonstrates a NullPointerException when switching on null
     */
    @Test
    void switchingOnNull() {
        Decision d = null;
        var n = switch (d) {
            case NO -> 0;
            case YES -> 1;
            case MAYBE -> -1;
        };
    }

    private int getDayOfWeek() {
        return LocalDate.now().getDayOfWeek().getValue();
    }

    enum Operator {
        PLUS, MINUS, TIMES, DIV
        /* , MOD */
    }

    static int calc1(char op, int x, int y) {
        return switch (op) {
            case '+':
                yield x + y;
            case '-':
                yield x - y;
            case '*':
                yield x * y;
            case '/':
                yield x / y;
            default:
                throw new RuntimeException();
        };
    }

    static int calc2(char op, int x, int y) {
        return switch (op) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            case '/' -> x / y;
            default -> throw new RuntimeException();
        };
    }

    static int calc3(Operator op, int x, int y) {
        return switch (op) {
            case PLUS -> x + y;
            case MINUS -> x - y;
            case TIMES -> x * y;
            case DIV -> x / y;
        };
    }

    private static enum Decision {
        YES,
        NO,
        MAYBE
    }
}