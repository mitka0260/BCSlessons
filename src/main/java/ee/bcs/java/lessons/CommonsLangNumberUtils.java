package ee.bcs.java.lessons;

//http://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html

import org.apache.commons.lang3.math.NumberUtils;

public class CommonsLangNumberUtils {

    public static void main(String[] args) {

        System.out.println("Compares two int values numerically");
        System.out.println("the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y");
        System.out.println(NumberUtils.compare(123, 123));

        System.out.println();
        System.out.println("createNumber () - позволяет нам создать числовое представление string");
        Number a = NumberUtils.createNumber("123456");  //java.lang.Number
        System.out.println(a);

        System.out.println();
        System.out.println("isDigit () - проверяет, состоит ли string только из цифр");
        System.out.println(NumberUtils.isDigits("123456"));

        System.out.println();
        System.out.println("max");
        int[] b = {1, 2, 3, 4, 5, 6};
        System.out.println(NumberUtils.max(b));

        System.out.println();
        System.out.println("min");
        System.out.println(NumberUtils.min(b));

        System.out.println();
        System.out.println("String 123 toInt: " + NumberUtils.toInt("123"));
        System.out.println("String abc toInt: " + NumberUtils.toInt("abc"));
        System.out.println("String abc with default return toInt: " + NumberUtils.toInt("abc", 666));

        System.out.println();
        System.out.println("toScaledBigDecimal: " + NumberUtils.toScaledBigDecimal(123.12345667));
        System.out.println("toScaledBigDecimal: " + NumberUtils.toScaledBigDecimal(123.12645667));



    }

}
