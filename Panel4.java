import javax.swing.*;
import java.awt.*;

public class Panel4 {
  public static void main(String[] args) {
    Panel4 gui = new Panel4();
    gui.go();
  }
  public void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    panel.setBackground(Color.darkGray);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JButton button1 = new JButton("Click me!");
    JButton button2 = new JButton("Bliss");

    panel.add(button1);
    panel.add(button2);

    frame.getContentPane().add(BorderLayout.EAST, panel);
    frame.setSize(250, 200);
    frame.setVisible(true);
  }
}