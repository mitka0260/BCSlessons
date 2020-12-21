package ee.bcs.java.learning;

/*
как делали перечисления до enum
 */

public class EnumBefore {

    //надо помнить все эти переменные и смотреть сюда
    private static final int DOG = 0;
    private static final int CAT = 1;
    private static final int FROG = 2;

    public static void main(String[] args) {
        int animal = DOG;
        int animal1 = 100;  //тут неопределнность, это ПРОБЛЕМА

        switch(animal) {
            case DOG:
                System.out.println("It's a dog");
                break;
            case FROG:
                System.out.println("It's a frog");
                break;
            default:
                System.out.println("It's not an animal");
        }

        //ИСПОЛЬЗОВАНИЕ ENUM
        EnumExampleAnimal animal2 = EnumExampleAnimal.CAT;

        switch (CAT) {
            case CAT:
                System.out.println("It's a cat!");
                break;
            case (DOG):
                System.out.println("It's a dog!");
                break;
        }

        EnumSeason season = EnumSeason.SUMMER;

        //глобальное наследование: Object -> Enum -> EnumSeason
        System.out.println(season instanceof EnumSeason);   //проверка является ли объект объектом этого класса - TRUE
        System.out.println(season instanceof Object);   //TRUE
        System.out.println(season instanceof Enum);   //TRUE
        System.out.println(season.getClass());   //class ee.bcs.java.learning.EnumSeason

        switch(season) {
            case SUMMER:
                System.out.println("It's warm outside");
                break;
            case WINTER:
                System.out.println("It's cold outside");
                break;
        }

        EnumExampleAnimal animal3 = EnumExampleAnimal.CAT;
        System.out.println(animal3.getTranslation());

        EnumExampleAnimal animal4 = EnumExampleAnimal.DOG;
        System.out.println(animal4);

        EnumSeason season1 = EnumSeason.WINTER;
        System.out.println(season1.getTemperature());

        //методы самого класса ENUM
        System.out.println(season1.name()); //WINTER - если неподходит переопределённый toString()
        System.out.println(EnumExampleAnimal.valueOf("CAT"));

        EnumExampleAnimal frog = EnumExampleAnimal.valueOf("FROG");
        System.out.println(frog.getTranslation());
        System.out.println(frog.ordinal()); //индекс объекта в классе Enum



    }

}
