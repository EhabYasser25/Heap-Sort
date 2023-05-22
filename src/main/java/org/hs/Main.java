import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrHeap h = new ArrHeap(10);
        int[] ar ={0 ,100 ,200 ,300 ,400 ,500 ,600 ,700 ,800 ,900, 1200} ;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 1000; i +=100) {
            //h.insert(i);
            pq.add(i);
        }
        h.heapSort(ar);
        for (int i :
                h.arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i :
                pq) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(h.getSize());
        System.out.println(Math.floor((0-1)/2));

        System.out.println();
        System.out.println(h.extractMax());
        System.out.println(pq.poll());
        for (int i = 0 ;i< h.size;i++
                ) {
            System.out.print(h.arr[i] + " " );
        }
        System.out.println();
        for (int i :
                pq) {
            System.out.print(i + " ");
        }
    }
}