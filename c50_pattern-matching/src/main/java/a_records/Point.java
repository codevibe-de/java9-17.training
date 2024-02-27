package a_records;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public record Point(
        double x,
        double y
) {
}

class App {

    @Test
    public void foo() {
        var p = new Point(1.23, 4.56);
        System.out.println(p);

        var p2 = new Point(1.23, 4.56);
        System.out.println(p.equals(p2)); // true

        var n = p.x();

        Arrays.stream(Point.class.getRecordComponents())
                .forEach(System.out::println);
    }


//    @Test
//    void jsonDeserialize() throws JsonProcessingException {
//        var json = """
//                { "x": 1.23, "ycoord": 99 }
//                """;
//        var p = new ObjectMapper().readValue(json, Record.class);
//        System.out.println(p);
//    }
}
