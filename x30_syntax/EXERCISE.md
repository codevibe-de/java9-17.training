# Exercise for chapter 30 - Syntax Changes

## a) Book Converter

Have a look at the main class `BookConverterApp`.

Then implement the body of the `BookConverter.convertBook()` method.

Make use of at least these features:

* switch expressions
* text blocks

## b) Calculator

Schauen Sie sich das Interface `Calculator` an.

Die bestehende Methode `calculate()` soll nicht mehr verwendet werden -- markieren Sie diese also als Deprecated.

Eine neue **private** Methode `calculateByOperation()` soll die Berechnung durchführen -- implementieren Sie diese.
Dabei sollen folgende Features verwendet werden:

- private interface methods
- switch expressions
- die vorhandene `CalculatorOperation`-Enum

Die existierenden Methoden `add()`, `subtract()`, `multiply()` und `divide()` sollen nun die neue
Methode `calculateByOperator()` verwenden.

Schreiben Sie dann eine Implementierung des Interfaces `Calculator` in einer neuen Klasse `PrintingCalculator`.
Diese soll die Berechnung durchführen und das Ergebnis zusätzlich auf der Konsole ausgeben. Dabei sollen folgende
Features verwendet werden:
- text blocks
- var
