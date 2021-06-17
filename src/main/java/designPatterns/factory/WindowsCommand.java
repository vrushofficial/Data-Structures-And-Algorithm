package designPatterns.factory;

public class WindowsCommand implements Command {

    @Override
    public void respectiveCommand() {
        System.out.println("Windows command executing..");
    }
}
