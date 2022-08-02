package swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

class Game{
    private JFrame frame;
    private JLabel background;
    public static void main(String args[]){
        Game game = new Game();
        game.init();

    }

    public Game(){
    }

    private void init(){
//        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        frame = new JFrame("Eskeet-poly");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) height, (int) height);
//        JButton button = new JButton("Press");
//        frame.getContentPane().add(button); // Adds Button to content pane of frame

//        JPanel panel = new JPanel();
//        frame.add(panel);

        background = new JLabel();
        try {
            //Local file path not working?
            Image img = ImageIO.read(new URL("https://p.kindpng.com/picc/s/74-748468_monopolylogo-monopoly-png-transparent-png.png"));
//            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("resources/main.png")));
            background.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        frame.getContentPane().add(background);
        frame.setVisible(true);
    }

}