package AbigailChan;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DefenceFrame extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DefenceFrame() {
        super("普通的卡牌大冒险");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 650);
        setResizable(false);
        JLabel jl = new JLabel(new ImageIcon("resources/defence.jpg"));
        add(jl);
    }    
}