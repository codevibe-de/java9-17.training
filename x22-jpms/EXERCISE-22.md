# Exercises for chapter "Java Platform Module System (JPMS)"

**NOTE:**:

* all command-line exercises expect a terminal with `./x22-jpms/appl` as the working directory.
* each exercise task has a solution in branch `x22-solution/taskXX`

## Easy Start

Take a look at the existing source code in submodule `appl`.

Start the application:

* in your IDE
* and also on the command line using `mvn -q compile exec:exec@runApp`

You should see some colorful output like:

````
App starting...
--------------------------------------------------------------------------------
````

## 01) Turn the application into a JPMS module

Add a `module-info.java` file to the root of your sources directory to convert your application into
a JPMS **modularized** application. Use the module name `x22_jpms.appl`.

Also perform the second step required to make Gradle recognize the application as being a proper module
by adding the following line to `./appl/build.gradle` right after the "mainClass" line:

````
mainModule = "x22_jpms.appl"
````

Does it still compile or can you execute it?

Further reading:

* https://docs.gradle.org/current/userguide/application_plugin.html#sec:application_modular

## 02) Fix it

Fix your application by adding the missing `requires <module-name>` imports to your application module.
Code completion can help you with the module names (e.g. type "jansi" and press CTRL-SPACE).

## 03) Classpath Investigation

Execute your application on the command line with additional output:

````shell
gradlew --info appl:run 
````

After quite some output you will see a line starting with `Starting process 'command`.

Within that line you can see how Gradle calls the java executable to launch the application including
the classpath and other arguments.

Examine how Gradle is calling the `java.exe` executable in terms of classpath construction.

What library-specific arguments are passed to the `java` command?

## 04) Using books-core

Add the following dependency to file `x22-jpms/appl/build.gradle`:

````groovy
    implementation project(":books-core")
````

Then edit `ModulesExerciseApp.java` and uncomment the two lines directly beneath `# Work with books-core API`.

The compiler will complain with message "Cannot resolve symbol 'Book'", **although** the "books-core" project is
declared as a dependency in Gradle.

What is the problem?

## 05) Modularize books-core

Fix the problem above by modularizing the "books-core" project as well.

Use the module name "x22_jpms.books_core" for this.

For this exercise you need to create a `module-info.java` file in the "books-core" library and also
export the `book.api` package.

But also two other things, which you have done before ... :)

PS Don't forget to finally add the missing import to class `ModulesExerciseApp`.

## 06) Deep Reflection

Now we are going to use "deep reflection" with our "books-core" library.

For that you will need to uncomment the two lines beneath `# Use reflection with books-core classes`.

Add the missing import for `Publisher`.

Now compile your application with `gradlew clean compileJava`, which should work. The code should also
compile within your IDE.

Finally, run your application again using `gradlew -q appl:run`. Does it work?

## 07) Fix it

Fix it by adding the appropriate "opens" statement to `x22-jpms/books-core/src/main/java/module-info.java`.

## 08) Integrate "books-report"

Uncomment the code lines beneath `# Work with books-report API`.

Adding the missing import for `Objects` is trivial -- but the other classes are not visible (yet).

Fix that using the "books-report" subproject :)

NOTE: You might need to recompile the "books-report" project as an intermediate step using `gradlew books-report:build`
and then refresh your IDE.

## 09) Use transitive modules imports

Since "books-report" is importing the module "books-core" we can make use of a transitive module import
by adding the keyword "transitive" there.

````
appl --> books-report --> books-core
  |                        |
  \--------(transitive)----/
````

We can then remove the module import to "books-core" from "appl".
