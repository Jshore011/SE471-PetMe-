public class Product {
    private final String name;
    private final int prodID;
    private final double price;

    public Product(String name, int prodID, double price)
    {
        this.name = name;
        this.prodID = prodID;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getProdID() {
        return this.prodID;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", prodID=" + prodID +
                ", price=" + price +
                "}\n";
    }
}
