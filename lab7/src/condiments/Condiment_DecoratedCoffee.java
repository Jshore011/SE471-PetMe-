package condiments;

import coffee.Coffee_IF;

public abstract class Condiment_DecoratedCoffee implements Coffee_IF {
    private Coffee_IF decoratedCoffee;

    Condiment_DecoratedCoffee(Coffee_IF decoratedCoffee){

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
