package coffee;

import condiments.Condiment_IF;
import CoffeeMachine.CoffeeOS_API;
public interface CoffeeServer_IF {

    void setEnvironment(CoffeeOS_API program);
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
