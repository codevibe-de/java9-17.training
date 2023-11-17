package zz_slides;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Taskbar.Feature;
import java.io.File;
import java.io.IOException;

public class TaskbarSlides {

    public static void main(String[] args) throws IOException {
        Window w = new JFrame();

        if (Taskbar.isTaskbarSupported()) {
            Taskbar taskbar = Taskbar.getTaskbar();

            if (taskbar.isSupported(Feature.ICON_BADGE_NUMBER)) {
                taskbar.setIconBadge("12");
            }
            if (taskbar.isSupported(Feature.ICON_BADGE_IMAGE_WINDOW)) {
                taskbar.setWindowIconBadge(
                        w,
                        ImageIO.read(new File("some.png"))
                );
            }
        }
    }
}
