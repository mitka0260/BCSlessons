package ee.bcs.java.BCSSpring.database;

import ee.bcs.java.BCSSpring.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankDB {

    @Autowired
    private BankService bankService;

    //@Autowired
    //private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("bank/createAccountDB")
    public void createAccountDB(@RequestParam("iban") String iban) {
        bankService.createAccountDB(iban);
    }

    @GetMapping("bank/getAccountBalanceDB")
    public int getAccountBalanceDB(@RequestParam("iban") String iban) {
        return bankService.getAccountBalanceDB(iban);
    }

    /*
    @GetMapping("bank/depositMoneyDB")
    public void depositMoneyDB(@RequestParam("iban") String iban,
                               @RequestParam("howMuch") int howMuch) {
        if (howMuch > 0) {
            String sql = "SELECT balance FROM account WHERE account_nr = :iban";
            Map paramMap = new HashMap<>();
            paramMap.put("iban", iban);
            Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
            result = result + howMuch;

            String sql1 = "UPDATE account SET balance = :result WHERE account_nr = :a";
            Map paramMap1 = new HashMap();
            paramMap1.put("result", result);
            paramMap1.put("a", iban);
            jdbcTemplate.update(sql1, paramMap1);
        }
    }

    @GetMapping("bank/withDrawMoneyDB")
    public void withDrawMoneyDB(@RequestParam("iban") String iban,
                                @RequestParam("howMuch") int howMuch) {
        if (howMuch > 0) {
            String sql = "SELECT balance FROM account WHERE account_nr = :iban";
            Map paramMap = new HashMap();
            paramMap.put("iban", iban);
            Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

            if (result >= howMuch) {
                result = result - howMuch;
                String sql1 = "UPDATE account SET balance = :result WHERE account_nr = :a";
                Map paramMap1 = new HashMap();
                paramMap1.put("result", result);
                paramMap1.put("a", iban);
                jdbcTemplate.update(sql1, paramMap1);
            }
        }
    }

    @GetMapping("bank/transferMoneyDB")
    public void transferMoneyDB(@RequestParam("ibanFrom") String ibanFrom,
                                @RequestParam("ibanTo") String ibanTo,
                                @RequestParam("howMuch") Integer howMuch) {
        String sql = "SELECT balance FROM account WHERE account_nr = :ibanFrom";
        Map paramMap = new HashMap<>();
        paramMap.put("ibanFrom", ibanFrom);
        Integer amountOnIbanFrom = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        if (amountOnIbanFrom >= howMuch) {
            amountOnIbanFrom = amountOnIbanFrom - howMuch;
            String sql1 = "UPDATE account SET balance = :amountOnIbanFrom WHERE account_nr = :ibanFrom";
            Map paramMap1 = new HashMap();
            paramMap1.put("amountOnIbanFrom", amountOnIbanFrom);
            paramMap1.put("ibanFrom", ibanFrom);
            jdbcTemplate.update(sql1, paramMap1);

            String sql2 = "SELECT balance FROM account WHERE account_nr = :ibanTo";
            Map paramMap2 = new HashMap<>();
            paramMap2.put("ibanTo", ibanTo);
            Integer amountOnIbanTo = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);
            amountOnIbanTo += howMuch;

            String sql3 = "UPDATE account SET balance = :amountOnIbanTo WHERE account_nr = :ibanTo";
            Map paramMap3 = new HashMap();
            paramMap3.put("amountOnIbanTo", amountOnIbanTo);
            paramMap3.put("ibanTo", ibanTo);
            jdbcTemplate.update(sql3, paramMap3);
        }
    }
*/
}
