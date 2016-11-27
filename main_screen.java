import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


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
    static DefaultListModel<String> model = new DefaultListModel<>();
    private JList list1 = new JList<String>(model);




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
        List<String> linkler=new ArrayList<String>();
        List<String> linklera=new ArrayList<String>();
        File input = new File("/home/ryubashi/Documents/Workspace/htmldeneme/src/ghdb_1-3953.html");
        Document doc = null;
        try {
            doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements links = doc.select("a[href]");

        model.addElement("1");
        for (Element link : links) {
            linkler.add(link.attr("abs:href"));
            linklera.add(link.text());
            model.addElement(link.attr("abs:href"));

        }
        System.out.println("----------------------------------------------");
        System.out.println(linkler);
        System.out.println(linklera);
        System.out.println(linkler.get(30));
        System.out.println(linklera.get(30));

    }

    public String create_link()
    {
        String url= "https://www.google.com.tr/#q="+textField1.getText();
        return  url;
    }


}
