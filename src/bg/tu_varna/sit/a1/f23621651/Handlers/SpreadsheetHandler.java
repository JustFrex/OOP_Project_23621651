package bg.tu_varna.sit.a1.f23621651.Handlers;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SpreadsheetHandler {
    private int rows;
    private int columns;
    private String[][] spreadsheet;

    public void openSpreadsheet(Scanner scanner) {
        List<String[]> data = new ArrayList<>();
        int maxCol = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            data.add(values);
            maxCol = Math.max(maxCol, values.length);
        }
        rows = data.size();
        columns = maxCol;
        spreadsheet = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] row = data.get(i);
            for (int j = 0; j < row.length; j++) {
                spreadsheet[i][j] = row[j].trim();
            }
            for (int j = row.length; j < columns; j++) {
                spreadsheet[i][j] = "";
            }
        }
    }

    public void printSpreadsheet() {
        int[] maxWidth = new int[columns];
        for (int i = 0; i < columns; i++) {
            int max = 0;
            for (int j = 0; j < rows; j++) {
                if (spreadsheet[j][i] != null) {
                    max = Math.max(max, getCell(j, i).length());
                }
            }
            maxWidth[i] = max;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String cell = getCell(i, j);
                System.out.print(String.format("%-" + maxWidth[j] + "s", cell) + "|");
            }
            System.out.println();
        }
    }

    public boolean isExistingCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    public String getCell(int row, int col) {
        if (!isExistingCell(row, col)) {
            return "";
        }
        String value = spreadsheet[row][col];
        if (value == null || value.isEmpty()) {
            return "";
        }
        if (value.startsWith("=")) {
            try {
                String formula = value.substring(1);
                double result = calculateFormula(formula);
                return (result == (int) result) ? String.format("%d", (int) result) : String.format(Locale.US, "%.2f", result);
            } catch (Exception e) {
                return "ERROR";
            }
        }
        return value;
    }

    private double calculateFormula(String formula) throws Exception {
        String[] tokens = formula.split("(?=[-+*/])|(?<=[-+*/])");
        double result = parseCell(tokens[0].trim());
        for (int i = 1; i < tokens.length; i += 2) {
            String operand = tokens[i];
            double nextValue = parseCell(tokens[i + 1]);
            switch (operand) {
                case "+":
                    result += nextValue;
                    break;
                case "-":
                    result -= nextValue;
                    break;
                case "*":
                    result *= nextValue;
                    break;
                case "/":
                    if (nextValue == 0) {
                        throw new Exception("Can't divide by 0");
                    }
                    result /= nextValue;
                    break;
                default:
                    throw new Exception("Invalid operand");
            }
        }
        return result;
    }

    private double parseCell(String token) {
        token = token.trim();
        if (token.matches("R\\d+C\\d+")) {
            int row = Integer.parseInt(token.substring(1, token.indexOf("C"))) - 1;
            int col = Integer.parseInt(token.substring(token.indexOf("C") + 1)) - 1;
            String value = getCell(row, col);
            try {
                return Double.parseDouble(value);
            } catch (Exception e) {
                return 0;
            }
        } else {
            try {
                return Double.parseDouble(token);
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public void setCell(int row, int col, String value) {
        spreadsheet[row][col] = value;
    }

    public String[][] getSpreadsheet() {
        return spreadsheet;
    }
}
