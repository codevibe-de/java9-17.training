package t_taskbar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Taskbar.Feature;
import java.io.IOException;
import java.util.Arrays;

public class TaskbarApp {

    public static void main(String[] args) throws InterruptedException, IOException {
        if (Taskbar.isTaskbarSupported()) {
            var taskbar = Taskbar.getTaskbar();

            listSupportedFeatures(taskbar);

            Frame frame = new JFrame("Toolbar API Demo");
            frame.setVisible(true);


            if (taskbar.isSupported(Feature.PROGRESS_VALUE_WINDOW)) {
                setWindowProgressValue(taskbar, frame);
            }
            if (taskbar.isSupported(Feature.ICON_BADGE_IMAGE_WINDOW)) {
                // Badge Icon by https://www.flaticon.com/authors/sbts2018
                Image badge = ImageIO.read(TaskbarApp.class.getResourceAsStream("/tick-mark.png"));
                setWindowIconBadge(taskbar, frame, badge);
            }

            Thread.sleep(500);

            frame.setVisible(false);
            System.exit(0);
        } else {
            System.out.println("Taskbar not supported");
        }
    }


    private static void listSupportedFeatures(Taskbar taskbar) {
        // https://stackoverflow.com/questions/31909107/javas-os-name-for-windows-10
        System.out.println("You are running " + System.getProperty("os.name") + ", which supports:");
        Arrays.stream(Feature.values())
                .filter(taskbar::isSupported)
                .forEach(System.out::println);
    }


    private static void setWindowProgressValue(Taskbar taskbar, Window window) throws InterruptedException {
        for (int progress = 0; progress < 100; progress += 10) {
            taskbar.setWindowProgressValue(window, progress);
            Thread.sleep(500);
        }
    }

    private static void setWindowIconBadge(Taskbar taskbar, Window window, Image badge) throws InterruptedException {
        taskbar.setWindowIconBadge(window, badge);
        Thread.sleep(500);
    }


}
