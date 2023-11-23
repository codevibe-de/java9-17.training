package w_stackwalker;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

public class Application {

    public static void main(String[] args) {
        demoForEach();
        demoWalk();
        demoWalkIllegal();
        demoWithClasses();
        demoOptions();
        demoLimit();
        demoSkip();
        demoFilterClasses();
        demoCallerClass();
        demoStackFrame();
        demoPerformance();
        demoTracer();
    }

    static void demoForEach() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance();
            walker.forEach((StackFrame f) -> System.out.println(f));
        });
    }

    static void demoWalk() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance();
            List<StackFrame> stack = walker.walk((Stream<StackFrame> s) -> s.collect(Collectors.toList()));
            for (StackFrame f : stack) {
                System.out.println(f);
            }
        });
    }

    static void demoWalkIllegal() {
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

    static void demoWithClasses() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
            walker.forEach(f -> {
                System.out.println(f);
                System.out.println("\t" + f.getDeclaringClass());
            });
        });
    }

    static void demoOptions() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance(Set.of(
                    StackWalker.Option.RETAIN_CLASS_REFERENCE,
                    StackWalker.Option.SHOW_HIDDEN_FRAMES,
                    StackWalker.Option.SHOW_REFLECT_FRAMES
            ));
            walker.forEach(System.out::println);
        });
    }

    static void demoLimit() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance();
            // StackWalker walker = StackWalker.getInstance(new
            // HashSet<StackWalker.Option>(), 2);
            List<StackFrame> stack = walker.walk(s -> s.limit(2).collect(Collectors.toList()));
            for (StackFrame f : stack) {
                System.out.println(f);
            }
        });
    }

    static void demoSkip() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance();
            List<StackFrame> stack = walker.walk(s -> s.skip(2).collect(Collectors.toList()));
            for (StackFrame f : stack) {
                System.out.println(f);
            }
        });
    }

    static void demoFilterClasses() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
            List<StackFrame> stack = walker
                    .walk(s -> s.filter(f -> f.getDeclaringClass() == Alpha.class).collect(Collectors.toList()));
            for (StackFrame f : stack) {
                System.out.println(f);
            }
        });
    }

    static void demoCallerClass() {
        logMethodCall();
        Alpha.alpha(() -> {
            StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
            Class<?> cls = walker.getCallerClass();
            System.out.println(cls);
        });
    }

    static void demoStackFrame() {
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

    static void demoPerformance() {
        logMethodCall();
        System.out.println("running...");
        Alpha.alpha(() -> {
            final int N = 100000;
            long n1 = 0;
            long n2 = 0;
            long n3 = 0;
            long duration1 = 0;
            long duration2 = 0;
            long duration3 = 0;
            for (int i = 0; i < N; i++) {
                {
                    long start = System.nanoTime();
                    StackWalker walker = StackWalker.getInstance();
                    List<StackFrame> stack = walker
                            .walk(s -> s.limit(2).collect(Collectors.toList()));
                    n1 += stack.size();
                    duration1 += (System.nanoTime() - start);
                }
                {
                    long start = System.nanoTime();
                    StackWalker walker = StackWalker.getInstance();
                    long count = walker
                            .walk(s -> s.limit(2).count());
                    n2 += count;
                    duration2 += (System.nanoTime() - start);
                }
                {
                    long start = System.nanoTime();
                    StackTraceElement[] elements = Thread.currentThread().getStackTrace();
                    n3 += elements.length;
                    duration3 += (System.nanoTime() - start);
                }
            }
            System.out.println(n1);
            System.out.println(n2);
            System.out.println(n3);
            System.out.println(duration1);
            System.out.println(duration2);
            System.out.println(duration3);
        });
    }

    static void demoTracer() {
        logMethodCall();
        int result = foo(42, "Hello");
        System.out.println("result = " + result);
    }

    static int foo(int x, String s) {
        try (Tracer tracer = new Tracer(x, s)) {
            tracer.trace("foo starts work...");
            bar(null);
            tracer.trace("foo terminates work...");
            return tracer.value(2 * x);
        }
    }

    static void bar(Object obj) {
        try (Tracer tracer = new Tracer(obj)) {
            tracer.trace("bar working...");
        }
    }
}

