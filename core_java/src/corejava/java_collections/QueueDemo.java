package core_java.src.corejava.java_collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueDemo {
    public static void main(String[] args) {
        // ---- Queue Interface Overview ----
        /**
         * Queue is an interface that extends Collection. Core Principle: FIFO (First-In-First-Out).
         * Hierarchy: Queue < Collection < Iterable.
         */

        // --- ArrayDeque Implementation ---
        /**
         * ArrayDeque is a resizable-array implementation of the Deque interface. - No capacity
         * restrictions (it grows as needed). - Faster than Stack when used as a stack, and faster
         * than LinkedList when used as a queue. - Does NOT allow null elements.
         */

        // Using it as a standard Queue (FIFO)
        Queue<Double> queue1 = new ArrayDeque<>();


        queue1.add(12.0);
        queue1.add(5.23);
        queue1.add(34.0);
        queue1.add(31.90);
        queue1.remove(); // removes the first element i.e 12.0


        System.out.println("Current Queue: " + queue1);


        // --- Deque (Double-Ended Queue) Features ---
        /**
         * Deque is an interface which extends Queue Since ArrayDeque implements Deque, we can
         * add/remove from BOTH ends. This makes it useful for stacks (LIFO) or complex buffers.
         */
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1); // Add to front
        deque.addLast(9); // Add to back
        deque.add(13); // add to back only
        deque.addLast(16);
        deque.addFirst(-12);
        deque.poll(); // removes the element in FIFO order
        deque.removeLast();// pop from back



        System.out.println("Deque View: " + deque);

        // using LinkedList, we will implement Dequeue , as we use doubly linkedlist so insertion
        // and deletion are possible and even it is efficent and ensures the insertion and deletion
        // in O(1)
        // but as it creates node and maintains next and prev pointer so it is less memory efficient

        Deque<Integer> dequeueLL = new LinkedList<>();
        dequeueLL.addFirst(10); // insert from front
        dequeueLL.addFirst(20);
        dequeueLL.addLast(30); // insert from rear
        dequeueLL.addLast(40);

        System.out.println("DequeueLL=" + dequeueLL); // [20, 10, 30, 40]


        // --- Priority Queue ---
        // It implements the Queue interface
        // It orders the elements based on some priority
        // can use custom comparator for customized ordering
        // Priority Queue extends Abstract Queue and Abstract Queue implements Queue and Queue
        // extends Collection
        // Priority Queue takes a generic

        /**
         * 1. Hierarchy: PriorityQueue -> AbstractQueue -> Queue -> Collection. 2. Ordering: Does
         * NOT follow FIFO. Elements are ordered by "Natural Priority" (ascending for numbers) or by
         * a custom Comparator. 3. Performance: - O(log n) for insertion (add/offer) and extraction
         * (poll/remove). - O(1) for retrieval of the head (peek). 4. Internal Logic: Built on a
         * Binary Heap data structure. 5. Constraints: Does not allow 'null' elements (needs to
         * compare values). it always gives priority to head of element or top or peek
         */

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(50);
        priorityQueue.add(10);
        priorityQueue.add(20);

        System.out.println("Peek:" + priorityQueue.peek()); // it will give the element peek as 10
        // as priority queue is heap and it always sorts(only the top element not ensures the entire
        // queue) the result and always keeps the natural
        // order at first
        System.out.println("Priority Queue:" + priorityQueue); // this may not display the element
        // in sorted order , use a while loop

        // while (!priorityQueue.isEmpty()) {
        // System.out.println("Element:" + priorityQueue.poll()); // poll returns null if pqueue is
        // // empty it does not return exception
        // }
        /*
         * Output: Element:10 Element:20 Element:50
         */

        priorityQueue.add(-20);
        System.out.println("Peek:" + priorityQueue.peek()); // -20
        while (!priorityQueue.isEmpty()) {
            System.out.println("Element:" + priorityQueue.poll()); // poll returns null if pqueue is
            // empty it does not return exception
        }
        /*
         * Output:Element:-20 Element:10 Element:20 Element:50
         */

        // using comparator to change the ordering or custom ordering

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // acts like max
                                                                                    // heap

        pq.add(-10);
        pq.add(100);
        pq.add(-5);
        pq.add(10);

        System.out.println("peek of priority queue(max heap):" + pq.peek()); // gives 100 as peek

        while (!pq.isEmpty()) {
            System.out.println("Element:" + pq.poll());
        }
        /*
         * Output: Element:100 Element:10 Element:-5 Element:-10
         */
    }
}
