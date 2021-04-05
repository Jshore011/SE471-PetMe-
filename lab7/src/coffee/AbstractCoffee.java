package coffee;

public abstract class AbstractCoffee implements CoffeeIF{
    private CoffeeIF program;

    public void setProgram(CoffeeIF program) {
        this.program = program;
    }

    protected CoffeeIF getProgram()
    {
        return program;
    }

    public abstract String getName();
    public abstract void start();
}
