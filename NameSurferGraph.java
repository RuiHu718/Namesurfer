/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 * 
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
        for (int i = 0; i < entries.size(); i++) {
            entries.remove(i);
        }
        this.update();
    }
	

    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     * Note that this method does not actually draw the graph, but
     * simply stores the entry; the graph is drawn by calling update.
     */
    public void addEntry(NameSurferEntry entry) {
        entries.add(entry);
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
        drawFixedLabel();
        drawAllEntries();
    }


    private void drawAllEntries() {
        for (int i = 0; i < entries.size(); i++) {
            drawGraph(entries.get(i));
        }
    }

    // test things out here
    private void drawGraph(NameSurferEntry entry) {
        // GLine t = new GLine(0, APPLICATION_HEIGHT/2, APPLICATION_WIDTH, APPLICATION_HEIGHT/2);
        // add(t);

        double[] points = new double[11];
        //double[] test = {58, 69, 99, 131, 168, 238, 278, 380, 467, 408, 466};
        int spread_h = APPLICATION_WIDTH/11;
        double spread_v = (APPLICATION_HEIGHT-2*GRAPH_MARGIN_SIZE) / 1000.0;
        for (int i = 0; i < 11; i++) {
            points[i] = entry.getRank(i)*spread_v + GRAPH_MARGIN_SIZE;
        }

        // GLine t = new GLine(0, test[0], spread_h, test[1]);
        // add(t);
        
        for (int j = 0; j < 10; j++) {
            GLine line = new GLine(j*spread_h, points[j], (j+1)*spread_h, points[j+1]);
            add(line);
        }
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


    private void drawFixedLabel() {
        int spread = APPLICATION_WIDTH/11;
        zero_lab = new GLabel("1900", 0, APPLICATION_HEIGHT);
        add(zero_lab);
        one_lab = new GLabel("1910", spread, APPLICATION_HEIGHT);
        add(one_lab);
        two_lab = new GLabel("1920", 2*spread, APPLICATION_HEIGHT);
        add(two_lab);
        three_lab = new GLabel("1930", 3*spread, APPLICATION_HEIGHT);
        add(three_lab);
        four_lab = new GLabel("1940", 4*spread, APPLICATION_HEIGHT);
        add(four_lab);
        five_lab = new GLabel("1950", 5*spread, APPLICATION_HEIGHT);
        add(five_lab);
        six_lab = new GLabel("1960", 6*spread, APPLICATION_HEIGHT);
        add(six_lab);
        seven_lab = new GLabel("1970", 7*spread, APPLICATION_HEIGHT);
        add(seven_lab);
        eight_lab = new GLabel("1980", 8*spread, APPLICATION_HEIGHT);
        add(eight_lab);
        nine_lab = new GLabel("1990", 9*spread, APPLICATION_HEIGHT);
        add(nine_lab);
        ten_lab = new GLabel("2000", 10*spread, APPLICATION_HEIGHT);
        add(ten_lab);
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
    private GLabel zero_lab;
    private GLabel one_lab;
    private GLabel two_lab;
    private GLabel three_lab;
    private GLabel four_lab;
    private GLabel five_lab;
    private GLabel six_lab;
    private GLabel seven_lab;
    private GLabel eight_lab;
    private GLabel nine_lab;
    private GLabel ten_lab;
    private ArrayList<NameSurferEntry> entries =
        new ArrayList<NameSurferEntry>();


    
    /* Implementation of the ComponentListener interface */
    public void componentHidden(ComponentEvent e) { }
    public void componentMoved(ComponentEvent e) { }
    public void componentResized(ComponentEvent e) { update(); }
    public void componentShown(ComponentEvent e) { }
}
