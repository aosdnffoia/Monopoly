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
        frame.setSize((int) (height*0.8), (int) (height*0.8));

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
            for(int col=0; col<1; col++){
                JLabel tile = new JLabel();

                try {
                    Image img;
                    img = ImageIO.read(Objects.requireNonNull(GameTEST.class.getResource("resources/0,0.jpg")));
                    if(getTileName(row, col) == ""){
                        //do nothing
                    }else{
                        //img = ImageIO.read(Objects.requireNonNull(GameTEST.class.getResource(getTileName(row, col))));
                        tile.setIcon(new ImageIcon(img));

                        c.fill = GridBagConstraints.HORIZONTAL;
                        c.weightx = 1;
                        c.weighty = 1;
                        c.gridx = col;
                        c.gridy = row;

                        if(col==10){
                            c.gridwidth = GridBagConstraints.REMAINDER;
                            boardLayout.setConstraints(tile, c);
                        }
                        main.add(tile, c);
                    }
                } catch (IOException ex) {
                }
            }
        }

        return main;
    }

    public static String getTileName(int row, int col){
        System.out.print("Row: " + row + " Col: " + col + "   ");
        if((row >= 1 && row <= 9) && (col >= 1 && col <= 9)){
            //do nothing
            System.out.println("DO NOTHING");
            return "";
        }else{
            System.out.println("resources/" + row + "," + col + ".png");
            return "resources/" + row + "," + col + ".png";
        }
    }
}