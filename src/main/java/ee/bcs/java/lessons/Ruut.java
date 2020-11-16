package ee.bcs.java.lessons;

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPikkus() {
        return pikkus;
    }

    public void setPikkus(int pikkus) {
        this.pikkus = pikkus;
    }
}