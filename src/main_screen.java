import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by ali on 15.11.2016.
 */
public class main_screen {


    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JButton searchButton;
    private JPanel ags;
    private JPanel ghdb;
    private JPanel zday;

    public main_screen() {
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url = create_link();

                if (Desktop.isDesktopSupported()) {
                    // Windows
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    // Ubuntu
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        runtime.exec("/usr/bin/firefox -new-window " + url);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GHackTool");
        frame.setContentPane(new main_screen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public String create_link()
    {
        String url= "https://www.google.com.tr/#q="+textField1.getText();
        return  url;
    }


}
