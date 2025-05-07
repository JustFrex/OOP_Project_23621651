package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.SpreadsheetHandler;

import java.io.IOException;

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
            if (arguments.length > 0)
            {
                String fileName = arguments[1];
                fileHandler.saveAsFile(fileName, spreadsheetHandler.getSpreadsheet());
            }
            else
            {
                System.out.println("File name not specified");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
