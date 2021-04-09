package condiments;

import coffee.Coffee_IF;

public abstract class AbstractCoffee implements Coffee_IF {
    private final Coffee_IF decoratedCoffee;

    AbstractCoffee(Coffee_IF decoratedCoffee){

        this.decoratedCoffee=decoratedCoffee;
    }

    @Override
    public double getPrice() {
        return decoratedCoffee.getPrice();
    }

    public String getType()
    {
        return decoratedCoffee.getType();
    }
}
