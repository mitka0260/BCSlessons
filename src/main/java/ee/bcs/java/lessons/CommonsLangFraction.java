package ee.bcs.java.lessons;

//http://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html

import org.apache.commons.lang3.math.Fraction;

public class CommonsLangFraction {

    public static void main(String[] args) {
        Fraction fr = Fraction.getFraction(3, 5);
        System.out.println(fr); //просто печатает числитель + / + знаменатель

        Fraction fr1 = Fraction.getFraction(1, 1, 2);   //прибавляет к числителю сколько надо чтобы не осталось целой части
        System.out.println("1 1/2 becomes: " + fr1);

        Fraction fr3 = Fraction.getReducedFraction(2, 4);   //сокращает дробь
        System.out.println("2/4 becomes: " + fr3);

        Fraction fr4 = Fraction.getFraction(1.5);
        System.out.println("1.5 becomes: " + fr4);

        System.out.println("Numerator of 3/2 is: " + fr4.getNumerator());
        System.out.println("The whole part of 3/2 is: " + fr4.getProperWhole());
        System.out.println("Proper numerator of 3/2 is: " + fr4.getProperNumerator());
        System.out.println("Denominator of 3/2 is: " + fr4.getDenominator());
        System.out.println("Inverted fraction 3/2 is: " + fr4.invert());
        System.out.println("Negative fraction 3/2 is: " + fr4.negate());

        Fraction a = Fraction.getFraction(1, 4);
        Fraction b = Fraction.getFraction(3, 4);
        System.out.println(a.add(b));
        System.out.println(a.multiplyBy(b));



    }
}
