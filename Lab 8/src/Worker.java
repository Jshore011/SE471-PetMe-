public class Worker extends Employee{


    public Worker(){}
    public void seeDanger(HReporter_IF r, Hazard h)
    {

        r.seeDanger(r.getDirectOverseer(), h);

    }

    public void evacuate()
    {

    }

    public void fixIt()
    {
        System.out.println("The employee %s is fixing it");
    }
}
