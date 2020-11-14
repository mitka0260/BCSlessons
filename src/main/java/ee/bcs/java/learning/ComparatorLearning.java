/*
Сравнение объектов
Первая цель такого сравнения - сортировка
Сами задаём правила сравнения

Comparator возвращает int по следующей схеме:
отрицательный int (первый объект отрицательный, то есть меньше)
положительный int (первый объект положительный, хороший, то есть больший)
ноль = объекты равны


 */

package ee.bcs.java.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class ComparatorLearning {
    public static void main(String[] args) {
        List<Message> messages = new ArrayList();
        messages.add(new Message("Hello, World!"));
        messages.add(new Message("Hello, Sun!"));
        System.out.println(messages);

        Comparator<Message> comparator = new Comparator<Message>() {
            public int compare(Message o1, Message o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };

        Collections.sort(messages, comparator);
        System.out.println(messages);




    }
}



