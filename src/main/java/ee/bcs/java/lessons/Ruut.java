package ee.bcs.java.demo.tasks;

public class Ruut {
    int x;
    int y;
    int pikkus;

    Ruut(int x1, int y1, int pikkus1) {
        x = x1;
        y = y1;
        pikkus = pikkus1;
    }

    int pindala() {
        return pikkus * pikkus;
    }

}