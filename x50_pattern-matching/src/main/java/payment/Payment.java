package payment;

public sealed interface Payment {
}

interface OnlinePayment {
    String getUri(long orderId);
}

non-sealed class PayCashUponDelivery implements Payment {
}

record DirectDebitPayment(String uri) implements Payment, OnlinePayment {
    @Override
    public String getUri(long orderId) {
        return uri() + "?oid=" + orderId;
    }
}

abstract sealed class CreditCardPayment implements Payment, OnlinePayment permits VisaPayment, MasterCardPayment {
    abstract String providerId();

    @Override
    public String getUri(long orderId) {
        return "https://credit-card-payment.com/" + providerId() + "?oid=" + orderId;
    }
}

final class VisaPayment extends CreditCardPayment {
    @Override
    String providerId() {
        return "via";
    }
}

final class MasterCardPayment extends CreditCardPayment {
    @Override
    String providerId() {
        return "master-card";
    }
}