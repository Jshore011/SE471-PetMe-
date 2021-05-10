package utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Date utility helper for conversion to and from unix timestamp
 */
public class DateUtils {
    /**
     * Converts a LocalDateTime to it's unix timestamp in milliseconds
     * @param ldt LocalDateTime Object
     * @return Unix time stamp in milliseconds
     */
    public static long dateToEpochMilli(LocalDateTime ldt) {
        ZoneOffset off = OffsetDateTime.now().getOffset();
        Instant instant = ldt.toInstant(off);
        return instant.toEpochMilli();
    }

    /**
     * Converts a unix timestamp to a LocalDateTime representation
     * @param millis milliseconds since epoch
     * @return new LocalDateTime object
     */
    public static LocalDateTime epochMilliToDate(long millis) {
        ZoneOffset off = OffsetDateTime.now().getOffset();
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), off);
    }
}
