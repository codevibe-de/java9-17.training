# Exercise for chapter "Java Platform Module System"

## 1) New Project

Create a new Maven or Gradle based project in a separate folder.

Your project should contain two Maven/Gradle modules - do not use Java 9 modularization yet. These 
modules can be named e.g. 

* mod-appl 
* mod-libA 

The parent project does not contain any sources.

Create a simple class in the library module.

Create a main class in the application module and instantiate the library class from there. Make
sure the supporting module dependencies are configured in your build script.

## 2) Modularize the application

