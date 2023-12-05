package x_logging;

import org.junit.jupiter.api.Test;

import static java.lang.System.Logger.Level.*;

public class SystemLoggerApp {

    @Test
    void performLogging() {
        System.Logger logger = System.getLogger(getClass().getName());
        System.out.println(logger.getName());

        logger.log(DEBUG, "Starting");

        var what = "day";
        logger.log(INFO, "Have a nice {0}!", what);

        if (logger.isLoggable(TRACE)) {
            String msg = createDiagnostics();
            logger.log(TRACE, msg);
        }

        Throwable t = new IllegalStateException("uh oh");
        logger.log(ERROR, "Water in drive A:", t);
    }

    private String createDiagnostics() {
        return "";
    }

}
