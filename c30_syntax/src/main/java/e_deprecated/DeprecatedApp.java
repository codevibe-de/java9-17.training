package e_deprecated;

public class DeprecatedApp {

    public static void main(String[] args) {
        var service = new DeprecatedService();
        service.foo(); // compiles with warning
        service.bar();
    }
}
