package a_collection_factory_methods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.MethodLogger.logMethodCall;

public class CollectionCopyOfApp {

    /**
     * Showcases copyOf for a List. Same applies to Set and Map.
     */
    @Test
    void listCopyOf() {
        logMethodCall();
        // create
        List<String> list = new ArrayList<>();
        list.add("red");
        list.add("green");
        list.add("blue");
        // copy
        List<String> copy = List.copyOf(list);
        // we cannot add to it
        try {
            copy.add("yellow");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getClass());
        }
    }


    @Test
    void listCopyOfImmutableListSameInstance() {
        var originalList = List.of(1);
        var copiedList = List.copyOf(originalList);
        System.out.println("originalList == copiedList? " + (originalList == copiedList));
    }


    /**
     * Demos Collectors.toUnmodifiableList -- same applies to Set and Map
     */
    @Test
    void demoCollectorsToUnmodifiableList() {
        logMethodCall();

        List<String> list1 = Stream.of("red", "green", "blue").collect(Collectors.toList());
        list1.add("yellow");
        list1.forEach(System.out::println);

        List<String> list2 = Stream.of("red", "green", "blue").collect(Collectors.toUnmodifiableList());
        try {
            list2.add("yellow");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getClass());
        }
        list2.forEach(System.out::println);
    }

}
