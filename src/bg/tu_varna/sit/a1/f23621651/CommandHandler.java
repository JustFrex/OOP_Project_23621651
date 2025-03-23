package bg.tu_varna.sit.a1.f23621651;

import bg.tu_varna.sit.a1.f23621651.Commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler
{
    private Map<String, Command> commandMap;

    public CommandHandler(Map<String, Command> commandMap)
    {
        this.commandMap = new HashMap<>();
        commandMap.put("open", new OpenFile());
        commandMap.put("close", new CloseFile());
        commandMap.put("save", new SaveFile());
        commandMap.put("saveas", new SaveAsFile());
        commandMap.put("edit", new EditCell());
        commandMap.put("print", new PrintSpreadsheet());
        commandMap.put("help", new Help());
        commandMap.put("exit", new Exit());
    }
}
