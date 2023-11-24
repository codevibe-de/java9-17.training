package demo;

public class VersionApp {

    public static void main(String[] args) {
        System.out.println(Runtime.version());
        System.out.println(Runtime.version().feature());
        System.out.println(Runtime.version().interim());
        System.out.println(Runtime.version().update());
        System.out.println(Runtime.version().patch());
        System.out.println(Runtime.version().build());
        System.out.println(Runtime.version().pre());
    }
}
