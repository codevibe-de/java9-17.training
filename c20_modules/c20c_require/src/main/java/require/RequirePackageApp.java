package require;

import book.Book;
import org.junit.jupiter.api.Test;

import static utils.MethodLogger.logMethodCall;

public class RequirePackageApp {

    public static void main(String[] args) {
        demoAlpha();
    }

    static void demoAlpha() {
        logMethodCall();
        new Book("", "", null, null);
    }

}
