# Exercise for chapter "Java Platform Module System (JPMS)"

## Easy Start

Take a look at the existing source code in submodule `appl`.

Start the application:

* in your IDE
* and also on the command line using `gradlew -q appl:run`

You should see some colorful output like:

````
App starting...
--------------------------------------------------------------------------------
````

## 01) Turn the application into a JPMS module

Add a `module-info.java` file to the root of your sources directory to convert your application into
a JPMS **modularized** application.

Use the module name `x22_jpms.appl`.

To make Gradle run the application using the "module-path" instead of the "classpath" argument
you need to add the following line to `./appl/build.gradle` right after the "mainClass" line:

````
mainModule = "x22_jpms.appl"
````

Does it still compile or can you execute it?

Further reading:

* https://docs.gradle.org/current/userguide/application_plugin.html#sec:application_modular

## 02) Fix it

Fix your application by adding the missing `requires` imports to your application module.

## 03) Classpath Investigation

Execute your application on the command line with additional output:

````shell
gradlew --info appl:run 
````

Now examine how Gradle is calling the `java.exe` executable in terms of classpath construction.

What library-specific arguments are passed to the `java` command?

Further reading:

* https://docs.gradle.org/current/userguide/java_library_plugin.html#sec:java_library_modular

## 04) Using books-core

Uncomment the code in `createAndPrintBook()` and add the missing import.

However, this won't work although the "books-core" project is declared as a dependency in Gradle.

What is the problem?

Further reading:

* https://openjdk.org/projects/jigsaw/spec/sotms/#the-unnamed-module
* https://docs.gradle.org/current/userguide/java_library_plugin.html#using_libraries_that_are_not_modules
* https://docs.gradle.org/current/samples/sample_java_modules_with_transform.html

## 05) Modularize books-core

Fix the problem above by modularizing the "books-core" project as well.

Use the module name "x22_jpms.books_core" for this.

For this exercise you need to create a `module-info.java` file in the "books-core" library and also
export the `book.api` package. But also something else, which you have done before ... :)

## 06) Classpath / Modulepath

## 07) Deep Reflection

## 08) Fix it

## 09) Integrate "books-report"

## 10) Use transitive modules imports