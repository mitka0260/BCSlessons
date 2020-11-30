package proselyte.developer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeveloperTests {

    Developer developer = new Developer();
    DeveloperLogic logic = new DeveloperLogic();

    @Before
    public void setUp() {
        developer.setFirstName("Simple");
        developer.setLastName("Developer");
        developer.setSpeciality("Java");
        developer.setSalary(2000_00);
    }

    @Test
    public void shouldCreateDeveloperInstanceTest() {
        //проверяет работу getters и setters
        assertEquals("Simple", developer.getFirstName());
        assertEquals("Developer", developer.getLastName());
        assertEquals("Speciality", developer.getSpeciality());
        assertEquals(2000_00, developer.getSalary());
    }

    @Test
    public void shouldCalculateAnnualSalaryTest() {
        //корректность вычисления годового дохода разработчика
        assertEquals(24_000_00, logic.calculateAnnualSalary(developer));
    }

    @Test
    public void shouldCalculateHourRateTest() {
        //правильность вычисления часовой ставки разработчика
        assertEquals(12, logic.calculateHourRate(developer));
    }
}
