package ee.bcs.java.learning;

/*
хеш-код
число int 4 байта
специальный метод вычисляет хеш-код для объекта при каждом запуске = каждый раз разный (по дефолту),
потому что в основе лежит алгоритм Park-Miller RNG random numbers generator

по умолчанию:
public native (=написан на С++) int hashCode();
про умолчанию возвращает номер йчейки памяти с объектом = всегда дщаёт == значения (также при незначительном изменении кода тоже возвращает ==)

public boolean equals(Object obj) {
return (this==object); }
то есть, сравнивает ССЫЛКИ

НАДО ПЕРЕОПРЕДЕЛЯТЬ чтобы:
1) у 1 объекты всегда был одинаковый хеш-код
2) два объекта с == содержимым имеют == хеш-код
3) у разных объектов железно разные хеш-коды
 */

import java.util.Objects;

public class HashCodeEquals {
    public static void main(String[] args) {
        int hCode = (new Object().hashCode());
        System.out.println("HashCode of new empty object: " + hCode);       //200006406
        // По умолчанию, функция hashCode() возвращает номер ячейки памяти, где объект сохраняется.
        // Поэтому, если изменение в код приложения не вносятся, то функция должна выдавать одно и то же значение.
        // При незначительном изменении кода значение hashCode также изменится.

        Test obj1 = new Test(11, 12);
        Test obj2 = new Test(11, 12);
        //два разных объекта с == содержимым
        System.out.println("obj1: " + obj1);    //@2d8e6db6 by default
        System.out.println("obj2: " + obj2);    //@23ab930d by default
        //это отдельные объекты, разные места в памяти
        System.out.println("haseCode of obj1: " + obj1.hashCode()); //764308918 by default
        System.out.println("haseCode of obj2: " + obj2.hashCode()); //598446861 by default
        // разные хеш-коды для разных объектов
        System.out.println("Comparing: " + obj1.equals(obj2) + " - because overrided method compares content of objects");
        //default method returns false - it compares links to memory cells

        //ЧТОБЫ ВСЁ РАБОТАЛО КАК НАДО, В КЛАССЕ ТЕСТ ПЕРЕОПРЕДЕЛЕНЫ ЭТИ МЕТОДЫ

    }


}


class Test {
    int f1 = -1;
    int f2 = -1;

    public Test(final int f1, final int f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public int getF1() {
        return this.f1;
    }

    public int getF2() {
        return this.f2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null)
            return false;
        else if (getClass() != obj.getClass())
            return false;

        Test other = (Test) obj;
        if (f1 != other.getF1())
            return false;
        else if (f2 != other.getF2())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + f1;
        result = prime * result + f2;
        return result;
    }

    //Библиотека Apache Commons включает два вспомогательных класса HashCodeBuilder и EqualsBuilder
    //для вызова методов hashCode() и equals(). Чтобы включить их в класс необходимо внести следующие изменения.
    //import org.apache.commons.lang.builder.EqualsBuilder;
    //import org.apache.commons.lang.builder.HashCodeBuilder;
    //http://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html


    /*
    //It follows the rules laid out in the book Effective Java by Joshua Bloch
    //When appending a data field, the current total is multiplied by the multiplier then a relevant value
    //for that data type is added. For example, if the current hashCode is 17, and the multiplier is 37,
    //then appending the integer 45 will create a hash code of 674, namely 17 * 37 + 45

    @Override
    public int hashCode() {
    final int prime = 31;
    return new HashCodeBuilder(getF1()%2 == 0 ?
                                        getF1() + 1 :
                                        getF1(), prime).toHashCode();
    }
    /*
    //example from apache:
    public class Person {
            String name;
            int age;
            boolean smoker;
   public int hashCode() {
     // you pick a hard-coded, randomly chosen, non-zero, odd number
     // ideally different for each class
     return new HashCodeBuilder(17, 37).
       append(name).
       append(age).
       append(smoker).
       toHashCode();
   }
 }
     */

/*
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null)
            return false;
        else if (getClass() != obj.getClass())
            return false;

        Test other = (Test) obj;
        return new EqualsBuilder().append(getF1(),other.getF1()).isEquals();
    }
     */


    //from apache:
    //It follows rules laid out in Effective Java , by Joshua Bloch
    //rule for comparing doubles, floats, and arrays can be tricky. Also, making sure that equals() and hashCode() are consistent can be difficult
    /*
   public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
        return false; }
    MyClass rhs = (MyClass) obj;
            return new EqualsBuilder()
                    .appendSuper(super.equals(obj))
                     .append(field1, rhs.field1)
                    .append(field2, rhs.field2)
                    .append(field3, rhs.field3)
                    .isEquals();
  }
    */

}