package calculator;

public enum CalculatorOperation {

    ADD('+'),
    SUBTRACT('-');

    private final char symbol;

    CalculatorOperation(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
