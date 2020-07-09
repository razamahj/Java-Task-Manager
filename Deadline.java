import java.text.DateFormat;
import java.util.Date;

/**
 * This class models a deadline which represents a date.
 * .
 * @author Dr A J Beaumont
 * @version 1.0
 */
public class Deadline {
    // dates are stored as the number of seconds since 01/01/1970
    private long deadline;
    // we have a DateFormat to format the date as text
    private DateFormat dateFormatter;
    
    // define some constants...
    public static final long SECOND = 1000;
    public static final long MINUTE = SECOND*60;
    public static final long HOUR = MINUTE * 60;
    public static final long DAY = HOUR*24;
    public static final long WEEK = DAY*7;
    
    /**
     * Construct a new deadline.  
     * By default, deadlines are one week ahead of the time now.
     */
    public Deadline() {
        // by default you get a week
        deadline = now() + WEEK;
        dateFormatter = DateFormat.getDateInstance();
    }
    
    /**
     * @return the time now as a long
     */
    private long now() {
        return new Date().getTime();
    }
    
    /**
     * Get the date of this deadline as a Date object.
     * @return the date of this deadline as a Date object.
     */
    private Date getDeadlineDate() {
        return new Date(deadline);
    }
    
    /**
     * Change the date of this deadline by a specified number of days.
     * @param numDays the number of days to add to the deadline date (may be negative).
     */
    public void setNewDeadline(int numDays) {
        deadline = deadline + (DAY*numDays);
    }
    
    /**
     * Find out if this deadline has passed.
     * @return true when the time now is later than the deadline.
     */
    public boolean hasPassed() {
        return now() > deadline;
    }
    
    /**
     * Return this deadline formatted as text to be printed.
     * @return a string representation of this deadline.
     */
    @Override
    public String toString() {
        return dateFormatter.format(getDeadlineDate());
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Deadline) {
            Deadline other = (Deadline) o;
            if (this.toString().equals(other.toString())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
}
