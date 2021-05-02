package PetManager;


import java.util.Date;

public class PetCommandFactory {


    public AbstractPetCommand createAddPetCommand(String name, String breed, int ID, String city, Date birthday, String petType)
    {

        return null; //need to fix this TODO

    }

    public AbstractPetCommand createDeletePetCommand(String name, String breed, int ID, String city, Date birthday, String petType)
    {
        return null; //TODO
    }

    public AbstractPetCommand createAddPetLogCommand(String type, Date date, String comment)
    {
        return null; //TODO
    }

    public AbstractPetCommand createDeletePetLogCommand(String type, Date date, String comment)
    {
        return null; //TODO
    }
}
