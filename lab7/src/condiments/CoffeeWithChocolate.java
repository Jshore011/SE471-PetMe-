package condiments;

import java.util.List;

public class CoffeeWithChocolate extends Condiment_DecoratedCoffee{
    private Condiment_IF condiment;

    CoffeeWithChocolate(Coffee_IF decoratedCoffee, Condiment_IF condiment) {
        super(decoratedCoffee);
        this.condiment = condiment;
    }

    @Override
    public List<Condiment_IF> getCondiment() {
        return null;
    }
}
