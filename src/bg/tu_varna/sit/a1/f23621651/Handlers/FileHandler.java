package bg.tu_varna.sit.a1.f23621651.Handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Manages file operations such as opening, saving, and closing spreadsheet files.
 */
public class FileHandler {
    private File file;
    private Scanner scanner;
    private boolean isFileOpen = false;

    /**
     * Opens a file for reading.
     *
     * @param fileName the path to the file
     * @throws Exception if the file is not found
     */
    public void openFile(String fileName) throws Exception {
        try {
            file = new File(fileName);
            scanner = new Scanner(file);
            isFileOpen = true;
        } catch (FileNotFoundException e) {
            throw new Exception("File " + fileName + " not found");
        }
    }

    /**
     * Closes the currently open file.
     */
    public void closeFile() {
        System.out.println("Successfully closed " + file.getName());
        scanner.close();
        scanner = null;
        file = null;
        isFileOpen = false;
    }

    /**
     * Saves the spreadsheet content to the specified file.
     *
     * @param file        the file to save to
     * @param spreadsheet the 2D array representing spreadsheet data
     */
    public void saveFile(File file, String[][] spreadsheet) {
        try {
            FileWriter writer = new FileWriter(file);
            for (String[] row : spreadsheet) {
                for (int i = 0; i < row.length; i++) {
                    writer.write(row[i]);
                    if (i < row.length - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully saved " + file.getName());
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    /**
     * Saves the spreadsheet content to a new file.
     *
     * @param fileName    the new file name
     * @param spreadsheet the 2D array representing spreadsheet data
     */
    public void saveAsFile(String fileName, String[][] spreadsheet) {
        File file = new File(fileName);
        saveFile(file, spreadsheet);
    }

    /**
     * Retrieves the Scanner for the currently opened file.
     *
     * @return the Scanner instance
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Checks if a file is currently open.
     *
     * @return true if a file is open, false otherwise
     */
    public boolean isFileOpen() {
        return isFileOpen;
    }

    /**
     * Gets the currently opened file.
     *
     * @return the File instance
     */
    public File getFile() {
        return file;
    }
}
