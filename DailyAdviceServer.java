import java.io.*;
import java.net.*;

public class DailyAdviceServer {
  String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they don not make you look fat", 
                        "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think", 
                        "You might want to rethik that haircut"};
  public void go() {
    try {
      ServerSocket serverSocket = new ServerSocket(4242);

      while (true) {
        Socket s = serverSocket.accept();
        PrintWriter writer = new PrintWriter(s.getOutputStream());
        String advice = getAdvice();
        writer.println(advice);
        writer.close();
        System.out.println(advice);
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public String getAdvice() {
    int random = (int) (Math.random() * adviceList.length);
    return adviceList[random];
  }

  public static void main(String[] args) {
    DailyAdviceServer server = new DailyAdviceServer();
    server.go();
  }
}