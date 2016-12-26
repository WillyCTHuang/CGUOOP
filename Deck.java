import java.util.ArrayList;
import java.util.Random;

public class Deck{
	
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	private ArrayList<Card> openCard;
	
	public int nUsed;
	
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		usedCard = new ArrayList<Card>() ;
		openCard = new ArrayList<Card>() ;
		
		
		for(int i=0;i<nDeck;i++)
		{
			for(int j=0;j<4;j++)
			{
				for(int k=0;k<13;k++)
				{
					Card.Suit thisCardSuit ;    
					Card card;
					
					switch(j){
						case 0:
							thisCardSuit = Card.Suit.Club;
							card = new Card(thisCardSuit,k+1);
							cards.add(card);
							break;
						case 1:
							thisCardSuit = Card.Suit.Diamond;
							card = new Card(thisCardSuit,k+1);
							cards.add(card);
							break;
						case 2:
							thisCardSuit = Card.Suit.Heart;
							card = new Card(thisCardSuit,k+1);
							cards.add(card);
							break;
						case 3:
							thisCardSuit = Card.Suit.Spade;
							card = new Card(thisCardSuit,k+1);
							cards.add(card);
							break;
						
					}
				}
			}
		}
		
		shuffle();

	}	
	

	public void printDeck(){
		
		for(Card c : cards){
			c.printCard();
		}

	}
	
	
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	
	public void shuffle(){
		
		
		for(int i=cards.size()-1;i>=0;i--){
			
			Random rnd = new Random(); 
			int rIndex = rnd.nextInt(i+1);
			
			Card cTemp = cards.get(rIndex);
			cards.remove(rIndex);
			cards.add(i,cTemp);
		}
		
		openCard.clear();
		usedCard.clear();
		nUsed = 0;
		
	}
	
	public Card getOneCard(boolean isOpened){
		
		
		if(nUsed>=cards.size()){
			shuffle();
		}
		
		Card c = cards.get(cards.size()-nUsed-1);
		

		nUsed++;
		usedCard.add(c);
		
		if(isOpened){
			openCard.add(c);
		}
		
		return c;
			
	}
	public ArrayList<Card> getOpenedCard(){
		return openCard;
	}
}