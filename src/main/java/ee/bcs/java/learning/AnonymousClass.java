package ee.bcs.java.learning;

interface AbleToEat {
    public void eat();
}

public class AnonymousClass {
    public static void main(String[] args) {
        AbleToEat ableToEat = new AbleToEat() {
            @Override
            public void eat() {
                System.out.println("It is eating...");
            }
        };
        ableToEat.eat();
        //создался анонимный класс, внутри {} идёт реализация метода интерфейса
        //ВНУТРИ АНОНИМНОГО КЛАССА
    }
}


//это просто пример как в сложном задании надо было сделать
//здесь показано что от чего идёт
//interface List {
//    public void eat();
//}
//
//class MyList implements List {
//    @Override
//    public void eat() {
//    }
//}
//
//class Test123 {
//    public static void main(String[] args) {
//        List list = new MyList();
//        list.eat();
//    }
//}

