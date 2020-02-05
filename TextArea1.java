import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea1 implements ActionListener {
  JTextArea textArea;
  public static void main(String[] args) {
    TextArea1 gui = new TextArea1();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button = new JButton("Click me!");
    button.addActionListener(this);
    textArea = new JTextArea(10, 20);

    JScrollPane scroller = new JScrollPane(textArea);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    panel.add(scroller);

    frame.getContentPane().add(BorderLayout.CENTER, panel);
    frame.getContentPane().add(BorderLayout.SOUTH, button);

    frame.setSize(350, 500);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    textArea.append("button clicked\n");
  }
}