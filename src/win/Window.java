package win;


import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Window {
    private JLabel killtext;
    private JPanel MainPanel;
    private JPanel Text;
    private JPanel Choose;
    private JLabel godText;
    private JCheckBox killCheckBox;
    private JCheckBox godCheckBox;

    public Window() {
        JFrame frame = new JFrame("Window");
        frame.setContentPane(MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void setKillCheckBox(boolean flag){
        killCheckBox.setSelected(flag);
    }

    public void setGodCheckBox(boolean flag){
        godCheckBox.setSelected(flag);
    }
}
