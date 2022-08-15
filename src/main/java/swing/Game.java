package swing;

import backend.*;
import swing.dice.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

class Game{
    private static final String TITLE = "Eskeet-poly";
    private JFrame frame;
    private JPanel panel;
    private JLabel background;
    static JButton b;

    // java frame
    static JFrame f;

    // popup menu
    static JPopupMenu pm;
    JLabel l;

    public static void main(String args[]){
        Game game = new Game();
        game.init();
        Popup setupPopup = new Popup();
        setupPopup.createMainMenu(TITLE);
        Board board = new Board(setupPopup.getPlayerCount());
    }

    /**
     * Game GUI default constructor
     */
    public Game(){
//        System.out.println(getClass().getResource("").getPath());
    }

    /**
     * Initial Setup Needed for Gameplay
     */
    private void init(){
//        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        frame = new JFrame();
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

        //Add Dice to panel
        panel.add(new RollDicePanel(), BorderLayout.CENTER);
        panel.add(background);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}