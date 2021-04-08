package condiments;

import coffee.Coffee_IF;

public abstract class CoffeeWithVanilla extends AbstractCoffee{
    private Condiment_IF condiment;
    private Coffee_IF decoratedCoffee
            ;
    CoffeeWithVanilla(Coffee_IF decoratedCoffee, Condiment_IF condiment) {
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
