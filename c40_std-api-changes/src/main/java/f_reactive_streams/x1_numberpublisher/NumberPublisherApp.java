package f_reactive_streams.x1_numberpublisher;

public class NumberPublisherApp {

    public static void main(String[] args) {
        var publisher = new NumberPublisher(10, 20);
        try (publisher) {
            publisher.createItems();
        }
    }
}
