package AbigailChan;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InstructionFrame extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InstructionFrame(String title) {
        super(title);
        setSize(1080, 800);  // 设置窗口界面大小
        setResizable(false);  // 设置窗口不能调整

        JLabel lab = new JLabel(new ImageIcon("resources/解释文档.png"));
        add(lab);
    }
}