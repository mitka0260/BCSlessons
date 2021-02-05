package ee.bcs.java.learning;

/*
Джава сама умеет создавать многопоточность.
Цель - не скорость, а реализация к-л функционала. (чтобы клиент не ждал, ... )
*/

public class MultiThreadingLearning {
    public static void main(String[] args) throws InterruptedException {    // это дефолтовый поток main

        MyThread myThread = new MyThread();
        myThread.start();       // ВАЖНО - вызывает метод start(), который запустит метод RUN()
        // myThread.run();      // так выполнится, но НЕ В ОТДЕЛЬНОМ ПОТОКЕ

        MyThread myThread2 = new MyThread();
        myThread2.start();  // стартуют в разное время

        // ПОТОКИ НИКАК НЕ СИНХРОНИЗИРУЮТСЯ
        // каждый раз выдача будет РАЗНАЯ

        Thread.sleep(3000); // после такой команды поток main продолжит выполнятся уже после myThread1+2
        // это выполнится раньше, т.к новый поток не успел создаться к моменты выполнения этой строки
        System.out.println("Hello from main thread1");

        // ====================================
        Thread thread3 = new Thread(new Runner());
        thread3.start();
        System.out.println("Hello from main thread2");

    }
}

//Способ 1
class MyThread extends Thread {     // находится в Java.land (доступен без импорта)
    // это уже поток
    // при вызове будет выполняться в отдельном потоке, параллельно другим потокам
    // одноядерный проц будет быстро переключаться между задачами/потоками

    @Override
    public void run() { // в этом методе мы описывам код, который мы хотим выполнить в отдельном потоке
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000); // так потоки станут более синхронизированными
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread " + i);
        }
    }

}

//Способ 2
class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000); // так потоки станут более синхронизированными
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread " + i);
        }
    }
}