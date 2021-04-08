package condiments;

import coffee.Coffee_IF;

public abstract class CoffeeWithChocolate extends Condiment_DecoratedCoffee{
    private Condiment_IF condiment;

    CoffeeWithChocolate(Coffee_IF decoratedCoffee, Condiment_IF condiment) {
        super(decoratedCoffee);
        this.condiment = condiment;
    }

   public double getPrice(){
        return super.getPrice()+condiment.returnPrice();
   }

   public String getType()
   {
       return super.getType();
   }
}
