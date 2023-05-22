package org.hs.Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort implements Sort{

    private int ogMin = 0;
    private int maxElement_numOfDigits = 0;
    private final int[] list;
    private Queue<Integer>[] buckets = new Queue[10];

    public RadixSort(int[] list){
        int maxIdx = 0, minIdx = 0;

        for(int i = 0; i < list.length; i++){
            if(list[i] > list[maxIdx])
                maxIdx = i;
            if(list[i] < list[minIdx])
                minIdx = i;
        }

        this.ogMin = list[minIdx];

        if(this.ogMin < 0)
            for(int i = 0; i < list.length; i++)
                list[i] += this.ogMin;


        for (int i = 0; i < 10; i++)
            this.buckets[i] = new LinkedList<>();

        while(list[maxIdx] > (int)Math.pow(10, maxElement_numOfDigits)) maxElement_numOfDigits++;
        this.list = list;
    }
    @Override
    public ArrayList<int[]> incremental_sort(){
        int[] sortedList;
        ArrayList<int[]> intermediateLists = new ArrayList<>(maxElement_numOfDigits);
        for(int i = 0; i < maxElement_numOfDigits; i++){
            sortedList = new int[this.list.length];
            for (int element : list)
                buckets[(element / (int)Math.pow(10, i)) % 10].add(element);

            int idx = 0;
            for (Queue<Integer> bucket : buckets)
                while (!bucket.isEmpty())   sortedList[idx++] = bucket.poll();
            intermediateLists.add(sortedList);
        }
        return intermediateLists;
    }

    @Override
    public int[] final_sort() {
        int[] sortedList = new int[this.list.length];
        for(int i = 0; i < maxElement_numOfDigits; i++){
            for (int element : list)
                buckets[(element / (int)Math.pow(10, i)) % 10].add(element);

            int idx = 0;
            for (Queue<Integer> bucket : buckets)
                while (!bucket.isEmpty())   sortedList[idx++] = bucket.poll();
        }
        return sortedList;
    }
}
