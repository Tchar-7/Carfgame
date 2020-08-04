package sh;

public class Person {
	String Name;
	double Speed;
	int Atk;
	int Def;
	int HP;
	Boolean injuryBuff;
	
	
	public Person(String name,double speed,int atk, int def, int hp)
	{
		this.Name = name;
		this.Speed = speed;
		this.Atk = atk;
		this.Def = def;
		this.HP = hp;
		this.injuryBuff = false;
	}
	
	public void setName(String n) 
	{
		this.Name = n;
	}
	public String getName()
	{
		return this.Name;
	}
	public void setSpeed(double s) 
	{
		this.Speed = s;
	}
	public double getSpeed()
	{
		return this.Speed;
	}
	public void setAtk(int a) 
	{
		this.Atk = a;
	}
	public int getAtk()
	{
		return this.Atk;
	}
	public void setDef(int d) 
	{
		this.Def = d;
	}
	public int getDef()
	{
		return this.Def;
	}
	public void setHP(int h)
	{
		this.HP = h;
	}
	public int getHP()
	{
		return this.HP;
	}
	public void setinjuryBuff(boolean b)
	{
		this.injuryBuff = b;
	}
	public boolean getinjuryBuff() 
	{
		return this.injuryBuff;
	}


	
}

