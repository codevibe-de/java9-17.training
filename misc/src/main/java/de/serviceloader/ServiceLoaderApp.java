package de.serviceloader;

import java.util.ServiceLoader;

@SuppressWarnings("Convert2MethodRef")
public class ServiceLoaderApp {

    public static void main(String[] args) {
        ServiceLoader<Runnable> loader = ServiceLoader.load(Runnable.class);
        loader.forEach(runnable -> runnable.run());

        ServiceLoader.load(System.LoggerFinder.class)
                        .forEach(System.out::println);

        System.getLogger("test").log(System.Logger.Level.ERROR, "uh oh");
    }
}
