# Exercise for chapter 50 -- Records & Sealed

## 1) Payment sum-type

Create a sealed interface `Payment`.

This can be implemented by exactly three subtypes:

* `PayCashUponDelivery`
* `OnlinePayment` being an abstract type open for any subclass
* `CreditCardPayment` having two subtypes `MasterCardPayment` and `VisaPayment`

## 2) Customer type

Create a `Customer` record, which holds:

* id of type Long
* fullName of type String

## 3) Order product-type

Create an `Order` record, which contains a reference to:

* the actual payment type
* a customer instance

## 4) Business Logic

Write some code that generates a (fictional) redirect URL for each order.

This should:

* return null for `PayCashUponDelivery`
* redirect to the payment's provider website in case of an `OnlinePayment`
* redirect to the credit-card's company website in case of an `CreditCardPayment`, which includes
  the customer's full name
