package bg.tu_varna.sit.a1.f23621651.Handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    private File file;
    private Scanner scanner;
    private boolean isFileOpen = false;

    public void openFile(String fileName) throws Exception {
        try {
            file = new File(fileName);
            scanner = new Scanner(file);
            isFileOpen = true;
        } catch (FileNotFoundException e) {
            throw new Exception(" File " + fileName + " not found");
        }
    }

    public void closeFile() {
        System.out.println("Successfully closed " + file.getName());
        scanner.close();
        scanner = null;
        file = null;
        isFileOpen = false;
    }

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

    public void saveAsFile(String fileName, String[][] spreadsheet) {
        File file = new File(fileName);
        saveFile(file, spreadsheet);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public boolean isFileOpen() {
        return isFileOpen;
    }

    public File getFile() {
        return file;
    }
}
