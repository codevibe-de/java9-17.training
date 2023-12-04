package f_reactive_streams.xrc1_numberpublisher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class NumberPublisher extends SubmissionPublisher<Integer> {

    private int from;
    private int to;

    private static final Log LOG = LogFactory.getLog(NumberPublisher.class);

    public NumberPublisher(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public void createItems() {
        LOG.debug("Start publishing items");
        IntStream.rangeClosed(this.from, this.to).forEach(n -> {
            LOG.debug("Submit " + n);
            submit(n);
        });
        LOG.debug("Finished publishing items");
    }

}
