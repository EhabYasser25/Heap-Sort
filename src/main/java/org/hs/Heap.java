import java.util.ArrayList;

public class Heap <T extends Comparable> {
    ArrayList<T> arr;
    int size;

    public Heap(){
        arr = new ArrayList<>();
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
        T tmp = arr.get(i1);
        arr.set(i1, arr.get(i2));
        arr.set(i2, tmp);
    }
    public void buildHeap(T[] inputArray){
        size = inputArray.length;
        arr = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            arr.add(inputArray[i]);
        }
        for(int i =(size-2)/2 ; i >= 0 ; i--){
            maxHeapify(i ,size);
        }
    }
    public void heapSort(T[] inputArray){
        buildHeap(inputArray);
        for(int i = size - 1; i >= 0 ; i--){
            System.out.println("here "+ i);
            swap(0, i);
            maxHeapify(0 ,i);
        }
    }
    public void insert(T element){
        arr.add(element);
        size++;
        int index = arr.size() -1;
        while( arr.get(index).compareTo(arr.get(parent(index))) > 0){
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

                if( arr.get(index).compareTo(arr.get(firstChild(index))) < 0 || arr.get(index).compareTo(arr.get(secondChild(index))) < 0) {
                    System.out.println(index +" "+ n);
                    if (arr.get(secondChild(index)).compareTo(arr.get(firstChild(index))) < 0) {
                        swap(index, firstChild(index));
                        index = firstChild(index);
                    } else {
                        swap(index, secondChild(index));
                        index = secondChild(index);
                    }
                }else{
                    System.out.println(index +" "+ n);
                    break;
                }
            }else if( firstChild(index) < size ){
                if (arr.get(index).compareTo(arr.get(firstChild(index))) < 0) {
                    swap(index, firstChild(index));
                    index = firstChild(index);
                }else{
                    System.out.println(index +" "+ n);
                    break;
                }
            }
        }
    }

    public T extractMax(){
        T max = arr.get(0);
        T last = arr.get(size-1);
        arr.remove(size-1);
        size--;
        arr.set(0 , last);
        maxHeapify(0, size);
        return max;
    }
    public int getSize(){
        return size;
    }
}
