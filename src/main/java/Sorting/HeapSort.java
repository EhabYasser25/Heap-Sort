package Sorting;

import java.util.ArrayList;

public class HeapSort implements Sort {
    private int[] originalList;
    private int[] sortedList;
    private ArrayList<int[]> steps;
    public HeapSort(int[] list) {
        this.originalList = list;
        steps = new ArrayList<>();
    }
    private int firstChild(int index){
        int firstChildIndex;
        firstChildIndex = index * 2 + 1;
        return firstChildIndex;
    }
    private int secondChild(int index){
        int secondChildIndex;
        secondChildIndex = index * 2 + 2;
        return secondChildIndex;
    }
    private void swap(int[] inArray, int i1, int i2){
        int tmp = inArray[i1];
        inArray[i1] = inArray[i2];
        inArray[i2]= tmp;
    }
    private boolean isLeaf(int index ,int arraySize){
        if((index < arraySize) && (firstChild(index) < arraySize || secondChild(index) < arraySize )){
            return false;
        }
        return true;
    }
    public void maxHeapifyDown(int[] inArray, int index, int n){
        while(!isLeaf(index ,n)){
            if(firstChild(index) < n && secondChild(index) < n){
                if(inArray[index] < inArray[firstChild(index)] || inArray[index] < inArray[secondChild(index)]) {
                    if (inArray[secondChild(index)] < inArray[firstChild(index)]) {
                        swap(inArray,index, firstChild(index));
                        index = firstChild(index);
                    } else {
                        swap(inArray, index, secondChild(index));
                        index = secondChild(index);
                    }
                }else{
                    break;
                }
            }else {
                if (inArray[index] < inArray[firstChild(index)]) {
                    swap(inArray, index, firstChild(index));
                    index = firstChild(index);
                }else{
                    break;
                }
            }
        }
    }

    @Override
    public ArrayList<int[]> incremental_sort() {
        int size = originalList.length;
        int[] heapArray = originalList.clone();
        //-----------buildHeap--------
        steps.add(heapArray.clone());
        for(int i =size/2 -1 ; i >= 0 ; i--){
            maxHeapifyDown(heapArray,i,size);
            steps.add(heapArray.clone());
        }
        //----------heapSort------------
        for(int i = size - 1; i >= 0 ; i--){
            swap(heapArray, 0, i);
            maxHeapifyDown(heapArray, 0 ,i);
            steps.add(heapArray.clone());
        }
        return steps;
    }

    @Override
    public int[] final_sort() {
        int size = originalList.length;
        int[] heapArray = originalList.clone();
        //-----------buildHeap--------
        for(int i = size/2 -1 ; i >= 0 ; i--){
            maxHeapifyDown(heapArray, i,size);
        }
        //----------heapSort------------
        for(int i = size -1; i >= 0 ; i--){
            swap(heapArray, 0, i);
            maxHeapifyDown(heapArray, 0 ,i);
        }
        sortedList = heapArray.clone();
        return sortedList;

    }
}
