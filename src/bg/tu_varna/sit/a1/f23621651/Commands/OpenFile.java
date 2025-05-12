package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.SpreadsheetHandler;

import java.io.File;
import java.util.Scanner;

public class OpenFile implements Command
{
    private FileHandler fileHandler;
    private SpreadsheetHandler spreadsheetHandler;

    public OpenFile(FileHandler fileHandler, SpreadsheetHandler spreadsheetHandler)
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
                throw new Exception("Command syntax not correct (\"open <file>\")");
            }
            if(arguments.length == 1)
            {
                throw new Exception("File name not specified");
            }
            String filePath = arguments[1];
            fileHandler.openFile(filePath);
            File file = new File(filePath);
            String fileName = file.getName();
            Scanner scanner = fileHandler.getScanner();
            spreadsheetHandler.openSpreadsheet(scanner);
            System.out.println("Successfully opened " + fileName);
        }
        catch (Exception e)
        {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
}
