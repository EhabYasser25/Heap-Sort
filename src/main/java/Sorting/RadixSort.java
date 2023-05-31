package Sorting;

import java.util.*;

public class RadixSort implements Sort{

    private int ogMin = 0;
    private int maxElement_numOfDigits = 0;
    private final int[] list;
    private final int[][] buckets = new int[10][];

    public RadixSort(int[] array){
        this.list = array.clone();
        int maxIdx = 0, minIdx = 0;

        for(int i = 0; i < list.length; i++){
            if(list[i] > list[maxIdx])
                maxIdx = i;
            if(list[i] < list[minIdx])
                minIdx = i;
        }

        if(this.list[minIdx] < 0){
            this.ogMin = list[minIdx];
            for(int i = 0; i < list.length; i++)
                this.list[i] -= this.ogMin;
        }

        for (int i = 0; i < 10; i++)
            this.buckets[i] = new int[array.length];


        while(list[maxIdx] >= (int)Math.pow(10, maxElement_numOfDigits)) maxElement_numOfDigits++;
    }

    @Override
    public ArrayList<int[]> incremental_sort(){
        int[] sortedList;
        ArrayList<int[]> intermediateLists;

        if(this.ogMin == 0)
            intermediateLists = new ArrayList<>(maxElement_numOfDigits + 1);
        else
            intermediateLists = new ArrayList<>(maxElement_numOfDigits + 2);

        intermediateLists.add(this.list.clone());
        int[] sizes = new int[]{0,0,0,0,0,0,0,0,0,0};
        for(int i = 0, den = 1; i < maxElement_numOfDigits; i++, den *= 10){
            sortedList = new int[this.list.length];
            for (int element : intermediateLists.get(i)){
                int idx = (element / den) % 10;
                buckets[idx][sizes[idx]++] = element;
            }

            int idx = 0;
            for (int b = 0; b < 10; b++){
                for (int s = 0; s < sizes[b]; s++)
                    sortedList[idx++] = buckets[b][s];
                sizes[b] = 0;
            }
            intermediateLists.add(sortedList);
        }

        if(this.ogMin == 0)
            return intermediateLists;

        sortedList = intermediateLists.get(maxElement_numOfDigits).clone();

        for(int i = 0; i < sortedList.length; i++)
            sortedList[i] += this.ogMin;

        intermediateLists.add(sortedList);

        return intermediateLists;
    }

    @Override
    public int[] final_sort() {
        int[] sortedList = this.list.clone();
        int[] sizes = new int[]{0,0,0,0,0,0,0,0,0,0};
        for(int i = 0, den = 1; i < maxElement_numOfDigits; i++, den *= 10){
            for (int element : sortedList) {
                int idx = (element / den) % 10;
                buckets[idx][sizes[idx]++] = element;
            }

            int idx = 0;
            for (int b = 0; b < 10; b++){
                for (int s = 0; s < sizes[b]; s++)
                    sortedList[idx++] = buckets[b][s];
                sizes[b] = 0;
            }
        }

        if(this.ogMin == 0)
            return sortedList;

        for(int i = 0; i < sortedList.length; i++)
            sortedList[i] += this.ogMin;

        return sortedList;
    }

    public static void main(String[] args){
        Sort s = new RadixSort(new int[]{5,-9,2,4,5,-10,54,3});
        for(int[] lst : s.incremental_sort()){
            for (int elem : lst)
                System.out.print(elem + " ");
            System.out.println();
        }
    }
}
