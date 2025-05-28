package bg.tu_varna.sit.a1.f23621651.Handlers;

public class Cell {
    private String value;
    private CellType type;

    public Cell(String value) {
        setValue(value);
    }

    public void setValue(String value) {
        this.value = value.trim();

        if (this.value.startsWith("=")) {
            this.type = CellType.FORMULA;
            return;
        }

        try {
            Integer.parseInt(this.value);
            this.type = CellType.INT;
            return;
        } catch (NumberFormatException e) {
        }
        try {
            Double.parseDouble(this.value);
            this.type = CellType.DOUBLE;
            return;
        } catch (NumberFormatException e) {
        }
        this.type = CellType.STRING;
    }

    public String getValue() {
        return value;
    }

    public CellType getType() {
        return type;
    }

    public double getNumber() throws Exception {
        if (type == CellType.INT || type == CellType.DOUBLE) {
            return Double.parseDouble(value);
        }
        throw new Exception("Cell is not numeric");
    }
}
