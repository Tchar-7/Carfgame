package AbigailChan;

import javax.swing.*;

import java.awt.event.*;


public class StartFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public StartFrame(String title) {
        super(title);
        setSize(1080, 800);  // 设置窗口界面大小
        setResizable(false);  // 设置窗口不能调整
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置程序退出
        setLayout(null);  // 设置布局为null，便于坐标调整

        ImageIcon back = new ImageIcon("resources/background.png");  // 背景图片
        JPanel background = new JPanel();  // 背景图片的Panel容器
        background.setLayout(null);  // 将容器布局调整为null，便于坐标调整
        setContentPane(background);  // 设置背景的属性，获得内容面板
        background.setOpaque(false);  // 设置面板背景为透明
        
        JLabel BackPictureLabel = new JLabel(back);  // 背景图片的Label容器，并将图片放入
        getLayeredPane().add(BackPictureLabel, new Integer(Integer.MIN_VALUE));  // 将背景Label，添加到内容面板中
        BackPictureLabel.setBounds(0, 0, back.getIconWidth(), back.getIconHeight());  // 调整图片标签大小位置

        JLabel BigTitle = new JLabel();  // 大标题
        BigTitle.setBounds(130, 100, 800, 250);  // 设置大标题的位置大小
        BigTitle.setIcon(new ImageIcon("resources/BigTitle.png"));  // 在大标题容器中添加大标题的图片

        JButton startButton = new JButton("Start");  // 开始按钮
        JButton exitButton = new JButton("Exit");  // 退出按钮
        JButton instruction = new JButton("游戏说明");  // 游戏说明按钮
        startButton.setBounds(465, 450, 150, 50);  //开始按钮位置大小
        exitButton.setBounds(465, 650, 150, 50);  //退出按钮位置大小
        instruction.setBounds(465, 550, 150, 50);  //说明文档按钮位置大小

        JLabel version = new JLabel();
        version.setBounds(500, 0, 80, 30);
        version.setText("内测");
        background.add(version);
        
        background.add(BigTitle);  // 将大标题添加到背景中
        background.add(startButton);  // 将开始按钮添加到背景中
        background.add(exitButton);  // 将结束按钮添加到背景中
        background.add(instruction);  // 添加到背景
        
        // 开始按钮的事件
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                dispose();  // 作用是释放当前窗口的内存，即关闭开始界面
                GameFrame gaming = new GameFrame("普通的卡牌大冒险");  // 新建游戏界面
                gaming.setVisible(true);  // 游戏界面可视
            }
        });

        // 结束按钮的事件
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);  // 退出程序
            }
        });

        // 说明文档的事件
        instruction.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                InstructionFrame ifa = new InstructionFrame("游戏说明");
                ifa.setVisible(true);
            }
        });
    }
}