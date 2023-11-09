package f_reactive1;

import java.util.concurrent.Flow;

public class SimpleSubscriber implements Flow.Subscriber<String> {

    private Flow.Subscription subscription;

    public SimpleSubscriber(Flow.Publisher<String> publisher) {
        publisher.subscribe(this);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        log("onSubscribe(..)");
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        log(String.format("onNext(%s)", item));
        this.subscription.request(1);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        log(String.format("onError(%s:%s)", throwable.getClass().getSimpleName(), throwable.getMessage()));
    }

    @Override
    public void onComplete() {
        log("onComplete()");
    }

    private void log(String msg) {
        System.out.printf(
                "[%s] %d %s\n",
                Thread.currentThread().getName(),
                System.currentTimeMillis(),
                msg);

    }

}
