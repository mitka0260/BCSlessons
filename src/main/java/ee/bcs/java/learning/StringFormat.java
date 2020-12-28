package ee.bcs.java.learning;

public class StringFormat {

    public static void main(String[] args) {

        String name = "Bender";
        int age = 12;
        String friend = "Fry";
        int weight = 200;

        System.out.println("User = {name: " + name + ", age: " + age + " years, friend: " + friend + ", weight: " + weight + " kg.}");

        //%s - string, %d - целое число, %f - с точкой, %b - boolean, %c - char, %t - date, %% - символ %
        String text = String.format("User = {name: %s, age: %d years, friend: %s, weight: %d kg.}",
                name, age, friend, weight);

        System.out.println(text);

    }
}
