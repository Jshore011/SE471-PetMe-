package condiments;

public class Cream implements Condiment_IF {
    private final String type;
    private final double price;

    public Cream() {
        price = 0.25;
        type = "Cream";
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
