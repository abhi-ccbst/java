package productManagament;

public class Product {
    private final int id;
    private final String name;
    private final String category;
    private final double price;
    private final double rating;
    private final int stockQuantity;

    public Product(int id, String name, String category, double price, double rating, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.stockQuantity = stockQuantity;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public int getStockQuantity() { return stockQuantity; }

    @Override
    public String toString() {
        return name + " (" + category + ", $" + price + ", Rating: " + rating + ")";
    }

}
