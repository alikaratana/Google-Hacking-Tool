import javax.swing.*;

/**
 * Created by ali on 15.11.2016.
 */
public class main_screen {


    private JPanel panel1;
    private JTabbedPane tabbedPane1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GHackTool");
        frame.setContentPane(new main_screen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
