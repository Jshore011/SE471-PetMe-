package coffee;

public interface CoffeeServer_IF {

    public interface CoffeeServerIF {
        void setProgram(CoffeeOS_API env);
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
