package f_reactive_streams;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

public class SimplePublisher extends SubmissionPublisher<String> {

    public SimplePublisher() {
        super(ForkJoinPool.commonPool(), 1);
    }

    @Override
    public int submit(String item) {
        System.out.println("Submitting " + item);
        return super.submit(item);
    }

    public int offer(String item) {
        System.out.println("Offering " + item);
        return super.offer(item, null);
    }
}
