package designPatterns.factory;

public class LinuxCommand implements Command {

  @Override
  public void respectiveCommand() {
    System.out.println("Linux command executing..");
  }
}
