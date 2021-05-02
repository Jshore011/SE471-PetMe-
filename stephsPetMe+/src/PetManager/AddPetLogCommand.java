package PetManager;

import java.util.Date;

public class AddPetLogCommand {
    String type;
    Date date;
    String comment;

    /**
     * constructor
     * @param type log type
     * @param date date entry was made
     * @param comment comments related to log entry
     */
    AddPetLogCommand(String type, Date date, String comment)
    {
        this.type=type;
        this.date=date;
        this.comment=comment;
    }

    public void addPetLog()
    {
        //TODO
    }

    public void undoAddPetLog()
    {
        //TODO
    }
}
