package h_objects;

import java.util.Objects;

class ArrayAccessor {

    static void uncheckedAccess(int[] array, int index) {
        System.out.println(array[index]);
    }

    static void checkedAccess(int[] array, int index) {
        Objects.checkIndex(index, array.length);
        System.out.println(array[index]);
    }

    static void rangedCheckedAccess(int[] array, int fromIndex, int toIndex) {
        Objects.checkFromToIndex(fromIndex, toIndex, array.length);
        for (int i = fromIndex; i < toIndex; i++)
            System.out.println(array[i]);
    }
}
