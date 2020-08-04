package tcy.Card1;


/**
 * @author char
 * @version 1.0
 * @created 25-5��-2020 14:22:32
 */
public class Card {
	private int cardtype;
	private int cost;
	private String information;
	private String name;
	private boolean onetime;

	public Card(int cardtype , int cost , String name ,Boolean onetime,String information){
		this.cost = cost;
		this.cardtype = cardtype;
		this.name = name;
		this.onetime = onetime;
		this.information = information;
	}

	public void finalize() throws Throwable {
		
	}

	public String getInformation(){
		return this.information;
	}

	public String getcardMusicinfor(int index){
		return "resources/"+this.name + "音效.wav";
	}

	public String getName(){
		return this.name;
	}
	public int getCost(){
		return this.cost;
	}
	public int getCardType(){
		return this.cardtype;
	}
	public boolean getOnetime(){
		return this.onetime ;
	}
	
	public String use(){
		return "你使用了"+getName()+"，"+getInformation();
	}

	public String tpString(){
		return "Name:"+getName()+" Cost:"+getCost() +" Information:"+getInformation();
	}
}//end Card