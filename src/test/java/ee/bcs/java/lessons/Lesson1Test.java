package ee.bcs.java.lessons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lesson1Test {

    // funktsiooniNimi_sisend_eeldatavVäljund
    @Test
    public void min_twoValues_minValue() {
        int result = Lesson1.min(9, -1000);
        assertEquals(-1000, result);
    }

    @Test
    public void abs_posValue_absValue() {
        int result = Lesson1.abs(999);
        assertEquals(999, result);
    }

    @Test
    public void abs_negValue_absValue() {
        int result = Lesson1.abs(-999);
        assertEquals(999, result);
    }

    @Test
    public void neg_negValue_negValue() {
        int result = Lesson1.neg(-4);
        assertEquals(-4, result);

        double a = 4.9;
        double b = 4.9;
        assertEquals(a, b, 0.001);
        //будет считать равными те значения, которые отличаются макс на 0.001

        //Assertions.assertTrue(true);
        //Assertions.assertThrows();
    }

    @Test
    public void neg_posValue_negValue() {
        int result = Lesson1.neg(4);
        assertEquals(-4, result);
    }

    @Test
    public void closest_3values_closestValue() {
        int result = Lesson1.closestToZero(1,-2,3);
        assertEquals(1, result);
    }

    @Test
    public void isEven_notEvenNumber_isEven() {
        boolean result = Lesson1.isNumberEven(-999);
        assertFalse(result);
    }

    @Test
    public void isEven_EvenNumber_isEven() {
        boolean result = Lesson1.isNumberEven(100);
        assertTrue(result);
    }
}
