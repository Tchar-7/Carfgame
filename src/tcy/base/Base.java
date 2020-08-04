package tcy.base;
import java.io.*;
import tcy.Card1.*;
import java.util.Random;


/**
 * @author char
 * @version 1.0
 * @created 27-5��-2020 10:02:47
 */
public class Base {

	private Card[] cardBase;
	private Card[] trashbinCards;
	private Card[] myCardBase;
	private Card[] useCard;
	private int index1 = 0,index2 = 0,index3 = 0,index4 = 0;

	public Base(){
		cardBase = new Card[20];
		myCardBase = new Card[50];
		trashbinCards = new Card[50];
		useCard = new Card[6];
		createBase();
	}

	public String getcardimfor(int index){
		return "resources/"+useCard[index].getName()+".png";
	}

	public Card getuseCard(int index){
		return useCard[index];
	}

	public void finalize() throws Throwable {

	}

	public void createBase(){
		try{
			BufferedReader re= new BufferedReader(new FileReader("resources/base.txt"));
			String str = "";
			String[] strlist;
			while((str = re.readLine()) != null){
				strlist = str.split(" ");
				switch(Integer.parseInt(strlist[0])){
					case 1:
						Card c1 = new Nai(Integer.parseInt(strlist[0])
						,Integer.parseInt(strlist[1]),strlist[2],
						Boolean.parseBoolean(strlist[3]),strlist[4],Integer.parseInt(strlist[5]));

						cardBase[index1] = c1;
						index1++;
						break;
					case 2:
						Card c2 = new GetCard(Integer.parseInt(strlist[0])
						,Integer.parseInt(strlist[1]),strlist[2],
						Boolean.parseBoolean(strlist[3]),strlist[4],
						Integer.parseInt(strlist[5]),Integer.parseInt(strlist[6]));

						cardBase[index1] = c2;
						index1++;
						break;
					case 3:
						Card c3 = new Attack(Integer.parseInt(strlist[0])
						,Integer.parseInt(strlist[1]),strlist[2],
						Boolean.parseBoolean(strlist[3]),strlist[4],
						Integer.parseInt(strlist[5]),Double.parseDouble(strlist[6]));

						cardBase[index1] = c3;
						index1++;
						break;
					case 4:
						Card c4 = new Armor(Integer.parseInt(strlist[0])
						,Integer.parseInt(strlist[1]),strlist[2],
						Boolean.parseBoolean(strlist[3]),strlist[4],
						Integer.parseInt(strlist[5]),Double.parseDouble(strlist[6]),Integer.parseInt(strlist[7]));

						cardBase[index1] = c4;
						index1++;
						break;
					case 5:
						Card c5 = new Magic(Integer.parseInt(strlist[0])
						,Integer.parseInt(strlist[1]),strlist[2],
						Boolean.parseBoolean(strlist[3]),strlist[4],
						Integer.parseInt(strlist[5]));

						cardBase[index1] = c5;
						index1++;
						break;
					case 6:
						Card c6 = new Defended(Integer.parseInt(strlist[0])
						,Integer.parseInt(strlist[1]),strlist[2],
						Boolean.parseBoolean(strlist[3]),strlist[4],
						Integer.parseInt(strlist[5]));

						cardBase[index1] = c6;
						index1++;
						break;
					case 7:
						Card c7 = new Trap(Integer.parseInt(strlist[0])
						,Integer.parseInt(strlist[1]),strlist[2],
						Boolean.parseBoolean(strlist[3]),strlist[4]);

						cardBase[index1] = c7;
						index1++;
						break;
				}
			}

			re.close();
		}
		catch(Exception e1){

		}		
	}
	
	public void addCard(int num){
		myCardBase[index3] = cardBase[num];
		index3++;
	}
	
	public void getCard(){
		Random r = new Random();
		for(int i = 0 ;i < 6 ; i++){
			int put = r.nextInt(index3);
			useCard[index4] = myCardBase[put];
			index3--;
			myCardBase[put] = myCardBase[index3];
			index4++;
			
		}
	}	

	public void getCard(int num){
		Random r = new Random();
		for(int i = 0 ;i < num ; i++){
			if(index4 == 6){
				break;
			}
			int put = r.nextInt(index3);
			useCard[index4] = myCardBase[put];
			index3--;		
			myCardBase[put] = myCardBase[index3];
			index4++;

		}
	}
	
	public void uCard(int a){
		index4--;
		if(useCard[a].getOnetime() == true){

		}
		else{
			trashbinCards[index2] = useCard[a];
			index2++;
		}
		useCard[a] = useCard[index4];
		Card kong = new Card(8, 0, "Kong", true, "白板一张");
		useCard[index4] = kong;
	}

	public void re(){
		while(index2 > 0){
			index2--;
			myCardBase[index3] = trashbinCards[index2];
			index3++;
		}
		while(index4 > 0 ){
			index4--;
			myCardBase[index3] = useCard[index4];
			index3++;
		}
	}

	public void printmybase(){
		for(int i = 0;i<index3;i++){
			System.out.print(myCardBase[i].toString());
		}
	}

	public void shownumberbase(){
		System.out.print("Base:"+index2);
	}

	public int gettrashbinCardsNum() {
		return index2;
	}

	public int getuserbaseNum() {
		return index3;
	}
}//end Base