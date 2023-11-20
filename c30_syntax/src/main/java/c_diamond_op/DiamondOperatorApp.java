// http://javasampleapproach.com/java-9-tutorial

package c_diamond_op;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static utils.MethodLogger.logMethodCall;

class Drink {
}

class Wine extends Drink {
}

class RedWine extends Wine {
}

class Range implements Iterable<Integer> {
    public final int first;
    public final int last;

    public Range(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int current = first;

            @Override
            public boolean hasNext() {
                return current <= last;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return current++;
            }
        };
    }

}

@SuppressWarnings("Convert2Lambda")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DiamondOperatorApp {

    @SuppressWarnings("Convert2Diamond")
    @Test
    @Order(0)
    void demoFunctionOld() {
        logMethodCall();
        List<String> list = new ArrayList<>();
        final Function<String, Integer> func = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                printGenericType(this);
                return s.length();
            }
        };
        System.out.println(func.apply("Hello"));
    }

    @Test
    @Order(100)
    void demoFunctionNew() {
        logMethodCall();
        final Function<String, Integer> func = new Function<>() {
            @Override
            public Integer apply(String s) {
                printGenericType(this);
                return s.length();
            }
        };
        System.out.println(func.apply("Hello"));
    }

    @Test
    @Order(200)
    void demoConsumer1() {
        logMethodCall();
        Consumer<Wine> c = new Consumer<>() {
            @Override
            public void accept(Wine w) {
                printGenericType(this);
                System.out.println(w);
            }
        };
        c.accept(new RedWine());
    }

    @Test
    @Order(300)
    void demoConsumer2() {
        logMethodCall();
        Consumer<? super Wine> c = new Consumer<Drink>() {
            @Override
            public void accept(Drink w) {
                printGenericType(this);
                System.out.println(w);
            }
        };
        c.accept(new RedWine());
    }

    @Test
    @Order(400)
    void demoConsumer3() {
        logMethodCall();
        Consumer<? super Wine> c = new Consumer<>() {
            @Override
            public void accept(Wine w) {
                printGenericType(this);
                System.out.println(w);
            }
        };
        c.accept(new RedWine());
    }

    @Test
    @Order(500)
    void demoSupplier1() {
        logMethodCall();
        Supplier<Wine> s = new Supplier<>() {
            @Override
            public Wine get() {
                printGenericType(this);
                return new RedWine();
            }
        };
        Wine w = s.get();
        System.out.println(w);
    }

    @Test
    @Order(600)
    void demoSupplier2() {
        logMethodCall();
        Supplier<? extends Wine> s = new Supplier<RedWine>() {
            @Override
            public RedWine get() {
                printGenericType(this);
                return new RedWine();
            }
        };
        Wine w = s.get();
        System.out.println(w);
    }

    @Test
    @Order(700)
    void demoSupplier3() {
        logMethodCall();
        Supplier<? extends Wine> s = new Supplier<>() {
            @Override
            public Wine get() {
                printGenericType(this);
                return new Wine();
            }
        };
        Wine w = s.get();
        System.out.println(w);
    }

    @Test
    @Order(800)
    void demoSupplier4() {
        logMethodCall();
        Supplier<? extends Wine> s = new Supplier<>() {
            @Override
            public RedWine get() {
                printGenericType(this);
                return new RedWine();
            }
        };
        Wine w = s.get();
        System.out.println(w);
    }

    @Test
    @Order(900)
    void demoRange() {
        logMethodCall();
        Range r = new Range(10, 12);
        for (Integer e : r) {
            System.out.println(e);
        }
    }

    private void printGenericType(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.getGenericInterfaces().length > 0) {
                ParameterizedType parameterizedType = (ParameterizedType) cls.getGenericInterfaces()[0];
                Type[] typeArgs = parameterizedType.getActualTypeArguments();
                System.out.print(cls.getInterfaces()[0].getSimpleName() + "<");
                for (int i = 0; i < typeArgs.length; i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(((Class<?>) typeArgs[i]).getSimpleName());
                }
                System.out.println(">");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
