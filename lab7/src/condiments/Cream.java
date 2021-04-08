package condiments;

public class Cream implements Condiment_IF {
    private final String type;
    private final double price;

    public Cream() {
        price = 0.25;
        type = "Cream";
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
