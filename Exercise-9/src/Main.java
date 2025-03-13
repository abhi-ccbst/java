import productManagament.MyFunctionalInterface;
import productManagament.Product;
import productManagament.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        System.out.println("Task 1: " + productService.task1());
        System.out.println("Task 2: " + productService.task2());
        System.out.println("Task 3: " + productService.task3());
        System.out.println("Task 4: " + productService.task4());
        System.out.println("Task 5: " + productService.task5());
        System.out.println("Task 6: " + productService.task6());
        System.out.println("Task 7: " + productService.task7());
        System.out.println("Task 8: " + productService.task8());

        // Lamda
        // () -> {}
        // (paramerter) -> { return xyz;}
        // Use Java's Consumer interface to store a lambda expression in a variable:
        Consumer<Integer> res = (e) -> {System.out.println(e);};
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);

        numbers.forEach(res);

        MyFunctionalInterface<String> obj = (n) -> "Hello to: " + n;
        System.out.println(obj.show("Abhi"));

        MyFunctionalInterface<Product> objProduct = (product) -> new Product(1,
                product.getName(),
                product.getCategory(),
                product.getPrice() + 10,
                5,
                0);
        System.out.println(objProduct.show(productService.task2()));

        // Filter
        Predicate<Integer> isEven = num -> num %2 == 0;
        System.out.println(isEven.test(11));

        Function<String, Integer> lengthFuc = str -> {return str.length();};
        System.out.println(lengthFuc.apply("Abhi"));

        //ForEach
        Consumer<String> print = msg -> System.out.println(msg);
        print.accept("Test");

        //Supplier
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 50);
        scores.put("Bob", 75);
        scores.put("Charlie", 90);
        Function<Map<String, Integer>, Map<String, Integer>> increaseScores = map ->
            map.entrySet().stream().collect(Collectors.toMap(key -> key.getKey(), value -> value.getValue() + 10));
        System.out.println(increaseScores.apply(scores));

    }
}