public class Worker extends Employee {

    //ctr
    public Worker(String name) {
        super(name);
    }

    //prints that the worker is fixing it
    public void fixIt() {
        System.out.println("The employee " + getName() + " is fixing it.");
    }

   //see danger
    @Override
    public void seeDanger(HReporter_IF r, Hazard h) {
        if (r != null) {
            fixIt();
        } else {
            fixIt();
            System.out.println("Notifying direct overseer...\n");
            getDirectOverseer().seeDanger(this, h);
        }
    }

    //prints the employees who are evacuating
    @Override
    public void evacuate() {
        System.out.println("The employee " + name + " is evacuating.");
    }


}
