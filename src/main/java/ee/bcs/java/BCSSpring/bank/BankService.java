package ee.bcs.java.BCSSpring.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createAccountDB(String iban) {
        bankRepository.createAccount(iban);
    }

    public int getAccountBalanceDB(String iban) {
        return bankRepository.getAccountBalanceDB(iban);
    }

    public void depositMoneyDB(String iban, int howMuch) {
        if (howMuch > 0) {
            Integer currentBalance = bankRepository.getAccountBalanceDB(iban);
            int newBalance = currentBalance + howMuch;
            bankRepository.setAccountBalanceDB(iban, newBalance);
        }
    }

    public void withDrawMoneyDB(String iban, int howMuch) {
        if (howMuch > 0) {
            Integer amount = bankRepository.getAccountBalanceDB(iban);

            if (amount >= howMuch) {
                amount = amount - howMuch;
                bankRepository.setAccountBalanceDB(iban, amount);
            }
        }
    }

    public void transferMoneyDB(String ibanFrom, String ibanTo, Integer howMuch) {
        if (howMuch < 0) {
            throw new RuntimeException("Kogus peab olema positiivne arv");
            //throw new Exception() + try+catch
        }
        Integer amountOnIbanFrom = bankRepository.getAccountBalanceDB(ibanFrom);

        if (amountOnIbanFrom >= howMuch) {
            amountOnIbanFrom = amountOnIbanFrom - howMuch;
            bankRepository.setAccountBalanceDB(ibanFrom, amountOnIbanFrom);

            Integer amountOnIbanTo = bankRepository.getAccountBalanceDB(ibanTo);
            amountOnIbanTo += howMuch;
            bankRepository.setAccountBalanceDB(ibanTo, amountOnIbanTo);
        }
    }

}

