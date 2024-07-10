package calculator;

public interface CalculatorApi {

    default int calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    private int calculateByOperation(int a, int b, CalculatorOperation operation) {
        return operation.getOperator().apply(a, b);
    }

    default int add(int a, int b) {
        return calculateByOperation(a, b, CalculatorOperation.ADD);
    }

    default int subtract(int a, int b) {
        return calculateByOperation(a, b, CalculatorOperation.SUBTRACT);
    }

    default int multiply(int a, int b) {
        return calculateByOperation(a, b, CalculatorOperation.MULTIPLY);
    }

    default int divide(int a, int b) {
        return calculateByOperation(a, b, CalculatorOperation.DIVIDE);
    }

}
