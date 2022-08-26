package swing;

import backend.Board;
import backend.Player;
import swing.dice.RollDicePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

class Game {
    private static final String TITLE = "Eskeet-poly";
    private static int numPlayers;
    private static JLabel[] playerLabels;
    private static JFrame frame;
    private JPanel panel;
    private static JLabel background;
    private static Board board;
    private static RollDicePanel rollDicePanel;
    private static Player currentPlayer;
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

        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new FlowLayout());
        //JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.add(createSidePanel());
        mainPanel.add(createCenterPanel(height));

        // Set the window to be visible as the default to be false
        //frame.add(createCenterPanel());
        frame.add(mainPanel);
        frame.pack();
        frame.setSize((int) (width), (int) (height));
        frame.setVisible(true);
    }

    private static JScrollPane createCenterPanel(double height){
        JPanel center = new JPanel();
        GridBagLayout boardLayout = new GridBagLayout();
        center.setLayout(boardLayout);
        GridBagConstraints c = new GridBagConstraints();

        for(int row=0; row<11; row++){
            for(int col=0; col<11; col++){
                JLabel tile = new JLabel();

                try {
                    Image img;
                    img = ImageIO.read(Objects.requireNonNull(Game.class.getResource("resources/0,0.jpg")));
                    if(getTileName(row, col) == ""){
                        //do nothing
                    }else{
                        img = ImageIO.read(Objects.requireNonNull(Game.class.getResource(getTileName(row, col))));
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
                        center.add(tile, c);
                    }
                } catch (IOException ex) {
                }
            }
        }

        JScrollPane scrollPane = new JScrollPane(center){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension((int) (height), (int) (height));
            }
        };
        //center.add(createSidePanel());
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
        rollDicePanel=new RollDicePanel();
        sidePanel.add(rollDicePanel);
        for(int i=0;i<numPlayers;i++){
            playerLabels[i] = new JLabel();
            playerLabels[i].setText("<html>"+board.getPlayer(i).getName() +" - $"+board.getPlayer(i).getMoney()+"<br>Current Location: "+board.getTile(board.getPlayer(i).getIndex()).getName()+"</html>");
            //Need to set opacity, the background is not painted, since the default of opaque is false for JLabel.
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

    private void takeTurn(){
        currentPlayer = board.getPlayer(0);
    }
}