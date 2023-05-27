package Sorting;

import java.util.*;

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
            if(!changed) break;
            // Array after each bubble including final array
            steps.add(sortedList.clone());
        }
        return steps;
    }

    @Override
    public int[] final_sort() {
        sortedList = originalList.clone();
        for (int i = sortedList.length; i>=2 ; i--) {
            boolean changed = false;
            for (int j = 1; j < i; j++) {
                if (sortedList[j - 1] >= sortedList[j]) {
                    swap(j - 1, j);
                    changed = true;
                }
            }
            if(!changed)
                break;
        }
        return sortedList;
    }

    private void swap(int i, int j) {
        int temp = sortedList[i];
        sortedList[i] = sortedList[j];
        sortedList[j] = temp;
    }
}
