/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

//import acm.program.*;           // for testing
import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

    /**
     * Creates a new NameSurferEntry from a data line as it appears
     * in the data file.  Each line begins with the name, which is
     * followed by integers giving the rank of that name for each
     * decade.
     */
    public NameSurferEntry(String line) {
        String[] splitResult = new String[12]; // 12 elements including the name
        splitResult = line.split(" ");
        name = splitResult[0];
        for (int i = 1; i < 12; i++) {
            ranks[i-1] = Integer.parseInt(splitResult[i]);
        }
    }
    

    /**
     * Returns the name associated with this entry.
     */
    public String getName() {
        // You need to turn this stub into a real implementation //
        return name;
    }


    /**
     * Returns the rank associated with an entry for a particular
     * decade.  The decade value is an integer indicating how many
     * decades have passed since the first year in the database,
     * which is given by the constant START_DECADE.  If a name does
     * not appear in a decade, the rank value is 0.
     */
    public int getRank(int decade) {
        // You need to turn this stub into a real implementation //
        return ranks[decade];
    }


    /**
     * Returns a string that makes it easy to see the value of a
     * NameSurferEntry.
     */
    public String toString() {
        String result = name + " [";
        for (int i = 0; i<NDECADES; i++) {
            result += ranks[i];
            result += " ";
        }
        result += "]";
        return result;
    }


    /* instance variables */
    private String name;
    private int[] ranks = new int[NDECADES];
}

