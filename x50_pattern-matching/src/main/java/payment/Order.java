package payment;

public record Order(
        long id,
        Payment payment,
        Customer customer
) {
}
