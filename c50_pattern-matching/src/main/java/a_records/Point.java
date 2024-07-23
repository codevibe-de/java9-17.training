package a_records;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public record Point(
        double x,
        double y
) {
//    // generated
//    public Point(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }

    // compact constructor
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x and y must be >= 0");
        }
    }

    // additional constructors
    public Point() {
        this(0, 0);
    }

    public Point(double x) {
        this(x, 0);
    }


}

class App {

    @Test
    public void foo() {
        var p = new Point(1.23, 4.56);
        System.out.println(p);

        var p2 = new Point(1.23, 4.56);
        System.out.println(p.equals(p2)); // true

        p.x();
        p.y();

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
