package f_reactive_streams.delegating;

public class DelegatingSubscriberApp {

    public static void main(String[] args) {
        var subscriber = new DelegatingSubscriber<String>();
        subscriber.setOnSubscribeHandler(s -> {
            s.request(1);
        });
    }
}
