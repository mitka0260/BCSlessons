package ee.bcs.java.lessons;

import ee.bcs.java.BCSSpring.controller.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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
        System.out.println("Ruudu pindala = " + ruut.pindala());
        System.out.println();
    }

    // TODO arvuta kasutades BigDecimali 1.89 * ((394486820345 / 15 ) + 4 )
    public static void yl1() {
        BigDecimal a = new BigDecimal("1.89");
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");

        BigDecimal e = b.divide(c, 6, RoundingMode.HALF_UP);
        BigDecimal f = a.multiply(e.add(d));
        System.out.println(f);
    }

    public static void yl2() {
        // TODO loo float muutuja ja väärtusta see 1.89
        // TODO korruta see läbi täisarvuga 11
        // TODO trüki tulemus välja
        // TODO nüüd tee seda kasutades klassi BigDecimal ja võrdle tulemust
        float a = 1.89f;
        a = a * 11;
        System.out.println(a);
        BigDecimal a1 = new BigDecimal("1.89");
        System.out.println(a1);
        BigDecimal a2 = new BigDecimal(1.89);
        System.out.println(a2);
        BigDecimal b1 = new BigDecimal(11);
        BigDecimal c1 = a1.multiply(b1);
        System.out.println(c1);
    }

}