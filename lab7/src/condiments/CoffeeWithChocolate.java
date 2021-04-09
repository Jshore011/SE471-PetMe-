package condiments;

import coffee.Coffee_IF;

public class CoffeeWithChocolate extends AbstractCoffee{
    private Condiment_IF condiment;
    private Coffee_IF decoratedCoffee;

    public CoffeeWithChocolate(Coffee_IF decoratedCoffee, Condiment_IF condiment) {
        super(decoratedCoffee);
        this.decoratedCoffee=decoratedCoffee;
        this.condiment = condiment;
    }

    public String getType() {
        return super.getType() + " " + condiment.getType();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + condiment.getPrice();
    }
}
