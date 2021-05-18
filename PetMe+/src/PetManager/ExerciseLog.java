/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetManager;

import java.time.LocalDateTime;
import java.util.ArrayList;



/**
 *
 * @author owner
 */
public class ExerciseLog extends PetLog{

    public ExerciseLog(PetLogVisitor_IF visitor, ArrayList<LogEntry> entries) {
    super(visitor, entries);
  }
     @Override
   public void accept(PetLogVisitor_IF visitor){
       visitor.visitExercise(this);
       super.accept(visitor);
   }
   
   @Override
  public String toString() {
    return "Exercise";
  }

    public void newEntry(String comments, LocalDateTime dt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}

