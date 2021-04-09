package coffee;

public abstract class AbstractCoffee implements Coffee_IF {
    private Coffee_IF decoratee;

    /*
     * Constructor
     */
    public AbstractCoffee(Coffee_IF decoratee) {
        this.decoratee = decoratee;
    }

    /*
     * Returns the decoratee's type
     */
    @Override
    public String getType() {
        return decoratee.getType();
    }

    /*
     * Returns the decoratee's price
     */
    @Override
    public double getPrice() {
        return decoratee.getPrice();
    }

}
