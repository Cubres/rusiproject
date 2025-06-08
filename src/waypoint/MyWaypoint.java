package waypoint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import java.awt.Dimension;

public class MyWaypoint extends DefaultWaypoint {

    private String name;
    private JButton button; 
    private String note;

    public MyWaypoint(String name, EventWaypoint event, GeoPosition coord, Color pinColor, String label) {
        super(coord);
        this.name = name;
        this.note = "";    
        initButton(event, pinColor, label);
    }

    public MyWaypoint() {
        this.note = "";
    }

    public String getName() {
        return name;
    }
    public GeoPosition getGeoPosition() {
    return super.getPosition();
}
    public void setName(String name) {
        this.name = name;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public String getNote() {
        return note;
    }


    public void setNote(String note) {
        this.note = note;
    }

    private void initButton(EventWaypoint event, Color pinColor, String label) {
        button = new ButtonWaypoint(pinColor, label);
            button.setPreferredSize(new java.awt.Dimension(40, 40)); 
    button.setMinimumSize(new java.awt.Dimension(40, 40));
    button.setMaximumSize(new java.awt.Dimension(40, 40));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            {        
            ImageIcon customIcon = new ImageIcon(getClass().getResource("/icon/image.png"));
            JTextArea textArea = new JTextArea(5, 30);
            textArea.setText(note);
            textArea.setLineWrap(true); 
            textArea.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            UIManager.put("OptionPane.okButtonText", "Потвърди");
            UIManager.put("OptionPane.cancelButtonText", "Отказ");
            int result = JOptionPane.showConfirmDialog(
                button,
                scrollPane, 
                "Добави бележка към дестинация: ",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                customIcon 
            );
            if (result == JOptionPane.OK_OPTION) {
                note = textArea.getText(); 
            }
            event.selected(MyWaypoint.this);
            }
            }
        });
        button.addComponentListener(new java.awt.event.ComponentAdapter() {
    @Override
    public void componentResized(java.awt.event.ComponentEvent e) {
        button.setSize(40, 40); // Very much needed bug fix, yes
    }
});
    }

}
