import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ali on 15.11.2016.
 */
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
    private JTextField textField5;
    private JTextField textField6;
    private JList list1;
    public SearchOperators searchOperators;
    public String url="http://www.google.com/";


    public main_screen() {

        searchOperators=new SearchOperators();
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                url+="search?";
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
            url=searchOperators.all_the_words(url,words)+"&";
        }

        if(!exact_word.getText().equals(""))
        {

        }

        if(!any_words.getText().equals(""))
        {

            String[] words=any_words.getText().split(",");
            for(int i=0;i<words.length;i++)
            {
                words[i]=words[i].replaceAll(" ","+");
            }
            url=searchOperators.any_of_words(url,words)+"&";
        }

        if(!non_words.getText().equals(""))
        {
            String[] words=non_words.getText().split(",");
            for(int i=0;i<words.length;i++)
            {
                words[i]=words[i].replaceAll(" ","+");
            }
            url=searchOperators.non_of_words(url,words)+"&";

        }

        return url;
    }




}
