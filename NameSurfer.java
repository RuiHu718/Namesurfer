/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 * need to commit
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

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

        NameSurferEntry test = new NameSurferEntry("Sam 58 69 99 131 168 236 278 380 467 408 466");
        println(test.getName());
        println(test.getRank(0));
        println(test.getRank(5));        
        println(test.toString());
        
    }

    /* Method: actionPerformed(e) */
    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nameField) {
            println("textField " + nameField.getText());
        }
        if (e.getActionCommand().equals("Graph")) {
            println("button " + nameField.getText());
        }
        if (e.getActionCommand().equals("Clear")) {
            println("Clear");
        }
    }


    /* Instance variables */
    private JTextField nameField;
    
}
