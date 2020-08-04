package syh;

import sh.*;

public class Monster_Move{
    Monster monster;
    Player player;

    public Monster_Move(Player player,Monster monster){
        this.player=player;
        this.monster=monster;
    };

    public void attack(){
        if(monster.getAtk()>player.getDef()){
            int HP=player.getHP()-monster.getAtk()+player.getDef();
            player.setHP(HP);
        }
        else{
            int def=player.getDef()-monster.getAtk();
            player.setDef(def);
        }
        if(player.getinjuryBuff()){
            int back_atk=monster.getAtk()/2;
            int mon_hp=monster.getHP();
            if(back_atk>monster.getDef()){
                mon_hp=mon_hp+monster.getDef()-back_atk;
                monster.setDef(0);
                if(mon_hp <= 0) {
                    mon_hp = 1;
                }
                monster.setHP(mon_hp);
            }
            else{
                int def=monster.getDef()-back_atk;
                monster.setDef(def);
            }
            player.setinjuryBuff(false);
        }
    }
    
    //怪物防御
    public void monster_def(){
        int def=monster.getDef()+monster.getaddDef();
        monster.setDef(def);
    }

    //怪物魔法攻击
    public void magic_attack(){
        int hp=player.getHP()-monster.getMagicAtk();
        player.setHP(hp);
    }

    //public Player return_player(){
    //    return this.player;
    //}

    //public Monster return_monster(){
    //    return this.monster;
    //}

}