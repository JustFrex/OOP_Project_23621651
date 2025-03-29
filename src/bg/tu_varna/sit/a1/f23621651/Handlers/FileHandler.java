package bg.tu_varna.sit.a1.f23621651.Handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler
{
    private File file;
    private Scanner scanner;

    public void openFile(String fileName)
    {
        try
        {
            file = new File(fileName);
            scanner = new Scanner(file);
            System.out.println("Successfully opened " + fileName);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File " + fileName + " not found");
        }
    }

    public void closeFile()
    {
        if(scanner != null)
        {
            System.out.println("Successfully closed " + file.getName());
            scanner.close();
            scanner = null;
            file = null;
        }
        else
        {
            System.out.println("File not opened");
        }
    }

    public void saveFile(String fileName)
    {

    }

    public void saveAsFile(String fileName)
    {

    }
}
