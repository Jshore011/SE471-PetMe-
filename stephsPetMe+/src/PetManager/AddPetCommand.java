package PetManager;

import java.util.Date;

public class AddPetCommand {
    String name;
    String breed;
    int ID;
    String city;
    Date birthday;
    String petType;

    /**
     * constructor
     * @param name pet name
     * @param breed pet breed
     * @param ID pet ID
     * @param city pet city
     * @param birthday pet birthday
     * @param petType pet type
     */
    AddPetCommand(String name, String breed, int ID, String city, Date birthday, String petType)
    {
        this.name=name;
        this.breed=breed;
        this.ID=ID;
        this.city=city;
        this.birthday=birthday;
        this.petType=petType;
    }

    public void addPet()
    {
        //TODO
    }

    public void undoAddPet()
    {
        //TODO
    }
}
