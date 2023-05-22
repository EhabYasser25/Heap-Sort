public class ArrHeap {
    int[] arr;
    int size;
    int maxSize ;

    public ArrHeap(int MaxSize){
        arr = new int[MaxSize];
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
    private void swap(int i1, int i2){
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2]= tmp;
    }
    public void buildHeap(int[] inputArray){
        size = inputArray.length;
        System.out.println(size);
        arr = inputArray;
        for(int i =size/2 -1 ; i >= 0 ; i--){
            System.out.println(i);
            maxHeapify(i,size);
        }
    }
    public void heapSort(int[] inputArray){
        buildHeap(inputArray);
        for(int i = size - 1; i >= 0 ; i--){
            System.out.println("here "+ i);
            swap(0, i);
            maxHeapify(0 ,i);
        }
    }
    public void insert(int element){
        if(size < maxSize) {
            arr[size] = element;
            size++;
            int index = size - 1;
            while (arr[index] > arr[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
    }

    private boolean isLeaf(int index ,int n){
        if((index < n) && (firstChild(index) < n || secondChild(index) < n )){
            return false;
        }
        return true;
    }
    private void maxHeapify(int index , int n){
        while(!isLeaf(index ,n)){
            if(firstChild(index) < n && secondChild(index) < n){
                if(arr[index] < arr[firstChild(index)] || arr[index] < arr[secondChild(index)]) {
                    if (arr[secondChild(index)] < arr[firstChild(index)]) {
                        swap(index, firstChild(index));
                        index = firstChild(index);
                    } else {
                        swap(index, secondChild(index));
                        index = secondChild(index);
                    }
                }else{
                    break;
                }
            }else {
                if (arr[index] < arr[firstChild(index)]) {
                    swap(index, firstChild(index));
                    index = firstChild(index);
                }else{
                    break;
                }
            }
        }
    }

    public int extractMax(){
        int max = arr[0];
        int last = arr[size-1];
        size--;
        arr[0] = last;
        maxHeapify(0,size);
        return max;
    }
    public int getSize(){
        return size;
    }
}
