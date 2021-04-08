package condiments;

public class Chocolate implements Condiment_IF {
    private final String type;
    private final double price;

    public Chocolate() {
        price = 1.00;
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
