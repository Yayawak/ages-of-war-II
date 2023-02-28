package srcs.Interfaces;

import java.awt.Component;

public interface ComponentSizeItf {
    // public default void showComponentSize(String className, JPanel panel) {
    public default void showComponentSize(String className, Component panel) {
        // System.out.println(panel.toString());
        // System.out.format("%s Size : W = %d, H = %d\n",
        System.out.format("%s Size : W = %.0f, H = %.0f\n",
        // System.out.format("%s Size : W = %f, H = %f\n",
            className,
            panel.getSize().getWidth(),
            panel.getSize().getHeight()
            // panel.getWidth(),
            // panel.getHeight()
        );
    }
}
