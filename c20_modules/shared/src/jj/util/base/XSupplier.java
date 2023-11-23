package jj.util.base;

import java.util.function.Function;

@FunctionalInterface
public interface XSupplier<T> {

    public static <T> T xget(XSupplier<T> supplier) {
        return xget(e -> new RuntimeException(e), supplier);
    }

    public static <T> T xget(
            Function<Throwable, ? extends RuntimeException> wrapper,
            XSupplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            throw wrapper.apply(e);
        }
    }

    public abstract T get() throws Exception;
}
