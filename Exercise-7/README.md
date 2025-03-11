Multi-threaded Banking System with Optimized Thread Management
Problem Statement
Design a highly concurrent banking system where multiple users can deposit, withdraw, and transfer money efficiently. Instead of manually creating threads for each transaction, optimize thread management using a thread pool (ExecutorService) to limit the number of concurrent threads and improve performance.

Requirements
Create a BankAccount class

Store an account number, balance, and methods for deposit(), withdraw(), and transfer().
Ensure thread safety with synchronization (synchronized, ReentrantLock).
Implement a Bank class to manage multiple accounts

Store multiple BankAccount objects.
Provide a method for users to perform transactions.
Use an ExecutorService to manage threads efficiently

Instead of creating new threads for each transaction, use a fixed thread pool to optimize system performance.
Display the number of active threads processing transactions