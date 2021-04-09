package condiments;

public class Vanilla implements Condiment_IF {
    private final String type;
    private final double price;

    public Vanilla() {
        price = 0.50;
        type = "Chocolate";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String returnType() {
        return type;
    }
    @Override
    public double returnPrice(){
        return price;
    }
}
