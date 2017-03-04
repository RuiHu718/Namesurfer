/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
    implements NameSurferConstants, ComponentListener {

    /**
     * Creates a new NameSurferGraph object that displays the data.
     */
    public NameSurferGraph() {
        addComponentListener(this);
        //	 You fill in the rest //
    }
	
    /**
     * Clears the list of name surfer entries stored inside this class.
     */
    public void clear() {
        //	 You fill this in //
    }
	
    /* Method: addEntry(entry) */
    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     * Note that this method does not actually draw the graph, but
     * simply stores the entry; the graph is drawn by calling update.
     */
    public void addEntry(NameSurferEntry entry) {
        // You fill this in //
    }
	
	
	
    /**
     * Updates the display image by deleting all the graphical objects
     * from the canvas and then reassembling the display according to
     * the list of entries. Your application must call update after
     * calling either clear or addEntry; update is also called whenever
     * the size of the canvas changes.
     */
    public void update() {
        drawFrameWork();
    }
	


    private void drawFrameWork() {
        top = new GLine(0, GRAPH_MARGIN_SIZE, APPLICATION_WIDTH, GRAPH_MARGIN_SIZE);
        add(top);
        bottom = new GLine(0, APPLICATION_HEIGHT-GRAPH_MARGIN_SIZE, APPLICATION_WIDTH,
                           APPLICATION_HEIGHT-GRAPH_MARGIN_SIZE);
        add(bottom);

        int spread = APPLICATION_WIDTH / 11;
        zero = new GLine(0, 0, 0, APPLICATION_HEIGHT);
        add(zero);
        one = new GLine(spread, 0, spread, APPLICATION_HEIGHT);
        add(one);
        two = new GLine(2*spread, 0, 2*spread, APPLICATION_HEIGHT);
        add(two);
        three = new GLine(3*spread, 0, 3*spread, APPLICATION_HEIGHT);
        add(three);
        four = new GLine(4*spread, 0, 4*spread, APPLICATION_HEIGHT);
        add(four);
        five = new GLine(5*spread, 0, 5*spread, APPLICATION_HEIGHT);
        add(five);
        six = new GLine(6*spread, 0, 6*spread, APPLICATION_HEIGHT);
        add(six);
        seven = new GLine(7*spread, 0, 7*spread, APPLICATION_HEIGHT);
        add(seven);
        eight = new GLine(8*spread, 0, 8*spread, APPLICATION_HEIGHT);
        add(eight);
        nine = new GLine(9*spread, 0, 9*spread, APPLICATION_HEIGHT);
        add(nine);
        ten = new GLine(10*spread, 0, 10*spread, APPLICATION_HEIGHT);
        add(ten);
    }
	

    /* instance variables */
    private GLine top;
    private GLine bottom;
    private GLine zero;         // represent the vertical line of 1900
    private GLine one;
    private GLine two;
    private GLine three;
    private GLine four;
    private GLine five;
    private GLine six;
    private GLine seven;
    private GLine eight;
    private GLine nine;
    private GLine ten;

    
    /* Implementation of the ComponentListener interface */
    public void componentHidden(ComponentEvent e) { }
    public void componentMoved(ComponentEvent e) { }
    public void componentResized(ComponentEvent e) { update(); }
    public void componentShown(ComponentEvent e) { }
}
