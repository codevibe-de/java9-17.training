package n_completablefuture;


import org.junit.jupiter.api.Test;
import utils.MethodLogger;
import utils.Sleeper;

import java.util.concurrent.*;
import java.util.function.Function;

import static utils.MethodLogger.logMethodCall;
import static utils.MethodLogger.tlog;

// todo
public class CompletableFutureApp {

    @Test
    void demoPythagoras() {
        logMethodCall();
        CompletableFuture<Double> cf1_start = new CompletableFuture<>();
        CompletableFuture<Double> cf2_start = new CompletableFuture<>();
        CompletableFuture<Double> cf1_next = cf1_start.thenApplyAsync(x -> x * x);
        CompletableFuture<Double> cf2_next = cf2_start.thenApplyAsync(x -> x * x);
        CompletableFuture<Double> cf_combined = cf1_next.thenCombine(cf2_next, (x, y) -> x + y);
        CompletableFuture<Double> cf_final = cf_combined.thenApply(Math::sqrt);
        cf1_start.complete(3.0);
        cf2_start.complete(4.0);
        try {
            double result = cf_final.get();
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void demoPythagorasVerbose() {
        logMethodCall();
        CompletableFuture<Double> f1 = new CompletableFuture<>();
        CompletableFuture<Double> f2 = new CompletableFuture<>();
        CompletableFuture<Double> f3 = f1.thenApplyAsync(x -> {
            tlog(x + " * " + x + " => " + (x * x));
            Sleeper.sleep(1000);
            return x * x;
        });
        CompletableFuture<Double> f4 = f2.thenApplyAsync(x -> {
            tlog(x + " * " + x + " => " + (x * x));
            Sleeper.sleep(1000);
            return x * x;
        });
        CompletableFuture<Double> f5 = f3.thenCombine(f4, (x, y) -> {
            tlog(x + " + " + y + " => " + (x + y));
            Sleeper.sleep(1000);
            return x + y;
        });
        CompletableFuture<Double> f6 = f5.thenApply(x -> {
            tlog("Math.sqrt(" + x + ") ==> " + Math.sqrt(x));
            Sleeper.sleep(1000);
            return Math.sqrt(x);
        });

        tlog("complete 3.0");
        f1.complete(3.0);
        Sleeper.sleep(300);

        tlog("complete 4.0");
        f2.complete(4.0);

        try {
            double result = f6.get();
            tlog(result);
        } catch (InterruptedException | ExecutionException e) {
            tlog(e);
        }
    }


    @Test
    void demoSimple() throws InterruptedException, ExecutionException {
        logMethodCall();
        CompletableFuture<Integer> f1 = new CompletableFuture<>();
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
        f1.complete(3);
        int result = f2.get();
        System.out.println(result);
    }


    @Test
    void demoCompleteAsync() throws InterruptedException, ExecutionException {
        logMethodCall();
        CompletableFuture<Integer> f1 = new CompletableFuture<>();
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
        f1.completeAsync(() -> 3);

        int result = f2.get();
        System.out.println(result);
    }


    /**
     * Demonstrates the use of the `completeOnTimeout` method by completing the future with a default value if the
     * computation takes too long.
     */
    @Test
    void demoCompleteOnTimeout() throws InterruptedException, ExecutionException {
        logMethodCall();
        CompletableFuture<Integer> f1 = new CompletableFuture<>();
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> {
            sleep(2000); // this is more than timeout
            return x * x;
        });
        CompletableFuture<Integer> f3 = f2.completeOnTimeout(-1, 1000, TimeUnit.MILLISECONDS);
        System.out.println(f3 == f2); // completeOnTimeout returns this

        f1.complete(3);
        int result = f3.get();
        System.out.println(result);
    }


    /**
     * Demonstrates the use of the `orTimeout` method by completing the future exceptionally if the computation takes
     * too long.
     */
    @Test
    void demoOrTimeout() {
        logMethodCall();
        CompletableFuture<Integer> f1 = new CompletableFuture<>();
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> {
            sleep(2000);
            return x * x;
        });
        CompletableFuture<Integer> f3 = f2.orTimeout(1000, TimeUnit.MILLISECONDS);
        System.out.println(f3 == f2);
        f1.complete(3);
        try {
            int result = f3.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e);
        }
    }


    @Test
    void demoCompletedFuture() throws InterruptedException, ExecutionException {
        logMethodCall();
        CompletableFuture<Integer> f1 = CompletableFuture.completedFuture(3); // java
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
        int result = f2.get();
        System.out.println(result);
    }


    @Test
    void demoFailedFuture() {
        logMethodCall();
        CompletableFuture<Integer> f1 = CompletableFuture.failedFuture(new RuntimeException("Water in drive a:"));
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
        try {
            int result = f2.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
    }


    @Test
    void demoCompletedStage() throws InterruptedException, ExecutionException {
        logMethodCall();
        CompletionStage<Integer> f1 = CompletableFuture.completedStage(3);
        CompletionStage<Integer> f2 = f1.thenApplyAsync(x -> x * x);
        f2.whenComplete((Integer v, Throwable t) -> System.out.println(v + " " + t));
    }


    @Test
    void demoFailedStage() throws InterruptedException, ExecutionException {
        logMethodCall();
        CompletionStage<Integer> f1 = CompletableFuture.failedStage(new RuntimeException("ex"));
        CompletionStage<Integer> f2 = f1.thenApplyAsync(x -> x * x);
        f2.whenComplete((Integer v, Throwable t) -> System.out.println(v + " " + t));
    }


    @Test
    void demoDefaultExecutor() {
        logMethodCall();
        CompletableFuture<Integer> f = new CompletableFuture<>();
        Executor executor = f.defaultExecutor();
        System.out.println(executor);
    }


    @Test
    void demoDelayedExecutor() throws InterruptedException, ExecutionException {
        logMethodCall();
        CompletableFuture<Integer> f1 = new CompletableFuture<>();
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
        f1.completeAsync(() -> 3, CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
        int result = f2.get();
        System.out.println(result);
    }


    @Test
    void demoNewIncompleteFuture() throws InterruptedException, ExecutionException {
        logMethodCall();
        CompletableFuture<Integer> f1 = new MyFuture<>();
        System.out.println(f1.getClass().getName());
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
        System.out.println(f2.getClass().getName());
        f1.complete(3);
        int result = f2.get();
        System.out.println(result);
    }


    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    static class MyFuture<T> extends CompletableFuture<T> {
        @SuppressWarnings("unchecked")
        @Override
        public CompletableFuture<T> newIncompleteFuture() {
            System.out.println("MyFuture.newIncompleteFuture()");
            return new MyFuture<T>();
        }

        @SuppressWarnings("unchecked")
        @Override
        public <R> MyFuture<R> thenApplyAsync(Function<? super T, ? extends R> function) {
            sleep(10);
            return (MyFuture<R>) super.thenApplyAsync(function, new MyExecutor());
        }

        static class MyExecutor implements Executor {
            @Override
            public void execute(Runnable command) {
                System.out.println("MyExecutor.execute(" + command + ")");
                new Thread(command).start();
            }
        }
    }
}