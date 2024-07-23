package calculator;

public interface CalculatorApi {

    /**
     * @deprecated Use {@link #add(int, int)} or {@link #subtract(int, int)} instead.
     */
    @Deprecated(since = "1.1", forRemoval = true)
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

    default int add(int a, int b) {
        return calculateInternal(a, b, CalculatorOperation.ADD);
    }

    default int subtract(int a, int b) {
        return calculateInternal(a, b, CalculatorOperation.SUBTRACT);
    }

    private int calculateInternal(int a, int b, CalculatorOperation calculatorOperation) {
        var result = switch (calculatorOperation) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
        };
        System.Logger logger = System.getLogger(this.getClass().getName());
        logger.log(
                System.Logger.Level.DEBUG,
                "%d %s %d = %d".formatted(a, calculatorOperation.getSymbol(), b, result)
        );
        return result;
    }

}
