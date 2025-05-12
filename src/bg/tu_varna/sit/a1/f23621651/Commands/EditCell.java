package bg.tu_varna.sit.a1.f23621651.Commands;

import bg.tu_varna.sit.a1.f23621651.Handlers.FileHandler;
import bg.tu_varna.sit.a1.f23621651.Handlers.SpreadsheetHandler;

public class EditCell implements Command
{
    private FileHandler fileHandler;
    private SpreadsheetHandler spreadsheetHandler;

    public EditCell(FileHandler fileHandler, SpreadsheetHandler spreadsheetHandler)
    {
        this.fileHandler = fileHandler;
        this.spreadsheetHandler = spreadsheetHandler;
    }

    @Override
    public void executeCommand(String[] arguments)
    {
        try
        {
            if (arguments.length >= 4)
            {
                if (!fileHandler.isFileOpen())
                {
                    throw new Exception("No file is open to edit");
                }
                try
                {
                    int row = Integer.parseInt(arguments[1]) - 1;
                    int col = Integer.parseInt(arguments[2]) - 1;
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 3; i < arguments.length; i++)
                    {
                        stringBuilder.append(arguments[i]);
                        if (i < arguments.length - 1)
                        {
                            stringBuilder.append(" ");
                        }
                    }
                    String value = stringBuilder.toString();
                    if (!spreadsheetHandler.isExistingCell(row, col))
                    {
                        throw new Exception("Invalid cell");
                    }
                    spreadsheetHandler.setCell(row, col, value);
                }
                catch (Exception e)
                {
                    throw new Exception("Invalid row/column");
                }
            }
            else
            {
                throw new Exception("Command syntax not correct (\"edit <row> <col> <value/formula>\")");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error editing cell: " + e.getMessage());
        }

    }
}
