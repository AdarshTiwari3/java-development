package core_java.src.corejava.core_concepts;

/**
 * Loops and loops in Java i.e for, while, do while and others
 */

public class Loops {
    public static void main(String args[]) {
        int num = 10;

        while (num <= 15) {
            System.out.printf("Number=%d\n", num);
            num++;
        }

        boolean check = false;

        do {
            System.out.println("Runs atleast once");
        } while (check == true);


        for (int i = 1; i <= 10; i++) {
            System.out.println("Number= " + i);
        }
        // Array
        // int[] arr={1,2,3,4,5}; // or int arr[]={1,2,3,4,5}
        // for (int ele : arr) {
        // System.out.println("arr="+ele);
        // }

        // enhanced for loop or for each loop
        int nums[] = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = i + 1;
        }
        for (int val : nums) { // iterate through the values
            System.out.println("num=" + val);
        }
        // inside foreach or enhanced loop we can't change the array value it will throw an error
        // 2D array

        int[][] arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int randomValue = (int) (Math.random() * 10) + 1; // Math.random returns double here
                                                                  // so type casting is needed here
                arr[i][j] = randomValue;
            }
        }
        // print
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("\narr[%d][%d]=%d", i, j, arr[i][j]);
            }
            System.out.println();
        }

        // enhanced for loop
        for (int row[] : arr) { // we can iterate row by row so get the row
            for (int ele : row) { // iterate particular row
                System.out.print(" " + ele);
            }
            System.out.println();
        }



    }
}
