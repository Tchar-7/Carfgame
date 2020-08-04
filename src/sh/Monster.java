package sh;
import sh.Person;

public class Monster extends Person
{
	int MagicAtk;
	int addDef;
	public Monster(String name,double Speed, int Atk, int magicAtk , int Def, int adddef,int HP)
	{
		super(name, Speed, Atk, Def, HP);
		this.MagicAtk = magicAtk;
		this.addDef = adddef;
	}
	
	public void setMagicAtk(int magicAtk) 
	{
		this.MagicAtk = magicAtk;
	}
	public int getMagicAtk()
	{
		return this.MagicAtk;
	}
	public int getaddDef(){
		return this.addDef;
	}
}
