package x_logging;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import static java.lang.System.Logger.Level.*;

public class SystemLoggerApp {

    @Test
    void logbackDirectly() {
        LoggerFactory.getLogger("test").info("Test!!!");
    }


    @Test
    void javaSystemLoggingDirectly() {
        System.Logger logger = System.getLogger(getClass().getName());
        logger.log(DEBUG, "Starting");

        var what = "day";
        logger.log(INFO, "Have a nice {0}!", what);

        // its good practice to check if level is active before computing complex
        // output data
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
                System.getLogger("java.lang.Runtime").isLoggable(DEBUG)
        );
    }


    /**
     * Calls VM classes that are making use of the new logging API
     */
    @Test
    void triggerInternalLogging() throws IOException {
        var urlConnection = new URL("https://bugs.openjdk.org/s/fn41jq/940014/1xlxtdz/_/jira-logo-scaled.png").openConnection();
        urlConnection.connect();
    }

}
