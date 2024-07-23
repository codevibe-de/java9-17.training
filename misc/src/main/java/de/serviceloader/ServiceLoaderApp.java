package de.serviceloader;

import java.util.ServiceLoader;

@SuppressWarnings("Convert2MethodRef")
public class ServiceLoaderApp {

    public static void main(String[] args) {
        System.out.println("Runnable:");
        ServiceLoader<Runnable> loader = ServiceLoader.load(Runnable.class);
        loader.forEach(runnable -> runnable.run());

        System.out.println("\nLoggerFinder:");
        ServiceLoader<System.LoggerFinder> loader2 = ServiceLoader.load(System.LoggerFinder.class);
        loader2.forEach(service -> System.out.println("Loaded service: " + service.getClass().getName()));

        System.out.println("\nLog Output:");
        System.getLogger("test").log(System.Logger.Level.ERROR, "uh oh");
    }
}
