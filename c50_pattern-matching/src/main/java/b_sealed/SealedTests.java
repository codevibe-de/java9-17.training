package b_sealed;

import org.junit.jupiter.api.Test;
import utils.MethodLogger;

import java.util.Arrays;

public class SealedTests {

    @Test
    void reflection() {
        MethodLogger.logMethodCall();
        System.out.println(Ship.class.isSealed());
        System.out.println(Arrays.toString(Ship.class.getPermittedSubclasses()));
    }
}
