package a_default_methods;

import org.junit.jupiter.api.Test;

public class DefaultMethodsApp {

    @Test
    void demoInterfaceCall() {
        var greeter = new GreeterImpl();
        System.out.println(greeter.isEmpty());
        System.out.println(greeter.isNotEmpty());
    }

}
