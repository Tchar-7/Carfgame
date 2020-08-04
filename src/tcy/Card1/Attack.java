package tcy.Card1;

/**
 * @author char
 * @version 1.0
 * @created 25-5��-2020 14:24:01
 */
public class Attack extends Card {

	private int number;
	private double percent;


	public Attack(int cardtype , int cost , String name ,boolean onetime,String information,int number,double percent){
		super(cardtype, cost, name, onetime, information);
		this.number = number;
		this.percent = percent;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public int getnumber(){
		return this.number;
	}

	public double getpercent(){
		return this.percent;
	}
}//end Attack