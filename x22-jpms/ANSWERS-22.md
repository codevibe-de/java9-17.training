#

## 01) Turn the application into a JPMS module

### Does it still compile or can you execute it?

No, because the packages imported by the application are not visible to the application yet.

The application module does not "require" them.

## 03) Classpath Investigation

### What library-specific arguments are passed to the `java` command?

````shell
TODO
````

## 04) Using books-core

### What is the problem?

A named module (such as our application) cannot read from the unnamed module BY DESIGN.

TODO warum ist die lib "unnamed" und nicht "automatic"? 

The unnamed module only exists for legacy applications where each class within that unnamed module
can read other classes.

Note that when applying an automatic module name using the manifest in Gradle, tools such as
Intellij
do not recognize the resulting JAR as an automatic module. Hence, we need to fix this by converting
our lib into a proper JPMS module.