class ScaryException extends Exception {

}


public class TestExceptions {
  static void doRisky(String test) throws ScaryException {
    System.out.println("start risky");
    if ("yes".equals(test)) {
      throw new ScaryException();
    }
    System.out.println("end risky");
  }
  public static void main(String[] args) {
    String test = "yes";
    try {
      System.out.println("start test");
      TestExceptions.doRisky(test);
      System.out.println("end test");
    }
    catch (ScaryException ex) {
      System.out.println("scary exception");
    }
    finally {
      System.out.println("finally");
    }
    System.out.println("end of main");
  }
}