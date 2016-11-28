
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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


public class main_screen {


    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField all_words;
    private JButton searchButton;
    private JPanel ags;
    private JPanel ghdb;
    private JPanel zday;
    private JTextField exact_word;
    private JTextField any_words;
    private JTextField non_words;
    private JTextField num_from;
    private JTextField num_to;
    private JList list1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    public SearchOperators searchOperators;
    public String url="http://www.google.com/search?q=";
    static DefaultListModel<String> model = new DefaultListModel<>();


    public main_screen() {
        ghdb();

        list1.setModel(model);
        searchOperators=new SearchOperators();

        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                url=create_link(url);
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

                url="http://www.google.com/search?q=";
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

    public String create_link(String url)
    {
        if(!all_words.getText().equals(""))
        {
            String[] words=all_words.getText().split(",");
            for(int i=0;i<words.length;i++)
            {
                words[i]=words[i].replaceAll(" ","+");
            }
            url=searchOperators.all_the_words(url,words);
        }

        if(!exact_word.getText().equals(""))
        {
            String[] words=exact_word.getText().split(",");
            for(int i=0;i<words.length;i++)
            {
                words[i]=words[i].replaceAll(" ","+");
            }
            url=searchOperators.exact_phrase(url,words);
        }

        if(!any_words.getText().equals(""))
        {

            String[] words=any_words.getText().split(",");
            for(int i=0;i<words.length;i++)
            {
                words[i]=words[i].replaceAll(" ","+");
            }
            url=searchOperators.any_of_words(url,words);
        }

        if(!non_words.getText().equals(""))
        {
            String[] words=non_words.getText().split(",");
            for(int i=0;i<words.length;i++)
            {
                words[i]=words[i].replaceAll(" ","+");
            }
            url=searchOperators.non_of_words(url,words);

        }

        if(!num_from.getText().equals("") && !num_to.getText().equals(""))
        {
            String number1=num_from.getText();
            String number2=num_to.getText();
            url=searchOperators.range(url,number1,number2);

        }

        return url;
    }

    public void ghdb()
    {
        List<String> linkler=new ArrayList<String>();
        List<String> linklera=new ArrayList<String>();
        File input = new File("Ghdb/ghdb_1-3953.html");
        Document doc = null;
        try {
            doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            linkler.add(link.attr("abs:href"));
            linklera.add(link.text());
            model.addElement(link.attr("abs:href"));

        }
        list1.setModel(model);


    }



}
