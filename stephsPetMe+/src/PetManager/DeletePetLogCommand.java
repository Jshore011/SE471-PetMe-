package PetManager;


import java.util.Date;

public class DeletePetLogCommand {
    String type;
    Date date;
    String comment;

    /**
     * constructor
     * @param type type of log entry
     * @param date date the entry was made
     * @param comment any comments made on the pet log
     */
    DeletePetLogCommand(String type, Date date, String comment)
    {
        this.type=type;
        this.date=date;
        this.comment=comment;
    }

    public void deletePetLog()
    {
        //TODO
    }

    public void undoDeletePetLog()
    {
        //TODO
    }
}
