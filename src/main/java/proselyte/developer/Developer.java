package proselyte.developer;

//Создадим простой POJO (Plain Old Java Object) класс Developer.java
public class Developer {
    private String firstName;
    private String lastName;
    private String speciality;
    private int salary;

    public Developer() {
    }

    public Developer(String firstName, String lastName, String speciality, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nSpeciality: " + speciality +
                "\nSalary: " + salary / 100 + "." + salary % 100;
    }
}
