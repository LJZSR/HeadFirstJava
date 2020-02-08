import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer {

  private JTextArea display;
  private ArrayList<QuizCard> cardList;
  private QuizCard currentCard;
  private int currentCardIndex;
  private JFrame frame;
  private JButton nextButton;
  private boolean isShowAnswer;

  public void go() {
    
    frame = new JFrame("Quiz Card Player");
    JPanel mainPanel = new JPanel();
    Font bigFont = new Font("sanserif", Font.BOLD, 24);

    display = new JTextArea(10, 20);
    display.setFont(bigFont);

    display.setLineWrap(true);
    display.setWrapStyleWord(true);
    display.setEditable(false);

    JScrollPane qScroller = new JScrollPane(display);
    qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    nextButton = new JButton("Please Load File");
    nextButton.addActionListener(new NextCardListener());
    nextButton.setEnabled(false);

    mainPanel.add(qScroller);
    mainPanel.add(nextButton);

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem loadMenuItem = new JMenuItem("Load Card Set");
    loadMenuItem.addActionListener(new OpenMenuListener());
    fileMenu.add(loadMenuItem);
    menuBar.add(fileMenu);

    frame.setJMenuBar(menuBar);
    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(500, 400);
    frame.setVisible(true);
  }

  private void showNextCard() {
    currentCard = cardList.get(currentCardIndex);
    currentCardIndex++;
    display.setText(currentCard.getQusetion());
    nextButton.setText("Show Answer");
    isShowAnswer = true;
  }

  private void loadFile(File file) {
    cardList = new ArrayList<QuizCard>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      while ((line = reader.readLine()) != null) {
        makeCard(line);
      }
      reader.close();
    }
    catch (Exception e) {
      System.out.println("Couldn't write the cardList out!");
      e.printStackTrace();
    }
  }

  private void makeCard(String line) {
    String[] result = line.split("/");
    QuizCard card = new QuizCard(result[0], result[1]);
    cardList.add(card);
    System.out.println("Made a card");
    nextButton.setEnabled(true);
    nextButton.setText("Show Question");
  }

  public class NextCardListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (isShowAnswer) {
        display.setText(currentCard.getAnswer());
        nextButton.setText("Next Card");
        isShowAnswer = false;
      }
      else {
        if (currentCardIndex < cardList.size()) {
          showNextCard();
        }
        else {
          display.setText("That was last card");
          nextButton.setEnabled(false);
        }
      }
    }
  }
  public class OpenMenuListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser fileOpen = new JFileChooser();
      fileOpen.showOpenDialog(frame);
      loadFile(fileOpen.getSelectedFile());
    }
  }

  public static void main(String[] args) {
    QuizCardPlayer reader = new QuizCardPlayer();
    reader.go();
  }
}