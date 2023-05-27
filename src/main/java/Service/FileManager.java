package Service;

import java.io.*;
import java.util.*;

public class FileManager {
    public static int[] readFile(String path) {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numberStrings = line.split(",");
                for (String numberString : numberStrings) {
                    numbers.add(Integer.parseInt(numberString.trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }

        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }
}
