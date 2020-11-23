package ee.bcs.java.BCSSpring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BooksDB {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
}
