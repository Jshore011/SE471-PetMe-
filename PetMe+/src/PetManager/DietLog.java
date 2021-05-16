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

    public DietLog(PetLogVisitor_IF visitor, ArrayList<LogEntry> entries) {
    super(visitor, entries);
  }
    @Override
   public void accept(PetLogVisitor_IF visitor){
       visitor.visitDiet(this);
       super.accept(visitor);
   }
   @Override
  public String toString() {
    return "Diet";
  }
}
