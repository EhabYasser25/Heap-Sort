package Tests;

import Service.*;
import Sorting.*;
import org.junit.*;

public class SortingTest {
    /*
      Worst-case, average-case, best-case scenarios for each
      algorithm (12 tests), and 8 comparison tests on a large array.
      All tests will test both correctness and time values.
     */

    @Test
    public void testBubbleSortBestCase() {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 7, 9, 10};
        Sort sort = new BubbleSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testBubbleSortAverageCase() {
        int[] arr = {1, 5, 2, 4, 3, 10, 6, 8, 7, 9};
        Sort sort = new BubbleSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testBubbleSortWorstCase() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sort sort = new BubbleSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testMergeSortBestCase() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Sort sort = new MergeSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testMergeSortAverageCase() {
        int[] arr = {1, 5, 2, 4, 3, 10, 6, 8, 7, 9};
        Sort sort = new MergeSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testMergeSortWorstCase() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sort sort = new MergeSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testRadixSortBestCase() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Sort sort = new RadixSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testRadixSortAverageCase() {
        int[] arr = {1, 5, 2, 4, 3, 10, 6, 8, 7, 9};
        Sort sort = new RadixSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testRadixSortWorstCase() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sort sort = new RadixSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testHeapSortBestCase() {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 7, 9, 10};
        Sort sort = new HeapSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testHeapSortAverageCase() {
        int[] arr = {1, 5, 2, 4, 3, 10, 6, 8, 7, 9};
        Sort sort = new HeapSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testHeapSortWorstCase() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sort sort = new HeapSort(arr);
        int[] res = sort.final_sort();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testBubbleMergeAverage() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_100K.txt");
        Sort sort1 = new BubbleSort(arr);
        Sort sort2 = new MergeSort(arr);
        long t1 = System.currentTimeMillis();
        int[] res1 = sort1.final_sort();
        long t2 = System.currentTimeMillis();
        int[] res2 = sort2.final_sort();
        long t3 = System.currentTimeMillis();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertTrue(t2 - t1 > 100*(t3 - t2));
    }

    @Test
    public void testBubbleMergeBest() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Best_10M.txt");
        Sort sort1 = new BubbleSort(arr);
        Sort sort2 = new MergeSort(arr);
        long t1 = System.currentTimeMillis();
        int[] res1 = sort1.final_sort();
        long t2 = System.currentTimeMillis();
        int[] res2 = sort2.final_sort();
        long t3 = System.currentTimeMillis();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertTrue(t2 - t1 < t3 - t2);
    }

    @Test
    public void testBubbleRadixAverage() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_100K.txt");
        Sort sort1 = new BubbleSort(arr);
        Sort sort2 = new RadixSort(arr);
        long t1 = System.currentTimeMillis();
        int[] res1 = sort1.final_sort();
        long t2 = System.currentTimeMillis();
        int[] res2 = sort2.final_sort();
        long t3 = System.currentTimeMillis();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertTrue(t2 - t1 > 100*(t3 - t2));
    }

    @Test
    public void testBubbleRadixBest() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Best_10M.txt");
        Sort sort1 = new BubbleSort(arr);
        Sort sort2 = new RadixSort(arr);
        long t1 = System.currentTimeMillis();
        int[] res1 = sort1.final_sort();
        long t2 = System.currentTimeMillis();
        int[] res2 = sort2.final_sort();
        long t3 = System.currentTimeMillis();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertTrue(t2 - t1 < t3 - t2);
    }

    @Test
    public void testBubbleHeapAverage() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_100K.txt");
        Sort sort1 = new BubbleSort(arr);
        Sort sort2 = new HeapSort(arr);
        long t1 = System.currentTimeMillis();
        int[] res1 = sort1.final_sort();
        long t2 = System.currentTimeMillis();
        int[] res2 = sort2.final_sort();
        long t3 = System.currentTimeMillis();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertTrue(t2 - t1 > 100*(t3 - t2));
    }

//    @Test
//    public void testBubbleHeapBest() {
//        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Best_10M.txt");
//        Sort sort1 = new BubbleSort(arr);
//        Sort sort2 = new HeapSort(arr);
//        long t1 = System.currentTimeMillis();
//        int[] res1 = sort1.final_sort();
//        long t2 = System.currentTimeMillis();
//        int[] res2 = sort2.final_sort();
//        long t3 = System.currentTimeMillis();
//        Assert.assertArrayEquals(res1, res2);
//        Assert.assertTrue(t2 - t1 < t3 - t2);
//    }

    @Test
    public void testMergeRadixAverage() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_10M.txt");
        Sort sort1 = new MergeSort(arr);
        Sort sort2 = new RadixSort(arr);
        long t1 = System.currentTimeMillis();
        int[] res1 = sort1.final_sort();
        long t2 = System.currentTimeMillis();
        int[] res2 = sort2.final_sort();
        long t3 = System.currentTimeMillis();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertTrue(t2 - t1 > t3 - t2);
    }

    @Test
    public void testMergeRadixBest() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Best_10M.txt");
        Sort sort1 = new MergeSort(arr);
        Sort sort2 = new RadixSort(arr);
        long t1 = System.currentTimeMillis();
        int[] res1 = sort1.final_sort();
        long t2 = System.currentTimeMillis();
        int[] res2 = sort2.final_sort();
        long t3 = System.currentTimeMillis();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertTrue(t2 - t1 < t3 - t2);
    }

//    @Test
//    public void testMergeHeapAverage() {
//        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_10M.txt");
//        Sort sort1 = new MergeSort(arr);
//        Sort sort2 = new HeapSort(arr);
//        long t1 = System.currentTimeMillis();
//        int[] res1 = sort1.final_sort();
//        long t2 = System.currentTimeMillis();
//        int[] res2 = sort2.final_sort();
//        long t3 = System.currentTimeMillis();
//        Assert.assertArrayEquals(res1, res2);
//        Assert.assertTrue(t2 - t1 < t3 - t2);
//    }

//    @Test
//    public void testRadixheapAverage() {
//        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_10M.txt");
//        Sort sort1 = new RadixSort(arr);
//        Sort sort2 = new HeapSort(arr);
//        long t1 = System.currentTimeMillis();
//        int[] res1 = sort1.final_sort();
//        long t2 = System.currentTimeMillis();
//        int[] res2 = sort2.final_sort();
//        long t3 = System.currentTimeMillis();
//        Assert.assertArrayEquals(res1, res2);
//        Assert.assertTrue(Math.abs(t2 - t1 < t3 - t2);
//    }

    @Test
    public void testBigBest() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Best_100K.txt");
        Sort sort1 = new BubbleSort(arr);
        Sort sort2 = new MergeSort(arr);
        Sort sort3 = new RadixSort(arr);
        Sort sort4 = new HeapSort(arr);
        int[] res1 = sort1.final_sort();
        int[] res2 = sort2.final_sort();
        int[] res3 = sort3.final_sort();
        int[] res4 = sort4.final_sort();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertArrayEquals(res1, res3);
        Assert.assertArrayEquals(res1, res4);
    }

    @Test
    public void testBigAverage() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_100K.txt");
        Sort sort1 = new BubbleSort(arr);
        Sort sort2 = new MergeSort(arr);
        Sort sort3 = new RadixSort(arr);
        Sort sort4 = new HeapSort(arr);
        int[] res1 = sort1.final_sort();
        int[] res2 = sort2.final_sort();
        int[] res3 = sort3.final_sort();
        int[] res4 = sort4.final_sort();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertArrayEquals(res1, res3);
        Assert.assertArrayEquals(res1, res4);
    }

    @Test
    public void testBigWorst() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Worst_100K.txt");
        Sort sort1 = new BubbleSort(arr);
        Sort sort2 = new MergeSort(arr);
        Sort sort3 = new RadixSort(arr);
        Sort sort4 = new HeapSort(arr);
        int[] res1 = sort1.final_sort();
        int[] res2 = sort2.final_sort();
        int[] res3 = sort3.final_sort();
        int[] res4 = sort4.final_sort();
        Assert.assertArrayEquals(res1, res2);
        Assert.assertArrayEquals(res1, res3);
        Assert.assertArrayEquals(res1, res4);
    }
}
