package bg.tu_varna.sit.a1.f23621651;

import bg.tu_varna.sit.a1.f23621651.Handlers.CommandHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;

public class Application
{
    public static void main(String[] args)
    {
        FileHandler fileHandler = new FileHandler();
        CommandHandler handler = new CommandHandler(fileHandler);
        while (true) {
            handler.executeCommand();
        }
    }
}
