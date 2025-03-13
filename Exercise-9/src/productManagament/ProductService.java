package productManagament;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    List<Product> products = List.of(
            new Product(1, "Laptop", "Electronics", 1200, 4.5, 10),
            new Product(2, "Smartphone", "Electronics", 800, 4.7, 25),
            new Product(3, "T-Shirt", "Clothing", 30, 4.0, 100),
            new Product(4, "Refrigerator", "Home", 1500, 4.6, 5),
            new Product(5, "Headphones", "Electronics", 150, 4.3, 50),
            new Product(6, "Jeans", "Clothing", 60, 4.2, 80),
            new Product(7, "Microwave", "Home", 300, 4.1, 15),
            new Product(8, "TV", "Electronics", 1000, 4.8, 8)
    );

    // ✅ Task 1: Products that cost more than $500
    public List<Product> task1() {
        return products.stream()
                .filter(p -> p.getPrice() > 500)
                .collect(Collectors.toList());
    }

    // ✅ Task 2: Most expensive product
    public Product task2() {
        return products.stream()
                .max(Comparator.comparing(e -> e.getPrice())).get();
    }

    // ✅ Task 3: Cheapest product
    public Product task3() {
        return products.stream()
                .min(Comparator.comparing(e -> e.getPrice())).get();
    }

    // ✅ Task 4: Average price per category
    public Map<String, Double> task4() {
        return products.stream().collect(Collectors.groupingBy(
                e-> e.getCategory(), Collectors.averagingDouble(f -> f.getPrice())
        ));
    }

    // ✅ Task 5: Count products in each category
    public Map<String, Long> task5() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    // ✅ Task 6: Top 3 highest-rated products
    public List<String> task6() {
        return products.stream()
                    .sorted(Comparator.comparing(Product::getRating).reversed())
                    .limit(3)
                    .map(e -> e.getName())
                    .collect(Collectors.toList());
    }

    // ✅ Task 7: Total stock quantity of all products
    public int task7() {
        return products.stream()
                .mapToInt(Product::getStockQuantity)
                .sum();
    }

    // ✅ Task 8: Sort products by price (descending)
    public List<Product> task8() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }


}
