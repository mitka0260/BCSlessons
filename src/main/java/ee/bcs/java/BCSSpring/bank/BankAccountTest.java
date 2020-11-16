package ee.bcs.java.BCSSpring.bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccountTest {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("EE123", 24);
        BankAccount account2 = new BankAccount("EE456", 55);
        System.out.println(account1.iban + ": " + account1.balance);
        System.out.println(account2.iban + ": " + account2.balance);
        account1.balance = 0;
        System.out.println(account1.iban +": " + account1.balance);

        List<BankAccount> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        System.out.println(accountList);
        System.out.println(accountList.get(0).balance);

        BankAccount firstAccount = accountList.get(0); //ссылаетя на тот же объект, меняет баланс аккаунта1
        firstAccount.balance = 100;
        System.out.println(accountList);
    }
}
