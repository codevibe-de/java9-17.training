package r_enhanced_random;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

public class EnhancedRandomApp {

    @Test
    void of() {
        Stream.of("SecureRandom",
                        "SplittableRandom",
                        "L32X64MixRandom"
                )
                .map(RandomGenerator::of)
                .forEach(System.out::println);
    }

    @Test
    void intsUnlimited() {
        RandomGenerator generator = RandomGenerator.getDefault();
        generator.ints()
                .takeWhile(v -> v > 0)
                .forEach(System.out::println);
    }


    @Test
    void intsLimitedAndRanged() {
        RandomGenerator generator = RandomGenerator.getDefault();
        generator.ints(10, 0, 1000)
                .forEach(System.out::println);
    }


    @Test
    void next() {
        RandomGenerator generator = ThreadLocalRandom.current();
        var serverPort = generator.nextInt(8000, 8080);
        System.out.println(serverPort);
    }
}
