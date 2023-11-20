package h_objects;

import utils.MethodLogger;

// todo
public class ObjectsApp {

    public static void main(String[] args) throws Exception {
        demoRequireNonNull();
        demoCheckIndex();
    }

    static void demoRequireNonNull() throws Exception {
        MethodLogger.logMethodCall();
        try {
            Foo.alpha(null);
        } catch (NullPointerException e) {
            System.out.println("Expected" + e);
        }
        Foo.beta(null);
        Foo.gamma(null);
    }

    static void demoCheckIndex() throws Exception {
        MethodLogger.logMethodCall();
        int[] array = new int[]{10, 11, 12, 13, 14};
        try {
            Bar.alpha(array, 5);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
        try {
            Bar.beta(array, 5);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
        Bar.gamma(array, 0, 5);
        try {
            Bar.gamma(array, -1, 6);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}