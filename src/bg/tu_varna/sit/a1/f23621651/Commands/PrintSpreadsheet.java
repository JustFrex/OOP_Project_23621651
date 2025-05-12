package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.SpreadsheetHandler;


public class PrintSpreadsheet implements Command
{
    private SpreadsheetHandler spreadsheetHandler;
    private FileHandler fileHandler;

    public PrintSpreadsheet(SpreadsheetHandler spreadsheetHandler, FileHandler fileHandler)
    {
        this.spreadsheetHandler = spreadsheetHandler;
        this.fileHandler = fileHandler;
    }

    @Override
    public void executeCommand(String[] arguments)
    {
        try
        {
            if (arguments.length > 1)
            {
                throw new Exception("Command syntax not correct (\"close\")");
            }
            if (!fileHandler.isFileOpen())
            {
                throw new Exception("No file is open to print");
            }
            spreadsheetHandler.printSpreadsheet();
        }
        catch (Exception e)
        {
            System.out.println("Error printing file: " + e.getMessage());
        }

    }
}
