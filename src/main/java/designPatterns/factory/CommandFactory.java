package designPatterns.factory;

public class CommandFactory {

    Command getCommand(String operatingSystem)
    {
        switch( operatingSystem ) {
            case "linux"   : return new LinuxCommand();
            case "windows" : return new WindowsCommand();
            case "mac"     : return new MacCommand();
            default: return null;
        }
    }
}
