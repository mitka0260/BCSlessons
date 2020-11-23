package ee.bcs.java.BCSSpring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    //сам подключится к базе данных
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    List<Employee> employeeList = new ArrayList<>();
    //глобальная переменная, к ней могут обращаться все методы

    @GetMapping("Employees") //returns all employees
    public List showAllEmployees() {
        return employeeList;
    }
    //http://localhost:8080/Employees

    @GetMapping("CreateEmployees")
    public void createEmployees(
            @RequestParam("id1") int id1,
            @RequestParam("name1") String name1,

            @RequestParam("id2") int id2,
            @RequestParam("name2") String name2,

            @RequestParam("id3") int id3,
            @RequestParam("name3") String name3,

            @RequestParam("id4") int id4,
            @RequestParam("name4") String name4,

            @RequestParam("id5") int id5,
            @RequestParam("name5") String name5) {

        Employee a = new Employee();
        a.setId(id1);
        a.setName(name1);
        employeeList.add(a);

        Employee b = new Employee();
        b.setId(id2);
        b.setName(name2);
        employeeList.add(b);

        Employee c = new Employee();
        c.setId(id3);
        c.setName(name3);
        employeeList.add(c);

        Employee d = new Employee();
        d.setId(id4);
        d.setName(name4);
        employeeList.add(d);

        Employee e = new Employee();
        e.setId(id5);
        e.setName(name5);
        employeeList.add(e);
    }
    //http://localhost:8080/CreateEmployees?id1=10&name1=John&id2=20&name2=Steve&id3=30&name3=Zach&id4=40&name4=Donald&id5=50&name5=James

    @GetMapping("Employee/index/{index}") //show employee by index in the List
    public Employee showEmployeeByIndex(
            @PathVariable("index") Integer index) {
        return employeeList.get(index);
    }
    //http://localhost:8080/Employee/index/3


    @GetMapping("Employee/id/{id}") //show employee by id
    public String showEmployeeById(
            @PathVariable("id") Integer id) {
        int idIndex = -1;
        int[] idArray = new int[employeeList.size()]; //5
        for (int i = 0; i < employeeList.size(); i++) {
            idArray[i] = employeeList.get(i).getId();
            if (employeeList.get(i).getId() == id)
                idIndex = i;
        }
        if (idIndex == -1) {
            return "No employee with this id";
        } else {
            return employeeList.get(idIndex).getName() + " is with your id in our List";
        }
    }

    @GetMapping("Employee/add") //add employee to List
    public void addEmployee(
            @RequestParam("id") int id,
            @RequestParam("name") String name) {
        Employee f = new Employee();
        f.setId(id);
        f.setName(name);
        employeeList.add(f);
    }
    //http://localhost:8080/Employee/add?id=60&name=Joseph

    @GetMapping("Employee/update") //updates=exchanges? set ?
    public void updateEmployee(
            @RequestParam("id") int id,
            @RequestParam("name") String name) {
        Employee newEmployee = new Employee();
        newEmployee.setId(id);
        newEmployee.setName(name);
        employeeList.set(0, newEmployee);
    }
    //http://localhost:8080/Employee/update?id=0&name=Alice

    @GetMapping("Employee/updateName")
    public void updateName(
            @RequestParam("id") int id,
            @RequestParam("name") String name) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id)
                employee.setName(name);
        }
    }

    @GetMapping("Employee/updateID")
    public void updateID(
            @RequestParam("id") int id,
            @RequestParam("name") String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name))
                employee.setId(id);
        }
    }

    @GetMapping("Employee/delete")
    public void deleteEmployee(
            @RequestParam("id") int id) {
        employeeList.remove(id);
    }
    //http://localhost:8080/Employee/delete?id=1

}
