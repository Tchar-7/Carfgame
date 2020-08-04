package tcy.Card1;

/**
 * @author char
 * @version 1.0
 * @created 25-5��-2020 14:21:05
 */
public class Trap extends Card {

	public Trap(int cardtype , int cost , String name ,boolean onetime,String information){
		super(cardtype, cost, name, onetime, information);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Trap