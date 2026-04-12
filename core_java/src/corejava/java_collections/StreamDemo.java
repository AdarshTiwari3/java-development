package core_java.src.corejava.java_collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        // Streams

        // Stream API are used to process collections of data in a functional or declarative manner
        // It simplifies data processing
        // It gives functional programming powers to write the code i.e lambda expressions
        // It also improves the readability and maintainability
        // It also enables easy parallelism without multithreading

        /**
         * A Stream is NOT a data structure (it doesn't store data). It is a pipeline that pulls
         * data from a source (Collection, Array, I/O) and transforms it without modifying the
         * original source (Immutability).
         */


        // What Stream is?
        // A Sequence of elements supportings functional and declarative programming
        // Three Stages of stream Source, Intermediate Operations and Terminal Operation

        // --- The 3 Stages of a Stream Pipeline ---
        /**
         * 1. Source: Where data comes from (Collection, Array, I/O channel). 2. Intermediate
         * Operations: Transformations (filter, map, sorted). - These are LAZY (they don't execute
         * until a terminal operation is called). - They return a NEW stream, keeping the original
         * data immutable. 3. Terminal Operation: The trigger (collect, forEach, reduce, count). -
         * This produces a result or a side-effect and closes the stream.
         */

        List<String> fruits = Arrays.asList("Apple", "Banana", "Apricot", "Blueberry", "Cherry");
        // --- The 3 Stages in Action ----
        List<String> res = fruits.stream() // stage 1 --> Source
                .filter((f) -> f.startsWith("A")) //// STAGE 2: Intermediate (Filtering)
                .map(String::toUpperCase) // STAGE 2: Intermediate (Transforming)
                .sorted() // STAGE 2: Intermediate (Sorting)
                .collect(Collectors.toList()); // STAGE 3: Terminal (Closing)
        // here we can also call directly .toList() in terminal stage but this will return immutable
        // list which can not be modified and when you are call Collectors.toList() it gives a
        // mutable list(ArrayList)
        System.out.println("Res=" + res);


        List<Integer> nums = Arrays.asList(1, 2, 3, 9, -10, 4, 4, 5, 5, 6); // this creates a fixed
        // size array
        // nums.add(21); it will throw an exception we can not add or remove from Array.asList()

        System.out.println("nums:" + nums);
        List<Integer> numsarray = nums.stream() // Source stage
                .filter(num -> num > 0) // Intermediate Stage
                .distinct() // Intermediate Stage
                .map(num -> num * num) // Intermediate Stage
                .sorted() // Intermediate Stage
                .skip(2). // Intermediate Stage
                limit(2). // Intermediate Stage
                toList(); // Terminal Stage
        numsarray.forEach(num -> System.out.println("num=" + num));
        // num=9
        // num=16

        // numsarray.add(45); // not allowed it will throw an exception
    }
}
