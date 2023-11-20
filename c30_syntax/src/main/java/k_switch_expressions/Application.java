package k_switch_expressions;

import static utils.MethodLogger.logMethodCall;

public class Application {
    public static void main(String[] args) {
        oldMultipleCase();
        oldMultiValueCase();
        newArrowSyntax();
        demo4();
        demo5();
        demo6();
    }

    static void oldMultipleCase() {
        logMethodCall();
        int day = 2;
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

    static void oldMultiValueCase() {
        logMethodCall();
        int day = 2;
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

    static void newArrowSyntax() {
        logMethodCall();
        int day = 2;
        switch (day) {
            case 1, 2, 3, 4, 5 -> System.out.println("workday");
            case 6 -> System.out.println("saturday");
            case 7 -> System.out.println("sunday");
        }
    }

    static void newArrowSyntaxAsExpression() {
        logMethodCall();
        int day = 2;
        var dayDescriptor =
                switch (day) {
                    case 1, 2, 3, 4, 5 -> "workday";
                    case 6 -> "saturday";
                    case 7 -> "sunday";
                    default -> "???";
                };
        System.out.println(dayDescriptor);
    }

    static void demo4() {
        logMethodCall();
        int result1 = calc1('+', 40, 2);
        System.out.println(result1);
        int result2 = calc2('+', 40, 2);
        System.out.println(result2);
        int result3 = calc3(Operator.PLUS, 40, 2);
        System.out.println(result3);
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

    enum Operator {
        PLUS, MINUS, TIMES, DIV
        /* , MOD */
    }

    ;

    static int calc3(Operator op, int x, int y) {
        return switch (op) {
            case PLUS -> x + y;
            case MINUS -> x - y;
            case TIMES -> x * y;
            case DIV -> x / y;
        };
    }

    static void demo5() {
        logMethodCall();
        int x = 2;
        Number n = switch (x) {
            // Double n = (double)switch (x) {
            case 1 -> 42;
            case 2 -> 77L;
            case 3 -> 3.14;
            default -> 0;
        };
        System.out.println(n + " " + n.getClass().getName());
    }

    static void demo6() {
        logMethodCall();
        int x = 2;
        var v = switch (x) {
            case 1 -> 42;
            case 2 -> 77L;
            case 3 -> 3.14;
            default -> 0;
        };
        Number n = v;
        System.out.println(n + " " + n.getClass().getName());
    }

    static void demo7() {
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
}