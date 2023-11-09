package f_reactive1;

import f_reactive_streams.SimplePublisher;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

public class SimpleReactiveStreamsApp {

    public static void main(String[] args) throws InterruptedException {
        subscribe();
        submit();
    }

    /**
     * Shows that subscription occurs in a separate thread -- without sleep no output
     */
    private static void subscribe() throws InterruptedException {
        var publisher = new SimplePublisher();
        new SimpleSubscriber(publisher);
        Thread.sleep(1000);
    }


    /**
     * Demos that submitted items and a closed publisher are received.
     */
    private static void submit() throws InterruptedException {
        System.out.println("DEMO offerItems():");
        var start = Instant.now();

        var publisher = new SimplePublisher();
        new SimpleSubscriber(publisher);

        publisher.submit("Hey");
        publisher.submit("ho");
        publisher.submit("let's");
        publisher.submit("go");

        publisher.close();
        System.out.println("Took " + Duration.between(start, Instant.now()).toMillis() + " ms");

        Thread.sleep(1000);
    }

}
