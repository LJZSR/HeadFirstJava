class Player {
  static int playerCounter = 0;
  private String name;
  public Player(String n) {
    name = n;
    playerCounter++;
  }
}

public class PlayerTestDrive {
  public static void main(String[] args) {
    System.out.println(Player.playerCounter);
    Player one = new Player("Tiger Woods");
    System.out.println(Player.playerCounter);
  }
}