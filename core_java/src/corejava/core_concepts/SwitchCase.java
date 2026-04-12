package core_java.src.corejava.core_concepts;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number (1-7)");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Its not Monday or Tuesday");
                break;
        }
        sc.close();
    }
}
