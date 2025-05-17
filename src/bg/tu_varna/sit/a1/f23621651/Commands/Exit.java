package bg.tu_varna.sit.a1.f23621651.Commands;

public class Exit implements Command {
    @Override
    public void executeCommand(String[] arguments) {
        try {
            if (arguments.length > 1) {
                throw new Exception("Command syntax not correct (\"exit\")");
            }
            System.out.println("Exiting the program...");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error exiting file: " + e.getMessage());
        }
    }
}
