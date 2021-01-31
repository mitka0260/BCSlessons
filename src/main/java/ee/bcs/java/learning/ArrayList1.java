package ee.bcs.java.learning;

/*

Продвинутая Java: Динамический массив (ArrayList) - Введение
Alishev

Одна из джава-коллекций
динамический массив - может менять размер (в отличие от обычного массива)

Наследование: ArrayList -> List -> Collection -> Iterable
*/

import java.util.List;
import java.util.ArrayList;

// внутри ArrayLista находится обычный массив + методы работы с ним

public class ArrayList1 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();    // размер не задан, по умолчианию 10
        // конвенция для java collections framework - когда создаём объект такого класса, то
        // надо этот объект сослать на переменную типа интерфейса. Поэтому в начале List
        // работает благодаря полиморфизму
        // зачем такая конвенция? В такой реализации можно переобъявить лист если где-тонадо будет удалять
        // много элементов из начала и/или середины - повысится эффективность
        // list = new LinkedList<>(); +скопировать элементы ил начального листа в новый

        for (int i = 0; i < 10; i++) {
            list.add(i);           // сам меняют свою длину
        }
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(9)); //list.size()-1
        System.out.println(list.get(list.size()-1));

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        for(Integer x : list)
            System.out.print(x + " ");
        System.out.println();

        list.remove(5);        // неэффективный метод для начала или середины списка
        System.out.println(list);

    }

}
