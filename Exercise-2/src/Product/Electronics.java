package Product;

public class Electronics implements Product {
    private String name;
    private double price;
    private String description;

    public Electronics(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Electronics [name=" + name + ", price=" + price + ", description=" + description + "]";
    }
}
