/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetManager;

import java.util.ArrayList;



/**
 *
 * @author owner
 */
public class DietLog extends PetLog{
public ArrayList<LogEntry> entries;
    public PetLogVisitor_IF visitor;
    public DietLog(PetLogVisitor_IF visitor, ArrayList<LogEntry> entries)
    {
        this.visitor=visitor;
        this.entries=entries;
    }
    @Override
   public void accept(PetLogVisitor_IF visitor){
       visitor.visitDiet(this);
   }
   @Override
  public String toString() {
    return "Diet";
  }
}
