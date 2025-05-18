package bg.tu_varna.sit.a1.f23621651.Handlers;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Handles operations related to spreadsheets like opening, editing, printing, and formula evaluation.
 */
public class SpreadsheetHandler {
    private int rows;
    private int columns;
    private String[][] spreadsheet;

    /**
     * Opens a spreadsheet from a given Scanner input.
     *
     * @param scanner the Scanner reading the spreadsheet content
     */
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

    /**
     * Prints the spreadsheet content to the console in a formatted manner.
     */
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

    /**
     * Checks if the given cell position exists within the spreadsheet.
     *
     * @param row the zero-based row index
     * @param col the zero-based column index
     * @return true if the cell exists, false otherwise
     */
    public boolean isExistingCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    /**
     * Gets the content of a specified cell, evaluating formulas if present.
     *
     * @param row the zero-based row index
     * @param col the zero-based column index
     * @return the cell content as a String
     */
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

    /**
     * Sets the value of a specific cell.
     *
     * @param row   the zero-based row index
     * @param col   the zero-based column index
     * @param value the new value or formula to set
     */
    public void setCell(int row, int col, String value) {
        System.out.println("Successfully edited cell R" + (row + 1) + "C" + (col + 1));
        spreadsheet[row][col] = value;
    }

    /**
     * Returns the entire spreadsheet as a 2D String array.
     *
     * @return the spreadsheet data
     */
    public String[][] getSpreadsheet() {
        return spreadsheet;
    }
}
