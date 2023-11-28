package reflection;

import alpha.Alpha;
import beta.Beta;
import utils.TryCatch;

import java.lang.reflect.Method;

import static utils.MethodLogger.logMethodCall;

public class ReflectionApp {

    public static void main(String[] args) {
        demoAlpha();
        demoBeta();
        demoGamma();
        demoDelta();
    }


    static void demoAlpha() {
        logMethodCall();
        Alpha.pub();
        // Alpha.pri(); // illegal
        TryCatch.run(() -> {
            final Method m = Alpha.class.getDeclaredMethod("pub");
            m.invoke(null);
        });
        TryCatch.run(() -> {
            final Method m = Alpha.class.getDeclaredMethod("pri");
            m.setAccessible(true);
            m.invoke(null);
        });
    }


    static void demoBeta() {
        logMethodCall();
        Beta.pub();
        // Beta.pri(); // illegal
        TryCatch.run(() -> {
            final Method m = Beta.class.getDeclaredMethod("pub");
            m.invoke(null);
        });
        TryCatch.run(() -> {
            final Method m = Beta.class.getDeclaredMethod("pri");
            m.setAccessible(true); // throw an InaccessibleObjectException
            m.invoke(null);
        });
    }

    static void demoGamma() {
        logMethodCall();
        // Gamma.pub(); // illegal
        TryCatch.run(() -> {
            final Class<?> cls = Class.forName("jj.mod.gamma.Gamma");
            TryCatch.run(() -> {
                final Method m = cls.getDeclaredMethod("pub");
                m.invoke(null);
            });
            TryCatch.run(() -> {
                final Method m = cls.getDeclaredMethod("pri");
                m.setAccessible(true);
                m.invoke(null);
            });
        });
    }


    static void demoDelta() {
        logMethodCall();
        // Delta.pub(); // illegal
        TryCatch.run(() -> {
            final Class<?> cls = Class.forName("jj.mod.delta.Delta");
            final Object obj = cls.getDeclaredMethod("pub").invoke(null); // IllegalAccessException
        });
    }

}
