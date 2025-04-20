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
        if (arguments.length > 0)
        {
            try
            {
                String filePath = arguments[1];
                fileHandler.openFile(filePath);
                File file = new File(filePath);
                String fileName = file.getName();
                Scanner scanner = fileHandler.getScanner();
                if(scanner != null)
                {
                    spreadsheetHandler.openSpreadsheet(scanner);
                    System.out.println("Successfully opened " + fileName);
                }
                else
                {
                    System.out.println("Error while opening file");
                }
            }
            catch (Exception e)
            {
                System.out.println("Error has occurred: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("File name not specified");
        }
    }
}
