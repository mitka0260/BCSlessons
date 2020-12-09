package ee.bcs.java.lessons;

//http://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class CommonsLangArrayUtils {

    public static void main(String[] args) {

        boolean[] array = new boolean[5];

        System.out.println("add - Copies the given array and adds the given element at the end of the new array");
        System.out.println(ArrayUtils.toString(array));
        boolean[] addedArray = ArrayUtils.add(array, true);
        System.out.println(ArrayUtils.toString(addedArray));
        //addAll, addFirst, clone

        System.out.println(ArrayUtils.contains(addedArray, true));

        System.out.println(ArrayUtils.indexesOf(array, false));

        System.out.println(ArrayUtils.isEmpty(array));
        System.out.println(ArrayUtils.isNotEmpty(array));

        int[] a = {1, 2, 3, 4, 5};
        System.out.println(ArrayUtils.toString(a));
        System.out.println("array is sorted: " + ArrayUtils.isSorted(a));
        ArrayUtils.reverse(a);
        System.out.println(ArrayUtils.toString(a));
        System.out.println("reversed array is sorted: " + ArrayUtils.isSorted(a));
        System.out.println("array after removing element " + ArrayUtils.toString(ArrayUtils.remove(a, 2)));


    }
}
