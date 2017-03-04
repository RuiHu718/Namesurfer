/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

import java.util.*;
import java.io.*;

public class NameSurferDataBase implements NameSurferConstants {
	
    /**
     * Creates a new NameSurferDataBase and initializes it using the
     * data in the specified file.  The constructor throws an error
     * exception if the requested file does not exist or if an error
     * occurs as the file is being read.
     */
    public NameSurferDataBase(String filename) {
        // standard file reading IO code
        BufferedReader rd = openFileReader(filename);
        try {
            while (true) {
                String line = rd.readLine();
                if (line == null) break;
                String name = getName(line);
                lineMap.put(name, line);
            }
            rd.close();
        } catch (IOException ex) {
            // error message
        }
    }


    // return only the name part given a line of data
    private String getName(String line) {
        // note the code here relies heavily on the data
        // to have proper format: no space at the beginning
        // only one space in between ints
        String name = " ";
        name = line.substring(0, line.indexOf(" "));
        // make all names upper case so don't have to worry about this later        
        return name.toUpperCase(); 
    }
    

    private BufferedReader openFileReader(String name) {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(name));
        } catch (IOException ex) {
            // error message
        }
        return rd;
    }


    /**
     * Returns the NameSurferEntry associated with this name, if one
     * exists.  If the name does not appear in the database, this
     * method returns null.
     */
    public NameSurferEntry findEntry(String name) {
        if (lineMap.containsKey(name.toUpperCase())) {
            NameSurferEntry entry = new NameSurferEntry(lineMap.get(name.toUpperCase()));
            return entry;
        } else {
            return null;
        }
    }


    /* instance variables */
    //use hashmap for database internal data structure
    private HashMap<String, String> lineMap = new HashMap<String, String>();
}

