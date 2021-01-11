package ee.bcs.java.learning;

/*
* Запишем объект во внешний файл - сериализация
* Чтение объекта из файла - десериализация
*/

import java.io.*;
import java.util.Arrays;

class Person implements Serializable {
    private static final long serialVersionUID = 1676742597816147679L;  // записали данные в файл. Потом сколько работали над проектом, проект изменился. Поэтому считать старые данные с новым проектом выдаст ошибку.
                                                                        // если я меняю класс, то надо заного сгенерировать эту переменную.
    private int id;              //transient -  т.к int - это примитивный тип, запишется 0
    private String name;         // если добавить transient, то не будет записываться
                                 // так как String - это объект, в результате будет записан null

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return id + " : " + name;
    }
}

public class Serialization {        // write object
    public static void main(String[] args) {
        Person person1 = new Person(1, "Bob");
        Person person2 = new Person(2, "Mike");
        Person[] people = {
                new Person(1, "Bob"),
                new Person(2, "Mike"),
                new Person(3, "Tom")
        };


        // (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.bin")))
        // здесь я оставил с методом close(), дальше оставил в таком синтаксе - МОЖНО ЗАБЫТЬ ЗАКРЫТЬ ПОТОК
        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(person1);
            oos.writeObject(person2);

            // запишем в файл массив из объектов - 1ый способ
            oos.writeInt(people.length); // длина массива
            for(Person person: people) {
                oos.writeObject(person);
            }

            // запишем в файл массив как объект то есть целиком - 2ой способ - так лучше (короче и проще)
            oos.writeObject(people);

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Deserialization {                // read object
    public static void main(String[] args) {

        // синтексис try with resources - тогда не надо в конце закрывать поток
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.bin "))) {
            // FileInputStream fis = new FileInputStream("people.bin");
            // ObjectInputStream ois = new ObjectInputStream(fis);

            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();

            System.out.println(person1);
            System.out.println(person2);

            // прочитаем из файла массив из объектов - 1ый способ
            int personCount = ois.readInt();
            Person[] people = new Person[personCount];
            for (int i = 0; i < personCount; i++) {
                people[i] = (Person) ois.readObject();
            }
            System.out.println(Arrays.toString(people));

            // записали массив как один объект, прочитаем так же - 2ой способ
            Person[] people1 = (Person[]) ois.readObject();
            System.out.println(Arrays.toString(people1));

            // ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}