package proselyte.developer;

public class DeveloperLogic {

    public int calculateHourRate(Developer developer) {
        return developer.getSalary() / 20 / 8; //часовая оплата
    }

    public int calculateAnnualSalary(Developer developer) {
        return developer.getSalary() * 12;  //годовая зарплата
    }

}
