import java.util.List;

public abstract class DirectAdministrator extends Administrator {

    //ctr
    public DirectAdministrator(String name, List<Employee> members) {
        super(name, members);
    }

    //reports to overseer
    @Override
    public void seeDanger(HReporter_IF r, Hazard h) {
        // Direct Administrator tells all of his/her team members to
        // perform fixIt()
        System.out.println("Instructing all team members to fix it...");
        for (HReporter_IF member : getMembers()) {
            if (member != r)
                member.seeDanger(this, h);
        }

        // Direct Administrator informs overseer
        if (getDirectOverseer() != null) {
            System.out.println("Notifying manager...\n");
            getDirectOverseer().seeDanger(this, h);
        }
    }

    //returns whether or not a decision has been made and feedback
    public boolean getFeedback(Hazard hazard) {
        System.out.println("Feedback by " + getName());
        return hazard.getHazard_level() > 0;
    }

}
