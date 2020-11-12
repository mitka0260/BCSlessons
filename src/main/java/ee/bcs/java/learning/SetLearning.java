package ee.bcs.java.demo.tasks;/*
Implementatsioonid для SET:
HashSet
TreeSet
LinkedHashSet

HashSet – это коллекция, которая для хранения элементов внутри использует их хэш-значения, которые возвращает метод hashCode().
Использование hash-кодов позволяет довольно быстро искать, добавлять и удалять элементы из множества (Set)
не поддерживает порядок элементов

LinkedHashSet – это HashSet, в котором элементы хранятся еще и в связном списке
А у LinkedHashSet можно получить итератор и с его помощью обойти все элементы именно в том порядке, в котором они добавлялись

TreeSet – это коллекция, которая хранит элементы в виде упорядоченного по значениям дерева
очень быстрые операции add, remove, contains

Главная особенность Set – в нем только уникальные объекты, т.е. они все разныe

Добавлять элемент(ы)	        add(), addAll()
Удалять элемент(ы)          	remove(), removeAll()
Проверять, есть ли элемент(ы)	contains(), containsAll()
кол-во элементов                size()
 */

import java.util.HashSet;
import java.util.Set;

public class SetLearning {

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("abc");
        stringSet.add("cde");
        System.out.println(stringSet + "       whole set print");
        System.out.println(stringSet.contains("abc") + "             contains abc?");
        stringSet.remove("abc");
        System.out.println(stringSet + "       removed abc");
        System.out.println(stringSet.size() + "           its size");
        stringSet.clear();
        System.out.println(stringSet + "       cleared");
        stringSet.toArray();

    }
}
