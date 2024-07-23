package misc;

/**
 * You can run this on the command line using:
 * java c60_misc/src/main/java/misc/StandaloneApp.java
 */
public class StandaloneApp {
    public static void main(String[] args) {
        new Greeter().run();
    }
}


class Greeter implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
