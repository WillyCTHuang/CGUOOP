

public class Card{
	
	public enum Suit{Club,Diamond,Heart,Spade};
	Suit suit;
	private int rank; //1~13
	
	public Card(Suit s,int r){
		suit =s;
		rank =r;
	}	

	public void printCard(){
		
		System.out.println(suit.toString()+" "+rank);
	}
	public Suit getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}

