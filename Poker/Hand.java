/**
	@author Ma. Fernanda Hernández Enriquez
    @version 1.0

	class Hand
	This class provides the definition of poker hand, defined by the cards
*/
public class Hand{
	
	//constants
	public static final int WH_ONEPAIR = 0;
	public static final int WH_TWOPAIRS = 1;
	public static final int WH_THREEOFAKIND = 2;
	public static final int WH_STRAIGHT = 3;
	public static final int WH_FLUSH =4;
	public static final int WH_FULLHOUSE = 5;
	public static final int WH_FOUROFAKIND = 6;
	public static final int WH_STRAIGHTFLUSH = 7;
	
	private Card[] cards;
	private int winnerHand;
	private Card[] aux;

	/**
		Empty constructor: Initiates a blank object
	*/
	public Hand(){
		this.cards = new Card [5];
		//this.winnerHand = this.WH_ONEPAIR;
	}
	
	/** 
		Constructor with parameters 
		@param cards	Deck with all the cards
	*/
	public Hand(Card [] cards){
		this.cards = cards;
		//this.winnerHand = winnerHand;
	}
	
	/**
		Accesor for the cards
		@return Array containing the 5 cards of the hand
	*/
	public Card[] getCards(){
		return this.cards;
	}
	
	/**
		Mutator for the cards
		@param cards 	New array containing the 5 cards of the hand
	*/
	public void setCards(Card[] cards){
		this.cards = cards;
	}
	
	/**
		Accesor for winner hand
		@return the winner hand
	*/
	public int getWinnerHand(){
		return this.winnerHand;
	}
	
	/**
		Mutator for winner hand
		@param winnerHand
	*/
	public void setWinnerHaner(int winnerHand){
		this.winnerHand = winnerHand;
	}

	public int length(){
		return this.cards.length;
	}

	public Card swapCard(int pos, Card c){
		Card aux = this.cards[pos];
		this.cards[pos] = c;
		return aux;
	}
	
	/**
	    Stringify version of the hand
		@return The hand stringified as WH_ winner hand
	*/
	public String toString()
	{
		String h = this.cards[0].toString();
		for (int i = 1; i < this.cards.length; i++){
			h += " | " + this.cards[i].toString();
		}
		return h;
	}

	
	public String winnerHandToString(){
		String wh = "";
		int wh1 = this.typeOfHand();
		switch (wh1){
			case WH_ONEPAIR:
				wh = "One pair";
				break;
			case WH_TWOPAIRS:
				wh = "Two pairs";
				break;
			case WH_THREEOFAKIND:
				wh = "Three of kind";
				break;
			case WH_STRAIGHT:
				wh = "Straight";
				break;
			case WH_FLUSH:
				wh = "Flush";
				break;
			case WH_FULLHOUSE:
				wh = "Full house";
				break;
			case WH_FOUROFAKIND:
				wh = "Four of a kind";
				break;
			case WH_STRAIGHTFLUSH:
				wh = "Straight flush";
				break;
			default:
				wh = "High hand";
				break;
		}
		return wh;
	}

	public Card[] bubbleSort(Card[] c){

		//Algorithm to sort the array asc
		for (int i = 0; i < c.length; i++){
			//This pinpoints each element in the array as aux[i]
			//This element will compare with all other elements to is right
			for (int j = i+1; j < c.length; j++){
				//This poinpoints the element that will be compared to as aux [j]
				if(c[i].getFace() > c[j].getFace())
				{
					Card tmp = c[i];
					c[i] = c[j];
					c[j] = tmp;
				}
			}			
		}
		return c;
	}

	public Card[] changeFace(Card[] c, int oFace, int nFace){
		for (int i = 0; i < c.length; i++){
			if (c[i].getFace() == oFace)
				c[i].setFace(nFace);
		}
		return c;
	}

	public int typeOfHand(){
		Card[] aux1 = this.cards;
		//aux1 = bubbleSort(aux1);
		Card[] aux2 = changeFace(aux1,1,14);
		aux2 = bubbleSort(aux2);

		int result = typeOfHandAlgorithm(aux2);
		if(result == -1){
			aux1 = bubbleSort(aux1);
			result = typeOfHandAlgorithm(aux1);
			if (result != -1)
				this.aux = aux1;
			else
				this.aux = aux2;
		}
		else{
			this.aux = aux2;
		}
		return result;
	}

	/**
	Method for to know what type of the hand that the player has
	@return the number of the type of the hand
	*/
	public int typeOfHandAlgorithm(Card[] c){
		
		int face = 0; // 1st metric, shows how many faces do I have
		int[] suit = new int[4];
		int[] diff = new int [2]; //2nd metric, shows how many diffeerences of 0 and 1 between face I have
		int cons = 1;
		int maxCons = 1; // 3rd metric, show maximum number fo the consecutive cards in the hand

		int previousFace = -1;
		for (int i = 0; i < c.length; i++){
			Card tmp = c[i];
			if (tmp.getFace() != previousFace){
				face++;
				if (cons > maxCons )
					maxCons = cons;
				cons = 1;
			}
			else
				cons++;
			suit[tmp.getSuit()]++;
			
			if (tmp.getFace() - previousFace <= 1)
				diff[tmp.getFace() - previousFace]++;
			
			previousFace = tmp.getFace();
		}
		if (cons > maxCons)
			maxCons = cons;

		int noSuits = 0;  //4th metric, shows how many suits do I have
		for (int i = 0; i < suit.length; i++){
			if (suit[i] > 0)
				noSuits++;
		}

		//System.out.println ("f= " +face+ " s= " + noSuits + " diff1= " + diff[1] + " cons= " +maxCons);

		int result = -1; // This value shows tha hand is not a winning hand
		if (noSuits == 1 && diff[1] == 4){
			result = WH_STRAIGHTFLUSH; //Straigth flush
		}
		else if (face == 2 && maxCons == 4){
			result = WH_FOUROFAKIND;//Four of kings
		}
		else if (face == 2 && maxCons == 3){
			result  = WH_FULLHOUSE; //Fullhouse
		}
		else if (noSuits == 1){
			result = WH_FLUSH;//Flush
		}
		else if (diff[1] == 4){
			result = WH_STRAIGHT; //Straight
		}
		else if (face == 3 && maxCons == 3){
			result = WH_THREEOFAKIND; //Three of a king
		}
		else if (face == 3 && maxCons == 2){
			result = WH_TWOPAIRS; //Two pair
		}
		else if (face == 4 && maxCons == 2){
			result = WH_ONEPAIR; //One pair
		}

		return result;
	}

}


//Hand
//-Cards[]
//<-----constants

//+toString()


//+isWinning()
//+typeOfHand():int
//+compareTo()