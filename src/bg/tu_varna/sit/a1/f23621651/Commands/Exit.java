package bg.tu_varna.sit.a1.f23621651.Commands;

public class Exit implements Command
{
    @Override
    public void executeCommand(String[] arguments)
    {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
