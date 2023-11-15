package f_reactive_streams.delegating;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class DelegatingSubscriber<T> implements Flow.Subscriber<T> {

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

    public DelegatingSubscriber<T> setOnSubscribeHandler(Consumer<Subscription> onSubscribeHandler) {
        this.onSubscribeHandler = onSubscribeHandler;
        return this;
    }

    public DelegatingSubscriber<T> setOnNextHandler(BiConsumer<Subscription, T> onNextHandler) {
        this.onNextHandler = onNextHandler;
        return this;
    }

    public DelegatingSubscriber<T> setOnErrorHandler(BiConsumer<Subscription, Throwable> onErrorHandler) {
        this.onErrorHandler = onErrorHandler;
        return this;
    }

    public DelegatingSubscriber<T> setOnCompleteHandler(Consumer<Subscription> onCompleteHandler) {
        this.onCompleteHandler = onCompleteHandler;
        return this;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        onSubscribeHandler.accept(subscription);
        this.subscription = subscription;
    }

    @Override
    public void onNext(T item) {
        this.onNextHandler.accept(this.subscription, item);
    }

    @Override
    public void onError(Throwable throwable) {
        this.onErrorHandler.accept(this.subscription, throwable);
    }

    @Override
    public void onComplete() {
        this.onCompleteHandler.accept(this.subscription);
    }
}
