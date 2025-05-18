package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;

/**
 * Command implementation for closing the currently open spreadsheet file.
 */
public class CloseFile implements Command {
    private FileHandler fileHandler;

    public CloseFile(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    /**
     * Executes the close command.
     *
     * @param arguments the command-line arguments
     */
    @Override
    public void executeCommand(String[] arguments) {
        try {
            if (arguments.length > 1) {
                throw new Exception("Command syntax not correct (\"close\")");
            }
            if (!fileHandler.isFileOpen()) {
                throw new Exception("No file is open to close");
            }
            fileHandler.closeFile();
        } catch (Exception e) {
            System.out.println("Error closing file: " + e.getMessage());
        }
    }
}
