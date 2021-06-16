package designPatterns.strategy;

public class ZoomInterviewStrategy implements InterviewStrategy {
    @Override
    public String interviewCall() {
        return "Interview held through Zoom and you  are passed!!";
    }
}
