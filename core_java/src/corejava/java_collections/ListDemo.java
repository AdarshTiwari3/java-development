package core_java.src.corejava.java_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * Here we will learn all the collection interfaces provided by the Collection Framework.
 */
public class ListDemo {
    public static void main(String[] args) {
        // List is an interface that extends the Collection interface.
        // The Collection interface, in turn, extends the Iterable interface.

        // Key characteristics of List:
        // 1. Ordered collection (maintains insertion order).
        // 2. Allows duplicate elements.
        // 3. Allows positional access (you can get an item by its index).

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(2);
        arrayList.add(23);
        arrayList.set(2, 9); // it will replace value on index 2


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("arrList=" + arrayList.get(i));
        }

        arrayList.forEach((num) -> System.out.println(num));

        for (Integer num : arrayList) {
            System.out.println("Arr=" + num);
        }

        Collections.sort(arrayList);
        System.out.println("After Sorting...");
        arrayList.forEach((num) -> System.out.println(num));

        arrayList.add(0, 100); // it will add the value at index 0 and rest will be shifted to right
                               // side
        arrayList.sort(null); // it tells to sort in ASC order
        System.out.println("After List Sorting...");
        arrayList.forEach((num) -> System.out.println(num));

        arrayList.sort(Comparator.reverseOrder());
        System.out.println("After List reversed Sorting...");
        arrayList.forEach((num) -> System.out.println(num));

        // array of string

        List<String> stringList = Arrays.asList("Shyam", "Rohit", "Ram");

        // stringList.add("Test"); // now allowed it creates a fixed size of list
        stringList.forEach((ele) -> System.out.println(ele));

        arrayList.remove(Integer.valueOf(23)); // remove value from array
        arrayList.forEach((num) -> System.out.println(num));

        boolean isTrue = arrayList.contains(100);
        System.out.println("9 found at index:" + (arrayList.indexOf(9) + 1));
        System.out.println("Is True=" + isTrue);

        stringList.sort((a, b) -> a.length() - b.length()); // sort the string array by length
        System.out.println(stringList);



        // ------- LinkedList -----
        // It is provided by Collection framework it works on doubly linked list
        // each element is wrapped in a node which points to another nodes address

        LinkedList<String> linkedlist = new LinkedList<>();
        linkedlist.add("Tom");
        linkedlist.add("Superman");
        linkedlist.add("Thor");
        linkedlist.add("Toa");
        linkedlist.add("Spiderman");
        linkedlist.add("Shaktiman");


        System.out.println("Size of linkedList is: " + linkedlist.size());
        linkedlist.sort(null);// linkedin list sorting is not a best practice as it takes O(n x n)
                              // time
        System.out.println(linkedlist); // although it is not a best practice
        linkedlist.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(linkedlist);

        for (String s : linkedlist) {
            System.out.println("ele=" + s);
        }
        // sort by first char
        linkedlist.sort((s1, s2) -> Character.compare(s1.charAt(0), s2.charAt(0)));
        System.out.println(linkedlist);
        // first sort by first char then last
        linkedlist.sort(Comparator.comparing((String s) -> s.charAt(0))
                .thenComparing(s -> s.charAt(s.length() - 1)));
        System.out.println(linkedlist);


        // ------ Vector ------
        // Vector is also an implementation of List Interface
        // Vector is thread safe or synchronized
        // but it is slow because of thread overhead
        // Vector also follows the dynamic array size concept of ArrayList
        // It was even available before collection framework

        Vector<Integer> vectorList = new Vector<>(); // after new keyword Vector<>() is a
                                                     // constructor which calls the Vector class

        vectorList.add(23);
        vectorList.add(11);
        vectorList.add(-29);
        vectorList.add(1);
        vectorList.add(100);

        // unlike other lists we can check vector capacity also, default capacity are always set as
        // 10, in arraylist the capacity are increased by 1.5 times here it is 2 time bydefault and
        // even we can give our custom capacity increments inside Vector constructor
        int capacity = vectorList.capacity(); // The total amount of space allocated in memory not
                                              // the vector size
        System.out.println("Capacity:" + capacity);
        vectorList.sort(null);
        System.out.println("vector list=" + vectorList);
        // sort in reverse
        vectorList.sort(Comparator.reverseOrder());
        System.out.println("vector list=" + vectorList);

        // ---- Stack ----
        // Stack extends Vector class

        Stack<Integer> stack = new Stack<>(); // LIFO order
        stack.push(12);
        stack.push(33);
        stack.push(-10);



        System.out.println("Stack:" + stack);
        Integer top = stack.peek();
        stack.pop();
        System.out.println("Top:" + top);
        System.out.println("Stack:" + stack);



    }
}
