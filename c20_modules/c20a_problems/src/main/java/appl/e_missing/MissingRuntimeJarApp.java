package appl.e_missing;

import book.api.BookService;

// Using a Terminal/Shell:
// a) change into directory `./c20_modules`
// b) execute `mvn clean install --projects c20a_book,c20a_book2,c20a_problems`
// c) execute `java -cp c20a_problems/target/c20a_problems-1.0-SNAPSHOT.jar appl.e_missing.MissingRuntimeJarApp`
public class MissingRuntimeJarApp {

    public static void main(String[] args) throws InterruptedException {
        // problem 5/5
        System.out.println("Everything looking fine...");
        Thread.sleep(2000);
        System.out.println("Now accessing some class for the first time...");
        Thread.sleep(3000);
        BookService.INSTANCE.createBook("", "");
    }
}
