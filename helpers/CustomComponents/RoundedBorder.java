package helpers.CustomComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {
    private final Color color;
    private final int radius;
    private final int thickness;
    private final Insets insets;

    public RoundedBorder(Color color, int radius, int thickness, int innerMargin) {
        this.color = color;
        this.radius = radius;
        this.thickness = thickness;
        this.insets = new Insets(thickness + innerMargin, thickness + innerMargin, thickness + innerMargin, thickness + innerMargin);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillRoundRect(x, y, width-1, height-1, radius, radius);
        g.setColor(c.getBackground());
        g.fillRoundRect(x+thickness, y+thickness, width-1-(thickness*2), height-1-(thickness*2), radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }
}
