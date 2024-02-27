# Exercises for chapter "Java Platform Module System (JPMS)"

**NOTE:**:

* all command-line exercises expect a terminal with `./x22-jpms` as the working directory.
* each exercise task has a solution in branch `x22-solution/taskXX`

## Easy Start

Take a look at the existing source code in submodule `appl`.

Start the application:

* in your IDE
* and also on the command line using `mvn -q --projects=appl compile exec:exec@runClass`

You should see some colorful output like:

````
App starting...
--------------------------------------------------------------------------------
````

## 01) Turn the application into a JPMS module

Add a `module-info.java` file to the root of your sources directory to convert your application into
a JPMS **modularized** application. Use the module name `x22_jpms.appl`.

Does it still compile or can you execute it?

NOTE: From now on you need to execute `mvn -q --projects=appl compile exec:exec@runModule` to start
your application when using Maven!
The `runModule` part identifies some other `<execution>` block in the build script,
which correctly sets module-path and also declares the module to launch from our main class from.

## 02) Fix it

Fix your application by adding the missing `requires <module-name>` imports to your application
module.
Code completion can help you with the module names (e.g. type "jansi" and press CTRL-SPACE).

## 03) Classpath Investigation

Execute your application on the command line with additional output:

````shell
mvn -X --projects=appl compile exec:exec@runModule > maven.log
````

Then open the resulting `maven.log` file in your IDE and look for a line starting with

````text
[DEBUG] Executing command line:
````

There you can see, how Maven has put together the `java.exe` call including all options.

It is using a dedicated file `appl/target/modulepath` for declaring all JARs. The `@` operator pulls
in the contents of that file.

What library-specific arguments are passed to the `java` command?

## 04) Using books-core

Add the following dependency to file `x22-jpms/appl/pom.xml`:

````xml

<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>x22-jpms-books-core</artifactId>
    <version>${project.version}</version>
</dependency>
````

Then edit `ModulesExerciseApp.java` and uncomment the two lines directly
beneath `# Work with books-core API`.

The compiler will complain with message "Cannot resolve symbol 'Book'", **although** the "
books-core" project is declared as a dependency in Maven.

What is the problem?

## 05) Modularize books-core

Fix the problem above by modularizing the "books-core" project as well.

Use the module name "x22_jpms.books_core" for this.

For this exercise you need to

* create a `module-info.java` file in the "books-core" project
* export the `book.api` package there
* require `org.apache.commons.lang3` since the books-core lib is using it, too

Finally, run `mvn --projects=books-core install` to deploy the new JAR to your local Maven repo.

Now you can use that JPMS module in your "appl" project and make things run again by requiring
the "x22_jpms.books_core" module there.

Run `mvn -q --projects=appl compile exec:exec@runModule` and you should see:

````text
App starting...
--------------------------------------------------------------------------------
Book[isbn=0-19-501919-9, title=A Pattern Language, year=1977, author=Christopher Alexander]
--------------------------------------------------------------------------------
````

## 06) Deep Reflection

Now we are going to use "deep reflection" with our "books-core" library.

For that you will need to uncomment the two lines
beneath `# Use reflection with books-core classes`.

Add the missing import for `Publisher`.

Now compile your application with `mvn --projects=appl clean compile`, which should work. The code
should also compile within your IDE.

Finally, run your application again. Does it work?

## 07) Fix it

Fix it by adding the appropriate "opens" statement
to `x22-jpms/books-core/src/main/java/module-info.java`.

## 08) Integrate "books-report"

Uncomment the code lines beneath `# Work with books-report API`.

Adding the missing import for `Objects` is trivial -- but the other classes are not visible (yet).

Fix that using the "books-report" subproject :)

## 09) Use transitive modules imports

Since "books-report" is importing the module "books-core" we can make use of a transitive module
import by adding the keyword "transitive" there.

````
appl --> books-report --> books-core
  |                        |
  \--------(transitive)----/
````

We can then remove the module import to "books-core" from "appl".
