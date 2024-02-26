package a_default_methods;

public interface GreetingProvider {

    String getGreeting();

    // --- additional methods ---

    default boolean isEmpty() {
        return this.containsOnlyWhitespace();
    }

    default boolean isNotEmpty() {
        return !this.containsOnlyWhitespace();
    }

    private boolean containsOnlyWhitespace() {
        var s = stringStripSpaces(getGreeting());
        return s.length() == 0;
    }

    private static String stringStripSpaces(String s) {
        return s.replace(" ", "");
    }

}
