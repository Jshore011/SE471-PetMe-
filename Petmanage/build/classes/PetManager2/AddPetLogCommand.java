/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetManager2;
import PetManager.LogEntry;
import PetManager2.Pet;
import java.util.Date;
import PetManager2.PetLogType;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author owner
 */
public class AddPetLogCommand {
    public LocalDateTime date;
    public String text;
    private PetLogType type;
    private ArrayList<LogEntry> entries;
    
     AddPetLogCommand(LocalDateTime date, String text, PetLogType type, ArrayList<LogEntry> entries)
     {
        this.date = date;
        this.text = text;
        this.type = type;
        this.entries = entries;
     }
     
     public void addPetLog(LogEntry entry)
     {
         this.entries.add(entry);
     }
     
     public void undoAddPetLog()
     {
         
     }
}
