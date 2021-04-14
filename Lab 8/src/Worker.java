public class Worker extends Employee{

    public Worker(){
        super();

    }
    @Override
    public void seeDanger(HReporter_IF r, Hazard h) {
        if(r!=null)
        {
            fixIt();
        }
        else
        {
            fixIt();
            getDirectOverseer().seeDanger(this, new Hazard("gas leak", "large tank", 5));
        }
    }

    @Override
    public void evacuate() {
        this.evacuate();
    }

    public void fixIt(){
        System.out.println("The Employee is fixing it");
    }
}
