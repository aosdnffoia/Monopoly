package swing;

import swing.dice.RollDicePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Test {
    private JFrame frame;
    private JPanel panel;
    private JLabel background;

    public static void main(String args[]){
        Test game = new Test();
        game.init();

    }

    public Test(){
//        System.out.println(getClass().getResource("").getPath());
    }

    private void init(){
//        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        frame = new JFrame("Eskeet-poly");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) height, (int) height);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //Create background label and load image
        background = new JLabel();
//        background.setBounds(0, 0, (int) height, (int) height);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("resources/board.jpg")));
            background.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }

        panel.add(new RollDicePanel(), BorderLayout.CENTER);
        panel.add(background);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
