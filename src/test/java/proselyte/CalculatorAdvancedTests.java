package proselyte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorAdvancedTests {

    private Calculator calculator = new Calculator();

    private int firstNumber;
    private int secondNumber;

    @Before
    //запускаются перед КАЖДЫМ тестом
    public void setUp() {
        firstNumber = 100;
        secondNumber = 200;
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
    }

    @Test
    public void shouldCreateCalculatorWithSetUpValues() {
        assertEquals(firstNumber, 100);
        assertEquals(secondNumber, 200);
    }

    @Test
    public void shouldReturnCorrectSum() {
        assertEquals(300, calculator.calculateSum());
    }




}
