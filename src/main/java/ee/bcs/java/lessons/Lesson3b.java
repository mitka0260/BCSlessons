package ee.bcs.java.demo.tasks;

import java.util.Arrays;
import java.util.Map;

public class Lesson3b {

    public static void main(String[] args) {
        int[] forSum = {1, 6, 3, 7, 2, 4};
        System.out.println("massiivi elementide summa = " + sum(forSum));
        System.out.println();

        System.out.println("faktoriaal               = " + factorial(5));
        System.out.println("faktoriaal rekursiivselt = " + factorialRec(5));
        System.out.println();
        System.out.println("Massiivi sorteerimine");

        int[] a = {7, 4, 67, 2, 1, 5, 65, 3, 34, 45, 54, 69};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println("           Arrays.sort(a)");

        int[] b = {7, 4, 67, 2, 1, 5, 65, 3, 34, 45, 54, 69};
        bubbleSort(b);
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println("           Bubble Sort");

        int[] c = {7, 4, 67, 2, 1, 5, 65, 3, 34, 45, 54, 69};
        selectionSort(c);
        for (int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");
        System.out.println("           Selection Sort");

        int[] d = {7, 4, 67, 2, 1, 5, 65, 3, 34, 45, 54, 69};
        insertionSort(d);
        for (int i = 0; i < d.length; i++)
            System.out.print(d[i] + " ");
        System.out.println("           Insertion Sort");

        int[] e = {7, 4, 67, 2, 1, 5, 65, 3, 34, 45, 54, 69};
        System.out.println();

        long isPrimeNr = 19;
        System.out.println("Number " + isPrimeNr + " is prime - " + isPrime(isPrimeNr));
        nrFactors(isPrimeNr);
    }

    private static void test(Map<String, String> testMap) {
        testMap.put("test", "test");
    }

    public static int uusSumma(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        return 0;
    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        int sum = 0;
        for (int i = 0; i < x.length; i++)
            sum += x[i];
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        if (x == 0)
            return 1;
        int f = 1;
        for (int i = 1; i <= x; i++)
            f *= i;
        return f;
    }

    public static int factorialRec(int x) {
        if (x == 0)
            return 1;
        if (x == 1)
            return 1;
        return x * factorial(x - 1);
    }

    /*
    Простая и неэффективная, глупая сортировка
    Берётся два элемента, сравниваются и переставляются если второй элемент меньше первого. И так по кругу.
     */
    public static void bubbleSort(int[] a) {   //miks tagastada massiivi??? Препод просто не ограничивал, можно менять исходный массив. Но обычно ученики создаюь новый массив и сортируют в него
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false;
            for (int i = 1; i < a.length; i++) {
                if (a[i] < a[i - 1]) {
                    swap(a, i, i - 1);
                    notSorted = true;
                }
            }
        }
        //System.out.println(Arrays.toString(a));
    }

    /*
    находится самый минимальный элемент и переставляется в начало массива
    В следующую итерацию ищется минимальный элемент, но без первого элемента (он уже на своём месте)
    НЕУСТОЙЧИВАЯ сортировка - переставляются местами одинаковые элементы, что не всегда нужно
     */
    public static void selectionSort(int[] a) {
        for (int j = 0; j < a.length; j++) {
            int min = Integer.MAX_VALUE;
            int tempIndex = 0;
            for (int i = j; i < a.length; i++) {
                if (a[i] < min) {
                    min = a[i];
                    tempIndex = i;
                }
            }
            swap(a, j, tempIndex);
        }
    }

    /*
    Сортировка вставками - устойчивая сортировка (=одинаковые элементы не изменят свой порядок)
     */
    public static void insertionSort(int[] a) {
        for (int left = 0; left < a.length; left++) {

            // Вытаскиваем значение элемента
            int value = a[left];

            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {

                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < a[i]) {
                    a[i + 1] = a[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            a[i + 1] = value;
        }
    }

    public static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static boolean isPrime(long x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        for (long i = 2; i < x - 1; i++) {
            return x % 2 != 0;
        }
        return true;
    }

    public static void nrFactors(long x) {
        long temp = x;
        System.out.print("Numbri jagajad on 1 ");
        for (long factor = 2; factor <= x / factor; factor++) {
            while (x % factor == 0) {
                x /= factor;
                System.out.print(factor + " ");
            }
        }
        if (x > 1)
            System.out.print(x);
        System.out.print(temp);
        System.out.println();
    }

}
