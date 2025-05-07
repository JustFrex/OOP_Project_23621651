package bg.tu_varna.sit.a1.f23621651.Handlers;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpreadsheetHandler
{
    private int rows;
    private int columns;
    private String[][] spreadsheet;

    public void openSpreadsheet(Scanner scanner)
    {
        List<String[]> data = new ArrayList<>();
        int maxCol = 0;
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] values = line.split(",", -1);
            data.add(values);
            maxCol = Math.max(maxCol, values.length);
        }
        rows = data.size();
        columns = maxCol;
        spreadsheet = new String[rows][columns];
        for(int i = 0; i < rows; i++)
        {
            String[] row = data.get(i);
            for(int j = 0; j < row.length; j++)
            {
                spreadsheet[i][j] = row[j];
            }
            for(int j = row.length; j < columns; j++)
            {
                spreadsheet[i][j] = "";
            }
        }
    }

    public void printSpreadsheet()
    {
        int[] maxWidth = new int[columns];
        for(int i = 0; i < columns; i++)
        {
            int max = 0;
            for (int j = 0; j < rows; j++)
            {
                if (spreadsheet[j][i] != null)
                {
                    max = Math.max(max, spreadsheet[j][i].length());
                }
            }
            maxWidth[i] = max;
        }
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                String cell;
                if (spreadsheet[i][j] == null)
                {
                    cell = "";
                }
                else
                {
                    cell = spreadsheet[i][j];
                }
                System.out.print(String.format("%-" + maxWidth[j] + "s", cell) + "|");
            }
            System.out.println();
        }
    }
    public String[][] getSpreadsheet()
    {
        return spreadsheet;
    }
}
