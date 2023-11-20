package a_optional;

import java.io.IOException;
import java.util.Optional;

public class Optional3App {

    @SuppressWarnings("SimplifyOptionalCallChains")
    public static void main(String[] args) throws IOException {
        Optional<String> s = getOptional();
        // old:
        if (!s.isPresent()) {
            System.out.println("empty");
        }
        // new:
        if (s.isEmpty()) {
            System.out.println("empty");
        }
    }

    private static Optional<String> getOptional() {
        return Optional.empty();
    }

}
