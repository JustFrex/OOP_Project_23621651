package bg.tu_varna.sit.a1.f23621651;

import bg.tu_varna.sit.a1.f23621651.Handlers.CommandHandler;

public class Application
{
    public static void main(String[] args)
    {
        CommandHandler handler = new CommandHandler();
        while(true)
        {
            handler.executeCommand();
        }
    }
}
