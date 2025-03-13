📌 Practice: Java Streams - Product Management
🔹 Scenario: E-Commerce Product Processing
You are given a list of Product objects. Each product has the following attributes:

id (Integer)
name (String)
category (String) (e.g., Electronics, Clothing, Home)
price (Double)
rating (Double, out of 5.0)
stockQuantity (Integer)
Your task is to use Java Streams to perform various operations on this dataset.


📝 Task List
✅ 1. Filter and print all products that cost more than $500
✅ 2. Find the most expensive product
✅ 3. Find the cheapest product
✅ 4. Get the average price of all products in each category
✅ 5. Count the number of products available in each category
✅ 6. Get the top 3 highest-rated products
✅ 7. Find the total stock quantity of all products
✅ 8. Sort and display the products by price in descending order

💡 Bonus Challenge
1️⃣ Find the product with the highest stock quantity
return products.stream()
        .max(Comparator.comparingInt(Product::getStockQuantity)).get();

2️⃣ List all products sorted first by category, then by price (ascending)
return products.stream()
        .sorted(Comparator.comparing(Product::getCategory)
        .thenComparing(Product::getPrice))
        .collect(Collectors.toList());

3️⃣ Find how many products have a rating greater than 4.5
return products.stream()
        .filter(product -> product.getRating() > 4.5)
        .count();

