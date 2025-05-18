package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.SpreadsheetHandler;

/**
 * Command implementation for saving the currently open spreadsheet file.
 */
public class SaveFile implements Command {
    private FileHandler fileHandler;
    private SpreadsheetHandler spreadsheetHandler;

    public SaveFile(FileHandler fileHandler, SpreadsheetHandler spreadsheetHandler) {
        this.fileHandler = fileHandler;
        this.spreadsheetHandler = spreadsheetHandler;
    }

    /**
     * Executes the save command.
     *
     * @param arguments the command-line arguments
     */
    @Override
    public void executeCommand(String[] arguments) {
        try {
            if (arguments.length > 1) {
                throw new Exception("Command syntax not correct (\"save\")");
            }
            if (!fileHandler.isFileOpen()) {
                throw new Exception("No file is open to save");
            }
            fileHandler.saveFile(fileHandler.getFile(), spreadsheetHandler.getSpreadsheet());
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
