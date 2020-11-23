package ee.bcs.java.BCSSpring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeDB {

    //сам подключится к базе данных
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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


    /*
    String sql = "SELECT amount FROM account WHERE id = :id";
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", id);
    Integer dbAmount = namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    */
}
