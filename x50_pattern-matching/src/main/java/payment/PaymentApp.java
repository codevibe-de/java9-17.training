package payment;

public class PaymentApp {

    public static void main(String[] args) {
        Payment payment = new DirectDebitPayment("https://klarna.de");
        Customer customer = new Customer("John Doe");
        Order order = new Order(777888, payment, customer);

        printPaymentInstructions(order);
    }

    private static void printPaymentInstructions(Order order) {
        String instructions = switch (order.payment()) {
            case OnlinePayment onlinePayment -> "Please open the following URL in your browser to pay for your order:\n"
                    + onlinePayment.getUri(order.id());
            case PayCashUponDelivery payCashUponDelivery -> "Please pay cash upon delivery";
        };
        System.out.printf("""
                Dear %s,
                %s%n""", order.customer().fullName(), instructions);
    }
}
