package PetManager;


import java.util.Date;

public class DeletePetCommand {
    String name;
    String breed;
    int ID;
    String city;
    Date birthday;
    String petType;

    /**
     * constructor
     * @param name pet's name
     * @param breed pet's breed
     * @param ID pet ID
     * @param city pet City
     * @param birthday pet Birthday
     * @param petType type of pet
     */
    DeletePetCommand(String name, String breed, int ID, String city, Date birthday, String petType)
    {
        this.name=name;
        this.breed=breed;
        this.ID=ID;
        this.city=city;
        this.birthday=birthday;
        this.petType=petType;
    }

    public void deletePet()
    {
       //TODO
    }

    public void undoDeletePet()
    {
        //TODO
    }
}
