# Exercise for chapter "Reactive Streams"

## 1) NumberPublisher subscribers

Take a look at class `f_reactive_streams/xrc1_numberpublisher/NumberPublisher.java`.

Write one or more subscribers that collects received data into an internal list
and that perform one of these tasks:

* collect a predefined number, then quit
* collect five even numbers, then quit
* collect all numbers that can be divided by 10
* ignore all numbers defined by a "skipping" `Predicate`, then
keep a defined count of numbers, then quit

## 2) Processor

Write a `Processor` implementation that takes two consecutive numbers and reduces them to their
sum.

Use the `NumberPublisher` to generate items and one of your subscribers developed above to collect
results.

## 3) Back Pressure

Write a subscriber that has to work between 1 and 5 seconds per item. 

It should run for a total of exactly 1 minute -- and ask for additional items after each item, 
if necessary, so that it so that it finally ends with a runtime of one minute.

This means the subscriber requests a number of certain items each time, which is calculated
based on the remaining time and the number of items processed so far.