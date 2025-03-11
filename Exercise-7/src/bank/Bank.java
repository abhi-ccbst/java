package bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount bankAccount) {
        accounts.put(bankAccount.getAccountNumber(), bankAccount);
    }

    public BankAccount getAccount(final int accountNumber) {
        return accounts.get(accountNumber);
    }
}
