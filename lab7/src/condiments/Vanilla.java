package condiments;

public abstract class Vanilla implements Condiment_IF {
    private final String type;
    private final double price;

    public Vanilla() {
        price = 0.50;
        type = "Chocolate";
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
