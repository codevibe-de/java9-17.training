package h_type_inference;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static utils.MethodLogger.logMethodCall;

@SuppressWarnings({"UnnecessaryLocalVariable", "ForLoopReplaceableByForEach"})
public class TypeInferenceApp {

    @Test
    void demoVar() {
        logMethodCall();

        var i = 42;
        i = 77;
        // i = 42L;		// illegal, different type

        var var = 77;
        System.out.println(var);

        class Var {
        }    // okay
//        class var {}    // illegal: 'var' is a restricted identifier and cannot be used for type declarations

// 		var j; // illegal, no type info
    }


    @Test
    void lessCodeForComplexTypes() {
        // classic style (pre Java 9)
        Map<String, ? extends Number> map = createMap();
        LocalDate now = LocalDate.now();

        // short and sweet :)
        var strToNumberMap = createMap();
        var todaysDate = LocalDate.now();
    }

    private Map<String, ? extends Number> createMap() {
        return new HashMap<>();
    }


    @Test
    void demoVarAndFinal() {
        logMethodCall();
        final var i = 42;
        // i = 77;		// illegal
    }


    @Test
    void demoListsAndLoops() {
        logMethodCall();
        var list = List.of(10, 20, 30);
        for (var value : list) {
            Integer v = value;
            System.out.println(v);
        }
        for (var i = 0; i < list.size(); i++) {
            Integer v = list.get(i);
            System.out.println(v);
        }
    }


    /**
     * Demonstrates that "var" assignments are not as flexible when using "final".
     */
    @Test
    void illegalImmediateAssignmentToVar() {
        logMethodCall();
        final int foo;
        if ("1".equals("1")) {
            foo = 42;
        } else {
            foo = 77;
        }
//		illegal:
//		final var bar;
//		if ("1".equals("1"))
//			bar = 42;
//		else
//			bar = 77;
    }


    @SuppressWarnings("Convert2MethodRef")
    @Test
    void illegalLambdaAssignmentToVar() {
        logMethodCall();
        Function<String, Integer> foo = s -> s.length();
        Function<String, Integer> foo2 = String::length;
//        var bar = s -> s.length();  // illegal (Cannot infer type...)
//        var bar2 = String::length;  // illegal (Cannot infer type...)
    }


    /**
     * Demonstrates that we cannot reassign an anonymous instance to a var, since the type of the
     * var-type is *exactly* typed to the anonymous class (TypeInferenceApp$0.class)
     */
    @Test
    void anonymousClassAssignment() {
        logMethodCall();
        var function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
// 		illegal (since var is bound to actual anonymous class-name (xyz$0):
//		function = new Function<String, Integer>() {
//			@Override
//			public Integer apply(String s) {
//				return s.length() / 2;
//			}
//		};
    }


    @Test
    void instantiateAndUseObjectSubclass() {
        logMethodCall();
        var foo = new Object() {
            public int bar = 77;
            public void alpha() {
                System.out.println("alpha");
            }
        };
        foo.alpha();
        System.out.println(foo.bar);
    }


    @Test
    void illegalClassFieldUsingVar() {
        logMethodCall();
        class Foo {
            // var i = 42;  // not allowed
        }
    }
}
