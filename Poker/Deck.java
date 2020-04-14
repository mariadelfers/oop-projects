import java.util.*;
/**
	@author Ma. Fernanda Hernández Enriquez
	
	class Deck
	This class provides the definition of the deck for a game, with all cards involves
*/
public class Deck{
	
	private Card [] cards;
	private int noCards; //not used by external classes, position of cards
	
	/**
		Blank constructor: provides a blank deck, 52 empty cards
	*/
	public Deck(){
		this.cards = new Card[52];
		this.noCards = -1;
		for(int i = 0; i <= 3; i++){
			for(int j=1; j<= 13; j++){
				this.addCard(new Card(j,i));
			}
		}
	}
	
	/**
		Constructor with parameters 
		@param cards	Deck with all the cards
	*/
	public Deck(Card [] cards){
		this.cards = cards;
		this.noCards = cards.length - 1;
	}
	
	/**
		Adds a card to the deck
		@param card		New card to be added
		@return True if the card was added correctly, false if the deck is full
	*/
	public boolean addCard (Card card){
		if(this.noCards == 51){
			return false;
		}
		else{
			this.noCards++;
			this.cards[noCards] = card;
			return true;
		}
	}
	
	/**
		Accesor fo the cards
		@return Array containing the 52 cards of the deck
	*/
	public Card[] getCards(){
		return this.cards;
	}
	
	/**
		Mutator for the cards
		@param cards 	New array containing the 52 cards of the deck
	*/
	public void setCards(Card[] cards){
		this.cards = cards;
	}

	/**
		Accesor for noCards
		@return number of cards of the deck
	*/
	public int getNoCards(){
		return this.noCards;
	}
	
	/**
		Mutator for noCards
		@param noCards New number of cards of the deck
	*/
	public void setNoCards(int noCards){	
		this.noCards = noCards;
	}

	/**
		Converts the object into a redeable Srting
		@return Srtingify version of the deck
	*/
	public String toString(){
		int count = 0;
		String result = "\n#### THE DECK: ##################################\n##\n";
		while(count <= this.noCards){
			if(count % 4 != 0)
				result += " | ";
			else
				result += "## ";
			result += " | " + this.cards [count].toString();
			count ++;
			if(count % 4 == 0)
				result += "\n";
		}
		if ((this.noCards + 1) % 4 != 0)
			result += "\n";
		result += "##\n#################################################\n";
		return result;
	}
	
	/**
		Shuffle the entire deck
	*/
	public void shuffle(){
		Card temp;
		Random r = new Random();
		for(int i=0; i <= this.noCards; i++){
			temp = this.cards[i];
			int k = r.nextInt(this.noCards + 1);
			this.cards[i] = this.cards[k];
			this.cards[k] = temp;
		}
	}
	
	/**
		Compare to method
		@param deck 	Another deck for comparison
		@return -1 if the deck is smaller, 1 if it is bigger, 0 if they are the same amount of cards and equal and -2 if they are the same amount of cards but different cards
	*/

	public int compareTo(Deck deck){
		if (this.noCards > deck.getNoCards())
			return 1;
		else if (this.noCards < deck.getNoCards())
			return -1;
		else {
			boolean res = false;
			Card temp;
			for (int x = 0; x <= this.noCards; x++){
				res = false;
				for (int y = 0; y <= this.noCards; y++){
					temp = (Card)(deck.getCards()[y]);
					if (this.cards[x].equals(temp)){
						res = true;
						break;
					}
				}
				if (res == false){
					break;
				}
			}
			if (res == true)
				return 0;
			else
				return -2;
		}
	}
	
	/**
		Returns a card from the top of the deck
		@return		Card returned
	*/
	public Card popCard() throws NullPointerException{
		if (this.noCards == -1)
			throw new NullPointerException();
		else {
			Card temp = this.cards [noCards];
			this.noCards--;
			return temp;
		}
	}

	/** 
		Returns the desired amount of the cards from the top of the deck, reduce noCards
		@param noCards 	Amount of the card to pop from the deck
		@return Array containing the desired amount of cards
	*/
	public Card[] popCards (int noCards) throws NullPointerException{
		if (this.noCards < noCards){
			throw new NullPointerException();
		}
		else {
			Card[] tmp = new Card[noCards];
			for (int i = 0; i < noCards; i++){
				tmp[i] = this.cards[this.noCards];
				this.noCards--;
			}
			return tmp;
		}
	}

}
