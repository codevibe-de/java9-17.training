package h_type_inference;

import java.lang.constant.ClassDesc;
import java.util.List;
import java.util.function.Function;

import static utils.MethodLogger.logMethodCall;

public class Application {

    public static void main(String[] args) {
        demoVar();
        demoVarAndFinal();
        demoListsAndLoops();
        demoImmediateAssign();
        demoLambdas();
        demoAnonymousClass();
        demoAnonymousClassMethods();
        demoAttribute();
    }

    static void demoVar() {
        logMethodCall();

        var i = 42;
        i = 77;
        // i = 42L;		// illegal, different type

        var var = 77;
        System.out.println(var);

        class Var {}    // okay
//        class var {}    // illegal: 'var' is a restricted identifier and cannot be used for type declarations

// 		var j; // illegal, no type info
    }

    static void demoVarAndFinal() {
        logMethodCall();
        final var i = 42;
        // i = 77;		// illegal
    }

    static void demoListsAndLoops() {
        logMethodCall();
        var list = List.of(10, 20, 30);
        List<Integer> l = list;
        for (var value : list) {
            Integer v = value;
            System.out.println(v);
        }
        for (var i = 0; i < list.size(); i++) {
            Integer v = list.get(i);
            System.out.println(v);
        }
        // List<Double> doubleList = list;  // illegal
    }

    static void demoImmediateAssign() {
        logMethodCall();
        final int foo;
        if ("1".equals("1"))
            foo = 42;
        else
            foo = 77;
//		illegal:
//		final var bar;
//		if ("1".equals("1"))
//			bar = 42;
//		else
//			bar = 77;
    }

    static void demoLambdas() {
        logMethodCall();
        Function<String, Integer> foo = s -> s.length();
        var result = foo.apply("Hello");
        System.out.println(result);
        // var bar = s -> s.length();  // illegal (-> Target Typing)
    }

    static void demoAnonymousClass() {
        logMethodCall();
        var function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
// 		illegal:
//		function = new Function<String, Integer>() {
//			@Override
//			public Integer apply(String s) {
//				return s.length() / 2;
//			}
//		};
    }

    static void demoAnonymousClassMethods() {
        logMethodCall();
        var foo = new Object() {
            public void alpha() {
                System.out.println("alpha");
            }

            public void beta() {
                System.out.println("beta");
            }

            public int bar = 77;
        };
        foo.alpha();
        foo.beta();
        System.out.println(foo.bar);
    }

    static void demoAttribute() {
        logMethodCall();
        ClassDesc d;
        class Foo {
            // var i = 42;  // not allowed
        }
    }
}
