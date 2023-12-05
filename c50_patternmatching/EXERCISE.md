#

##

Create a sealed interface `Payment`.

This can be implemented by exactly three subtypes:

* `PayCashUponDelivery`
* `OnlinePayment` being an abstract type open for any subclass
* `CreditCardPayment` having two subtypes `MasterCardPayment` and `VisaPayment`

##

Create a `Customer` record, which holds:

* id of type Long
* fullName of type String

## 

Create an `Order` record, which contains a reference to:

* the actual payment type
* a customer instance

## 

Write some code that generates a (fictional) redirect URL for each order.

This should:

* return null for `PayCashUponDelivery`
* redirect to the payment's provider website in case of an `OnlinePayment`
* redirect to the credit-card's company website in case of an `CreditCardPayment`
