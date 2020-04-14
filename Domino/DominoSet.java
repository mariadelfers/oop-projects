import java.util.*;
/**
	@author Ma. Fernanda Hernández Enriquez
	@author Diana Claudia Aranda Soriano
	
	class Domino Set
	This class provides the definition of the domino set for a game, with all domine tiles involves
*/
public class DominoSet{

	private DominoTiles [] dtiles;
	private int noTiles;

	/**
	Blank constructos: provides a blank domino set, 28 empty tiles
	*/
	public DominoSet(){
		this.dtiles = new DominoTiles[56];
		this.noTiles = -1;
		for (int i = 0; i < 7; i++){
				this.addTile(new DominoTiles(0,i));
		}
		for (int i = 1; i < 7 ; i++){
				this.addTile(new DominoTiles(1,i));
		}
		for (int i = 2; i < 7 ; i++){
				this.addTile(new DominoTiles(2,i));
		}
		for (int i = 3; i < 7 ; i++){
				this.addTile(new DominoTiles(3,i));
		}
		for (int i = 4; i < 7 ; i++){
				this.addTile(new DominoTiles(4,i));
		}
		for (int i = 5; i < 7 ; i++){
				this.addTile(new DominoTiles(5,i));
		}
		for (int i = 6; i < 7 ; i++){
				this.addTile(new DominoTiles(6,i));
		}
	}

	/**
	Constructor with parameters
	@param DominoTiles	Domino set with all the tiles
	*/
	public DominoSet(DominoTiles[] dtiles){
		this.dtiles = dtiles;
		this.noTiles = dtiles.length -1;
	}

	/**
	Adds a tile to the domino set
	@param dtile 	New tile to be added
	@return True if the tile was added correctly, false if the set domino is full
	*/
	public boolean addTile (DominoTiles dtile){
		if(this.noTiles == 56){
			return false;
		}
		else{
			this.noTiles++;
			this.dtiles[noTiles] = dtile;
			return true;
		}
	}

	/**
	Accesor for the domino tiles
	@return	Array containing the 28 tiles of the set domino
	*/
	public DominoTiles[] getDtiles(){
		return this.dtiles;
	}

	/**
	Mutator for the domino tiles
	@param dtiles 	New array containing the 28 tiles of the deck
	*/
	public void setDtiles (DominoTiles[] dtiles){
		this.dtiles=dtiles;
	}

	/**
	Accesor for the noTiles
	@return number of the tiles of the set domino
	*/
	public int getNoTiles(){
		return this.noTiles;
	}

	/**
	Mutator for noTiles
	@param noTiles New number of the tiles of the set domino
	*/
	public void setNoTiles (int noTiles){
		this.noTiles = noTiles;
	}

	/**
	Converts the object into a redeable String
	@return Stringify version of the set domino
	*/

	public String toString(){
		int i = 0;
		String set = "\n________DOMINO SET_________\n";
		while (i <= this.noTiles){
			// set+= "(" + i +")  ";
			set += this.dtiles[i].toString();
			i++;
			if(i%4 == 0)
				set += "\n";
		}
		set += "___________________________";
		return set;
	}

	/**
	Shuffle the domino set
	*/
	public void shuffle(){
		DominoTiles tmp;
		Random r = new Random();
		for (int i = 0; i <= this.noTiles; i++){
			tmp = this.dtiles[i];
			int a = r.nextInt(this.noTiles + 1);
			this.dtiles[i] = this.dtiles[a];
			this.dtiles[a] = tmp;
		}
	}

	/** 
		Returns the desired amount of the tiles from the top of the domino set, reduce noTiles
		@param noTiles 	Amount of the tiles to pop from the domino set
		@return Array containing the desired amount of tiles
	*/
	public DominoTiles[] popTiles (int noTiles) throws NullPointerException{
		if(this.noTiles < noTiles){
			throw new NullPointerException();
		}
		else{
			DominoTiles[] tmp = new DominoTiles[noTiles];
			for (int i = 0; i < noTiles; i++){
				tmp[i] = this.dtiles[this.noTiles];
				this.noTiles--;
			}
			return tmp;
		}
	}

	

	
}	