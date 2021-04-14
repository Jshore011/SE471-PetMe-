public abstract class DirectAdministrator extends Administrator{
    private boolean feedback = false;
    public boolean getFeedback() {
        return feedback;
    }

    @Override
    public void seeDanger(HReporter_IF r, Hazard h) {
        System.out.println(name + "got it!");
        for(Employee e: members)
        {
            if(e!=r)
            {
                e.seeDanger(this, h);
            }

        }
        if(overseer != null)
        {
            overseer.seeDanger(this, h);
        }
    }
}
