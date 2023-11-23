package f_reactive_streams.f3_delegating;

import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static utils.MethodLogger.tlogEnter;
import static utils.MethodLogger.tlogExit;

public class DelegatingSubscriber<T> implements Flow.Subscriber<T> {

    @NotNull
    private Consumer<Subscription> onSubscribeHandler = (s) -> {
    };
    @NotNull
    private BiConsumer<Subscription, T> onNextHandler = (s, i) -> {
    };
    @NotNull
    private BiConsumer<Subscription, Throwable> onErrorHandler = (s, t) -> {
    };
    @NotNull
    private Consumer<Subscription> onCompleteHandler = (s) -> {
    };

    private Subscription subscription;

    private final CountDownLatch done = new CountDownLatch(1);

    private final List<T> receivedItems = new ArrayList<>();

    public DelegatingSubscriber<T> setOnSubscribeHandler(@NotNull Consumer<Subscription> onSubscribeHandler) {
        this.onSubscribeHandler = Objects.requireNonNull(onSubscribeHandler);
        return this;
    }

    public DelegatingSubscriber<T> setOnNextHandler(@NotNull BiConsumer<Subscription, T> onNextHandler) {
        this.onNextHandler = Objects.requireNonNull(onNextHandler);
        return this;
    }

    public DelegatingSubscriber<T> setOnErrorHandler(@NotNull BiConsumer<Subscription, Throwable> onErrorHandler) {
        this.onErrorHandler = Objects.requireNonNull(onErrorHandler);
        return this;
    }

    public DelegatingSubscriber<T> setOnCompleteHandler(@NotNull Consumer<Subscription> onCompleteHandler) {
        this.onCompleteHandler = Objects.requireNonNull(onCompleteHandler);
        return this;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        tlogEnter(subscription.getClass().getSimpleName());
        this.subscription = subscription;
        this.onSubscribeHandler.accept(this.subscription);
        tlogExit();
    }

    @Override
    public void onNext(T item) {
        tlogEnter(item);
        this.receivedItems.add(item);
        this.onNextHandler.accept(this.subscription, item);
        tlogExit();
    }

    @Override
    public void onError(Throwable t) {
        tlogEnter(t);
        this.onErrorHandler.accept(this.subscription, t);
        done.countDown();
        tlogExit();
    }

    @Override
    public void onComplete() {
        tlogEnter();
        this.onCompleteHandler.accept(this.subscription);
        done.countDown();
        tlogExit();
    }

    public List<T> await() throws InterruptedException {
        tlogEnter();
        done.await();
        tlogExit();
        return this.receivedItems;
    }

    public void awaitAndAssert(List<T> expectedItems) throws InterruptedException {
        List<T> actualItems = await();
        Assertions.assertThat(actualItems).containsExactlyElementsOf(expectedItems);
    }
}