# Answers for exercise questions

This file will grow from branch to branch.

## 01) Turn the application into a JPMS module

### Does it still compile or can you execute it?

No, because the packages imported by the application are not visible to the application yet.

The application module does not "require" them.

````text
[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Dev/Workspaces/Codevibe/java9-17.training/x22-jpms/appl/src/main/java/appl/jansi_ext/JansiColors.java:[3,22] package org.fusesource.jansi is not visible
  (package org.fusesource.jansi is declared in the unnamed module, but module x22_jpms.appl does not read it)
````

## 03) Classpath Investigation

### What library-specific arguments are passed to the `java` command?

The extracted and pretty-printed `java` command looks like this:

````shell
C:\....\openjdk17\current\bin\java.exe
-Djansi.passthrough=true
 @C:\Dev\Workspaces\Codevibe\java9-17.training\x22-jpms\appl\target\modulepath
 -m
 x22_jpms.appl/appl.ModulesExerciseApp
````

The interesting part is within that `modulepath` file:

````text
-p
"C:\\Dev\\Workspaces\\Codevibe\\java9-17.training\\x22-jpms\\appl\\target\\classes;
C:\\Users\\Thomas\\.m2\\repository\\org\\fusesource\\jansi\\jansi\\2.4.1\\jansi-2.4.1.jar;
C:\\Users\\Thomas\\.m2\\repository\\org\\apache\\commons\\commons-lang3\\3.14.0\\commons-lang3-3.14.0.jar;
C:\\Users\\Thomas\\.m2\\repository\\org\\junit\\jupiter\\junit-jupiter-api\\5.10.1\\junit-jupiter-api-5.10.1.jar;
C:\\Users\\Thomas\\.m2\\repository\\org\\opentest4j\\opentest4j\\1.3.0\\opentest4j-1.3.0.jar;
C:\\Users\\Thomas\\.m2\\repository\\org\\junit\\platform\\junit-platform-commons\\1.10.1\\junit-platform-commons-1.10.1.jar;
C:\\Users\\Thomas\\.m2\\repository\\org\\apiguardian\\apiguardian-api\\1.1.2\\apiguardian-api-1.1.2.jar;
C:\\Users\\Thomas\\.m2\\repository\\org\\assertj\\assertj-core\\3.25.2\\assertj-core-3.25.2.jar;
C:\\Users\\Thomas\\.m2\\repository\\net\\bytebuddy\\byte-buddy\\1.14.11\\byte-buddy-1.14.11.jar"
````

We can see that Maven is putting the `target/classes` folder and all libraries into the *
*module-path** (`-p` option).

## 04) Using books-core

### What is the problem?

The class `Book` is not imported (in terms of a regular Java `import com.example.Xyz` statement).

BUT it cannot be imported, since the module, in which this class is residing, is not visible to our
application.