package bg.tu_varna.sit.a1.f23621651.Handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler
{
    private File file;
    private Scanner scanner;
    private boolean isFileOpen = false;

    public void openFile(String fileName)
    {
        try {
            file = new File(fileName);
            scanner = new Scanner(file);
            isFileOpen = true;
        } catch (FileNotFoundException e)
        {
            System.out.println("File " + fileName + " not found");
        }
    }

    public void closeFile()
    {
        if (scanner != null)
        {
            System.out.println("Successfully closed " + file.getName());
            scanner.close();
            scanner = null;
            file = null;
            isFileOpen = false;
        } else
        {
            System.out.println("File not opened");
        }
    }

    public void save(File file, String[][] spreadsheet)
    {
        try
        {
            FileWriter writer = new FileWriter(file);
            for (String[] row : spreadsheet)
            {
                for (String cell : row)
                {
                    writer.write(cell + ",");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully saved " + file.getName());
        } catch (IOException e)
        {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void saveFile(String[][] spreadsheet)
    {
        if (file != null)
        {
            save(file, spreadsheet);
        } else {
            System.out.println("File not opened");
        }
    }

    public void saveAsFile(String fileName, String[][] spreadsheet)
    {
        File file = new File(fileName);
        save(file, spreadsheet);
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public boolean isFileOpen()
    {
        return isFileOpen;
    }
}
