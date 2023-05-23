package org.hs;

import org.hs.Sorting.BubbleSort;
import org.hs.Sorting.MergeSort;
import org.hs.Sorting.RadixSort;
import org.hs.Sorting.Sort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Sort_Array {

    /**
     * The list of elements read from the CSV file during construction.
     */
    private final int[] elements;

    private Sort simple, efficient, nonComparative;

    /**
     * Takes an input file structured containing the list of elements
     * comma separated, reads it, and initializes the array.
     * @param path the path to the file from which to read the array.
     */
    public Sort_Array(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        String[] numStrings = line.split(",");
        elements = new int[numStrings.length];
        for(int i=0 ; i<elements.length ; i++)
            elements[i] = Integer.parseInt(numStrings[i]);
        simple = new BubbleSort(elements);
        efficient = new MergeSort(elements);
        nonComparative = new RadixSort(elements);
    }

    /**
     * Determines the format of the output of the sorting algorithm
     */
    public enum OutputFormat {
        /**
         * Return the intermediate arrays generated in the sorting process.
         */
        INTERMEDIATE,
        /**
         * Return only the final array after the sorting process is completed.
         */
        FINAL
    }

    /**
     * Applies the sorting algorithm chosen from the O(n^2) sorting algorithms
     * and either return the intermediate results or the final one.
     * @param format Determines whether to return the intermediate arrays or
     * the final sorted array.
     * @return An array of lists containing the results from the sorting algorithm.
     * The array would be of length one in case the OutputFormat chosen was FINAL
     */
    public ArrayList<int[]> simple_sort(OutputFormat format){
        ArrayList<int[]> results;
        if(format == OutputFormat.INTERMEDIATE)
            results = this.simple.incremental_sort();
        else{
            results = new ArrayList<>(1);
            results.add(this.simple.final_sort());
        }
        return results;
    }

    /**
     * Applies the sorting algorithm chosen from the O(n * lg n) sorting algorithms
     * and either return the intermediate results or the final one.
     * @param format Determines whether to return the intermediate arrays or
     * the final sorted array.
     * @return An array of lists containing the results from the sorting algorithm.
     * The array would be of length one in case the OutputFormat chosen was FINAL
     */
    public ArrayList<int[]> efficient_sort(OutputFormat format){
        ArrayList<int[]> results;
        if(format == OutputFormat.INTERMEDIATE)
            results = this.efficient.incremental_sort();
        else{
            results = new ArrayList<>(1);
            results.add(this.efficient.final_sort());
        }
        return results;
    }

    /**
     * Applies the sorting algorithm chosen from the O(n) sorting algorithms
     * and either return the intermediate results or the final one.
     * @param format Determines whether to return the intermediate arrays or
     * the final sorted array.
     * @return An array of lists containing the results from the sorting algorithm.
     * The array would be of length one in case the OutputFormat chosen was FINAL
     */
    public ArrayList<int[]> nonComparison_sort(OutputFormat format){
        ArrayList<int[]> results;
        if(format == OutputFormat.INTERMEDIATE)
            results = this.nonComparative.incremental_sort();
        else{
            results = new ArrayList<>(1);
            results.add(this.nonComparative.final_sort());
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        Sort_Array sort = new Sort_Array("src/main/java/org/hs/test.txt");
        System.out.println("\nSorting without steps: ");
        System.out.println(Arrays.toString(sort.nonComparison_sort(OutputFormat.FINAL).get(0)));
        System.out.println("\nSorting with steps: ");
        for(int[] lst : sort.nonComparison_sort(OutputFormat.INTERMEDIATE)){
            System.out.println(Arrays.toString(lst));
        }
    }
}
