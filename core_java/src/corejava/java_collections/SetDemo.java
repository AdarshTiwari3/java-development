package core_java.src.corejava.java_collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class SetDemo {
    public static void main(String[] args) {
        // ---- Set Interface in Java Collection ---
        /**
         * Set is an interface that extends collections and Collection interface extends Iterable
         * Set takes a generic type like set of string, set of integer
         * 
         * 1. Hierarchy: Set < Collection < Iterable. 2. Uniqueness: The core property of a Set is
         * that it forbids duplicate elements. 3. Mechanism: Most Sets use an object's hashCode()
         * and equals() to determine uniqueness. 4. Generics: Set<T> ensures type safety for a
         * specific Object type (e.g., String, Integer).
         */

        // HashSet: Best performance (O(1)). Does NOT guarantee any specific order of elements.

        // -------- HashSet -----
        /**
         * HashSet is the most commonly used implementation of the Set interface. * Characteristics:
         * - Performance: O(1) for basic operations (add, remove, contains). - Storage: Uses a
         * HashMap internally (the element is the 'Key', and a dummy 'Value' is used). - Ordering:
         * Does NOT guarantee any iteration order; it can change over time. - Nulls: Allows a single
         * null element.
         */

        Set<Integer> hashset = new HashSet<>();

        hashset.add(10);
        hashset.add(12);
        hashset.add(13);
        hashset.add(12);

        System.out.println("Set=" + hashset); // Set=[10, 12, 13] , it removes the duplicate element
        // and always give the unqiue

        hashset.remove(12);
        System.out.println("HashSet=" + hashset); // Set=[10, 13]


        // -------- LinkedHashSet -----
        /**
         * Maintains Insertion Order: It uses a doubly-linked list running through all of its
         * entries. Use this when you need uniqueness + the order of entry.
         */

        Set<Integer> linkedset = new LinkedHashSet<>();
        linkedset.add(10);
        linkedset.add(15);
        linkedset.add(15);
        linkedset.add(12);

        System.out.println("LinkedHashSet=" + linkedset); // linkedset=[10, 15, 12]


        // -------- linkedset -----
        /**
         * Sorted Order: Implements NavigableSet. Elements are sorted in their 'Natural Order'
         * (Ascending for numbers/alphabets). Performance: O(log n) because it uses a Red-Black
         * Tree.
         */

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(100);
        treeSet.add(10);
        treeSet.add(50);
        // treeSet.remove(11); // returns false
        treeSet.remove(50);
        System.out.println("TreeSet (Sorted): " + treeSet); // [10, 100]



    }
}
