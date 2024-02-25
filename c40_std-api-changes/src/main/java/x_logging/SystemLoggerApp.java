package x_logging;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static java.lang.System.Logger.Level.*;

public class SystemLoggerApp {

    @Test
    void logbackDirectly() {
        LoggerFactory.getLogger("test").info("Test!!!");
    }


    @Test
    void performLogging() {
        System.Logger logger = System.getLogger(getClass().getName());
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


    @Test
    void checkLevel() {
        System.out.println(
                System.getLogger("java.runtime").isLoggable(DEBUG)
        );
    }

}
