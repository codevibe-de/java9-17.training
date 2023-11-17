package a_collection_factory_methods;

import jj.util.log.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionCopyOfApp {

    public static void main(String[] args) {
        demoCopyOf();
        demoCollectorsToUnmodifiableList();
        demoCollectorsToUnmodifiableMap();
    }

    static void demoCopyOf() {
        Log.logMethodCall();
        List<String> list = new ArrayList<>();
        list.add("red");
        list.add("green");
        list.add("blue");

        List<String> copy = List.copyOf(list);
        System.out.println(copy.size());
        for (String s : copy)
            System.out.println(s);
        try {
            copy.add("yellow");
        } catch (UnsupportedOperationException e) {
            System.out.println("expected: " + e);
        }

        // dito f�r Set und Map
    }

    static void demoCollectorsToUnmodifiableList() {
        Log.logMethodCall();

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

    static void demoCollectorsToUnmodifiableMap() {
        Log.logMethodCall();

        Map<String, Integer> map1 = Stream.of("red", "green", "blue")
                .collect(Collectors.toMap(s -> s, s -> s.length()));
        map1.put("yellow", 5);
        System.out.println(map1);

        Map<String, Integer> map2 = Stream.of("red", "green", "blue")
                .collect(Collectors.toUnmodifiableMap(s -> s, s -> s.length()));
        try {
            map2.put("yellow", 5);
        } catch (UnsupportedOperationException e) {
            System.out.println("expected: " + e);
        }

        System.out.println(map2);
    }
}
