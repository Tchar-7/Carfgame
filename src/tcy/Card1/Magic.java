package tcy.Card1;


/**
 * @author char
 * @version 1.0
 * @created 25-5��-2020 14:20:57
 */
public class Magic extends Card {

	private int number;

	public Magic(int cardtype , int cost , String name ,boolean onetime,String information,int number){
		super(cardtype, cost, name, onetime, information);
		this.number = number;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public int getnumber(){
		return this.number;
	}
}//end Magic