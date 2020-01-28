class Duck {
  int size;
  public Duck() {
    size = 27;
    System.out.println("Quack!");
    System.out.println("Size is " + size);
  }
  public Duck(int duckSize) {
    size = duckSize;
    System.out.println("Quack!");
    System.out.println("Size is " + size);
  }
}

public class UseDuck {
  public static void main(String[] args) {
    Duck d1 = new Duck(42);
    Duck d2 = new Duck();
  }
}