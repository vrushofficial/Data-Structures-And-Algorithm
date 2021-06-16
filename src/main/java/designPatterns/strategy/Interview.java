package designPatterns.strategy;

public class Interview {
  private InterviewStrategy interviewStrategy;

  public static void main(String[] args) {
    Interview interview = new Interview();
    String interviewThrough = "skype";
    String result = null;
    if (interviewThrough.equalsIgnoreCase("skype"))
      interview.setInterviewStrategy(new SkypeInterviewStrategy());
    if (interviewThrough.equalsIgnoreCase("teams"))
      interview.setInterviewStrategy(new TeamsInterviewStrategy());
    if (interviewThrough.equalsIgnoreCase("zoom"))
      interview.setInterviewStrategy(new ZoomInterviewStrategy());
    result = interview.getInterviewStrategy().interviewCall();
    System.out.println(result + " Thanks.");
  }

  public InterviewStrategy getInterviewStrategy() {
    return interviewStrategy;
  }

  public void setInterviewStrategy(InterviewStrategy interviewStrategy) {
    this.interviewStrategy = interviewStrategy;
  }
}
