package ee.bcs.java.learning;

/*
enum = enumeration = перечисление
Нужно перечислить типы объектов
 */

//примеры использования в файле EnumBefore
public enum EnumExampleAnimal {
    DOG("собака"),
    CAT("кошка"),
    FROG("лягушка");

    private String translation;

//    EnumExampleAnimal(){    //дефолтовый конструктор
//
//    }

    EnumExampleAnimal(String translation) {   //создадим конструтор
        this.translation = translation;     //теперь джава не может сама создать объекты этого класса (нет дефолтового конструтора)
    }

    public String getTranslation() {
        return translation;
    }

    public String toString() {
        return "Перевод на великий и могучий: " + translation;
    }


}
