package ee.bcs.java.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Fibonacci iteratiivselt = " + fibonacci1(95));
        //for int type max = 47
        //for long type max = 95

        System.out.println("Fibonacci rekursiivselt = " + fibonacci2(7));
        //for int type max = 47
        //for long type max = ??? (too much time to wait)

        System.out.println("Fibonacci rekursiivselt massiiviga = " + fibonacci3(95));
        //for int type m = 47
        //for long type max = 95

        System.out.println();
        /*
        for (int i = 0; i < f.length; i++)
            System.out.print(f[i] + " ");
        */
        System.out.println();
        readFromFile();
        System.out.println();
        reverse("Tere!");
    }

    // TODO
    // Fibonacci arv on defineeritud kui
    // fib(n) = fib(n-1) + fib(n-2)
    // Näiteks: 0 1 1 2 3 5 8 13 ...
    // leia nii mitmes arv fibonacci jadas
    // lahenda iteratiivselt
    public static long fibonacci1(int nr) {
        long[] fib = new long[nr + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        //for (int i = 0; i < nr; i++)
        //System.out.print(fib[i] + " ");
        System.out.println();
        return fib[nr - 1];
    }

    // TODO
    // leia nii mitmes arv fibonacci jadas
    // lahenda rekursiivselt
    public static long fibonacci2(int nr) {
        if (nr == 1)
            return 0;
        if (nr == 2)
            return 1;
        return fibonacci2(nr - 1) + fibonacci2(nr - 2);
    }

    public static long[] f = new long[200];

    public static long fibonacci3(int nr) {

        if (nr == 1)
            return 0;
        if (nr == 2)
            return 1;

        if (f[nr] > 0)
            return f[nr];

        f[nr] = fibonacci3(nr - 1) + fibonacci3(nr - 2);    //мемоизация - сохранение уже выполненных вычислений

        /*
        for (int i = 0; i < f.length; i++)
            System.out.print(f[i] + " ");
        System.out.println();
        */

        return f[nr];
    }

    // TODO Prindi välja faili iga teine täht
    public static void readFromFile() throws FileNotFoundException {
        File myObj = new File("C:\\Users\\mitka\\Desktop\\BCSlessons\\src\\main\\java\\ee\\bcs\\java\\lessons\\Lesson3.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            System.out.println("The length of the string is " + data.length());
            for (int i = 0; i < data.length(); i++) {
                if (i % 2 != 0)
                    System.out.print(data.charAt(i) + " ");
            }
            System.out.println();
            //System.out.println(data.substring(3)); //печать начиная с 3 символа
        }
        myReader.close();
    }

    // TODO tagasta sisestatud String s tagurpidi
    // Näiteks
    // Sisend = "Tere" / Väljund = "ereT"
    public static void reverse(String s) {
        String a = s;
        /*
        //тренируюсь на кошечках
        System.out.println(a + "            and this length is " + a.length());
        String b = a + " maailm";
        System.out.println(b);
        a += " maailm";
        System.out.println(a);
        System.out.println(a.equals(b));
        String c = "Tere! mAAilm";
        System.out.println(a.equalsIgnoreCase(c));
        System.out.println(a.substring(6));
        System.out.println(a.substring(6, 9));
        System.out.println(a.charAt(2));
        */
        System.out.println();

        System.out.println("Your value is                      " + a);
        char[] tere = new char[s.length()];
        System.out.print("Value in reversed order is         ");
        for (int i = 0; i < tere.length; i++) {
            tere[i] = s.charAt(tere.length - 1 - i);
            System.out.print(tere[i]);
        }

        System.out.println();
        System.out.println();
        for (int i = s.length() - 1; i >= 0; i--)
            System.out.print(s.charAt(i));

        System.out.println();
    }

}