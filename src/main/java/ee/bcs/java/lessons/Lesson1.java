package ee.bcs.java.lessons;

public class Lesson1 {

    public static void main(String[] args) {

        System.out.println("Hello World");
        System.out.println(String.format("Hello World, %s!", "mitka")); //args[0]
        System.out.println("Hello World, " + "mitka" + "!");            //args[0]
        System.out.println("Min value is = " + min(-3, 5));
        System.out.println("Absolute value is = " + abs(-8));
        System.out.println("Negative value is = " + neg(-8));
        System.out.println("closest to zero is = " + closestToZero(-5, 3, 4));
        System.out.println("closest to zero is = " + closestToZero(-5, -2, 0));
        System.out.println("Number is even - " + isNumberEven(-10));
        System.out.println(seq3n(7));
        System.out.println("max value is " + max(2, 9, 4));
        System.out.println("largest even number is " + largestEven(-6, -8));
        System.out.println();

        int[] b = {1, 2, 4, 7, 5, 9, 8, 10, 9, -10};
        //System.out.println(closestTo(6, b));
        System.out.println(closestTo1(6, b));
        System.out.println(closestTo2(6, b));

        /*
        int a = 5;
        if (a > 5) {
            System.out.println("a>5");
        } else if (a < 5) {
            System.out.println("a<5");
        } else {
            System.out.println("a==5");
        }
         */

    }

    // leia 2 arvu miinimum väärtus
    // Näited:
    // min (3, 5) = 3
    // min (-3, 8) = -3
    public static int min(int a, int b) {
        if (a > b)
            return b;
        else
            return a;
    }

    // TODO: Leia arvu absoluutväärtus
    // Näited:
    // abs(3) = 3
    // abs(-5) = 5
    public static int abs(int a) {
        if (a >= 0)
            return a;
        else
            return -a;
    }

    // TODO: Luua funktsioon, mis tagastab vastava arvu alati negatiivsena
    // Näited:
    // neg(0) = 0
    // neg(-1) = -1
    // neg(8) = -8
    public static int neg(int a) {
        if (a >= 0)
            return -a;
        else
            return a;
        //return -abs(a);
    }

    // TODO: Luua funktsioon mis leiab sisend muutujates numbri mis on kõige lähemal 0-ile
    // Näited
    // (-5, -2, 0) -> 0
    // (2, 3, 4) -> 2
    public static int closestToZero(int a, int b, int c) {
        /*
        не работает как надо. Если введено -2, 5, 6, метод ответит 2, а должен "-2".
        int[] array = new int[3];
        array[0] = abs(a);
        array[1] = abs(b);
        array[2] = abs(c);
        int inf = (int) Double.POSITIVE_INFINITY;
        for (int i = 0; i < 3; i++) {
            if (array[i] < inf)
                inf = array[i];
        }
        return inf;
        */

        if (abs(a) <= abs(b) && abs(a) <= abs(c))
            return a;
        else if (abs(b) <= abs(a) && abs(b) <= abs(c))
            return b;
        else //if (abs(c) < abs(a) && abs(c) < abs(b))  //если написать так, он подумает что может быть случай не включённый в выборку и выдаст ошибку
            return c;
    }

    // TODO: Luua funktsioon, mis tagastab kas a on paaris arv
    // Näited
    // isNumberEven(4) = true
    // isNumberEven(1) = false
    public static boolean isNumberEven(int a) {
        if (a % 2 == 0)
            return true;
        else
            return false;
        // return a%2==0;
    }

    // TODO: Luua funktsioon, mis
    // Juhul kui a on paaris arv, siis jaga sisend 2
    // Juhul kui a on paaritu arv, siis korruta sisend 3 ja liida 1

    /**
     * @param a
     * @return
     */
    public static int seq3n(int a) {
        if (a % 2 == 0)             //if(isNumbereven(a))
            return (a / 2);
        else
            return (a * 3 + 1);
    }

    // TODO tagasta maksimum väärtus
    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    // TODO tagasta maksimum väärtus
    public static int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        else if (b >= a && b >= c)    //здесь не надо одного их этих условий. Пока не знаю, почему
            return b;
        else
            return c;
    }

    // TODO tagasta suurim paaris arv
    // Kui kumbki arv ei ole paaris siis tagasta 0
    public static int largestEven(int a, int b) {
        if (a % 2 != 0)
            a = Integer.MIN_VALUE;
        if (b % 2 != 0)
            b = Integer.MIN_VALUE;
        if (a == b && a == Integer.MIN_VALUE) //если задать два числа Integer.MIN_VALUE - будет лажа
            return 0;
        return max(a, b);

	/*
	int maxEvenNumber = Integer.MIN_VALUE;
        if(isNumberEven(a) && a > maxEvenNumber){
            maxEvenNumber = a;
        }
        if (isNumberEven(b) && b > maxEvenNumber) {
            maxEvenNumber = b;
        }
        if(isNumberEven(c) && c > maxEvenNumber) {
            maxEvenNumber = c;
        }
        if(isNumberEven(a) || isNumberEven(b) || isNumberEven(c)){
            return maxEvenNumber;
        } else {
            return 0;
        }
	*/

    }
    /*
    if(isNumberEven(a) && isNumberEven(b))
        return max(a, b);
    else if (isNumberEven(a))
        return a;
    else if (isNumberEven(b))
        return b;
    return 0;
    */

    //TODO tagasta listist arv, mis kõige lähem numbrile nr
    public static int closestTo(int nr, int[] numbers) {
        int[] temp = new int[numbers.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = abs(nr - numbers[i]);
            System.out.print(temp[i] + " ");
        }
        System.out.println();
        int min = (int) Double.POSITIVE_INFINITY;
        for (int i = 0; i < temp.length; i++) {
            if (min > temp[i])
                min = temp[i];
        }
        int v = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == min)
                v = i;
        }
        return numbers[v];
    }

    public static int closestTo1(int nr, int[] numbers) {
        int min = (int) Double.POSITIVE_INFINITY;
        int temp = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (abs(nr - numbers[i]) < min) {
                min = abs(nr - numbers[i]);
                temp = i;
            }
        }
        return numbers[temp];
    }

    //так лучше, потому что не будет ошибки если одно из значений будет == Integer.MAX_VALUE
    public static int closestTo2(int nr, int[] numbers) {
        int minDistance = Math.abs(nr - numbers[0]);
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (Math.abs(nr - numbers[i]) < minDistance) {
                minDistance = Math.abs(nr - numbers[i]);
                minIndex = i;
            }
        }
        return numbers[minIndex];
        // TODO 1 | trükkige välja kõik numbers massivis olevad väärtused
        // TODO 2 | trükkge välja kõigi elementide kohta kui kaugel nad on nr
        // TODO 3 | salvestage miinimum number muutujasse
    }

}
