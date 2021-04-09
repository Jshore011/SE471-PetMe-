package condiments;

public abstract class Chocolate implements Condiment_IF {
    private final String type;
    private final double price;

    public Chocolate() {
        price = 1.00;
        type = "Chocolate";
    }
<<<<<<< HEAD

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    //@Override
=======
    @Override
>>>>>>> 4519b6d50e1d40b4f1b9e3537a0bc1c3b6816978
    public String returnType() {
        return null;
    }
    //@Override
    public double returnPrice(){
        return 0;
    }
}
