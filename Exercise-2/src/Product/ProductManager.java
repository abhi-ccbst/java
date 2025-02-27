package Product;

import java.util.*;

public class ProductManager {
    private List<Product> products;
    private Map<Integer, Product> productMap;

    public ProductManager() {
        this.products = new ArrayList<>();
        this.productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        int id = products.size() + 1;
        products.add(product);
        productMap.put(id, product);
    }

    public void displayProducts() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println(product);
        }
    }

    public Product getProductById(int i) {
        return productMap.get(i);
    }
}
