package PetManager;

import java.util.ArrayList;

/**
 * Class that represents an entire PetLog journal full of logs
 */
public class PetLog {
    private PetLogType type;
    private ArrayList<LogEntry> entries;

    /**
     * Creates a new petlog
     * @param type type of pet log
     * @param entries logs to insert
     */
    public PetLog(PetLogType type, ArrayList<LogEntry> entries) {
        this.type = type;
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
     * Adds a new entry to the pet log
     * @param entry entry to add
     */
    public void addEntry(LogEntry entry) {
        this.entries.add(entry);
    }

    /**
     * Gets the pet log type for this log
     * @return pet log type
     */
    public PetLogType getType() {
        return type;
    }

    /**
     * Removes an entry from our petlog
     * @param index index to remove
     */
    public void removeEntry(int index) {
        this.entries.remove(index);
    }
}
