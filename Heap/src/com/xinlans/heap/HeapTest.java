package com.xinlans.heap;

public class HeapTest
{

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
        Heap heap = new Heap();
        
        heap.insert(9);
        heap.insert(7);
        heap.insert(8);
        heap.insert(6);
        heap.insert(5);
        heap.insert(2);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
//        heap.insert(1);
//        heap.insert(2);
//        heap.insert(3);
//        System.out.println(heap);
//        heap.deleteMin();
//        System.out.println(heap);
    }
}//end class
