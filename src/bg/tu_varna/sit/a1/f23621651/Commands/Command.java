package bg.tu_varna.sit.a1.f23621651.Commands;

/**
 * Interface for all spreadsheet application commands.
 */
public interface Command {
    /**
     * Executes the command using the provided arguments.
     *
     * @param arguments the command-line arguments
     */
    void executeCommand(String[] arguments);
}
