package swing;

import backend.*;
import swing.dice.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static java.awt.Color.*;

class Game{
    private static final String TITLE = "Eskeet-poly";
    private static int numPlayers;
    private static JLabel[] playerLabels;
    private static JFrame frame;
    private JPanel panel;
    private static JLabel background;
    private static Board board;
    static JButton b;

    // java frame
    static JFrame f;

    // popup menu
    static JPopupMenu pm;
    JLabel l;

    public static void main(String args[]){
        Popup setupPopup = new Popup();
        setupPopup.createMainMenu(TITLE);
        board = new Board(numPlayers);
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
    public static void init(){
        //Load number of players from user input
        numPlayers=Popup.getPlayerCount();

        //Create initial board
        board = new Board(numPlayers);

//        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) height, (int) height);

        JPanel mainPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        //GridLayout mainLayout = new GridLayout(1, 14);
        //mainLayout.setVgap(2);
        //mainPanel.setLayout(mainLayout);

        //Create gridlayout for side panel with dice+player cards
        GridLayout layout = new GridLayout(numPlayers+1,1);
        //Vertical gap between grid tiles
        layout.setVgap(8);
        sidePanel.setLayout(layout);

        //Create background label and load image
        background = new JLabel();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(Game.class.getResource("resources/board.jpg")));
            background.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }

        //Add Dice and players to side-panel
        playerLabels=new JLabel[numPlayers];
        sidePanel.add(new RollDicePanel());
        for(int i=0;i<numPlayers;i++){
            playerLabels[i] = new JLabel();
            playerLabels[i].setText(board.getPlayer(i).getName() +" - $"+board.getPlayer(i).getMoney());
            //Otherwise, the background is not painted, since the default of opaque is false for JLabel.
            playerLabels[i].setOpaque(true);
            //Random RGB COLOR
            playerLabels[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
            sidePanel.add(playerLabels[i]);
        }

        //Add side panel and background to main panel
        //TODO: Individual panels
        mainPanel.add(sidePanel);
        mainPanel.add(new JLabel("1"));
        mainPanel.add(background);

        // Set the window to be visible as the default to be false
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

}