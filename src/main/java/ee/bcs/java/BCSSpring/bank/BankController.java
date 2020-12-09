package ee.bcs.java.BCSSpring.bank;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("bank") //тогда в начале каждого GetMapping не надо писать bank/
@RestController
public class BankController {

    private final List<BankAccount> accountList = new ArrayList<>();

    @CrossOrigin
    @GetMapping("bank/accounts")
    public List<BankAccount> getAccountList() {
        return accountList;
    }

    //create account
    @CrossOrigin
    @GetMapping("bank/createAccount")
    public void createAccount(@RequestParam("iban") String iban) {
        BankAccount account = new BankAccount(iban, 0);
        accountList.add(account);
    }

    //get account balance
    //http://localhost:8080/bank/getBalance?i=0
    @CrossOrigin
    @GetMapping("bank/getBalance")
    public double getAccountBalance(@RequestParam("i") int i) {
        return accountList.get(i).balance;
    }

    //deposit money
    @CrossOrigin
    @GetMapping("bank/depositMoney")
    public void depositMoney(
            @RequestParam("iban") String iban,
            @RequestParam("deposit") int d) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).iban.equals(iban))
                accountList.get(i).balance = accountList.get(i).balance + d;
        }
    }

    //withDrawMoney
    @CrossOrigin
    @GetMapping("bank/withdrawMoney")
    public void withdrawMoney(
            @RequestParam("iban") String iban,
            @RequestParam("withdraw") int w) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).iban.equals(iban))
                accountList.get(i).balance = accountList.get(i).balance - w;
        }
    }

    //transferMoney
    @CrossOrigin
    @GetMapping("bank/transfer")
    public void transferMoney(
            @RequestParam("ibanFrom") String ibanFrom,
            @RequestParam("ibanTo") String ibanTo,
            @RequestParam("howMuch") int howMuch) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).iban.equals(ibanFrom))
                accountList.get(i).balance = accountList.get(i).balance - howMuch;
            if (accountList.get(i).iban.equals(ibanTo))
                accountList.get(i).balance = accountList.get(i).balance + howMuch;
        }
    }

}
