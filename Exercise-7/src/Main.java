import bank.Bank;
import bank.BankAccount;
import bank.DaemonThreadExample;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        DaemonThreadExample daemonThread = new DaemonThreadExample();
        daemonThread.setDaemon(true);
        daemonThread.setName("Daemon Thread");
        daemonThread.start();
        try  {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        ExecutorService executor = Executors.newFixedThreadPool(30);
        Bank bank = new Bank();
        BankAccount acc1 = new BankAccount(101, 500);
        BankAccount acc2 = new BankAccount(102, 1000);
        BankAccount acc3 = new BankAccount(103, 700);
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);

        executor.submit(() -> acc1.deposit(200, "Alice"));
        executor.submit(() -> acc2.withdraw(500, "Bob"));
        executor.submit(() -> acc3.transfer(acc1, 300, "Charlie"));
        executor.submit(() -> acc1.withdraw(700, "David"));
        executor.submit(() -> acc2.deposit(600, "Eve"));
        executor.submit(() -> acc3.withdraw(800, "Frank"));

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nFinal Account Balances:");
        System.out.println("Account 101: $" + acc1.getBalance());
        System.out.println("Account 102: $" + acc2.getBalance());
        System.out.println("Account 103: $" + acc3.getBalance());
    }
}