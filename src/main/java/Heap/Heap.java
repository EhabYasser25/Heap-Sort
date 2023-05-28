package Heap;

import java.util.*;

public class Heap {
    public int[] heapArray;
    private int[] originalArray;
    private int size;
    private int maxSize ;

    public Heap(int MaxSize){
        heapArray = new int[MaxSize];
        originalArray = new int[MaxSize];
        maxSize = MaxSize;
        size = 0;
    }
    // indices:
    //         0
    //        / \
    //       1   2
    //      / \
    //     3   4
    private int parent(int index){
        int parentIndex;
        parentIndex = (int) Math.floor((index-1)/2);
        return parentIndex;
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
    public void buildHeap(int[] inputArray){
        size = inputArray.length;
        System.out.println(size);
        heapArray = inputArray.clone();
        originalArray = inputArray.clone();
        for(int i =size/2 -1 ; i >= 0 ; i--){
            System.out.println(i);
            maxHeapify(heapArray, i,size);
        }
    }
    public void insert(int element){
        if(size < maxSize) {
            heapArray[size] = element;
            size++;
            int index = size - 1;
            while (heapArray[index] > heapArray[parent(index)]) {
                swap(heapArray, index, parent(index));
                index = parent(index);
            }
        }else{
            throw new IllegalStateException("Heap is full");
        }
    }

    private boolean isLeaf(int index ,int arraySize){
        if((index < arraySize) && (firstChild(index) < arraySize || secondChild(index) < arraySize )){
            return false;
        }
        return true;
    }
    public void maxHeapify(int[] inArray, int index, int n){
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

    public int extractMax(){
        if(size == 0){
            throw new IllegalStateException("Heap is empty");
        }
        int max = heapArray[0];
        int last = heapArray[size-1];
        size--;
        heapArray[0] = last;
        maxHeapify(heapArray, 0,size);
        return max;
    }
    public int getSize(){
        return size;
    }

}
