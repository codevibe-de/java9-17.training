# Training Java 9 to 17

## troubleshooting

#### Eclipse: "Preview features enabled at an invalid source release"

You are using an Eclipse version that is "too new" for Java 17 since it doesn't support the Java 17 preview
features anymore:

https://stackoverflow.com/questions/72986374/eclipse-preview-features-enabled-at-an-invalid-source-release-level

Solution: Remove `<compilerArgs>--enable-preview</compilerArgs>` from top-level pom.xml

This will break compilation for `/c50_pattern-matching`, which can be fixed by setting the `<version.java>` property
in that module's POM to `21`. 

Of course, you need to have a Java 21 JRE configured in Eclipse for this to work.