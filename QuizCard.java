public class QuizCard{
  private String question;
  private String answer;

  public QuizCard(String q, String a) {
    question = q;
    answer = a;
  }

  public String getQusetion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }
}