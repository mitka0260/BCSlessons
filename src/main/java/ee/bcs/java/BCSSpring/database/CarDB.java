package ee.bcs.java.BCSSpring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarDB {

    //сам подключится к базе данных
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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

}
