package appl.d_missing;

import book.api.BookService;

// a) `mvn clean install --projects c20.0_book,c20.1_problems` from `./c20_modules` dir
// b) `java -cp c20.1_problems\target\c20.1_problems-1.0-SNAPSHOT.jar appl.d_missing.MissingRuntimeJarApp`
public class MissingRuntimeJarApp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Everything looking fine...");
        Thread.sleep(2000);
        System.out.println("Now accessing some class for the first time...");
        Thread.sleep(3000);
        BookService.INSTANCE.createBook("", "");
    }
}
