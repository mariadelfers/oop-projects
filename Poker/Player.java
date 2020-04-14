/**
	@author Ma. Fernanda Hernández Enriquez
	
	class Player
	This class provides the definition of the Player
*/
public class Player extends Person
{
	private float money;
	private String alias;
	private Hand hand;
	
	/**
		Empty constructor: Initiates a blank object
	*/
	public Player(){
		super();
		this.money = 0;
		this.alias = "";
		this.hand = new Hand();
	}
	
	/**
		Constructor with parameters
		@param money	The amount of money that the player has
		@param alias 	The username of the player for the game
	*/
	public Player(String name, String lastName, String alias, float money){
		super (name, lastName, true);
		this.money = money;
		this.alias = alias;	
		this.hand = new Hand();
	}
	
	/**
		Accesor for money
		@return Amount of money of the player
	*/
	public float getMoney(){
		return this.money;
	}
	
	/**
		Mutator for money
		@param money New amount of money of the player
	*/
	public void setMoney(float money){
		this.money = money;
	}
	
	/**
		Accesor for alias
		@return username of the player
	*/
	public String getAlias(){
		return this.alias;
	}
	
	/**
		Mutator for alias
		@param alias	New username of the player
	*/
	public void setAlias(String alias){
		this.alias = alias;
	}
	

	/**
		Accesor for hand
		@return hand of the player
	*/
	public Hand getHand(){
		return this.hand;
	}
	
	/**
		Mutator for hand
		@param hand	New hand of the player
	*/
	public void setHand(Hand hand){
		this.hand = hand;
	}
	
	/**
	    Stringify version of the player
		@return The player stringified as alias_money
	*/
	public String toString()
	{
		//String info = getName() + " " + getLastName() + ": "+ this.alias + " - $" + this.money;
		String info = this.alias + " ($" +this.money + ") H: " +this.hand.toString();
		return info;
	}
}
