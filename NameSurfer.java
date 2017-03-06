/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 * 
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

    /* Method: init() */
    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the bottom of the window.
     */
    public void init() {
        nameField = new JTextField(10);
        add(new JLabel("Name"), SOUTH);
        add(nameField, SOUTH);
        nameField.addActionListener(this);
        add(new JButton("Graph"), SOUTH);        
        add(new JButton("Clear"), SOUTH);

        addActionListeners();

        graph = new NameSurferGraph();
        add(graph);

        // NameSurferEntry test = new NameSurferEntry("Sam 58 69 99 131 168 236 278 380 467 408 466");
        // println(test.getName());
        // println(test.getRank(0));
        // println(test.getRank(2));        
        // println(test.toString());

        //NameSurferDataBase db = new NameSurferDataBase("names-data.txt");
        //        println (db.findEntry("Samantha").toString()); 
        
    }

    /* Method: actionPerformed(e) */
    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nameField) {
            //            println("textField " + nameField.getText());
            entry = sd.findEntry(nameField.getText());
            graph.addEntry(entry);
            graph.update();
            
        }
        if (e.getActionCommand().equals("Graph")) {
            entry = sd.findEntry(nameField.getText());
            graph.addEntry(entry);
            graph.update();
        }
        if (e.getActionCommand().equals("Clear")) {
            graph.clear();
            graph.update();
        }
    }


    /* Instance variables */
    private JTextField nameField;
    private NameSurferGraph graph;
    private NameSurferDataBase sd = new NameSurferDataBase("names-data.txt");
    private NameSurferEntry entry;
    
}
