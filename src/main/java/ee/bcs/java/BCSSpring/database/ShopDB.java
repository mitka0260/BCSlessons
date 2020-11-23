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
public class ShopDB {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("shopDB/checkPrice")
    public Integer checkPrice(@RequestParam("id") int id) {
        String sql = "SELECT price FROM shop WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Integer dbPrice = namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return dbPrice;
    }

    @GetMapping("shopDB/add")
    public void addSomething () {
        String sql = "INSERT INTO shop (title, price) VALUES ('Sony', 70)";
        Map<String, String> paramMap = new HashMap<>();
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("shopDB/add1")
    public void addSomething1 (@RequestParam("something") String something,
                              @RequestParam("price") Integer price) {
        String sql = "INSERT INTO shop (title, price) VALUES (:something, :price)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("something", something);
        paramMap.put("price", price);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("selectFromShop")
    public List<Shop> selectFromShop(@RequestParam("id") int id) {
        String sql = "SELECT * FROM shop WHERE id = :id";
        Map <String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List <Shop> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new ShopRowMapper());
        return resultList;
    }

    private class ShopRowMapper implements RowMapper<Shop> {
        @Override
        public Shop mapRow(ResultSet resultSet, int i) throws SQLException {
            Shop qwerty = new Shop();
            qwerty.id = resultSet.getInt("id");
            qwerty.title = resultSet.getString("title");
            qwerty.price = resultSet.getInt("price");
            return qwerty;
        }
    }

}
