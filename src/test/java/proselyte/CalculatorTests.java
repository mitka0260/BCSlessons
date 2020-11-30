package proselyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorTests {

    private Calculator calculator = new Calculator(10, 20);

    @Test
    public void shouldCreateCalculatorInstance() {
        assertNotNull(calculator);
    }
    //проверка: экземпляр создан и не является null

    @Test
    public void shouldReturnCorrectSum() {
        assertEquals(30, calculator.calculateSum());
    }
    //Проверка: метод calculateSum класса Calculator возвращает корректное значение (10 + 20 = 30)
}
