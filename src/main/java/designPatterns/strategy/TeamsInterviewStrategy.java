package designPatterns.strategy;

public class TeamsInterviewStrategy implements InterviewStrategy {
  @Override
  public String interviewCall() {
    return "Interview held through Teams and you  are passed!!";
  }
}
