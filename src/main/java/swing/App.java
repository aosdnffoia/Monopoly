package swing;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame{
    private JPanel board;
    private JLabel backgroundlabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame window = new App("MONOPOLOY");
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private void createUIComponents() {
//        Image backgroundImage = Toolkit.getDefaultToolkit().getImage("resources/board.jpg");
//        JLabel bgl = window.backgroundlabel;
//        bgl.setIcon(new ImageIcon(backgroundImage));
    }

    public App(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(board);
        this.pack();
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }
}
