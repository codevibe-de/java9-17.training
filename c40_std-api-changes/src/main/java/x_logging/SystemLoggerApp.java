package x_logging;

import org.junit.jupiter.api.Test;

public class SystemLoggerApp {

    @Test
    void performLogging() {
        System.Logger logger = System.getLogger(getClass().getName());
        System.out.println(logger.getName());

        logger.log(System.Logger.Level.DEBUG, "Starting");

        var what = "day";
        logger.log(System.Logger.Level.INFO, "Have a nice {0}!", what);

        if (logger.isLoggable(System.Logger.Level.TRACE)) {
            String msg = createDiagnostics();
            logger.log(System.Logger.Level.TRACE, msg);
        }

        Throwable t = new IllegalStateException("uh oh");
        logger.log(System.Logger.Level.ERROR, "Water in drive A:", t);
    }

    private String createDiagnostics() {
        return "";
    }

}
