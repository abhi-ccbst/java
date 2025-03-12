import bank.Bank;
import bank.BankAccount;
import bank.DaemonThreadExample;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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

        String[] name = new String[3];
        name[0] = "Abhi";
        name[1] = "Test";
        name[2] = "Meet";
        List<String> test = Arrays.asList(name);
        Set<String> collectedList = test.stream().collect(Collectors.toSet());
        String xyz = "Abhi Patel";
        System.out.println(Arrays.stream(xyz.split(" ")).collect(Collectors.summingInt(x -> x.length())));

        List<Integer> intcount = List.of(1,2,3,4);
        System.out.println(intcount.stream().collect(Collectors.summingInt(x ->x)));
        List<String> names = List.of("Alice", "Bob", "Charlie");
        Map<String, Integer> nameLengths = names.stream().collect(Collectors.toMap(x -> x, x->x.length()));
        System.out.println(nameLengths);

        List<BlogPost> posts = Arrays.asList(
                new BlogPost("Java 17 Features", "Alice", BlogPostType.NEWS, 150),
                new BlogPost("Spring Boot Guide", "Bob", BlogPostType.GUIDE, 250),
                new BlogPost("Best Laptops 2025", "Charlie", BlogPostType.REVIEW, 180),
                new BlogPost("Tech News Today", "Alice", BlogPostType.NEWS, 90),
                new BlogPost("Spring Boot vs Quarkus", "David", BlogPostType.GUIDE, 300),
                new BlogPost("Phone Reviews 2025", "Eve", BlogPostType.REVIEW, 220)
        );

        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().collect(Collectors.groupingBy(e ->e.type));
        System.out.println(postsPerType);

        Map<AuthPostTypes, Set<BlogPost>> postsPerAuthorType = posts.stream().collect(Collectors.groupingBy(
                e -> new AuthPostTypes(e.author, e.type), Collectors.toSet()
        ));
        System.out.println(postsPerAuthorType);

        Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream().collect(Collectors.groupingBy(
                e->e.author, Collectors.groupingBy(f -> f.type)
        ));
        System.out.println(map);
    }

    public static record AuthPostTypes(String author, BlogPostType type) {
        @Override
        public String toString() {
            return "{Author: " + author + ", Type: " + type + "}";
        }
    }
    public static class BlogPost {
        String title;
        String author;
        BlogPostType type;
        int likes;

        public BlogPost(final String title, final String author, final BlogPostType type, final int likes) {
            this.title = title;
            this.author = author;
            this.type = type;
            this.likes = likes;
        }

        @Override
        public String toString() {
            return "title: " + title +
                    " author: " + author +
                    " likes: " + likes;
        }
    }
    public static enum BlogPostType {
        NEWS,
        REVIEW,
        GUIDE
    }
}

//toList()	Converts stream to List	collect(Collectors.toList())
//toSet()	Converts stream to Set (removes duplicates)	collect(Collectors.toSet())
//toMap()	Converts stream to Map	collect(Collectors.toMap())
//joining()	Joins elements into a single String	collect(Collectors.joining(","))
//counting()	Counts elements in the stream	collect(Collectors.counting())
//summingInt()	Sums values in the stream	collect(Collectors.summingInt(x -> x))
//groupingBy()	Groups elements based on a condition	collect(Collectors.groupingBy(x -> x.length()))