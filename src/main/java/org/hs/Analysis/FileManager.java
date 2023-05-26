package org.hs.Analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static int[] readFile(String path) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }

        int[] numbers = new int[words.size()];
        for(int i = 0; i < words.size(); i++) {
            numbers[i] = Integer.parseInt(words.get(i));
        }

        return numbers;
    }
    public static void writeLongToFile(List<Long> base, String filename) throws IOException {
        try {
            FileWriter writer = new FileWriter(filename);
            for (long word : base) {
                writer.write(word + "\n"); // write word followed by newline character
            }
            writer.close();
            System.out.println("Word list written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}