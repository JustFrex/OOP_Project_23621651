package bg.tu_varna.sit.a1.f23621651.Commands;

/**
 * Command implementation for displaying available commands and their syntax.
 */
public class Help implements Command {
    /**
     * Executes the help command.
     *
     * @param arguments the command-line arguments
     */
    @Override
    public void executeCommand(String[] arguments) {
        try {
            if (arguments.length > 1) {
                throw new Exception();
            }
            System.out.println("The following commands are supported:");
            System.out.println("open <file>                          opens <file>");
            System.out.println("close                                closes currently opened file");
            System.out.println("save                                 saves the currently open file");
            System.out.println("saveas <file>                        saves the currently open file in <file>");
            System.out.println("edit <row> <column> <value/formula>  edits cells based on the given parameters");
            System.out.println("print                                prints the currently open spreadsheet");
            System.out.println("help                                 prints this information");
            System.out.println("exit                                 exits the program");
        } catch (Exception e) {
            System.out.println("Command syntax not correct (\"help\")");
        }
    }
}
