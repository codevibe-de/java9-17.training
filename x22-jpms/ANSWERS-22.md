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
