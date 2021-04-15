import java.util.List;

public abstract class Administrator extends Employee{
    public List<Employee> members;

        //ctr
    public Administrator(String name, List<Employee> members) {
        super(name);
        this.members=members;

    }

    //abstract method seeDanger
    public abstract void seeDanger(HReporter_IF r, Hazard h);

    //method telling employees to evacuate
    public void evacuate() {
    for(Employee e:members)
    {
        e.evacuate();
        System.out.println("The Employee " + getName() + " is evacuating");
    }

    }

    //getter for employee's in the list
    public List<Employee> getMembers()
    {
        return members;
    }
}
