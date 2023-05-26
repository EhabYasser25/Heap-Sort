package CLI;

import Sorting.*;

import java.util.*;

import static CLI.SortAlgorithm.*;
import static CLI.OutputFormat.*;

public class SortApp {

    Scanner sc = new Scanner(System.in);

    Sort_Array sort;

    SortAlgorithm algorithm;

    OutputFormat format;

    public void startProgram() {
        printIntro();
        while (true) {
            System.out.println("Enter the path of the file:");
            System.out.print("> ");
            String filePath = sc.nextLine();
            try {
                sort = new Sort_Array(filePath);
                break;
            } catch (Exception c) {
                System.out.println("File not found!");
            }
        }
        System.out.println("Please select an algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Radix Sort");
        System.out.println("4. Heap Sort");
        System.out.println("0. Exit");
        programLoop();
    }

    public void programLoop() {
        int option;
        while(true) {
            System.out.print("> ");
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                option = -1;
            }
            if(setAlgorithm(option) == -1) continue;
            do {
                System.out.println("Please select an output format:");
                System.out.println("1. Final Array");
                System.out.println("2. Intermediate Arrays");
                System.out.print("> ");
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    option = -1;
                }
            } while (setFormat(option) != 0);
            long time = execute();
            System.out.println("Time in microseconds: " + time / 1000);
        }
    }

    public int setAlgorithm(int option) {
        if (option == 0) System.exit(0);
        if (option > 4 || option < 1){
            System.out.println("Invalid input!!");
            return -1;
        }
        switch (option) {
            case 1 -> algorithm = BUBBLE;
            case 2 -> algorithm = MERGE;
            case 3 -> algorithm = RADIX;
//            case 4 -> algorithm = HEAP;
        }
        return 0;
    }

    public int setFormat(int option) {
        if (option > 2 || option < 1){
            System.out.println("Invalid input!!");
            return -1;
        }
        switch (option) {
            case 1 -> format = FINAL;
            case 2 -> format = INTERMEDIATE;
        }
        return 0;
    }

    private long execute() {
        ICommand command = new CommandsInvoker().invoke(algorithm);
        return command.execute(sort, format);
    }

    public void printIntro() {
        System.out.println("\nWelcome to our project!\n\n\n");
    }
}