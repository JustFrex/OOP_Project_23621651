package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;

public class CloseFile implements Command
{
    private FileHandler fileHandler;

    public CloseFile(FileHandler fileHandler)
    {
        this.fileHandler = fileHandler;
    }

    @Override
    public void executeCommand(String[] arguments)
    {
        try
        {
            fileHandler.closeFile();
        }
        catch (Exception e)
        {
            System.out.println("Error while closing file: " + e.getMessage());
        }
    }
}
