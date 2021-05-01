package PetManager;


public abstract class AbstractPetCommand {

    public abstract void AddPet();
    public abstract void deletePet();
    public abstract void undoAddPet();
    public abstract void undoDeletePet();
    public abstract void addPetLog();
    public abstract void deletePetLog();
    public abstract void undoAddPetLog();
    public abstract void undoDeletePetLog();
}
