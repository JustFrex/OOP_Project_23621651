package bg.tu_varna.sit.a1.f23621651;

public class Cell
{
    private String value;
    private CellType type;

    public Cell(String value, CellType type)
    {
        this.value = value;
        this.type = type;
    }

    private CellType typeDetermine()
    {
        if(value.matches(""))
        {
            return CellType.INTEGER;
        }
        if(value.matches(""))
        {
            return CellType.DOUBLE;
        }
        if(value.matches(""))
        {
            return CellType.STRING;
        }
        if(value.matches(""))
        {
            return CellType.FORMULA;
        }
        return CellType.EMPTY;
    }

    public String getValue()
    {
        return value;
    }

    public CellType getType()
    {
        return type;
    }
}
