package de.serviceloader;

public class SecondRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Second!");
    }
}
