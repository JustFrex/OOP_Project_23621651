package bg.tu_varna.sit.a1.f23621651.Commands;

/**
 * Command implementation for terminating the program.
 */
public class Exit implements Command {
    /**
     * Executes the exit command.
     *
     * @param arguments the command-line arguments
     */
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
