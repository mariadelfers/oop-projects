/**
	@author Ma. Fernanda Hernández Enriquez
	@author Diana Claudia Aranda Soriano
	
	class Player
	This class provides the definition of the Player
*/
public class Player{

	private String name;
	private int dobs;
	private PlayerSet[] playSet;
	private String playerSet;

	/**
	Emnpty constructor: Initiates a blank object
	*/
	public Player(){
		this.name = "";
		this.dobs = 0;
		this.playSet = new PlayerSet[1];
		this.playerSet = "";
	}

	/**
	Constructor with parameters
	@param dobs		The amount of points that the has accumulated
	*/
	public Player(String name, int dobs, String playerSet){
		this.name = name;
		this.dobs = dobs;
		this.playerSet = playerSet;
	}

	/**
	Accesor for name
	@return name of the player
	*/
	public String getName(){
		return this.name;
	}

	/**
	Mutator for name
	@param name 	New name of the player
	*/
	public void setName(String name){
		this.name = name;
	}

	/**
	Accesor for dobs
	@return points of the player
	*/
	public int getDobs(){
		return this.dobs;
	}

	/**
	Mutator for dobs
	@param dobs 	New points of the player
	*/
	public void setDobs(int dobs){
		this.dobs = dobs;
	}

	/**
	Accesor for the set of the player
	@return Array containing 1 set for each game
	*/
	public PlayerSet[] getPlaySet(){
		return this.playSet;
	}
	
	/**
	Mutator for the set of the player
	@param dtiles 	New array containing 1 ser for each game
	*/
	public void setPlaySet(PlayerSet[] playSet){
		this.playSet = playSet;
	}

	/**
	Accesor for player set
	@return set of the player
	*/
	public String getPlayerSet(){
		return this.playerSet;
	}

	/**
	Mutator for player set
	@param playerSet 	New set of the player
	*/
	public void setPlayerSet(String playerSet){
		this.playerSet = playerSet;
	}


	/**
	Stringify version of player
	@return The player stringified as name_points(dobs)
	*/
	public String toString(){
		String play = "Player: " + this.name + " points: " + this.dobs;
		play += "\n"+ this.playerSet;
		return play;
	}
}