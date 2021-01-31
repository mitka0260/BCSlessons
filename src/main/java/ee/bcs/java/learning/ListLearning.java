package ee.bcs.java.learning;/*
ArrayList - списочный массив
размер можно менять
Внутри каждого объекта типа ArrayList хранится обычный массив элементов

То, что у листа есть, но нет у массивов:
вставка и удаление элементов из середины массива, и чтобы не оставалось дырок
изменение размера:
а) создаётся ещё один массив, в полтора раза больше размера внутреннего массива, плюс один элемент.
б) все элементы из старого массива копируются в новый массив.
в) новый массив сохраняется во внутренней переменной объекта ArrayList, старый массив объявляется мусором (мы просто перестаём хранить на него ссылку).


ArrayList vs LinkedList
ArrayList - обычный массив, при вставке элемента, надо сначала подвинуть другие элементы - медленно
БЫСТРО - взятие и изменение элемента - get, set(add?)

LinkedList - связный список, каждый элемент хранит ссылку на следующий и предыдущий элемент
Чтобы вставить, надо изменить только ссылки его будущих соседей
Но чтобы получить 130ый элемент, надо пройтись по всем. То есть, SET, GET/ADD - МЕДЛЕННО!

SET - присвоить
ADD - добавить

правило: если ты собираешься вставлять (или удалять) в середину коллекции много элементов,
то тебе лучше использовать LinkedList. Во всех остальных случаях – ArrayList
*/

import java.util.ArrayList;
import java.util.List;

public class ListLearning {

    public static void main(String[] Args) {

        List<String> stringList = new ArrayList<>();
        //ArrayList, LinkedList
        stringList.add("abc");
        System.out.println(stringList + "           lisatud abc ning trükitud");
        System.out.println(stringList.get(0) + "           trükitud 0 element");
        stringList.add("cde");
        System.out.println(stringList + "           lisatud cde");

        System.out.println(stringList.contains("abc") + "           kas sisaldab abc");
        stringList.remove("abc");
        System.out.println(stringList.size() + "           size + abc kustutatud");
        stringList.clear();
        System.out.println(stringList + "           kõik cleared");
        stringList.toArray();


        System.out.println();

        ArrayList<String> list = new ArrayList<String>();   //Создание контейнера элементов
        int n = list.size();                                //Получение количества элементов
        list.add(0, "first");                                     //Запись элемента в массив
        System.out.println(list);

        String s = list.get(0);                             //Взятие элемента из коллекции
        System.out.println(s);

        list.add("second");                                        //Добавление элемента в конец
        System.out.println(list);
        list.add(1, "to the middle");                              //Вставка элемента в середину
        list.add(0, "to beginning");                                 //Вставка элемента в начало
        System.out.println(list);
        list.remove(3);                                 //Удаление элемента
        System.out.println(list);

        System.out.println();
        ArrayList<String> list1 = new ArrayList<String>(10);
        for (int i = 0; i < 10; i++) {
            list1.add("Hello" + i);
        }
        System.out.println(list1);

        for (int i = list1.size() - 1; i >= 0; i--)
            System.out.print(list1.get(i) + " ");

    }
}
