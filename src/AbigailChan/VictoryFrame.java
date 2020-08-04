package AbigailChan;

import javax.swing.*;

import java.io.File;
import java.net.URL;
import java.net.URI;
import java.applet.Applet;
import java.applet.AudioClip;

public class VictoryFrame extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VictoryFrame() {
        super("普通的卡牌大冒险");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 436);
        setResizable(false);
        JLabel jl = new JLabel(new ImageIcon("resources/victory.jpg"));
        add(jl);
        try {
            File musicFile = new File("resources/z胜利音效.wav");
            URI uri = musicFile.toURI();
            URL url = uri.toURL();
            AudioClip ac = Applet.newAudioClip(url);
            ac.loop();
        } catch (Exception e) {
            
        }
    }
}