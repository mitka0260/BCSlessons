package ee.bcs.java.BCSSpring.database;

import ee.bcs.java.BCSSpring.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@RequestMapping("bank")
//тогда в начале гетмаппинг не надо каждый раз писать "банк/"
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

    @GetMapping("bank/depositMoneyDB")
    public void depositMoneyDB(@RequestParam("iban") String iban,
                               @RequestParam("howMuch") int howMuch) {
        bankService.depositMoneyDB(iban, howMuch);
    }

    @GetMapping("bank/withDrawMoneyDB")
    public void withDrawMoneyDB(@RequestParam("iban") String iban,
                                @RequestParam("howMuch") int howMuch) {
        bankService.withDrawMoneyDB(iban, howMuch);
    }

    @GetMapping("bank/transferMoneyDB")
    public void transferMoneyDB(@RequestParam("ibanFrom") String ibanFrom,
                                @RequestParam("ibanTo") String ibanTo,
                                @RequestParam("howMuch") Integer howMuch) {
        bankService.transferMoneyDB(ibanFrom, ibanTo, howMuch);
    }

}
