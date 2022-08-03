package swing;

import swing.dice.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

class Game{
    private JFrame frame;
    private JLabel background;
    public static void main(String args[]){
        Game game = new Game();
        game.init();

    }

    public Game(){
//        System.out.println(getClass().getResource("").getPath());
    }

    private void init(){
//        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        frame = new JFrame("Eskeet-poly");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) height, (int) height);

        //Create background label and load image
        background = new JLabel();
        background.setBounds(0, 0, (int) height, (int) height);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("resources/board.jpg")));
            background.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }

        frame.add(new RollDicePanel(), BorderLayout.CENTER);
//        frame.add(background);
        frame.setVisible(true);
    }

}