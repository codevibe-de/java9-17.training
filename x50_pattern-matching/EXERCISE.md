# Exercise for chapter 50—Records & Sealed

## 1) Payment sum-type

Create a sealed interface `Payment`, which will become an algebraic "sum" data type.

This can be implemented by exactly three subtypes:

* `PayCashUponDelivery`, a regular class open for further subclassing
* `DirectDebitPayment`, a record accepting a payment URI as a constructor argument
* `CreditCardPayment`, an abstract sealed class having the two subtypes `MasterCardPayment` and `VisaPayment`

## 2) OnlinePayment interface

Create an interface `OnlinePayment` that defines a method `getUri`, which returns a `String`
and accepts an order ID.

Implement this interface in the `DirectDebitPayment` and `CreditCardPayment` classes:

- DirectDebitPayment could accept the URI as a constructor argument
- CreditCardPayment could generate the URI based on a fixed string plus some provider ID
  returned by each concrete subtype e.g. "https://credit-card-payment.com/visa"

## 2) Customer type

Create a `Customer` record, which holds:

* `fullName` of type String

## 3) Order product-type

Create an `Order` record, which contains:

* `id` of type `long`
* a `Payment` instance
* a `Customer` instance

## 4) Business Logic

Write some code that generates a simple string with payment instructions for any given `Order`
instance:

* return "Please pay cash when picking up your order" for `PayCashUponDelivery`
* tell the user which URL to open in the browser in case of an `OnlinePayment`

Example:

````text
Dear Max Mustermann,
Please open the following URL in your browser to pay for your order:
https://credit-card-payment.com/visa
````