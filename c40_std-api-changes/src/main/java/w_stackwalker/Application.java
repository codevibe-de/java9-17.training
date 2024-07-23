package w_stackwalker;

import org.junit.jupiter.api.Test;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.stream.Stream;

import static utils.MethodLogger.logMethodCall;

class Alpha {
    static void alpha(Runnable runnable) {
        Beta.beta(runnable);
    }
}

class Beta {
    static void beta(Runnable runnable) {
        Gamma.gamma(runnable);
    }
}

class Gamma {
    static void gamma(Runnable runnable) {
        runnable.run();
    }
}

@SuppressWarnings("Convert2MethodRef")
public class Application {

    @Test
    void oldStyle() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    }

    @Test
    void demoForEach() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance();
            walker.forEach((StackFrame f) -> System.out.println(f));
        });
    }


    @Test
    void demoWalk() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance();
            List<StackFrame> stack = walker.walk(
                    (Stream<StackFrame> s) -> s.toList()
            );
            stack.forEach(System.out::println);
        });
    }


    // the stream of StackFrames is closed after walk() - hence we cannot use the stream later
    @Test
    void demoWalkIllegal() {
        logMethodCall();
        try {
            Alpha.alpha(() -> {
                StackWalker walker = StackWalker.getInstance();
                Stream<StackFrame> stream = walker.walk(s -> s);
                stream.forEach(f -> System.out.println(f));
            });
        } catch (Exception e) {
            System.out.println(e);
            // java.lang.IllegalStateException: This stack stream is not valid for walking.
        }
    }


    @Test
    void demoSupportGetDeclaringClassAccessor() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
            walker.forEach(f -> {
                System.out.println(f);
                System.out.println("\t" + f.getDeclaringClass());
            });
        });
    }


    // let the walker skip the first frame and then create only the three top-most frames after that
    @Test
    void demoLimit() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance();
            List<StackFrame> stack = walker.walk(
                    s -> s.skip(1).limit(3).toList()
            );
            stack.forEach(System.out::println);
        });
    }


    // show only frames for classes from our package
    @Test
    void demoFilterClasses() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
            List<StackFrame> stack = walker.walk(
                    s -> s.filter(f -> f.getDeclaringClass().getPackageName().startsWith("w_")).toList()
            );
            stack.forEach(System.out::println);
        });
    }


    @Test
    void demoCallerClass() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
            Class<?> cls = walker.getCallerClass();
            System.out.println(cls);
        });
    }


    @Test
    void demoStackFrame() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
            walker.forEach(f -> print(f));
        });
    }

    static void print(StackFrame f) {
        System.out.println(f);
        System.out.println("\tClassName      = " + f.getClassName());
        System.out.println("\tDeclaringClass = " + f.getDeclaringClass());
        System.out.println("\tMethodName     = " + f.getMethodName());
        System.out.println("\tFileName       = " + f.getFileName());
        System.out.println("\tLineNumber     = " + f.getLineNumber());
    }

}

