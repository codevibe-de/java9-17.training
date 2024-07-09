package f_arrays;

import org.junit.jupiter.api.Test;
import utils.MethodLogger;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysApp {

    /**
     * Checks for equality of two arrays of `int` values using a range of indices.
     */
    @Test
    void demoEqualsRange() throws Exception {
        MethodLogger.logMethodCall();
        int[] ints1 = new int[]{10, 11, 12, 13, 14, 15};
        int[] ints2 = new int[]{11, 12, 13, 14, 15, 16};

        // public static boolean equals(
        //   int[] a, int aFromIndex, int aToIndex,
        //   int[] b, int bFromIndex, int bToIndex
        // )
        System.out.println(Arrays.equals(ints1, 1, 5, ints2, 0, 4));
    }


    /**
     * Checks for equality of two arrays of `Foo` objects using a custom comparator since `Foo` does not implement `Comparable`.
     */
    @Test
    void demoEquals() throws Exception {
        MethodLogger.logMethodCall();

        class Foo {
            public final int x;

            public Foo(int x) {
                this.x = x;
            }
        }

        Foo[] foos1 = new Foo[]{new Foo(10), new Foo(11)};
        Foo[] foos2 = new Foo[]{new Foo(10), new Foo(11)};

        // public static boolean equals(Object[] a, Object[] a2) {
        System.out.println(Arrays.equals(foos1, foos2)); // false

        // public static <T> boolean equals(T[] a, T[] a2, Comparator<? super T> cmp) {
        Comparator<Foo> comparator = Comparator.comparing(foo -> foo.x);
        System.out.println(Arrays.equals(foos1, foos2, comparator)); // true
    }


    /**
     * Compares two arrays of `int` values.
     */
    @Test
    void demoComparePrimitive() throws Exception {
        MethodLogger.logMethodCall();
        int[] ints1 = new int[]{11, 12, 13, 15};
        int[] ints2 = new int[]{11, 12, 13, 15};
        System.out.println(Arrays.compare(ints1, ints2)); // 0

        int[] ints3 = new int[]{11, 12, 13, 15};
        int[] ints4 = new int[]{11, 12, 130, 150};
        System.out.println(Arrays.compare(ints3, ints4)); // -1

        int[] ints5 = new int[]{11, 12, 13, 155};
        int[] ints6 = new int[]{11, 12};
        System.out.println(Arrays.compare(ints5, ints6)); // 2
    }


    /**
     * Compares two arrays of `Foo` objects, which implement `Comparable`.
     */
    @Test
    void demoCompareComparable() {
        MethodLogger.logMethodCall();

        class Foo implements Comparable<Foo> {
            public final int x;
            public Foo(int x) {
                this.x = x;
            }
            @Override
            public int compareTo(Foo other) {
                return Integer.compare(this.x, other.x);
            }
        }

        Foo[] foos1 = new Foo[]{new Foo(10), new Foo(11)};
        Foo[] foos2 = new Foo[]{new Foo(10), new Foo(11)};
        System.out.println(Arrays.compare(foos1, foos2));

        Foo[] foos3 = new Foo[]{new Foo(10), new Foo(11)};
        Foo[] foos4 = new Foo[]{new Foo(10), new Foo(111)};
        System.out.println(Arrays.compare(foos3, foos4));

        Foo[] foos5 = new Foo[]{new Foo(10), new Foo(111)};
        Foo[] foos6 = new Foo[]{new Foo(10), new Foo(11)};
        System.out.println(Arrays.compare(foos5, foos6));
    }


    /**
     * Compares two arrays of `Foo` objects, which do not implement `Comparable` using a custom comparator.
     */
    @Test
    void demoCompareComparator() {
        MethodLogger.logMethodCall();

        class Foo {
            public final int x;
            public Foo(int x) {
                this.x = x;
            }
        }

        Foo[] foos1 = new Foo[]{new Foo(10), new Foo(111)};
        Foo[] foos2 = new Foo[]{new Foo(10), new Foo(11)};
        System.out.println(Arrays.compare(foos1, foos2, Comparator.comparing(foo -> foo.x)));
    }


    /**
     * Finds the index of the first mismatch between two arrays of `int` values.
     */
    @Test
    void demoMismatch() throws Exception {
        MethodLogger.logMethodCall();
        int[] ints1 = new int[]{11, 12, 13, 14};
        int[] ints2 = new int[]{11, 12, 13, 14};
        System.out.println(Arrays.mismatch(ints1, ints2)); // -1

        int[] ints3 = new int[]{11, 12, 13, 14};
        int[] ints4 = new int[]{11, 12, 133, 14};
        System.out.println(Arrays.mismatch(ints3, ints4)); // 2
    }
}