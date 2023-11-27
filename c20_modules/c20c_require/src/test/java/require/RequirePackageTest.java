package require;

import book.Book;
import org.junit.jupiter.api.Test;

import static utils.MethodLogger.logMethodCall;

public class RequirePackageTest {

    @Test
    void demoAlpha() {
        logMethodCall();
        new Book("", "", null, null);
//        Alpha.pub();
//        // Alpha.pri();  // illegal
//        TryCatch.run(() -> Class.forName("jj.mod.alpha.Alpha").getMethod("pub").invoke(null));
//        TryCatch.run(() -> {
//            Method m = Class.forName("jj.mod.alpha.Alpha").getDeclaredMethod("pri");
//            m.setAccessible(true);  // InaccessibleObjectException
//            m.invoke(null);
//        });
    }

    @Test
    void demoBeta() {
        logMethodCall();
//        // Beta.pub(); // illegal
//        TryCatch.run(() -> {
//            Method m = Class.forName("jj.mod.beta.Beta").getDeclaredMethod("pub");
//            System.out.println(m);
//            m.invoke(null); // IllegalAccessException (because missing exports)
//        });
    }

}
