class XCopy {
  int go(int arg) {
    return 2 * arg;
  }

  public static void main(String[] args) {
    int orig = 42;
    XCopy x = new XCopy();
    int y = x.go(orig);
    System.out.println(orig + " " + y);
  }
}