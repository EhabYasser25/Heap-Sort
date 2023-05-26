package Analysis;

import Service.FileManager;
import Sorting.BubbleSort;
import Sorting.MergeSort;
import Sorting.RadixSort;
import Sorting.Sort;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Analysis {

    void bubble_analysis(int number_of_points) throws IOException {
        List<Long> reading_best = new ArrayList<>();
        // best case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\best\\" + Integer.toString(i) +".txt");
            Sort bubble = new BubbleSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                bubble.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_best.add(time / 10);
            System.out.println("best Bubble" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_best, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\bubble_best");

        List<Long> reading_worst = new ArrayList<>();
        // worst case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\worst\\" + Integer.toString(i) +".txt");
            Sort bubble = new BubbleSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                bubble.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_worst.add(time / 10);
            System.out.println("worst Bubble" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_worst, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\bubble_worst");

        List<Long> reading_avg = new ArrayList<>();
        // Average case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\average\\" + Integer.toString(i) +".txt");
            Sort bubble = new BubbleSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++){
                long start = System.nanoTime();
                bubble.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_avg.add(time / 10);
            System.out.println("average Bubble" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_avg, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\bubble_average");
    }

    void merge_analysis(int number_of_points) throws IOException {
        List<Long> reading_best = new ArrayList<>();
        // best case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\best\\" + Integer.toString(i) +".txt");
            Sort merge = new MergeSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                merge.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_best.add(time / 10);
            System.out.println("best Merge" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_best, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\merge_best");

        List<Long> reading_worst = new ArrayList<>();
        // worst case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\worst\\" + Integer.toString(i) +".txt");
            Sort merge = new MergeSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                merge.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_worst.add(time / 10);
            System.out.println("worst Merge" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_worst, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\merge_worst");

        List<Long> reading_avg = new ArrayList<>();
        // Average case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\average\\" + Integer.toString(i) +".txt");
            Sort merge = new MergeSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                merge.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_avg.add(time / 10);
            System.out.println("average Merge" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_avg, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\merge_average");

    }

    void radix_analysis(int number_of_points) throws IOException {
        List<Long> reading_best = new ArrayList<>();
        // best case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\best\\" + Integer.toString(i) +".txt");
            assert numbers != null;
            Sort radix = new RadixSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                radix.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_best.add(time / 10);
            System.out.println("best radix" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_best, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\radix_best");

        List<Long> reading_worst = new ArrayList<>();
        // worst case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\worst\\" + Integer.toString(i) +".txt");
            assert numbers != null;
            Sort radix = new RadixSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                radix.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_worst.add(time / 10);
            System.out.println("worst radix" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_worst, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\radix_worst");

        List<Long> reading_avg = new ArrayList<>();
        // Average case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\average\\" + Integer.toString(i) +".txt");
            assert numbers != null;
            Sort radix = new RadixSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                radix.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_avg.add(time / 10);
            System.out.println("average radix" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_avg, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\radix_average");

    }

    void heap_analysis(int number_of_points) throws IOException {
        List<Long> reading_best = new ArrayList<>();
        // best case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\best\\" + Integer.toString(i) +".txt");
            assert numbers != null;
            Sort radix = new RadixSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                radix.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_best.add(time / 10);
            System.out.println("best radix" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_best, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\radix_best");

        List<Long> reading_worst = new ArrayList<>();
        // worst case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\worst\\" + Integer.toString(i) +".txt");
            assert numbers != null;
            Sort radix = new RadixSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                radix.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_worst.add(time / 10);
            System.out.println("worst radix" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_worst, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\radix_worst");

        List<Long> reading_avg = new ArrayList<>();
        // Average case analysis
        for(int i = 0; i < number_of_points; i++) {
            int[] numbers = FileManager.readFile("D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\average\\" + Integer.toString(i) +".txt");
            assert numbers != null;
            Sort radix = new RadixSort(numbers);
            long time = 0;
            for(int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                radix.final_sort();
                long end = System.nanoTime();
                time += (end - start);
            }
            reading_avg.add(time / 10);
            System.out.println("average radix" + i);
            System.gc();
        }
        FileManager.writeLongToFile(reading_avg, "D:\\CSED\\semester4\\Plotter\\Sorting_Algorithms_Analysis\\analysis_data\\readings\\radix_average");

    }

    @Test
    void run() throws IOException {
        int num_points = 200;
//        bubble_analysis(num_points);
//        merge_analysis(num_points);
//        radix_analysis(num_points);
        heap_analysis(num_points);
    }

}
