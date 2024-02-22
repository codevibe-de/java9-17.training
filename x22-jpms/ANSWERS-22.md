#

## 01) Turn the application into a JPMS module

### Does it still compile or can you execute it?

No, because the packages imported by the application are not visible to the application yet.

The application module does not "require" them.



###

````shell
C:\...\openjdk17\current\bin\java.exe 
-Djansi.passthrough=true 
-Dfile.encoding=UTF-8 
-Duser.country=DE 
-Duser.language=de 
-Duser.variant 
-cp 
    D:\Workspaces\Codevibe\java9-17.training\x22-jpms\appl\build\classes\java\main;
    D:\Workspaces\Codevibe\java9-17.training\x22-jpms\appl\build\resources\main;
    C:\...\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-lang3\3.14.0\1ed471194b02f2c6cb734a0cd6f6f107c673afae\commons-lang3-3.14.0.jar;
    C:\...\.gradle\caches\modules-2\files-2.1\org.fusesource.jansi\jansi\2.4.1\d5774f204d990c9f5da2809b88f928515577beb4\jansi-2.4.1.jar 
    appl.ModulesExerciseApp
````

### 04

A named module (such as our application) cannot read from the unnamed module BY DESIGN.

The unnamed module only exists for legacy applications where each class within that unnamed module can read 
other classes.

Note that when applying an automatic module name using the manifest in Gradle, tools such as Intellij
do not recognize the resulting JAR as an automatic module. Hence, we need to fix this by converting
our lib into a proper JPMS module.