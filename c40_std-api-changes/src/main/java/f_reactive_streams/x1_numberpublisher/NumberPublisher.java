package f_reactive_streams.x1_numberpublisher;

import utils.TimedLogger;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class NumberPublisher extends SubmissionPublisher<Integer> {

    private final int from;
    private final int to;

    private static final TimedLogger LOG = new TimedLogger();

    public NumberPublisher(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public void createItems() {
        LOG.log("Start publishing items");
        IntStream.rangeClosed(this.from, this.to).forEach(n -> {
            LOG.log("Submit " + n);
            submit(n);
        });
        LOG.log("Finished publishing items");
    }

}
