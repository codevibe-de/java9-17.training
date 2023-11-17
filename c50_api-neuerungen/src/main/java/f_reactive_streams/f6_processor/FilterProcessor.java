package f_reactive_streams.f6_processor;

import f_reactive_streams.f3_delegating.DelegatingSubscriber;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Predicate;

// unfortunately we cannot inherit from *both* SubmissionPublisher and DelegatingSubscriber
public class FilterProcessor<T> extends SubmissionPublisher<T> implements Processor<T, T> {

    private final DelegatingSubscriber<T> subscriber = new DelegatingSubscriber<>();

    public FilterProcessor(Predicate<? super T> predicate) {
        super(ForkJoinPool.commonPool(), 1);
        this.subscriber
                .setOnSubscribeHandler(s -> s.request(1))
                .setOnNextHandler((s, item) -> {
                    if (predicate.test(item)) {
                        this.submit(item);
                    }
                    s.request(1);
                })
                .setOnCompleteHandler(s -> this.close());
    }

    // DELEGATE pattern:

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(T item) {
        this.subscriber.onNext(item);
    }

    @Override
    public void onError(Throwable t) {
        this.subscriber.onError(t);
    }

    @Override
    public void onComplete() {
        this.subscriber.onComplete();
    }
}