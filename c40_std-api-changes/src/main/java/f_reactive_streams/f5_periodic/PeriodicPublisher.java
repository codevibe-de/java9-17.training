package f_reactive_streams.f5_periodic;

import java.util.concurrent.*;
import java.util.function.Supplier;

import static utils.MethodLogger.tlog;

class PeriodicPublisher<T> extends SubmissionPublisher<T> {

    private final ScheduledFuture<?> periodicTask;
    private final ScheduledExecutorService scheduler;

    public PeriodicPublisher(int millis, Supplier<? extends T> supplier) {
        this.scheduler = new ScheduledThreadPoolExecutor(1);
        this.periodicTask = scheduler.scheduleAtFixedRate(
                () -> {
                    T element = supplier.get();
                    tlog("submit " + element);
                    this.offer(element, null);
                },
                0, millis, TimeUnit.MILLISECONDS);
    }

    public void close() {
        this.periodicTask.cancel(false);
        this.scheduler.shutdown();
        super.close();
    }
}