package a_collection_factory_methods;

import org.junit.jupiter.api.Test;
import utils.MethodLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

@SuppressWarnings({"ThrowablePrintedToSystemOut", "DataFlowIssue"})
public class CollectionFactoryMethodsApp {

    @Test
    void demoListOf() {
        MethodLogger.logMethodCall();

        List<Integer> list = List.of(1, 2, 3);
        list.forEach(System.out::println);
        System.out.println(list.getClass());

        list = new ArrayList<>(list);
        try {
            list.add(4);
        } catch (final Exception e) {
            System.out.println(e);
        }

        final List<Integer> list2 = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);  // E e1, E e2, ... E e10
        final List<Integer> list3 = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);  // E... elements
        System.out.println(list2);
        System.out.println(list3);
    }


    @Test
    void demoSetOf() {
        MethodLogger.logMethodCall();

        final Set<String> set = Set.of("red", "green", "blue");
        set.forEach(System.out::println);
        System.out.println(set.getClass());

        try {
            set.remove("red");
        } catch (final Exception e) {
            System.out.println(e);
        }
    }


    @Test
    void demoMapOf() {
        MethodLogger.logMethodCall();

        final Map<Integer, String> map = Map.of(42, "red", 43, "green", 44, "blue");
        map.forEach((k, v) -> System.out.println(k + " => " + v));
        System.out.println(map.getClass());

        try {
            map.put(45, "yellow");
        } catch (final Exception e) {
            System.out.println(e);
        }
    }


    @Test
    void demoMapOfEntries() {
        MethodLogger.logMethodCall();

        final Map<Integer, String> map = Map.ofEntries(
                entry(77, "RED"),
                entry(78, "GREEN"),
                entry(79, "BLUE")
        );
        map.forEach((k, v) -> System.out.println(k + " => " + v));
        System.out.println(map.getClass());

        try {
            map.put(45, "yellow");
        } catch (final Exception e) {
            System.out.println(e);
        }
    }
}
