import productManagament.ProductService;

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

    }
}