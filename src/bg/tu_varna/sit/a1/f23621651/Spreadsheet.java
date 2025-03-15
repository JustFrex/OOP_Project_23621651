package bg.tu_varna.sit.a1.f23621651;

import java.util.ArrayList;
import java.util.List;

public class Spreadsheet
{
    private List<List<Cell>> spreadsheet = new ArrayList<>();

    public void printTable()
    {
        for(List<Cell> row : spreadsheet)
        {
            for(Cell cell : row)
            {
                System.out.println(cell.toString() + " | ");
            }

        }
    }

    public void editCell(int row, int column, String value)
    {
        try
        {

        } catch (Exception e)
        {
            System.out.println("Error: ");
        }
    }
}
