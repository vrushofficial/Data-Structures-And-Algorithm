package designPatterns.strategy;

public class SkypeInterviewStrategy implements InterviewStrategy {
  @Override
  public String interviewCall() {
    return "Interview held through Skype and you  are passed!!";
  }
}
