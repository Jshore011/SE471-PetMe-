package condiments;

public class Vanilla implements Condiment_IF {
    private final String type;
    private final double price;

    public Vanilla() {
        price = 0.50;
        type = "Vanilla";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    //@Override
    public String returnType() {
        return null;
    }
    //@Override
    public double returnPrice(){
        return 0;
    }
}
