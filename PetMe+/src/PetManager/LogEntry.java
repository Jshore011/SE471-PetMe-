package PetManager;

import java.time.LocalDateTime;

/**
 * Log entry that holds pet info log data
 */
public class LogEntry {
    public LocalDateTime date;
    public String text;

    /**
     * Creates a new Log entry
     * @param date date of log entry
     * @param text log contents
     */
    public LogEntry(LocalDateTime date, String text) {
        this.date = date;
        this.text = text;
    }
}
