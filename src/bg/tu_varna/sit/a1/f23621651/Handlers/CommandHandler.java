package bg.tu_varna.sit.a1.f23621651.Handlers;

import bg.tu_varna.sit.a1.f23621651.Commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandHandler
{
    private static final Map<String, Command> commandMap = new HashMap<>();;

    public CommandHandler()
    {
        commandMap.put("open", new OpenFile());
        commandMap.put("close", new CloseFile());
        commandMap.put("save", new SaveFile());
        commandMap.put("saveas", new SaveAsFile());
        commandMap.put("edit", new EditCell());
        commandMap.put("print", new PrintSpreadsheet());
        commandMap.put("help", new Help());
        commandMap.put("exit", new Exit());
    }

    public void executeCommand()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String input = scanner.nextLine().trim();
        String[] command = input.split(" ");
        Command cmd = commandMap.get(command[0].toLowerCase());
        if(cmd != null)
        {
            cmd.executeCommand();
        }
        else
        {
            System.out.println("Command not found");
        }
    }
}
