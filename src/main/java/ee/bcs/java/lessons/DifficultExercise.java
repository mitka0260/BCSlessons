package ee.bcs.java.lessons;

/*
    Loo klass mis implementeerib java.util.List-i

    Implementeeri meetodid:
        add(Object a);
        contains(Object o);
        size();
        remove(Object o);

*/

import java.util.ArrayList;
import java.util.List;

public class DifficultExercise {

    public static void main(String[] args) {
        List<String> testList = new MyList();
        testList.add("added string");
        System.out.println(testList.get(0));

        testList.add("second string");
        System.out.println(testList.get(1));

        System.out.println(testList.size());

        System.out.println(testList.contains("second string"));
        System.out.println(testList.contains("something"));
        System.out.println(testList.contains("something"));
        testList.remove("second string");
        System.out.println(testList.size());
        System.out.println(testList.contains("second string"));
        testList.remove("anything");
        System.out.println(testList.size());

    }

}
