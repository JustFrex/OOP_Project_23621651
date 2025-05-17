package bg.tu_varna.sit.a1.f23621651.Handlers;

import bg.tu_varna.sit.a1.f23621651.Commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandHandler {
    private static final Map<CommandType, Command> commandMap = new HashMap<>();
    private FileHandler fileHandler;
    private SpreadsheetHandler spreadsheetHandler;

    public CommandHandler(FileHandler fileHandler, SpreadsheetHandler spreadsheetHandler) {
        commandMap.put(CommandType.OPEN, new OpenFile(fileHandler, spreadsheetHandler));
        commandMap.put(CommandType.CLOSE, new CloseFile(fileHandler));
        commandMap.put(CommandType.SAVE, new SaveFile(fileHandler, spreadsheetHandler));
        commandMap.put(CommandType.SAVEAS, new SaveAsFile(fileHandler, spreadsheetHandler));
        commandMap.put(CommandType.EDIT, new EditCell(fileHandler, spreadsheetHandler));
        commandMap.put(CommandType.PRINT, new PrintSpreadsheet(spreadsheetHandler, fileHandler));
        commandMap.put(CommandType.HELP, new Help());
        commandMap.put(CommandType.EXIT, new Exit());
    }

    public void executeCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String input = scanner.nextLine().trim();
        String[] command = input.split("[\\s]+");
        try {
            CommandType commandType = CommandType.valueOf(command[0].toUpperCase());
            Command cmd = commandMap.get(commandType);
            cmd.executeCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println("Command not found");
        }

    }
}
