package ee.bcs.java.BCSSpring.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccountDB(String iban) {
        String sql = "INSERT INTO account (account_nr, balance) VALUES (:account_nr, 0)";
        Map paramMap = new HashMap<>();
        paramMap.put("account_nr", iban);
        jdbcTemplate.update(sql, paramMap);
    }

    public int getAccountBalanceDB(String iban) {
        String sql = "SELECT balance FROM account WHERE account_nr = :iban";
        HashMap paramMap = new HashMap();
        paramMap.put("iban", iban);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }
}
