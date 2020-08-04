package tcy.Card1;

/**
 * @author char
 * @version 1.0
 * @created 25-5��-2020 14:23:21d
 */
public class Defended extends Card {
	private int number;

	public Defended(int cardtype , int cost , String name ,boolean onetime,String information,int number){
		super(cardtype, cost, name, onetime, information);
		this.number = number;
	}

	public int getnumber(){
		return this.number;
	}
}//end Defended