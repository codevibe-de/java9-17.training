# Exercise for chapter "Java Platform Module System (JPMS)"

## Easy Start

Take a look at the existing source code in submodule `appl`.

Start the application

* in your IDE 
* and also on the command line using `gradlew -q appl:run`

You should see some colorful output like:

````
App starting...
--------------------------------------------------------------------------------
````

## 01) Turn the application into a JPMS module

Add a `module-info.java` file to the root of your sources directory to convert your application into a 
JPMS **modularized** application.

Does it still compile or can you execute it?

