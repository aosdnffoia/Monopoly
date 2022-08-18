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

        // Set the window to be visible as the default to be false
        frame.add(createMainPanel());
        frame.pack();
        frame.setSize((int) (height*2), (int) (height*2));
        frame.setVisible(true);
    }

    public static JScrollPane createMainPanel(){
        JPanel main = new JPanel();
        GridBagLayout boardLayout = new GridBagLayout();
        main.setLayout(boardLayout);
        GridBagConstraints c = new GridBagConstraints();

        for(int row=0; row<11; row++){
            for(int col=0; col<11; col++){
                JLabel tile = new JLabel();

                try {
                    Image img;
                    img = ImageIO.read(Objects.requireNonNull(GameTEST.class.getResource("resources/0,0.jpg")));
                    if(getTileName(row, col) == ""){
                        //do nothing
                    }else{
                        img = ImageIO.read(Objects.requireNonNull(GameTEST.class.getResource(getTileName(row, col))));
                        tile.setIcon(new ImageIcon(img));

                        if((row >= 1 && row <= 9) && (col >= 1 && col <= 9)){
                            c.ipadx = 0;
                            c.ipady = 0;
                        } else{
                            c.ipadx = 1;
                            c.ipady = 1;
                        }
                        c.fill = GridBagConstraints.BOTH;
                        c.gridx = col;
                        c.gridy = row;

                        if(col==10){
                            c.gridwidth = GridBagConstraints.REMAINDER;
                        }

                        boardLayout.setConstraints(tile, c);
                        main.add(tile, c);
                    }
                } catch (IOException ex) {
                }
            }
        }

        JScrollPane scrollPane = new JScrollPane(main);
        main.add(createSidePanel());
        return scrollPane;
    }

    private static JPanel createSidePanel(){
        JPanel sidePanel = new JPanel();

        //Create gridlayout for side panel with dice+player cards
        GridLayout layout = new GridLayout(numPlayers+1,1);
        //Vertical gap between grid tiles
        layout.setVgap(8);
        sidePanel.setLayout(layout);

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

        return sidePanel;
    }

    public static String getTileName(int row, int col){
        System.out.print("Row: " + row + " Col: " + col + "   ");
        if((row >= 1 && row <= 9) && (col >= 1 && col <= 9)){
            return "resources/background.jpg";
        }else{
            System.out.println("resources/" + row + "," + col + ".jpg");
            return "resources/" + row + "," + col + ".jpg";
        }
    }
}