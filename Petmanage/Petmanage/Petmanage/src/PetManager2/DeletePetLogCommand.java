/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetManager2;

import java.util.Date;

/**
 *
 * @author owner
 */
public class DeletePetLogCommand {
    String name;
    String breed;
    int ID;
    String city;
    Date birthday;
    String petType;
     DeletePetLogCommand(String name, String Breed, int ID, String city, Date birthday, String petType)
     {
         this.name=name;
         this.breed=breed;
         this.ID=ID;
         this.city=city;
         this.birthday=birthday;
         this.petType=petType;
         
     }
     
     public void deletePetLog(){
         
     }
     
     public void undoDeletePetLog(){
         
     }
}
