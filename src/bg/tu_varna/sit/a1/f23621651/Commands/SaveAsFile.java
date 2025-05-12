package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.SpreadsheetHandler;


public class SaveAsFile implements Command
{
    private FileHandler fileHandler;
    private SpreadsheetHandler spreadsheetHandler;

    public SaveAsFile(FileHandler fileHandler, SpreadsheetHandler spreadsheetHandler)
    {
        this.fileHandler = fileHandler;
        this.spreadsheetHandler = spreadsheetHandler;
    }

    @Override
    public void executeCommand(String[] arguments)
    {
        try
        {
            if (arguments.length > 2)
            {
                throw new Exception("Command syntax not correct (\"saveas <file>\")");
            }
            if (!fileHandler.isFileOpen())
            {
                throw new Exception("No file is open to save");
            }
            if(arguments.length == 1)
            {
                throw new Exception("File name not specified");
            }
            String fileName = arguments[1];
            fileHandler.saveAsFile(fileName, spreadsheetHandler.getSpreadsheet());
        }
        catch (Exception e)
        {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
