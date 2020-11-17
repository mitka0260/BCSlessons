package ee.bcs.java.lessons;

import ee.bcs.java.BCSSpring.controller.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lesson4 {

    /* TODO all olev on näidis, loo uus klass selle ülesande jaoks
     * Loo uus klass ruut
     * ruudu konstruktor peab vastu võtma x ja y kordinaadi ning külje pikkuse.
     * objektil peab olema meetod pindala, mis tagastab ruudu pindala
     */

    public static void main(String[] args) {
        yl1();
        yl2();
        Ruut ruut = new Ruut(100, 100, 15);
        System.out.println("Ruudu pindala = " + ruut.pindala());    //225
        System.out.println();
    }

    // TODO arvuta kasutades BigDecimali 1.89 * ((394486820345 / 15 ) + 4 )
    public static void yl1() {
        BigDecimal a = new BigDecimal("1.89");
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");

        System.out.println(a.multiply((b.divide(c, 6, RoundingMode.HALF_UP).add(d))));
        //49705339371.02999937
    }

    public static void yl2() {
        // TODO loo float muutuja ja väärtusta see 1.89
        // TODO korruta see läbi täisarvuga 11
        // TODO trüki tulemus välja
        // TODO nüüd tee seda kasutades klassi BigDecimal ja võrdle tulemust
        float a = 1.89f;
        System.out.println(a*11);  //20.789999

        System.out.println(new BigDecimal("1.89")); //1.89
        System.out.println(new BigDecimal(1.89)); //1.8899999999999999023003738329862244427204132080078125

        System.out.println(new BigDecimal("1.89").multiply(new BigDecimal("11")));    //20.79
    }

}