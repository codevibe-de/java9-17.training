package jj.util.base;

import java.util.function.Function;

@FunctionalInterface
public interface XRunnable {

    public static void xrun(XRunnable runnable) {
        xrun(e -> new RuntimeException(e), runnable);
    }

    public static void xrun(
            Function<Throwable, ? extends RuntimeException> wrapper,
            XRunnable runnable) {
        try {
            runnable.run();
        } catch (Throwable e) {
            throw wrapper.apply(e);
        }
    }

    public abstract void run() throws Throwable;
}
