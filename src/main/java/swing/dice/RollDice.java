package swing.dice;

import java.awt.*;
import javax.swing.*;

///////////////////////////////////////////////////////// class RollDice
/** RollDice.java -- Program to display two dice and roll them.
 * @author Fred Swartz
 * @version 2005-01-29
 * This can run as an application because it has a main method.
 * It can also be used as an applet because it extends JApplet.
 * Use the following for an applet tag. <br>
 * &lt;applet code="roll_dice2.RollDice.class" archive="roll_dice2.jar"
 *            width="130" height="107"&gt;&lt;/appletgt;
 */
public class RollDice extends JApplet {

    //=============================================== applet constructor
    /** Applet constructor requires putting the panel in applet.*/
    public RollDice() {
        this.setContentPane(new RollDicePanel());
    }

    //====================================================== method main
    /** Create JFrame and set content pane to a RollDicePanel. */
    public static void main(String[] args) {
        JFrame window = new JFrame("Dice Demo");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new RollDicePanel());
        window.pack();
        window.setVisible(true);
    }//end main

}