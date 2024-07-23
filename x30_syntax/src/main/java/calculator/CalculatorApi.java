package calculator;

public interface CalculatorApi {

    default int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                throw new IllegalArgumentException("Unhandled operator: " + operator);
        }
    }

    int add(int a, int b);

    int subtract(int a, int b);

}
