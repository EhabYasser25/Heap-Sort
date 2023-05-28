package Heap;

import java.util.*;

public class GenericHeap<T extends Comparable> {
    ArrayList<T> heapList;
    int size;

    public GenericHeap(){
        heapList = new ArrayList<>();
        size = 0;
    }
    // indices:
    //          0
    //        /   \
    //       1     2
    //      / \   / \
    //     3   4 5   6
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
    private void swap(int i1, int i2){
        T tmp = heapList.get(i1);
        heapList.set(i1, heapList.get(i2));
        heapList.set(i2, tmp);
    }
    public void buildHeap(T[] inputArray){
        size = inputArray.length;
        heapList = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            heapList.add(inputArray[i]);
        }
        for(int i =(size-2)/2 ; i >= 0 ; i--){
            maxHeapify(i ,size);
        }
    }
    public void heapSort(T[] inputArray){
        buildHeap(inputArray);
        for(int i = size - 1; i >= 0 ; i--){
            swap(0, i);
            maxHeapify(0 ,i);
        }
    }
    public void insert(T element){
        heapList.add(element);
        size++;
        int index = heapList.size() -1;
        while( heapList.get(index).compareTo(heapList.get(parent(index))) > 0){
            swap(index , parent(index));
            index = parent(index);
        }
    }


    private boolean isLeaf(int index , int n){
        if(index < n && (firstChild(index) < n || secondChild(index) < n) ){
            return false;
        }
        return true;
    }
    private void maxHeapify(int index , int n){  // where n is the size of the heap
        System.out.println(index +" "+ n);
        while(!isLeaf(index, n)){

            if(firstChild(index) < n && secondChild(index) < n){

                if( heapList.get(index).compareTo(heapList.get(firstChild(index))) < 0 || heapList.get(index).compareTo(heapList.get(secondChild(index))) < 0) {
                    System.out.println(index +" "+ n);
                    if (heapList.get(secondChild(index)).compareTo(heapList.get(firstChild(index))) < 0) {
                        swap(index, firstChild(index));
                        index = firstChild(index);
                    } else {
                        swap(index, secondChild(index));
                        index = secondChild(index);
                    }
                }else{
                    break;
                }
            }else if( firstChild(index) < size ){
                if (heapList.get(index).compareTo(heapList.get(firstChild(index))) < 0) {
                    swap(index, firstChild(index));
                    index = firstChild(index);
                }else{
                    break;
                }
            }
        }
    }

    public T extractMax(){
        T max = heapList.get(0);
        T last = heapList.get(size-1);
        heapList.remove(size-1);
        size--;
        heapList.set(0 , last);
        maxHeapify(0, size);
        return max;
    }
    public int getSize(){
        return size;
    }
}
