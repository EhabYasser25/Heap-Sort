package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort implements Sort{
    int[] originalList;
    int[] sortedList;
    ArrayList<int[]> steps;

    public MergeSort(int[] list){
        originalList = list;
    }

    private void mergeSort(int start, int end, boolean steps) {
        if(start >= end) return;
        int mid = (start+end)/2;
        mergeSort(start,mid,steps);
        mergeSort(mid+1,end,steps);
        merge(start,mid,end,steps);
    }

    private void merge(int start, int mid, int end, boolean steps) {
        if (!steps && sortedList[mid] <= sortedList[mid+1]) return;
        int index1 = start, index2 = mid+1, index3 = 0;
        int[] merged = new int[end-start+1];
        while(index1 <= mid && index2 <= end) {
            if (sortedList[index1] < sortedList[index2])
                merged[index3++] = sortedList[index1++];
            else
                merged[index3++] = sortedList[index2++];
        }
        if (index1 == mid+1)
            while(index2 <= end) merged[index3++] = sortedList[index2++];
        if (index2 == end+1)
            while(index1 <= mid) merged[index3++] = sortedList[index1++];
        for(int i=start, j=0 ; i<=end ; i++,j++) sortedList[i] = merged[j];

        if (steps) this.steps.add(merged);
    }

    @Override
    public ArrayList<int[]> incremental_sort() {
        sortedList = originalList.clone();
        steps = new ArrayList<>();
        mergeSort(0, sortedList.length-1, true);
        return steps;
    }

    @Override
    public int[] final_sort() {
        sortedList = originalList.clone();
        mergeSort(0, sortedList.length-1, false);
        return sortedList;
    }

    public static void main(String[] args){
        Sort s = new MergeSort(new int[]{-5,-1000,5,9,-8,2,-3,4,5,10,54,-7,3});
        System.out.println("\nSorting without steps: ");
        System.out.println(Arrays.toString(s.final_sort()));
        System.out.println("\nSorting with steps: ");
        for(int[] lst : s.incremental_sort()){
            System.out.println(Arrays.toString(lst));
        }
    }
}
