package syh;
import tcy.Card1.*;
import sh.*;


public class Player_Move{
    Player player;
    Monster monster;
    Card card;

    public Player_Move(Player player,Monster monster,Card card){
        this.player=player;
        this.monster=monster;
        this.card=card;
    };

    //玩家攻击
    //输入攻击系数和额外固伤
    void attack(double multiple,int extra){
        int atk=(int)(player.getAtk()*multiple+extra);
        if(atk>monster.getDef()){
            int HP=monster.getHP()-atk+monster.getDef();
            monster.setHP(HP);
            monster.setDef(0);
        }
        else{
            int def=monster.getDef()-atk;
            monster.setDef(def);
        }
    }

    //魔法攻击
    void magic_attack(int magic_attack){
        int hp=monster.getHP()-magic_attack;
        monster.setHP(hp);
    }

    //玩家防御
    void def(int card_def){
        int def=player.getDef()+card_def;
        player.setDef(def);
    }

    //玩家回血
    void player_recover(int recover){
        int hp=player.getHP()+recover;
        if(hp>85){
            hp=85;
        }
        player.setHP(hp);
    }

    //玩家穿甲攻击
    //输入穿甲攻击的值、攻击系数和额外固伤
    void player_penetrate(int penetrate,double multiple,int extra){
        int def=monster.getDef();
        if(def>0){
            def=def-penetrate;
            if(def<0){
                def=0;
            };
        }
        monster.setDef(def);
        this.attack(multiple,extra);
    }
    
    public void move(){
        int type=card.getCardType();
        int pp=player.getPP()-card.getCost();
        player.setPP(pp);
        switch(type){
            case 1:
                Nai nai=(Nai)this.card;
                this.player_recover(nai.getnumber());
                break;
            case 2:
                GetCard chou=(GetCard)this.card;
                this.attack(0.0, chou.getattack());
                break;
            case 3:
                Attack att=(Attack)this.card;
                this.attack(att.getpercent(), att.getnumber());
                break;
            case 4:
                Armor chuan=(Armor)this.card;
                this.player_penetrate(chuan.getMul(), chuan.getpercent(), chuan.getnumber());
                break;
            case 5:
                Magic magic=(Magic)card;
                this.magic_attack(magic.getnumber());
                break;
            case 6:
                Defended defend=(Defended)this.card;
                this.def(defend.getnumber());
                break;
            case 7:
                this.player.setinjuryBuff(true);
                break;
        }
    }

    //public Player return_player(){
    //    return this.player;
    //}

    //public Monster return_monster(){
    //    return this.monster;
    //}
}