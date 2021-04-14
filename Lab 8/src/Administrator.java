public abstract class Administrator extends Employee{
    private Employee members;

    public Administrator(Employee members) {
        this.members=members;

    }

    public Administrator() {

    }

    public abstract void seeDanger(HReporter_IF r, Hazard h);

    public void evacuate() {

    }
}
