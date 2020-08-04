package tcy.Card1;


/**
 * @author char
 * @version 1.0
 * @created 25-5��-2020 14:21:01
 */
public class Armor extends Attack {

	private int toarmor;

	public Armor(int cardtype , int cost , String name ,boolean onetime,String information,int number1,double mul,int number2){
		super(cardtype, cost, name, onetime, information,number1,mul);
		this.toarmor = number2;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public int getMul(){
		return this.toarmor;
	}
}//end Armor