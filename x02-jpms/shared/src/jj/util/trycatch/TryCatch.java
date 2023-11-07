package jj.util.trycatch;

public class TryCatch {
    @FunctionalInterface
    public interface Action {
        public abstract void execute() throws Throwable;
    }

    public static void run(Action action) {
        try {
            action.execute();
        } catch (Throwable t) {
            t.printStackTrace(System.out);
        }
    }
}
