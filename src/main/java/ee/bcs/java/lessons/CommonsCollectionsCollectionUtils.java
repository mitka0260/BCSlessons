package ee.bcs.java.lessons;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CommonsCollectionsCollectionUtils {

    public static void main(String[] args) {

        List<String> list = new LinkedList<String>();

        CollectionUtils.addIgnoreNull(list, null);
        CollectionUtils.addIgnoreNull(list, "a");

        System.out.println(list);

        if (list.contains(null)) {
            System.out.println("collection contains null");
        } else {
            System.out.println("collection does not contain null");
        }

        // ============================

        List<String> sortedList1 = Arrays.asList("A", "C", "E");
        List<String> sortedList2 = Arrays.asList("B", "D", "F");

        //объединение двух уже отсортированных списков
        List<String> mergedList = CollectionUtils.collate(sortedList1, sortedList2);
        System.out.println(mergedList);

        // =============================

        //преобразуем список строк в список целых чисел
        List<String> stringList = Arrays.asList("1", "2", "3");
        List<Integer> integerList = (List<Integer>) CollectionUtils.collect(stringList, new Transformer<String, Integer>() {
            @Override
            public Integer transform(String input) {
                return Integer.parseInt(input);
            }
        });
        System.out.println(integerList);

        // =============================

        List<Integer> integerList1 = new ArrayList<>();
        integerList1.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println("Original list: " + integerList1);

        CollectionUtils.filter(integerList1, new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer input) {

                if (input.intValue() % 2 == 0)
                    return true;
                else
                    return false;
            }
        });
        System.out.println("Filtered list: " + integerList1);

        // =============================

        //отфильтруем список целых чисел, чтобы получить только нечетные числа
        List<Integer> integerList2 = new ArrayList<>();
        integerList2.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("Original list: " + integerList2);

        CollectionUtils.filterInverse(integerList2, new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer input) {
                if (input.intValue() % 2 == 0) {
                    return true;
                } else {
                }
                return false;
            }
        });
        System.out.println("Filtered list: " + integerList2);

        // =============================

        //проверки, содержит ли коллекция данную коллекцию или нет
        List<String> list1 = Arrays.asList("A", "A", "A", "C", "B", "B");
        List<String> list2 = Arrays.asList("A", "A", "B", "B");
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("Is list 2 contained on list1: " + CollectionUtils.isSubCollection(list2, list1));

        // =============================
        // получения общих объектов между двумя коллекциями (пересечение).
        System.out.println("Commons objects of list1 and lis2: " + CollectionUtils.intersection(list1, list2));

        // =============================
        // получения новой коллекции путем вычитания объектов одной коллекции из другой
        System.out.println("list1 - list2: " + CollectionUtils.subtract(list1, list2));

        // =============================
        // объединение двух коллекций
        System.out.println("Union of list1 and list2: " + CollectionUtils.union(list1, list2));
    }

}
