package a_default_methods;

public interface Foo {

    void hello();

    // --- additional methods ---

    default void f() {
        this.g();
        g(this);
    }

    private void g() {
        this.hello();
    }

    private static void g(Foo foo) {
        foo.hello();
    }

}
