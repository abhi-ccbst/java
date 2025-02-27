import Product.*;

public class Main {
    public static void main(String[] args) {
        Product electronics1 = new Electronics("Smartphone", 699.99, "Latest model smartphone with advanced features.");
        Product electronics2 = new Electronics("Laptop", 999.99, "Powerful laptop for work and gaming.");
        Product clothing1 = new Clothing("T-Shirt", 19.99, "Comfortable cotton T-shirt.");
        Product clothing2 = new Clothing("Jeans", 49.99, "Stylish denim jeans.");

        ProductManager productManager = new ProductManager();
        productManager.addProduct(electronics1);
        productManager.addProduct(electronics2);
        productManager.addProduct(clothing1);
        productManager.addProduct(clothing2);

        System.out.println("All Products:");
        productManager.displayProducts();

        System.out.println("\nProduct with ID 2:");
        Product productById = productManager.getProductById(2);
        System.out.println(productById);
    }
}