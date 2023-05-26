package Sorting;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort implements Sort{

    private int[] originalList;
    private int[] sortedList;

    public BubbleSort(int[] list) {
        this.originalList = list;
    }

    @Override
    public ArrayList<int[]> incremental_sort() {
        sortedList = originalList.clone();
        ArrayList<int[]> steps = new ArrayList<>();
        steps.add(sortedList.clone()); // Initial array
        boolean changed;
        for (int i = sortedList.length; i>=2 ; i--) {
            changed = false;
            for (int j = 1; j < i; j++) {
                if (sortedList[j - 1] >= sortedList[j]) {
                    swap(j - 1, j);
                    changed = true;
                }
            }
            // Array after each bubble including final array
            if (changed) steps.add(sortedList.clone());
        }
        return steps;
    }

    @Override
    public int[] final_sort() {
        sortedList = originalList.clone();
        for (int i = sortedList.length; i>=2 ; i--)
            for (int j=1 ; j<i ; j++)
                if (sortedList[j-1] >= sortedList[j]) swap(j-1,j);
        return sortedList;
    }

    private void swap(int i, int j) {
        int temp = sortedList[i];
        sortedList[i] = sortedList[j];
        sortedList[j] = temp;
    }
}
