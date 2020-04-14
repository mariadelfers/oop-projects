/**
	@author Ma. Fernanda Hernández Enriquez
    @version 1.0

	class Card
	This class provides the definition of a poker card, defined by a number (face) and a suit
*/

public class Card{
	
	public static final int SUIT_CLUBS = 0;
	public static final int SUIT_DIAMONS = 1;
	public static final int SUIT_HEARTS = 2;
	public static final int SUIT_SPADES = 3;
	
	public static final int COLOR_BLACK = 0;
	public static final int COLOR_RED = 1;
	
	private int face;//This is the number or figure of the card
	private int suit;
	
	/**
		Empty constructor: Initiates a blank object
	*/
	public Card(){
		this.face = 0;
		this.suit = this.SUIT_DIAMONS;
	}
	
	/**
		Constructor with parameters
		@param face Integer reoresentation of the face of the card, 1 to 10, 11 for Jack, 12 for Queen and 13 for King
		@param suit Integer representation of the suit of the card, 0 for diamons, 1 for clubs, 2 for hearts and 3 for spades
	*/
	public Card (int face, int suit){
		this.face = face;
		this.suit = suit;
	}
	
	/**
		Accesor for face
		@return Integer representation of the face of the card
	*/
	public int getFace(){
		return this.face;
	}
	
	/**
		Mutator for face
		@param face New face of the card
	*/
	public void setFace(int face){
		this.face = face;
	}
	
	/**
		Accesor for suit
		@return Integer representation of the suit card
	*/
	public int getSuit(){
		return this.suit;
	}
	
	/**
		Mutator for suit
		@param suit New suit of the card
	*/
	public void setSuit(int suit){
		this.suit = suit;
	}
	
	/**
		Stringify representation of the object
		@string Card represented as: face of suit
	*/
	public String toString(){
		return faceToString() + "" + suitToString();
	}
	
	/**
		String representation of the face of the card
		@string Face to string
	*/
	public String faceToString(){
		String f = "";
		switch(this.face){
			case 1:
				f = "1";
				break;
			case 2:
				f = "2";
				break;
			case 3:
				f = "3";
				break;
			case 4:
				f = "4";
				break;
			case 5:
				f = "5";
				break;
			case 6:
				f = "6";
				break;
			case 7:
				f = "7";
				break;
			case 8:
				f = "8";
				break;
			case 9:
				f = "9";
				break;
			case 10:
				f = "10";
				break;
			case 11:
				f = "J";
				break;
			case 12:
				f = "Q";
				break;
			case 13: 
				f = "K";
				break;
			default:
				f = "?";
				break;
		}
		return f;
	}
	
	/**
		Stringy representation of the suit
		@return Suit to String
	*/
	public String suitToString(){
		String s = "";
		switch (this.suit){
			case SUIT_DIAMONS:
				s = "D";
				break;
			case SUIT_CLUBS:
				s = "C";
				break;
			case SUIT_HEARTS:
				s = "H";
				break;
			case SUIT_SPADES:
				s = "S";
				break;
			default :
				s = "?";
				break;
		}
		return s;
	}
	
	/**
		Compares the object with another card
		@param card Card to compare
		@return true if the cards are the same, false if are differents
	*/
	public boolean equals(Card card){
		return this.face == card.getFace() && this.suit == card.getSuit();
	}
	
	/**
		Compares the object with another card and return if it is higher or not
		@param card Card to compare
		@return 1 If the object is higher than the card compared; -1 if the object is smaller that the card compared and 0 if it is equals
	*/
	public int comparteTo(Card card){
		if (this.equals(card))
			return 0; 
		else{
			int a = this.face;
			if (a == 1)
				a = 14;
			int b = card.getFace();
			if  (b == 1)
				b = 14;
			if(a > b)
				return 1;
			else if (a < b)
				return -1;
			else {
				int c = this.suit;
				int d = card.getSuit();
				if (c > d)
					return 1;
				if (c < d)
					return -1;
				else 
					return 0;
			}
		}
	}
	
	/**
		Returns the color of the card
		@return Integer represented of the color of the card, 0 for black and 1 for red
	*/
	public int getColor(){
		int i = -1;
		switch(this.suit){
			case SUIT_CLUBS:
			case SUIT_SPADES:
			i = this.COLOR_BLACK;
			break;
			case SUIT_DIAMONS:
			case SUIT_HEARTS:
			i = this.COLOR_RED;
			break;
		}
		return i;
	}
}