package coffee;

import condiments.Condiment_IF;

public interface CoffeeServer_IF {

    void setProgram(CoffeeOS coffeeOS);
    void start();
    void addCondiment(Condiment_IF condiment);
    Coffee_IF getCoffee();

        // stores the different types of coffee servers
        enum CoffeeType {
            Regular,
            Mocha,
            Latte,
            Espresso,
            Cappuccino
        }
}
