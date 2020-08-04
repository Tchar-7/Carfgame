package tcy.Card1;


/**
 * @author char
 * @version 1.0
 * @created 25-5��-2020 14:20:59
 */
public class GetCard extends Card {

	private int number;
	private int attack;

	public GetCard(int cardtype , int cost , String name ,boolean onetime,String information,int number,int attack){
		super(cardtype, cost, name, onetime, information);
		this.number = number;
		this.attack = attack;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public int getnumber(){
		return this.number ;
	}
	public int getattack(){
		return this.attack;
	}
}//end GetCard