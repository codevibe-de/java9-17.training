package jj.util.etc;

public class Watch {
    public final String name;
    public final long start;

    public Watch(String name) {
        this.name = name;
        this.start = System.nanoTime();
    }

    public String toString() {
        long n = (System.nanoTime() - this.start) / 1_000_000;
        return this.name + " : " + n;
    }
}
