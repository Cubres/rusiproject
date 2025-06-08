package waypoint;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;

public class ButtonWaypoint extends JButton {

    private Color pinColor;
    private String label;

    public ButtonWaypoint(Color pinColor, String label) {
        this.pinColor = pinColor;
        this.label = label;
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(40, 40));
        setMaximumSize(new Dimension(40, 40));
        setMinimumSize(new Dimension(40, 40));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, width, height);
        int padding = 4;
        g.setColor(pinColor);
        g.fillOval(padding, padding, width - 2 * padding, height - 2 * padding);
        g.setColor(Color.WHITE); 
        g.setFont(new Font("Arial", Font.BOLD, 18));
        int stringWidth = g.getFontMetrics().stringWidth(label);
        int stringHeight = g.getFontMetrics().getAscent();
        int x = (width - stringWidth) / 2;
        int y = (height + stringHeight) / 2 - 2;
        g.drawString(label, x, y);
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, width - 1, height - 1);
    }
    public void setPinColor(Color color) {
        this.pinColor = color;
        repaint();
    }
    public void setLabel(String label) {
        this.label = label;
        repaint();
    }
    @Override
       public String getLabel() {
        return label; 
    }
}
