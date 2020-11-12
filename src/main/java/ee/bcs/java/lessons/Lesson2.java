package ee.bcs.java.lessons;

import java.util.Scanner;

// TODO anna konsoolilt sisseloetud number funktsioonile ette ja prindi välja väljund
public class Lesson2 {
    public static void main(String[] args) {

        System.out.println("Please, tell me some number, I will tell you it's absolute value");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Your number's abs value is " + abs(n));
        //System.out.println(Lesson1.abs(n));
        System.out.println();

        System.out.println("Now I will tell you 10 first even numbers");
        calculateArray(10);
        System.out.println();

        System.out.println("Please tell me ten numbers, I will tell you them in reversed order");
        reverseOrder();
        System.out.println();
        System.out.println();

        System.out.println("Please estimate my multiplying table");
        multiplyingTable(5, 8);
    }

    // Leia arvu absoluutväärtus
    public static int abs(int x) {
        if (x >= 0)
            return x;
        else
            return -x;
    }

    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static void calculateArray(int x) {
        for (int i = 2; i <= (x * 2); i = i + 2)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 1; i <= x; i++) {
            System.out.print(i * 2 + " ");
        }
        System.out.println();

        for (int i = 1; i <= x * 2; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // TODO loe konsoolist sisse 10 täisarvu
    // TODO trüki varem sisestatud arvud välja vastupidises järiekorras
    public static void reverseOrder() {
        Scanner in1 = new Scanner(System.in);
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = in1.nextInt();
        }
        int temp = 0;
        for (int i = 0; i < a.length / 2; i++) {
            temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrg
    // näiteks x = 3 y = 3
    // väljund:
    // 1 2 3
    // 2 4 6
    // 3 6 9
    public static void multiplyingTable(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

}
