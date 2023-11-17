package f_reactive_streams.f5_periodic;

import f_reactive_streams.f3_delegating.Message;
import f_reactive_streams.f3_delegating.StandardSubscriber;

import java.util.concurrent.atomic.AtomicInteger;

import static z_utils.MethodLogger.logMethodCall;
import static z_utils.MethodLogger.tlog;

public class PeriodicPublisherApp {

    public static void main(String[] args) throws InterruptedException {
        demo();
    }

    static void demo() throws InterruptedException {
        logMethodCall();
        AtomicInteger number = new AtomicInteger(42);
        tlog("creating Publisher");
        PeriodicPublisher<Message> publisher = new PeriodicPublisher<>(1000, () -> new Message(number.getAndIncrement()));
        StandardSubscriber<Message> subscriber = new StandardSubscriber<>(1);
        Thread.sleep(2000);
        tlog("subscribe");
        publisher.subscribe(subscriber);
        Thread.sleep(5000);
        tlog("close");
        publisher.close();
        subscriber.await();
    }
}
