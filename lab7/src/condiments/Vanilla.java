package condiments;

public abstract class Vanilla implements Condiment_IF {
    private final String type;
    private final double price;

    public Vanilla() {
        price = 0.50;
        type = "Vanilla";
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
