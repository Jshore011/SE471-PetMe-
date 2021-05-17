package PetManager;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that represents an entire PetLog journal full of logs
 */
public class PetLog extends LogEntry {

    
   // public PetLogType type;
    private ArrayList<LogEntry> entries;
    public PetLogVisitor_IF visitor;

    /**
     * Creates a new petlog
     * @param visitor
     * @param entries logs to insert
     */
    public PetLog(PetLogVisitor_IF visitor, ArrayList<LogEntry> entries) {
        this.visitor = visitor;
        this.entries = entries;
    }

    /**
     * Retrieves the amount of pet logs stored
     * @return pet logs stored
     */
    public int getSize() {
        return entries.size();
    }

    /**
     * Retrieves a petlog
     * @param index index to retrieve from
     * @return pet log
     */
    public LogEntry getEntry(int index) {
        return entries.get(index);
    }

    /**
     * Adds a new diet entry to the pet log
     * @param entry entry to add
     */
    public void addDietEntry(DietLog entry) {
        this.entries.add(entry);
    }
/**
     * Adds a new exercise entry to the pet log
     * @param entry entry to add
     */
    public void addExerciseEntry(ExerciseLog entry) {
        this.entries.add(entry);
    }
    /**
     * Adds a new diet entry to the pet log
     * @param entry entry to add
     */
    public void addMedicineEntry(MedicineLog entry) {
        this.entries.add(entry);
    }
    /**
     * Gets the pet log type for this log
     * @return pet log type
     */
    //public PetLog getType() {
   //     return type;
    //}

    /**
     * Removes an entry from our petlog
     * @param index index to remove
     */
    public void removeEntry(int index) {
        this.entries.remove(index);
    }
    
    public void accept(PetLogVisitor_IF visitor)
    {
        //for each entry in the log, accept visitor
        for (Iterator<LogEntry> it = entries.iterator(); it.hasNext();) {
            visitor = (PetLogVisitor_IF) it.next();
            accept(visitor);
        }
    }
}
