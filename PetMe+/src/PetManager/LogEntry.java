package PetManager;

import java.time.LocalDateTime;

/**
 * Log entry that holds pet info log data
 */
public abstract class LogEntry {
    public LocalDateTime date;
    public String text;
   
    /**
     * Creates a new Log entry
     * @param date date of log entry
     * @param text log contents
     */
    public LogEntry() {
        
    }
    public void newEntry(String text, LocalDateTime date)
    {
        this.date=date;
        this.text=text;
        
    }
    abstract public void accept(PetLogVisitor_IF visitor);
}
