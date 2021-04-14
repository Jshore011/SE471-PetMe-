import java.util.List;

public abstract class Administrator extends Employee{
    public List<Employee> members;

    public Administrator(List<Employee> members) {
        this.members=members;

    }

    public Administrator() {

        super();
    }


    public abstract void seeDanger(HReporter_IF r, Hazard h);

    public void evacuate() {
    for(Employee e:members)
    {
        e.evacuate();
    }
    this.evacuate();
    }
}
