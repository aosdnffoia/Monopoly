package swing;

import backend.Board;
import swing.dice.RollDicePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

class GameTEST {
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
    public GameTEST(){
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

        // Set the window to be visible as the default to be false
        frame.add(getMainPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static JPanel getMainPanel(){
        JPanel main = new JPanel();
        GridBagLayout boardLayout = new GridBagLayout();
        main.setLayout(boardLayout);
        GridBagConstraints c = new GridBagConstraints();

        for(int row=0; row<11; row++){
            for(int col=0; col<12; col++){
                JLabel tile = new JLabel();

                try {
                    Image img;
                    img = ImageIO.read(Objects.requireNonNull(GameTEST.class.getResource("resources/1 Mediterranean Avenue.jpg")));
                    if(getTileName(row, col) == ""){
                        //do nothing
                    }else{
                        img = ImageIO.read(Objects.requireNonNull(GameTEST.class.getResource(getTileName(row, col))));
                        tile.setIcon(new ImageIcon(img));

                        c.fill = GridBagConstraints.HORIZONTAL;
                        c.weightx = 0;
                        c.weighty = 0;
                        c.gridx = col;
                        c.gridy = row;

                        if(col==11){
                            c.gridwidth = GridBagConstraints.REMAINDER;
                            boardLayout.setConstraints(tile, c);
                        }
                        main.add(tile, c);
                    }
                    /*tile.setIcon(new ImageIcon(img));

                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.gridx = col;
                    c.gridy = row;

                    if(col==11){
                        c.gridwidth = GridBagConstraints.REMAINDER;
                        boardLayout.setConstraints(tile, c);
                    }
                    main.add(tile, c);*/
                } catch (IOException ex) {
                }
            }
        }

        return main;
    }

    public static String getTileName(int row, int col){
        switch(col){
            case 0: //case for first column displaying RollDicePanel and player info
                return "";
            case 1:
                switch(row){
                    case 0:
                        return "resources/20 Free Parking.jpg";
                    case 1:
                        return "resources/19 New York Avenue.jpg";
                    case 2:
                        return "resources/18 Tennessee Avenue.jpg";
                    case 3:
                        return "resources/33 Community Chest.jpg";
                    case 4:
                        return "resources/16 St. James Place.jpg";
                    case 5:
                        return "resources/15 Pennsylvania Railroad.jpg";
                    case 6:
                        return "resources/14 Virginia Avenue.jpg";
                    case 7:
                        return "resources/13 States Avenue.jpg";
                    case 8:
                        return "resources/12 Electric Company.jpg";
                    case 9:
                        return "resources/11 St. Charles Place.jpg";
                    case 10:
                        return "resources/10 Jail.jpg";
                }
                return "resources/1 Mediterranean Avenue.jpg";
        }
        return "";
    }
}