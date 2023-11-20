package f_reactive_streams.f3_delegating;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class DelegatingSubscriberApp {

    public static void main(String[] args) throws InterruptedException {
        var subscriber = new StandardSubscriber<>(100);

        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        publisher.subscribe(subscriber);
        publisher.submit(1);
        publisher.submit(2);
        publisher.submit(3);
        publisher.close();

        subscriber.awaitAndAssert(List.of(1, 2, 3));

        Thread.sleep(1000);
    }
}
