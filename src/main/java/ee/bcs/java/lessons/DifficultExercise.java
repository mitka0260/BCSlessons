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
        //List<String> testList = new ArrayList<>();
        List<String> testList = new MyList();
        testList.add("String1");
        System.out.println(testList.get(0));

    }

}
