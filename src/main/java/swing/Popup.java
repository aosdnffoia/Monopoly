package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Popup extends JFrame implements ActionListener {
    private static JButton b;
    private static JFrame f;
    private static JPopupMenu pm;
    private JLabel l;
    private static JTextField textData;

    // default constructor
    Popup()
    {
    }

    public static void createMainMenu(String name){
        // create a frame
        f = new JFrame("Welcome!");

        // set the size of the frame
        f.setSize(400, 400);

        // hide the frame when close button is pressed
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // create a new panel
        JPanel p = new JPanel();

        // create an object of mouse class
        Popup pop = new Popup();

        // create a button
        b = new JButton("Submit");

        // addActionListener
        b.addActionListener(pop);


        // create textlabel
        textData = new JTextField();

        textData.setBounds(50,100, 200,30);

        // create a popup menu
        pm = new JPopupMenu("Message");

        // create menuItems
        JMenuItem m1 = new JMenuItem("Item1");
        JMenuItem m2 = new JMenuItem("Item2");
        JMenuItem m3 = new JMenuItem("Item3");

        // create a Jlabel
        JLabel l = new JLabel("Welcome to "+name);

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

        // add button and label to frame
        p.add(l);
        p.add(textData);
        p.add(b);
        p.setLayout(new FlowLayout());

        f.add(p);
        f.setVisible(true);
    }

    // when the button is clicked
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("click")) {

            // add the popup to the frame
            pm.show(f, 200, 200);
        }
    }
}
