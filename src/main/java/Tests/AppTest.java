package Tests;

import CLI.*;
import Service.*;
import Sorting.*;
import org.junit.*;
import java.util.*;

public class AppTest {

    @Test
    public void testBubbleIntermediate() {
        int[] arr = new int[] {1, 3, 4, 2, 5};
        Sort_Array sort = new Sort_Array(arr);
        ICommand command = new CommandsInvoker().invoke(SortAlgorithm.BUBBLE);
        command.execute(sort, OutputFormat.INTERMEDIATE);
        ArrayList<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1, 3, 4, 2, 5});
        expected.add(new int[]{1, 3, 2, 4, 5});
        expected.add(new int[]{1, 2, 3, 4, 5});
        ArrayList<int[]> res = command.getResult();
        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void testMergeIntermediate() {
        int[] arr = new int[] {1, 3, 4, 2, 5};
        Sort_Array sort = new Sort_Array(arr);
        ICommand command = new CommandsInvoker().invoke(SortAlgorithm.MERGE);
        command.execute(sort, OutputFormat.INTERMEDIATE);
        ArrayList<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1, 3});
        expected.add(new int[]{1, 3, 4});
        expected.add(new int[]{2, 5});
        expected.add(new int[]{1, 2, 3, 4, 5});
        ArrayList<int[]> res = command.getResult();
        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void testRadixIntermediate() {
        int[] arr = new int[] {1, 41, 3, 4, 747, 2, 5, 132, 93};
        Sort_Array sort = new Sort_Array(arr);
        ICommand command = new CommandsInvoker().invoke(SortAlgorithm.RADIX);
        command.execute(sort, OutputFormat.INTERMEDIATE);
        ArrayList<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1, 41, 3, 4, 747, 2, 5, 132, 93});
        expected.add(new int[]{1, 41, 2, 132, 3, 93, 4, 5, 747});
        expected.add(new int[]{1, 2, 3, 4, 5, 132, 41, 747, 93});
        expected.add(new int[]{1, 2, 3, 4, 5, 41, 93, 132, 747});
        ArrayList<int[]> res = command.getResult();
        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void testHeapIntermediate() {
        int[] arr = new int[] {1, 3, 4, 2, 5};
        Sort_Array sort = new Sort_Array(arr);
        ICommand command = new CommandsInvoker().invoke(SortAlgorithm.HEAP);
        command.execute(sort, OutputFormat.INTERMEDIATE);
        ArrayList<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1, 3, 4, 2, 5});
        expected.add(new int[]{1, 5, 4, 2, 3});
        expected.add(new int[]{5, 3, 4, 2, 1});
        expected.add(new int[]{4, 3, 1, 2, 5});
        expected.add(new int[]{3, 2, 1, 4, 5});
        expected.add(new int[]{2, 1, 3, 4, 5});
        expected.add(new int[]{1, 2, 3, 4, 5});
        expected.add(new int[]{1, 2, 3, 4, 5});
        ArrayList<int[]> res = command.getResult();
        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void testBubbleFinal() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_10K.txt");
        Sort_Array sort = new Sort_Array(arr);
        ICommand command = new CommandsInvoker().invoke(SortAlgorithm.BUBBLE);
        command.execute(sort, OutputFormat.FINAL);
        int[] res = command.getResult().get(0);
        for(int i = 1; i < res.length; i++)
            Assert.assertTrue(res[i] >= res[i-1]);
    }

    @Test
    public void testMergeFinal() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_10K.txt");
        Sort_Array sort = new Sort_Array(arr);
        ICommand command = new CommandsInvoker().invoke(SortAlgorithm.MERGE);
        command.execute(sort, OutputFormat.FINAL);
        int[] res = command.getResult().get(0);
        for(int i = 1; i < res.length; i++)
            Assert.assertTrue(res[i] >= res[i-1]);
    }

    @Test
    public void testRadixFinal() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_10K.txt");
        Sort_Array sort = new Sort_Array(arr);
        ICommand command = new CommandsInvoker().invoke(SortAlgorithm.RADIX);
        command.execute(sort, OutputFormat.FINAL);
        int[] res = command.getResult().get(0);
        for(int i = 1; i < res.length; i++)
            Assert.assertTrue(res[i] >= res[i-1]);
    }

    @Test
    public void testHeapFinal() {
        int[] arr = FileManager.readFile("src/main/java/Tests/Files/Average_10K.txt");
        Sort_Array sort = new Sort_Array(arr);
        ICommand command = new CommandsInvoker().invoke(SortAlgorithm.HEAP);
        command.execute(sort, OutputFormat.FINAL);
        int[] res = command.getResult().get(0);
        for(int i = 1; i < res.length; i++)
            Assert.assertTrue(res[i] >= res[i-1]);
    }

}
