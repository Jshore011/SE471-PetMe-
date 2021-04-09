package coffee;

import coffee.AbstractCoffee;
import coffee.Coffee_IF;
import condiments.Condiment_IF;

public class CoffeeWithCream extends AbstractCoffee {
    private Condiment_IF condiment;
    private Coffee_IF decoratedCoffee;

    public CoffeeWithCream(Coffee_IF decoratedCoffee, Condiment_IF condiment) {
        super(decoratedCoffee);
        this.decoratedCoffee=decoratedCoffee;
        this.condiment = condiment;
    }


    public String getType() {
        return super.getType() + " " + condiment.getType();
    }
    public double getPrice() {
        return super.getPrice() + condiment.getPrice();
    }
}
