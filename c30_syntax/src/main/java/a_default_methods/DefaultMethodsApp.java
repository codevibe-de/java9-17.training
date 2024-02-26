package a_default_methods;

import org.junit.jupiter.api.Test;

public class DefaultMethodsApp {

    @Test
    void demoInterfaceCall() {
        var g = new GreetingProviderImpl();
        System.out.println(g.isEmpty());
        System.out.println(g.isNotEmpty());
    }

}
