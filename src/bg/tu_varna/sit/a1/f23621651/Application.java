package bg.tu_varna.sit.a1.f23621651;

import bg.tu_varna.sit.a1.f23621651.Handlers.CommandHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.SpreadsheetHandler;

/**
 * The main class that runs the spreadsheet application.
 * Initializes handlers and enters a command execution loop.
 */
public class Application {
    /**
     * The main entry point for the application.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        SpreadsheetHandler spreadsheetHandler = new SpreadsheetHandler();
        CommandHandler commandHandler = new CommandHandler(fileHandler, spreadsheetHandler);
        while (true) {
            commandHandler.executeCommand();
        }
    }
}
