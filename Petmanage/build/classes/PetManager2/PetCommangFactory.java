/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetManager2;

import PetManager.LogEntry;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author owner
 */
public class PetCommangFactory {
    
    
    public AbstractPetCommand createAddPetCommand(String name, String breed, int ID, String city, Date birthday, String petType)
    {
        return null;
    }
    
    public AbstractPetCommand createDeletePetCommand(String name, String breed, int ID, String city, Date birthday, String petType)
    {
        return null;
    }
    
    public AbstractPetCommand createAddPetLogCommand(LocalDateTime date, String text, PetLogType type, ArrayList<LogEntry> entries)
    {
        return null;
    }
    
    public AbstractPetCommand createDeletePetLogCommand(String type, Date date, String comment)
    {
        return null;
    }
}
