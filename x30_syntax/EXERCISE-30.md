# Exercise for chapter 30 - Syntax Changes

## a) Book Converter

Have a look at the main class `BookConverterApp`.

It makes use of a `BookConverter` instance to convert a `Book` object to a `String` representation using a given
Content-Type.

Implement the body of the `BookConverter.convertBook()` method.

Make use of at least these features:

* switch expressions
* text blocks (with or without printf-style formatting)

## b) Calculator

Take a look at the interface `CalculatorApi`.

The existing method `calculate()` should no longer be used. Mark it as deprecated since version 1.1 (since we
are currently working on the "1.1-SNAPSHOT" version in this module) and also as marked for removal.

Instead, the API Designer has decided that calculations should be performed by using the methods `add()`
and `subtract()`. Document this decision using javadoc for the deprecated method.

Both of the new methods should delegate to a new private method that performs the calculation and logs the result. 

Implement this method by using the following features:

- private interface methods
- switch expressions
- the existing `CalculatorOperator` enum

