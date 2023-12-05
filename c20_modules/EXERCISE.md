# Exercise for chapter "Java Platform Module System"

## 1) New Project

Create a new Maven or Gradle based project in a separate folder.

Your project should contain two Maven modules/Gradle subprojects. DO NOT use Java 9 modularization
yet. These modules can be named e.g.

* mod-appl
* mod-libA

The parent project does not contain any sources.

Create a simple class in the library module.

Create a main class in the application module and instantiate the library class from there. Make
sure the supporting module dependencies are configured in your build script.

## 2) Modularize the application

Make the application module executable by specifying the main class in the build script.

Execute your application using Maven or Gradle.