package AbigailChan;

import sh.*;
import syh.*;
import tcy.base.*;
import tcy.Card1.*;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.*;

import java.io.File;
import java.net.URL;
import java.net.URI;
import java.applet.Applet;
import java.applet.AudioClip;


public class GameFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ImageIcon back;
    private JPanel background;
    private JLabel BackPictureLabel;

    private JLabel player;
    private JLabel monster;
    private JLabel pDefence;
    private JLabel mDefence;
    private JLabel pDefenceNum;
    private JLabel mDefenceNum;
    private JLabel PlayerBuff;

    private JLabel[] cardLabel;
    private JButton[] cardButton;

    private JButton endButton;

    private JPanel PaiKuPan;
    private JPanel QiPaiPan;

    private JLabel PaiKuLabel;
    private JLabel QiPaiLabel;

    private JProgressBar blood;
    private JProgressBar Mblood;
    private JProgressBar PP;

    private Player P;
    private Monster M;
    private Base base;
    private Monster_Move M_Move;
    private Player_Move P_Move;

    private JTextArea informationText;
    private JScrollPane jsp;

    private int ci = 5;

    public GameFrame(String title) {
        super(title);
        setSize(1080, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        //--------------------------------------------------------------------------
        back = new ImageIcon("resources/background2.png");  // 背景图片
        background = new JPanel();  // 背景图片的Panel容器
        background.setLayout(null);  // 将容器布局调整为null，便于坐标调整
        setContentPane(background);  // 设置背景的属性，获得内容面板
        background.setOpaque(false);  // 设置面板背景为透明
        
        BackPictureLabel = new JLabel(back);  // 背景图片的Label容器，并将图片放入
        getLayeredPane().add(BackPictureLabel, new Integer(Integer.MIN_VALUE));  // 将背景Label，添加到内容面板中
        BackPictureLabel.setBounds(0, 0, back.getIconWidth(), back.getIconHeight());  // 调整图片标签大小位置
        //--------------------------------------------------------------------------
        pDefenceNum = new JLabel();
        mDefenceNum = new JLabel();
        pDefenceNum.setBounds(128, 460, 30, 30);
        mDefenceNum.setBounds(938, 460, 30, 30);
        background.add(pDefenceNum);
        background.add(mDefenceNum);

        player = new JLabel();
        monster = new JLabel();
        player.setBounds(100, 120, 200, 300);
        player.setIcon(new ImageIcon("resources/guda.png"));
        monster.setBounds(650, 100, 800, 400);
        monster.setIcon(new ImageIcon("resources/zhongfengge.png"));
        background.add(player);
        background.add(monster);
        pDefence = new JLabel(new ImageIcon("resources/防御值.png"));
        mDefence = new JLabel(new ImageIcon("resources/防御值.png"));
        pDefence.setBounds(110, 450, 50, 50);
        mDefence.setBounds(920, 450, 50, 50);
        background.add(pDefence);
        background.add(mDefence);

        PlayerBuff = new JLabel(new ImageIcon("resources/反制buff.png"));
        PlayerBuff.setBounds(250, 50, 50, 50);
        background.add(PlayerBuff);

        this.Creat_Base();
        this.getcardmain();
        //-----------------------------------------------------------------卡牌
        cardLabel = new JLabel[6];
        cardButton = new JButton[6];
        endButton = new JButton("回合结束");
        for(int i = 0; i < 6; i++) {
            cardLabel[i] = new JLabel();
        }
        for(int i = 0; i < 6; i++) {
            cardButton[i] = new JButton("出牌");
        }
        for(int i = 0; i < 6; i++) {
            cardLabel[i].setBounds(40 + i*170, 550, 150, 200);
            background.add(cardLabel[i]);
        }
        for(int i = 0; i < 6; i++) {
            cardButton[i].setBounds(85 + i*170, 510, 60, 35);
            background.add(cardButton[i]);
        }
        endButton.setBounds(480, 20, 100, 40);
        background.add(endButton);
        this.connectPicture();
        //------------------------------------------------------------------牌库与弃牌
        PaiKuPan = new JPanel();
        QiPaiPan = new JPanel();

        PaiKuPan.setBounds(0, 450, 100, 50);
        QiPaiPan.setBounds(980, 450, 100, 50);

        PaiKuLabel = new JLabel();
        QiPaiLabel = new JLabel();

        PaiKuLabel.setText("牌库：" + base.getuserbaseNum());
        PaiKuPan.add(PaiKuLabel);
        QiPaiLabel.setText("弃牌区:" + base.gettrashbinCardsNum());
        QiPaiPan.add(QiPaiLabel);
        //------------------------------------------------------------------血条与蓝条
        blood = new JProgressBar();
        Mblood = new JProgressBar();

        PP = new JProgressBar();
        PP.setBounds(50, 55, 150, 30);
        PP.setMinimum(0);
        PP.setMaximum(5);
        PP.setStringPainted(true);

        background.add(blood);
        background.add(Mblood);
        background.add(PP);
        background.add(PaiKuPan);
        background.add(QiPaiPan);

        this.Creat_Person();
        String ps = "<html> 名称:" +P.getName()+"<br/> 攻击:"+P.getAtk()+"<br> 速度 : "+P.getSpeed()+"<br/></html>";
        player.setToolTipText(ps);
        String ms =  "<html> 名称:" +M.getName()+"<br/> 攻击:"+M.getAtk()+"<br>魔法攻击: "+M.getMagicAtk()+"<br> 叠甲值: "+M.getaddDef()+"<br> 速度 : "+M.getSpeed()+"<br/></html>";
        monster.setToolTipText(ms);
        PlayerBuff.setToolTipText("反伤:敌方将会受到其对你造成伤害的一半的伤害");

        blood.setBounds(50, 20, 300, 30);
        blood.setMinimum(0);
        blood.setMaximum(P.getHP());
        blood.setForeground(Color.RED);
        blood.setStringPainted(true);

        Mblood.setBounds(750, 20, 300, 30);
        Mblood.setMinimum(0);
        Mblood.setMaximum(M.getHP());
        Mblood.setStringPainted(true);
        Mblood.setForeground(Color.RED);

        //------------------------------------------------------------------------信息框
        informationText = new JTextArea();
        jsp = new JScrollPane(informationText);
        jsp.setBounds(380, 100, 320, 195);
        informationText.setBounds(380, 100, 320, 195);
        informationText.setEditable(false);
        //background.add(informationText);
        background.add(jsp);

        this.setAttribute();

        MyEventListener listen = new MyEventListener();
        for(int i = 0; i < 6; i++) {
            cardButton[i].addActionListener(listen);
        }
        endButton.addActionListener(listen);

        //--------------------------------------------------------------------------
        try {
            File musicFile = new File("resources/Megalovania改.wav");
            URI uri = musicFile.toURI();  // URI,统一资源标志符
            URL url = uri.toURL();  // URL，统一资源定位符
            AudioClip ac = Applet.newAudioClip(url);
            ac.loop();
        } catch (Exception e) {
                    
        }
                
    }


    public void Creat_Person() {
        P = new Player("Guda", 5, 6, 0, 85, 5);
        M = new Monster("Great Jagras", 3, 20, 25, 10, 15, 150);
        M_Move=new Monster_Move(P,M);
    }


    public void Creat_Base() {
        base = new Base();
        //创建基础卡牌库
        for(int i = 0; i<3;i++){
            base.addCard(0);
        }
        for(int i = 0; i<2;i++){
            base.addCard(1);
        }
        for(int i = 0; i<4;i++){
            base.addCard(2);
        }
        for(int i = 0; i<5;i++){
            base.addCard(3);
        }
        for(int i = 0; i<3;i++){
            base.addCard(4);
        }
        for(int i = 0; i<3;i++){
            base.addCard(5);
        }
        for(int i = 0; i<2;i++){
            base.addCard(6);
        }
        for(int i = 0; i<1;i++){
            base.addCard(7);
        }
        for(int i = 0; i<8;i++){
            base.addCard(8);
        }
        for(int i = 0; i<1;i++){
            base.addCard(9);
        }
        
    
    }


    public void connectPicture() {
        for(int i = 0; i < 6; i++) {
            cardLabel[i].setIcon(new ImageIcon(base.getcardimfor(i)));
        }
    }


    public void getcardmain(){
        base.getCard();
    }


    public void end(){
        P.setPP(5);
        ci=5;
        base.re();
        for (int i = 0 ;i<=ci ;i++){
            cardButton[i].setEnabled(true);
        }
        
        Random rand=new Random();
        int temp=rand.nextInt(3);
        switch(temp){
            case 0:
                M_Move.attack();
                //this.M = M_Move.return_monster();
                //this.P = M_Move.return_player();
                this.informationText.append(M.getName() + "对你造成了" + M.getAtk() + "点伤害！\n");
                break;
            case 1:
                M_Move.monster_def();
                //this.M = M_Move.return_monster();
                //this.P = M_Move.return_player();
                this.informationText.append(M.getName() + "获得了" + M.getaddDef() + "点护甲！\n");
                break;
            case 2:
                M_Move.magic_attack();
                //this.M = M_Move.return_monster();
                //this.P = M_Move.return_player();
                this.informationText.append(M.getName() + "使用了魔法，对你造成了" + M.getMagicAtk() + "点魔法伤害！\n");
                break;
        }
        this.getcardmain();
        setAttribute();
        connectPicture();
    }


    public void setAttribute(){
        blood.setValue(P.getHP());
        blood.setString("HP: "+String.valueOf(P.getHP()));
        Mblood.setValue(M.getHP());
        Mblood.setString("HP: "+M.getHP());
        PP.setValue(P.getPP());
        PP.setString("PP: "+P.getPP());
        pDefenceNum.setText(String.valueOf(P.getDef()));
        mDefenceNum.setText(String.valueOf(M.getDef()));
        setVisible(true);
        if(P.getinjuryBuff()){
            PlayerBuff.setVisible(true);
        }
        else{
            PlayerBuff.setVisible(false);
        }
        QiPaiLabel.setText("弃牌区：" + base.gettrashbinCardsNum());
        PaiKuLabel.setText("牌库区：" + base.getuserbaseNum());
    }


    public void Music(String filename) {
        try {
            File musicFile = new File(filename);
            URI uri = musicFile.toURI();
            URL url = uri.toURL();
            AudioClip ac = Applet.newAudioClip(url);
            ac.play();
        } catch (Exception e) {
            
        }
    }


    class MyEventListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            Card use;
            for(int i=0;i<6;i++){
                if(ae.getSource() == cardButton[i]){
                    use = base.getuseCard(i);
                    P_Move= new Player_Move(P, M, use);
                    if(use.getCost()<=P.getPP()){
                        Music(use.getcardMusicinfor(i));
                        P_Move.move();
                        //M = P_Move.return_monster();
                        //P = P_Move.return_player();
                        base.uCard(i);
                        informationText.append("你使用了" + use.getName() + use.getInformation() + "\n");
                        setAttribute();
                        connectPicture();
                        cardButton[ci].setEnabled(false);
                        ci--;
                        if(use.getCardType() == 2){
                            GetCard g = (GetCard)use;
                            base.getCard(g.getnumber());
                            ci++;
                            cardButton[ci].setEnabled(true);
                            connectPicture();
                            setAttribute();
                        }
                    } 
                }
            }
            if(ae.getSource() == endButton) {
                end();
            }
            if(P.getHP() <= 0) {
                dispose();
                DefenceFrame df = new DefenceFrame();
                df.setVisible(true);
            }
            if(M.getHP() <= 0) {
                dispose();
                VictoryFrame vf = new VictoryFrame();
                vf.setVisible(true);
            }
        }
    }
}