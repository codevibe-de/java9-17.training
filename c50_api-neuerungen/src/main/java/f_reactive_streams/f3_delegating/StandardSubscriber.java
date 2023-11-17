package f_reactive_streams.f3_delegating;

import z_utils.MethodLogger;

import static z_utils.MethodLogger.tlog;

public class StandardSubscriber<T> extends DelegatingSubscriber<T> {

    public StandardSubscriber(int sleepTime) {
        this.setOnSubscribeHandler(s -> {
            int n = 1;
            tlog("    request(" + n + ")");
            s.request(n);
        });

        this.setOnNextHandler((s, item) -> {
            int n = 1;
            tlog("    sleep(" + sleepTime + ")");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tlog("    request(" + n + ")");
            s.request(n);
        });
    }
}