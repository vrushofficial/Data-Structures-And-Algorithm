package designPatterns.factory;

public class CommandLineExecutor {

    public static void main(String[] args) {
    CommandFactory commandFactory = new CommandFactory();
    Command command= commandFactory.getCommand("mac");
    command.respectiveCommand();
  }
}
