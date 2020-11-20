package ee.bcs.java.BCSSpring.controller;

import ee.bcs.java.lessons.Lesson1;
import ee.bcs.java.lessons.Lesson3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SpringController {

    //сам подключится к базе данных
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //аннотация, работает сервер спринга, запускает мой код, ищет весь мой код
    //контроллер - это важный для нас класс, и это спринг знает
    @GetMapping(value = "")
    public String helloSpring() {
        return "Hello, Spring!";
    }

    /*
    @GetMapping("")
    public String helloSpringPage(
            @RequestParam("name") String name) {
        if (name=="")
            return "Hello, Spring";
        else
            return "Hello, " + name;
    }
     */

    @GetMapping("math/abs/{n}")
    public String absValuePath(
            @PathVariable("n") Integer n) {
        return "Your number's absolute value is " + Lesson1.abs(n);
    }
    //http://localhost:8080/math/abs/-10

    @GetMapping("math/isEven/{n}")
    public String isNumberEvenPath(
            @PathVariable("n") Integer n) {
        return "Your number is even - " + Lesson1.isNumberEven(n);
    }
    //http://localhost:8080/math/isEven/5

    @GetMapping("math/isEven")
    public String isNumberEvenReq(
            @RequestParam("number") int a) {
        return "Your number is even - " + Lesson1.isNumberEven(a);
    }
    //http://localhost:8080/math/isEven?number=4

    @GetMapping("math/max/{a}/{b}")
    public String maxValuePath(
            @PathVariable("a") Integer a,
            @PathVariable("b") Integer b) {
        return "Max value = " + Lesson1.max(a, b);
        //return "Max value = " + max(a, b);
    }
    //http://localhost:8080/math/max/3/7

    //можно и здесь написать код метода
    private int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    @GetMapping("math/max")
    public String maxValueReq(
            @RequestParam("aKey") int a,
            @RequestParam("bKey") int b,
            @RequestParam("cKey") int c) {
        return "Max value is " + Lesson1.max(a, b, c);
    }
    //http://localhost:8080/math/max?aKey=3&bKey=4&cKey=10

    @GetMapping("math/min/{a}/{b}")
    public String minValuePath(
            @PathVariable("a") int a,
            @PathVariable("b") int b) {
        return "Min value is " + Lesson1.min(a, b);
    }
    //http://localhost:8080/math/min/7/2

    @GetMapping("math/min")
    public String minValueReq(
            @RequestParam("aKey") int a,
            @RequestParam("bKey") int b) {
        return "Min value is " + Lesson1.min(a, b);
    }
    //http://localhost:8080/math/min?aKey=3&bKey=10

    @GetMapping("math/Fibonacci/{n}")
    public String fibonacciNrPath(
            @PathVariable("n") int n) {
        return "Fibonacci " + n + "th number is " + Lesson3.fibonacci1(n);
    }
    //http://localhost:8080/math/Fibonacci/7

    @GetMapping("math/Fibonacci")
    public String fibonacciNrReq(
            @RequestParam("n") int n) {
        return "Fibonacci " + n + "th number is " + Lesson3.fibonacci1(n);
    }
    //http://localhost:8080/math/Fibonacci?n=7

    @GetMapping("math/closestToNr/{a}/{b}/{c}/{d}/{e}/{f}/{g}")
    public String closestToNrPath(
            @PathVariable("a") Integer a,
            @PathVariable("b") Integer b,
            @PathVariable("c") Integer c,
            @PathVariable("d") Integer d,
            @PathVariable("e") Integer e,
            @PathVariable("f") Integer f,
            @PathVariable("g") Integer g) {
        int[] array = {b, c, d, e, f, g};
        return "Closest to " + a + " is number " + Lesson1.closestTo2(a, array);
    }
    //http://localhost:8080/math/closestToNr/1/2/3/4/5/6/7

    @GetMapping("math/ClosestToNr")
    public String closestToNrReq(
            @RequestParam("aKey") int a,
            @RequestParam("bKey") int b,
            @RequestParam("cKey") int c,
            @RequestParam("dKey") int d,
            @RequestParam("eKey") int e,
            @RequestParam("fKey") int f,
            @RequestParam("gKey") int g) {
        int[] array = {b, c, d, e, f, g};
        return "Closest to " + a + " is " + Lesson1.closestTo2(a, array);
    }
    //http://localhost:8080/math/ClosestToNr?aKey=1&bKey=2&cKey=3&dKey=4&eKey=5&fKey=6&gKey=7


    int value = 0;

    @GetMapping("math/gameWithValues/add")
    public int addGameWithValues(
            @RequestParam("x") int x) {
        value += x;
        return value;
    }
    //http://localhost:8080/math/gameWithValues/add?x=5

    @GetMapping("math/gameWithValues/multiply")
    public int multiplyGameWithValues(
            @RequestParam("x") int x) {
        value *= x;
        return value;
    }
    //http://localhost:8080/math/gameWithValues/multiply?x=5

    @GetMapping("math/gameWithValues/subtract")
    public int subtractGameWithValues(
            @RequestParam("x") int x) {
        value -= x;
        return value;
    }
    //http://localhost:8080/math/gameWithValues/subtract?x=4

    @GetMapping("SampleResult")
    public SampleResult sampleResultLesson() {
        SampleResult a = new SampleResult();
        a.setStatus("OK");
        a.setMessage("I like Metallica");
        return a;
    }
    //выведет в формате json
    //{"status":"OK","message":"I like Metallica"}


    List<Employee> employeeList = new ArrayList<>();
    //шлобальная переменная, к ней могут обращаться все методы

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

    @GetMapping("Employee/indexDB/{index}") //show employee by index in the List
    public String showEmployeeByIndex1(
            @PathVariable("index") Integer index) {
        String sql = "SELECT name FROM employee WHERE id = " + index;
        String result = namedParameterJdbcTemplate.queryForObject(sql, new HashMap<>(), String.class);
        return result;
    }
    //http://localhost:8080/Employee-indexDB/3

    @GetMapping("employee/getNameDB")
    public String getEmployee(@RequestParam("id") int idFromRequest) {
        String sql = "SELECT name FROM employee WHERE id = :idSql";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idSql", idFromRequest);
        String result = namedParameterJdbcTemplate.queryForObject(sql, paramMap, String.class);
        return result;

        //методы селект и др ничего не возвращают, тогда надо так:
        //namedParameterJdbcTemplate.update(sql, paramMap);
    }
//WHERE id =" + idFromRequest; - так писать нельзя в целях безопасности!!!

    @GetMapping("car/regnr")
    public String getRegNr(@RequestParam("id") Integer id) {
        String sql = "SELECT regnr FROM car WHERE id=1";
        Map paramMap = new HashMap();
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    @GetMapping("car/regnr1")
    public String getRegNr1(@RequestParam("id") Integer i) {
        String sql = "SELECT regnr FROM car WHERE id=:a";
        Map paramMap = new HashMap();
        paramMap.put("a", i);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    @GetMapping("car/brand")
    public List<String> getCarsByBrand(@RequestParam("id") String id) {
        String sql = "SELECT regnr FROM car WHERE lower(brand) = :a";
        Map paramMap = new HashMap();
        paramMap.put("a", id.toLowerCase());
        return namedParameterJdbcTemplate.queryForList(sql, paramMap, String.class);
    }

    @GetMapping("car/update")
    public void updateRegNr(@RequestParam("q") String q1,
                            @RequestParam("w") Integer w1) {
        String sql = "UPDATE car SET regnr=:q WHERE id=:w";
        Map paraMap = new HashMap();
        paraMap.put("q", q1);
        paraMap.put("w", w1);
        namedParameterJdbcTemplate.update(sql, paraMap);
    }
    //Exercise
    //Luua tabel raamatud(id, nimi, aasta, autor)
    //Luua teenus mis otsib kõik raamatud autori järgi
    //tagastab NIMI + AASTA query
    @GetMapping("booksSearchByAuthor")
    public List<String> searchByAuthor(@RequestParam("author") String author) {
        String sql = "SELECT name FROM books WHERE author = :a";
        Map paramMap = new HashMap();
        paramMap.put("a", author);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap, String.class);
    }
    //http://localhost:8080/booksSearchByAuthor?author=John

    @GetMapping("car/showAll")
    public List<Car> showAllCars() {
        String sql = "SELECT * FROM car";
        Map paraMap = new HashMap();
        return namedParameterJdbcTemplate.query(sql, paraMap, new CarRowMapper());
    }

    private class CarRowMapper implements RowMapper<Car> {
        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car qwerty = new Car();
            qwerty.id = resultSet.getInt("id");
            qwerty.regnr = resultSet.getString("regnr");
            qwerty.brand = resultSet.getString("brand");
            return qwerty;
        }
    }

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

    /*
    String sql = "SELECT amount FROM account WHERE id = :id";
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", id);
    Integer dbAmount = namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    */

}
