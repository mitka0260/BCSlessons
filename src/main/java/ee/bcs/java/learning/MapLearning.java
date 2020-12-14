package ee.bcs.java.learning;
/*
ассоциативный массив, словарь, карта или мапа

Внутри Map данные хранятся в формате “ключ”-”значение”, то есть по парам. И в качестве ключей,
и в качестве значений могут выступать любые объекты — числа, строки или объекты других классов

Ключ может быть только один на всю мапу - они уникальны - НЕЛЬЗЯ СОЗДАТЬ МАПУ С 2 == КЛЮЧАМИ

--------------------

существуют 3 основные реализации интерфейса Map:

HashMap
элементы не в порядке добавления
порядок элементов может меняться
позволяет иметь ключ и значение null
не синхронизирована

TreeMap
элементы в порядке добавления (или по компаратору)
позволяет иметь ключ и значение null только если позволяет компаратор
Если компаратор не используется, то null нельзя
не синхронизирована

Hashtable
элементы не в порядке добавления
порядок элементов может меняться
НЕ позволяет иметь ключ и значение null
синхронизирована
Потокобезопасна

------------------
Set – это множество – куча ненумерованных объектов. Главная особенность Set – в нем только уникальные объекты, т.е. они все разныe.
Добавлять элемент(ы)            add(), addAll()
Удалять элемент(ы)              remove(), removeAll()
Проверять, есть ли элемент(ы)   contains(), containsAll()
кол-во элементов                size()

--------------------
Map:
Получить множество всех пар         entrySet()
Получить множество всех ключей      keySet()
Получить множество всех значений    values()
Добавить пару	                    put(key, value)
Получить значение по ключу          get(key)
Проверить наличие «ключа»           containsKey(key)
Проверить наличие «значения»        containsValue(value)
Проверить что Map — пустой          isEmpty()
Очистить Map	                    clear()
Удалить элемент по ключу	        remove(key)
-------------------------------------------------
HashMap:
Хеш-таблицей называется структура данных, реализующая интерфейс ассоциативного массива
(абстрактная модель «ключ – значение» или entry), которая обеспечивает очень быструю вставку и поиск.
По сути, это обычный массив, где местоположение элемента зависит от значения самого элемента.
Связь между значением элемента и его позицией в хеш-таблице задает хеш-функция.

Хеш-функция получает входную часть данных, которую мы называем ключом, а на выходе она выдает целое число,
известное как хеш-значение (или хеш-код). Затем, хеш-значение привязывает наш ключ к определенному индексу хеш-таблицы.
Для основных операций: вставки, поиска и удаления мы используем одну и ту же хеш-функцию,
поэтому эти операции осуществляются довольно быстро.
По этой причине важно, чтобы хеш-функция вела себя последовательно и выводила один и тот же индекс
для одинаковых входных данных.

*/

import java.util.*;

public class MapLearning {

    public static void main(String[] args) {

        HashMap<Integer, String> passAndNames = new HashMap<>();

        //добавим новые пару в мапу
        passAndNames.put(215643, "Митяй");
        passAndNames.put(456123, "Гриша");
        System.out.println(passAndNames + "    вся мапа");   //map имеет переопределённый метод toString, поэтому так можно
        passAndNames.put(456123, "Петя");   //не будет добавлен, т.к ключ такой уже есть, будет ПЕРЕЗАПИСАН
        System.out.println(passAndNames + "     перезаписали Гришу на Петю");

        //доступ осуществляется только ПО КЛЮЧУ!!!
        String mitkaName = passAndNames.get(215643);
        System.out.println(mitkaName + "                           достали значение по ключу");
        passAndNames.remove(456123);
        System.out.println(passAndNames + "                  удалили значение по ключу");
        //ИНДЕКСОВ НЕТ

        //Проверка наличия ключа и значения
        System.out.println(passAndNames.containsKey(123454) + "                           содержит ли данный ключ");
        System.out.println(passAndNames.containsValue("Митяй") + "                            содержит ли данное значение");

        //Получение списка всех ключей и значений
        Set<Integer> keys = passAndNames.keySet(); //коллекция set - в ней не может быть повоторов
        System.out.println(keys + "                        список всех ключей мапы");

        ArrayList<String> values = new ArrayList<>(passAndNames.values());
        System.out.println(values + "                         список всех значений мапы");

        System.out.println(passAndNames.size() + "                               размер мапы");
        passAndNames.clear();
        System.out.println(passAndNames + "                              зачистили мапу");

        if (!passAndNames.isEmpty())
            System.out.println(passAndNames + "                Проверка, пустая ли мапа");
        System.out.println(passAndNames.isEmpty() + "                            Проверка, пустая ли мапа");

        HashMap<Integer, String> boys = new HashMap<>();
        HashMap<Integer, String> girls = new HashMap<>();
        boys.put(54654, "Петя");
        boys.put(54655, "Гриша");
        boys.put(54656, "Вася");

        girls.put(54657, "Лена");
        girls.put(54658, "Катя");
        girls.put(54659, "Анжела");
        boys.putAll(girls);
        System.out.println(boys + "         Объеденили мапы");

        //перебор мапы в цикле
        //Интерфейс Map.Entry обозначает пару “ключ-значение” внутри словаря
        //Метод entrySet() возвращает список всех пар в нашей HashMap
        //мы перебираем именно пары
        for (Map.Entry entry : girls.entrySet())
            System.out.print(entry + " ");
        System.out.println("                вывели всю мапу циклом");

        for (Map.Entry<Integer, String> entry : girls.entrySet()) {
            Integer key = entry.getKey();
            System.out.print(key + " ");
        }
        System.out.println("                вывели все ключи");

        for (Map.Entry<Integer, String> entry : girls.entrySet()) {
            String value = entry.getValue();
            System.out.print(value + " ");
        }
        System.out.println("                 вывели все значения");


        //как сделать ArrayList из Map
        //лист ключей
        List<Integer> keyList = new ArrayList<>(girls.keySet());       //возвращает множество(Set) ключей
        System.out.print(keyList + "    все ключи");
        System.out.println();

        //лист значений
        List<String> valueList = new ArrayList<>(girls.values());     //возвращает коллекцию(Collection) значений
        System.out.print(valueList + "    все значения");
        System.out.println();

        //лист ключ-значения
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(girls.entrySet());   //возвращает множество(Set) наборов “ключ-значение”
        System.out.print(entryList + "    все пары");
        System.out.println();

        //Сортировка мап
        //метод 1
        //Поместить Map.Entry в список и отсортировать его, используя Comparator
        List<Map.Entry<Integer, String>> list = new ArrayList<>(boys.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        //всё это короче (нужно знать лямбды)
        //Collections.sort(list, Comparator.comparingInt(Map.Entry::getKey));

        System.out.print(list + " ");
        System.out.println("         отсортировали мапу по ключам");

        //Сортировка мап
        //метод 2
        //Использовать SortedMap, а точнее, ее реализацию — TreeMap, которая в конструкторе принимает Comparator.
        //Данный компаратор будет применяться к ключам мапы, поэтому ключами должны быть классы, реализующие интерфейс Comparable
        SortedMap<Integer, String> sortedMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        //короче
        //SortedMap<Integer, String> sortedMap = new TreeMap<>(Comparator.comparingInt(o -> o));

        System.out.print(sortedMap + " ");
        System.out.println("         отсортировали мапу по ключам");


    }

}
