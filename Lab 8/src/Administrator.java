public abstract class Administrator extends Employee{


    public Administrator(String name, Administrator overseer) {
        super(name, overseer);
    }

    public abstract void seeDanger(HReporter_IF r, Hazard h);

    public void evacuate() {

    }
}
