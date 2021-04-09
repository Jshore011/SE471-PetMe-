package condiments;

public class Chocolate implements Condiment_IF {
    private final String type;
    private final double price;

    public Chocolate() {
        price = 1.00;
        type = "Chocolate";
    }
    public String returnType() {
        return null;
    }

    public double returnPrice() {
        return 0;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

}
