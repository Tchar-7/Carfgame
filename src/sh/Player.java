package sh;
import sh.Person;

public class Player extends Person
{
	int PP;
	
	public Player(String name,double Speed, int Atk, int Def, int HP, int pp)
	{
		super(name, Speed, Atk, Def, HP);
		this.PP = pp;
	}
	
	public void setPP(int pp)
	{
		this.PP = pp;
	}
	public int getPP()
	{
		return this.PP;
	}
}
