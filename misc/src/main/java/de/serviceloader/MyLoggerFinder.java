package de.serviceloader;

import java.util.ResourceBundle;

public class MyLoggerFinder extends System.LoggerFinder {

    @Override
    public System.Logger getLogger(String name, Module module) {
        return new System.Logger() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public boolean isLoggable(Level level) {
                return true;
            }

            @Override
            public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
                System.out.println("###" + msg);
            }

            @Override
            public void log(Level level, ResourceBundle bundle, String format, Object... params) {
                System.out.println("###" + format.formatted(params));
            }
        };
    }

}
