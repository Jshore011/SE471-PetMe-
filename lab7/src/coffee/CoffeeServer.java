package coffee;

public abstract class CoffeeServer implements CoffeeServer_IF{
    private CoffeeServer_IF program;

    public void setProgram(CoffeeServer_IF program) {
        this.program = program;
    }

    public CoffeeServer_IF getProgram()
    {
        return program;
    }

    public abstract String getName();
    public abstract void start();
}
