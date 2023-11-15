package f_reactive_streams.f1_simple;

import f_reactive_streams.SimpleSubscriber;
import z_utils.MethodLogger;
import z_utils.TimedLogger;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

@SuppressWarnings({"DuplicatedCode", "resource"})
public class SimpleReactiveStreamsApp {

    public static void main(String[] args) throws InterruptedException {
        subscribe();
        submitNoSubscribers();
        submit();
        submitUnbuffered();
        offer();
    }

    /**
     * Shows that subscription occurs in a separate thread -- without sleep no output
     */
    private static void subscribe() throws InterruptedException {
        MethodLogger.logMethodCall();
        var publisher = new SubmissionPublisher<String>();
        var subscriber = new SimpleSubscriber("subscriber", new TimedLogger());
        publisher.subscribe(subscriber);
        Thread.sleep(1000);
    }


    /**
     * A publisher without subscribers basically discards all items.
     */
    private static void submitNoSubscribers() throws InterruptedException {
        MethodLogger.logMethodCall();
        TimedLogger log = new TimedLogger();

        var publisher = new SubmissionPublisher<String>();

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            log.log("Submitting %s", item);
            publisher.submit(item);
        }

        publisher.close();
        log.log("Publisher closed");

        Thread.sleep(1000);
    }


    /**
     * Demos that submitted items and a closed publisher are received by the subscriber.
     */
    private static void submit() throws InterruptedException {
        MethodLogger.logMethodCall();
        TimedLogger log = new TimedLogger();

        var publisher = new SubmissionPublisher<String>();
        var subscriber = new SimpleSubscriber("subscriber", log);
        publisher.subscribe(subscriber);

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            log.log("Submitting %s", item);
            publisher.submit(item);
        }

        publisher.close();
        log.log("Publisher closed");

        Thread.sleep(2000);
    }


    /**
     * Demos that an unbuffered publisher blocks on subscribers when using {@code submit()}.
     */
    private static void submitUnbuffered() throws InterruptedException {
        MethodLogger.logMethodCall();
        TimedLogger log = new TimedLogger();

        var publisher = new SubmissionPublisher<String>(ForkJoinPool.commonPool(), 1);
        var subscriber = new SimpleSubscriber("subscriber", log);
        publisher.subscribe(subscriber);

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            log.log("Submitting %s", item);
            publisher.submit(item);
        }

        publisher.close();
        log.log("Publisher closed");

        Thread.sleep(1000);
    }


    /**
     * Demonstrates that {@code offer()} does not block but discards items that cannot be received.
     */
    private static void offer() throws InterruptedException {
        MethodLogger.logMethodCall();
        TimedLogger log = new TimedLogger();

        var publisher = new SubmissionPublisher<String>(ForkJoinPool.commonPool(), 1);
        var subscriber = new SimpleSubscriber("subscriber", log);
        publisher.subscribe(subscriber);

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            log.log("Offering %s", item);
            publisher.offer(item, null);
        }

        publisher.close();
        log.log("Publisher closed");

        Thread.sleep(1000);
    }
}
