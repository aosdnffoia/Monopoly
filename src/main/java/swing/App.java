package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import javax.swing.JPanel;

public class App extends JFrame{
    private JPanel board;
    private JLabel backgroundlabel;
    private JButton button1;

    public App() {

        initUI();
        board.addComponentListener(new ComponentAdapter() {
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Test");
            }
        });
    }

    private void initUI() {

        add(new Panel());

        setSize(250, 200);

        setTitle("Monopoly");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

//        EventQueue.invokeLater(() -> {
//            App ex = new App();
//            ex.setVisible(true);
//        });

        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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

    public static class Panel extends JPanel {

        public Panel() {
        }
    }
}
