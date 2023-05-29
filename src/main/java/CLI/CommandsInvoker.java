package CLI;

import Sorting.*;
import java.util.*;

public class CommandsInvoker {
    public ICommand invoke(SortAlgorithm algorithm) {
        return switch (algorithm) {
            case BUBBLE -> new SimpleSort();
            case MERGE -> new EfficientSort();
            case RADIX -> new NonComparisonSort();
            case HEAP -> new HeapSort();
        };
    }
}

class SimpleSort implements ICommand {
    ArrayList<int[]> result;
    public long execute(Sort_Array sort, OutputFormat format) {
        long start = System.nanoTime();
        result = sort.simple_sort(format);
        long end = System.nanoTime();
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
        return end - start;
    }
    public ArrayList<int[]> getResult() {
        return result;
    }
}

class EfficientSort implements ICommand {
    ArrayList<int[]> result;
    public long execute(Sort_Array sort, OutputFormat format) {
        long start = System.nanoTime();
        result = sort.efficient_sort(format);
        long end = System.nanoTime();
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
        return end - start;
    }
    public ArrayList<int[]> getResult() {
        return result;
    }
}

class NonComparisonSort implements ICommand {
    ArrayList<int[]> result;
    public long execute(Sort_Array sort, OutputFormat format) {
        long start = System.nanoTime();
        result = sort.nonComparison_sort(format);
        long end = System.nanoTime();
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
        return end - start;
    }
    public ArrayList<int[]> getResult() {
        return result;
    }
}

class HeapSort implements ICommand {
    ArrayList<int[]> result;
    public long execute(Sort_Array sort, OutputFormat format) {
        long start = System.nanoTime();
        result = sort.heap_sort(format);
        long end = System.nanoTime();
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
        return end - start;
    }
    public ArrayList<int[]> getResult() {
        return result;
    }
}