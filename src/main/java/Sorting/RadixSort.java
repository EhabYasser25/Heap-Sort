package Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort implements Sort{

    private int ogMin = 0;
    private int maxElement_numOfDigits = 0;
    private final int[] list;
    private Queue<Integer>[] buckets = new Queue[10];

    public RadixSort(int[] array){
        this.list = array.clone();
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
                list[i] -= this.ogMin;


        for (int i = 0; i < 10; i++)
            this.buckets[i] = new LinkedList<>();

        while(list[maxIdx] > (int)Math.pow(10, maxElement_numOfDigits)) maxElement_numOfDigits++;
    }
    @Override
    public ArrayList<int[]> incremental_sort(){
        int[] sortedList;
        ArrayList<int[]> intermediateLists = new ArrayList<>(maxElement_numOfDigits + 1);
        intermediateLists.add(this.list);
        for(int i = 0; i < maxElement_numOfDigits; i++){
            sortedList = new int[this.list.length];
            for (int element : intermediateLists.get(intermediateLists.size() - 1))
                buckets[(element / (int)Math.pow(10, i)) % 10].add(element);

            int idx = 0;
            for (Queue<Integer> bucket : buckets)
                while (!bucket.isEmpty())   sortedList[idx++] = bucket.poll();
            intermediateLists.add(sortedList);
        }
        intermediateLists.forEach((lst) -> {
            for (int j = 0; j < lst.length; j++)
                lst[j] += this.ogMin;
        });
        return intermediateLists;
    }

    @Override
    public int[] final_sort() {
        int[] sortedList = this.list.clone();
        for(int i = 0; i < maxElement_numOfDigits; i++){
            for (int element : sortedList)
                buckets[(element / (int)Math.pow(10, i)) % 10].add(element);

            int idx = 0;
            for (Queue<Integer> bucket : buckets)
                while (!bucket.isEmpty())   sortedList[idx++] = bucket.poll();
        }
        for(int i = 0; i < sortedList.length; i++)
            sortedList[i] += this.ogMin;
        return sortedList;
    }

    public static void main(String[] args){
        Sort s = new RadixSort(new int[]{-5,-1000,5,9,-8,2,-3,4,5,10,54,-7,3});
        for(int[] lst : s.incremental_sort()){
            for(int i : lst)
                System.out.print(i + " ");
            System.out.println();
        }

    }
}
