Assignment: Bank Account Management System
Objective
Implement a banking system using Java concepts like inheritance, polymorphism, abstract classes, interfaces, exception handling, getters/setters, and Scanner.

🔹 Problem Statement
Create a Bank Account Management System where users can:

Create accounts (Savings & Current).
Deposit money.
Withdraw money (with overdraft for Current Account).
Display account details.
Handle exceptions (e.g., insufficient balance, invalid input).
🔹 Requirements
1. Abstract Class (BankAccount)
   Attributes: accountNumber, accountHolderName, balance.
   Abstract methods: deposit(double amount), withdraw(double amount).
   Getters & Setters.
2. Subclasses (SavingsAccount, CurrentAccount)
   SavingsAccount: Has a minimum balance of 500. Prevents withdrawal below this.
   CurrentAccount: Allows overdraft up to -1000.
3. Interface (AccountOperations)
   void displayAccountDetails();
4. Exception Handling
   InsufficientBalanceException (Custom Exception for withdrawals).
   Handle invalid inputs using try-catch.
5. User Input (Scanner)
   Allow users to interact via menu-driven program.