package bank;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount implements BankInterface{
    private final int accountNumber;
    private int balance;
//    private final ReentrantLock lock = new ReentrantLock();
    private final Semaphore lock = new Semaphore(1);
    public BankAccount(final int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void deposit(int amount, String user) {

        try {
            lock.acquire();
            balance+=amount;
            System.out.println(user + " deposited $" + amount + " to Account " + accountNumber + " | New Balance: $" + balance);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            lock.release();
        }
    }

    @Override
    public void withdraw(int amount, String user) {

        try {
            lock.acquire();
            if (balance >= amount) {
                balance -= amount;
                System.out.println(user + " withdrew $" + amount + " from Account " + accountNumber + " | New Balance: $" + balance);
            } else {
                System.out.println(user + " failed to withdraw $" + amount + " due to insufficient balance.");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.release();
        }
    }

    @Override
    public void transfer(BankAccount targetAccount, int amount, String user) {
//        lock.lock();
        try {
            lock.acquire();
            if (balance >= amount) {
                balance -= amount;
                targetAccount.deposit(amount, user);
                System.out.println(user + " transferred $" + amount + " from Account " + accountNumber + " to Account " + targetAccount.getAccountNumber());
            } else {
                System.out.println(user + " failed to transfer $" + amount + " due to insufficient balance.");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.release();
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


}
