package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Popup extends JFrame implements ActionListener {
    private static JButton b;
    private static JFrame f;
    private static JPopupMenu pm;
    private static JLabel l;
    private static JLabel l2;
    private static JTextField textData;
    private int playerCount;

    // default constructor
    Popup()
    {
    }

    public void createMainMenu(String name){
        // create a frame
        f = new JFrame("Welcome!");

        // set the size of the frame
        f.setSize(400, 400);

        // hide the frame when close button is pressed
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // create a new panel
        JPanel p = new JPanel();

        // create a new panel
        JPanel p2 = new JPanel();

        // create an object of mouse class
        Popup pop = new Popup();

        // create a button
        b = new JButton("Submit");

        // addActionListener
        b.addActionListener(pop);


        // create textlabel
        textData = new JTextField(29);

        // addActionListener
        textData.addActionListener(pop);


        // create a popup menu
        pm = new JPopupMenu("Message");

        // create menuItems
        JMenuItem m1 = new JMenuItem("Item1");
        JMenuItem m2 = new JMenuItem("Item2");
        JMenuItem m3 = new JMenuItem("Item3");

        // create a Jlabel
        l = new JLabel("Welcome to "+name);

        l2 = new JLabel("Please enter number of players (2-8)");

        // add menuitems to popup menu
        pm.add(m1);
        pm.add(m2);
        pm.add(m3);

        // addActionListener
        m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("Item 1 clicked.");
            }
        });

        m2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("Item 2 clicked.");
            }
        });

        m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("Item 3 clicked.");
            }
        });

        //Set layout for panel
        p.setLayout(new GridLayout(4,1 ));

        // add button and label to frame
        p.add(l);
        p.add(l2);
        p.add(textData);
        p.add(b);




        f.add(p);
        f.setVisible(true);
    }

    // when the button is clicked
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        String userInput = textData.getText();
        if (s.equals("click")) {

            // add the popup to the frame
            pm.show(f, 200, 200);
        } else if (s.equals("Submit")) {
            if(isNumeric(userInput)) {
                if (Integer.parseInt(userInput)>2 && Integer.parseInt(userInput)<8) {
                    playerCount = Integer.parseInt(userInput);
                    l2.setText("Thank you. You entered "+userInput);
                    System.out.println("here");
                }
            }else{
                l2.setText("Please enter valid number between 2 to 8. You entered "+userInput);
            }
        }

    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public int getPlayerCount() {
        return playerCount;
    }
}
