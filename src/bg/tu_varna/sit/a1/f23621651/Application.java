package bg.tu_varna.sit.a1.f23621651;

import bg.tu_varna.sit.a1.f23621651.Handlers.CommandHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.SpreadsheetHandler;

public class Application {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        SpreadsheetHandler spreadsheetHandler = new SpreadsheetHandler();
        CommandHandler commandHandler = new CommandHandler(fileHandler, spreadsheetHandler);
        while (true) {
            commandHandler.executeCommand();
        }
    }
}
