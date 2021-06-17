package designPatterns.factory;

public class MacCommand implements Command {

  @Override
  public void respectiveCommand() {
    System.out.println("Mac command executing..");
  }
}
