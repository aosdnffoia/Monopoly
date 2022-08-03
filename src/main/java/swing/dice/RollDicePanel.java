package swing.dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

///////////////////////////////////////////////////////// class RollDicePanel
/** RollDicePanel.java - Panel builds GUI for RollDice application/applet.
 It subclasses JPanel to contain two dice and a button to roll them.

 @author Fred Swartz
 @version 2005-01-29
 */
public class RollDicePanel extends JPanel {
    //=============================================== instance variables
    private Die myLeftDie;     // component for one die
    private Die myRightDie;

    //====================================================== constructor
    /** Create border layout panel with one button and two dice. */
    public RollDicePanel() {
        //... Create the dice
        myLeftDie  = new Die();
        myRightDie = new Die();

        //...Create the button to roll the dice
        JButton rollButton = new JButton("New Roll");
        rollButton.setFont(new Font("Sansserif", Font.PLAIN, 24));

        //... Add listener.
        rollButton.addActionListener(new RollListener());

        //... Layout components
        this.setLayout(new BorderLayout(5, 5));
        this.add(rollButton, BorderLayout.NORTH);
        this.add(myLeftDie , BorderLayout.WEST);
        this.add(myRightDie, BorderLayout.EAST);
    }//end constructor


    /////////////////////////////////// inner listener class RollListener
    /** Inner listener class for Roll button. */
    private class RollListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myLeftDie.roll();
            myRightDie.roll();
        }
    }
}