package h_objects;

import java.util.Objects;

class Bar {
    static void alpha(int[] array, int index) {
        System.out.println(array[index]);
    }

    static void beta(int[] array, int index) {
        Objects.checkIndex(index, array.length);
        System.out.println(array[index]);
    }

    static void gamma(int[] array, int fromIndex, int toIndex) {
        Objects.checkFromToIndex(fromIndex, toIndex, array.length);
        for (int i = fromIndex; i < toIndex; i++)
            System.out.println(array[i]);
    }
}
