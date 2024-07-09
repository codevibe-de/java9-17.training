package calculator;

import java.util.function.BinaryOperator;

public enum CalculatorOperation {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operatorId;
    private final BinaryOperator<Integer> operator;

    CalculatorOperation(String operatorId, BinaryOperator<Integer> operator) {
        this.operatorId = operatorId;
        this.operator = operator;
    }

    public String getOperatorId() {
        return operatorId;
    }

}
