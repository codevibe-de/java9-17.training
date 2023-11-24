package a_collection_factory_methods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.MethodLogger.logMethodCall;

public class CollectionCopyOfApp {

    @Test
    void listCopyOf() {
        logMethodCall();
        List<String> list = new ArrayList<>();
        list.add("red");
        list.add("green");
        list.add("blue");

        List<String> copy = List.copyOf(list);
        System.out.println(copy.size());
        copy.forEach(System.out::println);

        try {
            copy.add("yellow");
        } catch (UnsupportedOperationException e) {
            System.out.println("expected: " + e);
        }

        // dito für Set und Map
    }


    @Test
    void listCopyOfImmutableListSameInstance() {
        var originalList = List.of(1);
        var copiedList = List.copyOf(originalList);
        System.out.println("originalList == copiedList? " + (originalList == copiedList));
    }


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
            System.out.println("expected: " + e);
        }
        list2.forEach(System.out::println);

        // dito: toUnmodifiableSet, toUnmodifiableMap
    }

}
