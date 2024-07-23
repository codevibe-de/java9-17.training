package calculator;

public class CalculatorApp {

    public static void main(String[] args) {
        var calculator = new CalculatorApi() {
        };
        calculator.add(1, 2);
        calculator.subtract(1, 2);
    }
}
