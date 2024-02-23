# Answers for exercise questions

This file will grow from branch to branch.

## 01) Turn the application into a JPMS module

### Does it still compile or can you execute it?

No, because the packages imported by the application are not visible to the application yet.

The application module does not "require" them.

## 03) Classpath Investigation

### What library-specific arguments are passed to the `java` command?

The extracted and pretty-printed java command looks like this:

````shell
C:\...\openjdk17\current\bin\java.exe 
-Djansi.passthrough=true 
-Dfile.encoding=UTF-8 
--module-path 
  C:\...\java9-17.training\x22-jpms\appl\build\libs\appl-1.0-SNAPSHOT.jar;
  C:\...\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-lang3\3.14.0\1ed471194b02f2c6cb734a0cd6f6f107c673afae\commons-lang3-3.14.0.jar;
  C:\...\.gradle\caches\modules-2\files-2.1\org.fusesource.jansi\jansi\2.4.1\d5774f204d990c9f5da2809b88f928515577beb4\jansi-2.4.1.jar 
  appl.ModulesExerciseApp
````

We can see that Gradle is putting all libraries into the **module-path** now.

## 04) Using books-core

### What is the problem?

The class `Book` is not imported and hence not visible.

BUT it cannot be imported, since the module, in which this class is residing, is not visible to our application.