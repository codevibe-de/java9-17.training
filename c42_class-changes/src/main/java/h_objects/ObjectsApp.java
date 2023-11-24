package h_objects;

import org.junit.jupiter.api.Test;
import utils.MethodLogger;

// todo
public class ObjectsApp {

    @Test
    void demoRequireNonNull() throws Exception {
        MethodLogger.logMethodCall();
        try {
            Foo.alpha(null);
        } catch (NullPointerException e) {
            System.out.println("Expected" + e);
        }
        Foo.requireWithDefaultValue(null);
        Foo.requireWithDefaultLambda(null);
    }


    @Test
    void demoCheckIndex() throws Exception {
        MethodLogger.logMethodCall();
        int[] array = new int[]{10, 11, 12, 13, 14};
        try {
            ArrayAccessor.uncheckedAccess(array, 5);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
        try {
            ArrayAccessor.checkedAccess(array, 5);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
        ArrayAccessor.rangedCheckedAccess(array, 0, 5);
        try {
            ArrayAccessor.rangedCheckedAccess(array, -1, 6);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}