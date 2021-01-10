package ee.bcs.java.learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {

        String[] array1 = {"мама", "мыла", "раму"};
        String[] array2 = {"я", "очень", "люблю", "JAVA"};
        String[] array3 = {"мир", "труд", "май"};

        List<String[]> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

        Comparator<String[]> sortByLength = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1.length - o2.length;
            }
        };

        //the same but replaced with lambda
        Comparator<String[]> sortByLengthLambda = (o1, o2) -> o1.length - o2.length;

        arrays.sort(sortByLength);

        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.get(i).length; j++) {
                System.out.print(arrays.get(i)[j] + " ");
            }
            System.out.println();
        }

        Comparator<String[]> sortByWordsLength = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int length1 = 0;
                int length2 = 0;
                for(String s : o1)
                    length1 += s.length();
                for(String s : o2)
                    length2 += s.length();
                return length1 - length2;
            }
        };

        Comparator<String[]> sortByWordsLengthLambda = (o1, o2) -> {
            int length1 = 0;
            int length2 = 0;
            for(String s : o1)
                length1 += s.length();
            for(String s : o2)
                length2 += s.length();
            return length1 - length2;
        };

        arrays.sort(sortByWordsLength);
        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.get(i).length; j++) {
                System.out.print(arrays.get(i)[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        arrays.forEach(x -> System.out.println(x));

    }
}
