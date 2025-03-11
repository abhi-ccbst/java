package bank;

public interface BankInterface {
    void deposit(int amount, String user);
    void withdraw(int amount, String user);
    void transfer(BankAccount targetAccount, int amount, String user);

}
