package ee.bcs.java.BCSSpring.bank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BankController {

    private List<BankAccount> accountList = new ArrayList<>();

    @GetMapping("bank/accounts")
    public List<BankAccount> getAccountList() {
        return accountList;
    }

    //create account
    @GetMapping("bank/createAccount")
    public void createAccount(@RequestParam("iban") String iban) {
        BankAccount account = new BankAccount(iban, 0);
        accountList.add(account);
    }

    //get account balance
    @GetMapping("bank/getBalance")
    public double getAccountBalance(@RequestParam("i") int i) {
        return accountList.get(i).balance;
    }

    //deposit money
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
