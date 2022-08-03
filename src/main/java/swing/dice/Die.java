package swing.dice;

import java.awt.*;
import javax.swing.*;

////////////////////////////////////////////////////////////// class Die
/** Die.java - Component to display one die (dice).  This class
 subclasses JPanel to display the face, and it provides functions
 to "roll", giving different random values.
 Possible improvements:
 <ul>
 <li>Use Graphics2 anti-aliasing to smooth the dot edges.</li>
 <li>Add a border.</li>
 </ul>
 @author Fred Swartz
 @version 2003-04-30
 */
public class Die extends JPanel {
    //================================================ constant
    private static final int SPOT_DIAMETER = 9;  // Diameter of spots

    //=============================================== instance variables
    private int myFaceValue;     // value that shows on face of die
    //end instance variables

    //====================================================== constructor
    /** Initialize to white background and 60x60 pixels. Initial roll.*/
    public Die() {
        setBackground(Color.white);
        //-- Preferred size is set, but layout may change it.
        setPreferredSize(new Dimension(60,60));
        roll();  // Set to random initial value
    }//end constructor

    //====================================================== method roll
    /** Produce random roll in range 1-6.  Causes repaint().
     @return Result of roll (1-6).
     */
    public int roll() {
        int val = (int)(6*Math.random() + 1);   // Range 1-6
        setValue(val);
        return val;
    }//end roll

    //================================================== method getValue
    /** Returns result of last roll.*/
    public int getValue() {
        return myFaceValue;
    }//end setValue

    //================================================== method setValue
    /** Sets the value of the Die.  Causes repaint().
     @param spots Number from 1-6.
     */
    public void setValue(int spots) {
        myFaceValue = spots;
        repaint();    // Value has changed, must repaint
    }//end setValue

    //============================================ method paintComponent
    /** Draws spots of die face. */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Required

        int w = 60;  // Panel height and width
        int h = 60;

        g.drawRect(0, 0, w-1, h-1);  // Draw border

        switch (myFaceValue) {
            case 1: drawSpot(g, w/2, h/2);
                break;
            case 3: drawSpot(g, w/2, h/2);
                // Fall thru to next case
            case 2: drawSpot(g, w/4, h/4);
                drawSpot(g, 3*w/4, 3*h/4);
                break;
            case 5: drawSpot(g, w/2, h/2);
                // Fall thru to next case
            case 4: drawSpot(g, w/4, h/4);
                drawSpot(g, 3*w/4, 3*h/4);
                drawSpot(g, 3*w/4, h/4);
                drawSpot(g, w/4, 3*h/4);
                break;
            case 6: drawSpot(g, w/4, h/4);
                drawSpot(g, 3*w/4, 3*h/4);
                drawSpot(g, 3*w/4, h/4);
                drawSpot(g, w/4, 3*h/4);
                drawSpot(g, w/4, h/2);
                drawSpot(g, 3*w/4, h/2);
                break;
        }
    }//end paintComponent

    /** Utility method used by paintComponent(). */
    //================================================== method drawSpot
    private void drawSpot(Graphics g, int x, int y) {
        g.fillOval(x-SPOT_DIAMETER/2, y-SPOT_DIAMETER/2, SPOT_DIAMETER, SPOT_DIAMETER);
    }
}