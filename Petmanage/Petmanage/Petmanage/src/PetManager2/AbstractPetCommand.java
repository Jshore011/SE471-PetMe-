/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetManager2;

/**
 *
 * @author owner
 */
public abstract class AbstractPetCommand {
    
    public void addPet();
    public void deletePet();
    public void undoAddPet();
    public void undoDeletePet();
    public void addPetLog();
    public void deletePetLog();
    public void undoAddPetLog();
    public void undoDeletePetLog();
}
