package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;

public class SaveFile implements Command
{
    private FileHandler fileHandler;

    public SaveFile(FileHandler fileHandler)
    {
        this.fileHandler = fileHandler;
    }

    @Override
    public void executeCommand()
    {

    }
}
