public class Product {
    private String name;
    private int prodID;
    private double price;

    Product(String name, int prodID, double price)
    {
        this.name = name;
        this.prodID = prodID;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getProdID() {
        return prodID;
    }

    public double getPrice() {
        return price;
    }

}
