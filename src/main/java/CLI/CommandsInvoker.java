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

interface ICommand {
    long execute(Sort_Array sort, OutputFormat format);
}

class SimpleSort implements ICommand {
    public long execute(Sort_Array sort, OutputFormat format) {
        long start = System.nanoTime();
        ArrayList<int[]> result = sort.simple_sort(format);
        long end = System.nanoTime();
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
        return end - start;
    }
}

class EfficientSort implements ICommand {
    public long execute(Sort_Array sort, OutputFormat format) {
        long start = System.nanoTime();
        ArrayList<int[]> result = sort.efficient_sort(format);
        long end = System.nanoTime();
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
        return end - start;
    }
}

class NonComparisonSort implements ICommand {
    public long execute(Sort_Array sort, OutputFormat format) {
        long start = System.nanoTime();
        ArrayList<int[]> result = sort.nonComparison_sort(format);
        long end = System.nanoTime();
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
        return end - start;
    }
}

class HeapSort implements ICommand {
    public long execute(Sort_Array sort, OutputFormat format) {
        long start = System.nanoTime();
        ArrayList<int[]> result = sort.heap_sort(format);
        long end = System.nanoTime();
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
        return end - start;
    }
}