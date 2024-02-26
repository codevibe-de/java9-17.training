package c_diamond_op;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Function;

import static utils.MethodLogger.logMethodCall;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DiamondOperatorApp {

    /**
     * Shows how we previously had to provide generic types in the constructor call
     */
    @SuppressWarnings("Convert2Diamond")
    @Test
    @Order(0)
    void demoFunctionOld() {
        logMethodCall();
        final Function<String, Integer> func = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                printGenericType(this);
                return s.length();
            }
        };
        func.apply("Hello");
    }

    /**
     * Same as above but now without generic types in the constructor call
     */
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
        func.apply("Hello");
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
