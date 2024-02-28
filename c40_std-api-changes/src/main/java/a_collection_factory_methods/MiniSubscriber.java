package a_collection_factory_methods;

import utils.TimedLogger;

import java.util.concurrent.Flow;

public class MiniSubscriber implements Flow.Subscriber<String> {

    private Flow.Subscription subscription;

    public MiniSubscriber() {
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
    }

    @Override
    public void onComplete() {
    }

}
