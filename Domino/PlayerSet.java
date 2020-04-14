import java.util.Arrays;
/**
	@author Ma. Fernanda Hernández Enriquez
	@author Diana Claudia Aranda Soriano
    @version 1.0

	class Player set
	This class provides the definition of the set of the player, defined by the tiles
*/
public class PlayerSet{

	private DominoTiles[] dtiles;
	private int tiles; 

	/**
	Empty constructor: Initiates a blank object
	*/
	public PlayerSet(){
		this.dtiles = new DominoTiles [5]; 
	}

	/**
	Constructor with parameters
	@param dtiles 	
	*/
	public PlayerSet(DominoTiles[] dtiles){
		this.dtiles = dtiles;
	}

	/**
		Accesor for the tiles
		@return Array containing the 6 tiles of the domino set
	*/
	public DominoTiles[] getDtiles(){
		return this.dtiles;
	}
	
	/**
		Mutator for the tiles
		@param dtiles 	New array containing the 6 tiles of the domino set
	*/
	public void setDtiles(DominoTiles[] dtiles){
		this.dtiles = dtiles;
	}

	/**
	    Stringify version of the player set
		@return The player set stringified as [number | number]
	*/
	public String toString(){
		String ps = this.dtiles[0].toString();
		for(int i = 1; i<this.dtiles.length; i++){
			ps += this.dtiles[i].toString();
		}
		return ps;
	}

	/**
	This method order the tiles low to high just with the number one
	*/
	
	public String orderTiles(){
		for(int i = 0; i < this.dtiles.length; i++){
			for(int j = i+1; j < this.dtiles.length; j++){
				if(this.dtiles[i].getNumber1() > this.dtiles[j].getNumber1())
				{
					DominoTiles tmp = this.dtiles[i];
					this.dtiles[i] = this.dtiles[j];
					this.dtiles[j] = tmp;
				}
			}
		}
		String x = this.dtiles[0].toString();
		for(int i = 1; i<this.dtiles.length; i++){
		x += "\n" + this.dtiles[i].toString();
		}
		return x;
	} 

	/**
	This method gives you the position of the biggest tile of the set of the player
	@return dtile
	*/
	public DominoTiles bigTileSet(){
		int sum = 0;//Numero mayor
		int x = 0; //Posición
		int bigNum = 0;
		int [] arr = new int [this.dtiles.length];
		for(int i = 0; i<this.dtiles.length; i++){
		 sum = this.dtiles[i].getNumber1() + this.dtiles[i].getNumber2();
		 arr[i] = sum;
		}
		for (int j = 0; j <arr.length; j++){
			if (arr[j]>bigNum){
   			bigNum = arr[j];
   			x = j;
			}
		}
		//Arrays.sort(arr);
		//sum2 = arr[0]
		//for (int i = 0; i<this.dtiles.length; )
		return this.dtiles[x];
	}

	/**
	Delete a tile of the set player
	@param tile 	title was play
	@paramm Player set 	the first player set
	@return array of the new domino tiles of the player
	*/

	public String deleteTile(DominoTiles tile){
		String x = this.dtiles[0].toString();
		for (int i = 0; i < this.dtiles.length; i++){
			if (tile.equals(this.dtiles[i]) == true){
				this.dtiles[i] = new DominoTiles(99999,99999);
				x += "\n[/][/]";
			}
			else 
				x+="\n" + this.dtiles[i].toString();
		}
		return x;
	}

	/**
	Compares the tile of the game with all the player set
	@param tile1 of the current game
	@paramm player set for the next player
	@return the tile for the next turn
	*/
	public String compare1To(DominoTiles tile1){
		String x = "";
        for (int i = 0; i<this.dtiles.length; i++){
			int b1 = this.dtiles[i].getNumber1();
			int b2 = this.dtiles[i].getNumber2();
			int a1 = tile1.getNumber1();
			int a2 = tile1.getNumber2();
			
			if(a2 == b1){
				//x = tile1.toString();
				x = this.dtiles[i].toString();

				break;
			}
			else if (a2 == b2){
				//x = tile1.toString();
				this.dtiles[i] = new DominoTiles(b2,b1);
				x = dtiles[i].toString();
				break;
			}
			else if (a1 == b2){
				x = this.dtiles[i].toString();
				//x += tile1.toString();
				break;
			}
			else if (a1 == b1){
				this.dtiles[i] = new DominoTiles(b2,b1);
				x = this.dtiles[i].toString();
				//x += tile1.toString();
				break;
			}
			else 
				x = "No hay fichas compatibles";
		}
		
		return x;	
	}

	public boolean compare11To(DominoTiles tile1){
		boolean x =false;
        for (int i = 0; i<this.dtiles.length; i++){
			int b1 = this.dtiles[i].getNumber1();
			int b2 = this.dtiles[i].getNumber2();
			int a1 = tile1.getNumber1();
			int a2 = tile1.getNumber2();
			
			if(a2 == b1){
				x = true;
				break;
			}
			else if (a2 == b2){
				x = true;
			}
			else if (a1 == b2){
				x = true;
				break;
			}
			else if (a1 == b1){
				x = true;
				break;
			}
			else 
				x = false;
		}
		
		return x;	
	}

	public DominoTiles compare111To(DominoTiles tile1){
        DominoTiles x = new DominoTiles(0,0);
        for (int i = 0; i<this.dtiles.length; i++){
			int b1 = this.dtiles[i].getNumber1();
			int b2 = this.dtiles[i].getNumber2();
			int a1 = tile1.getNumber1();
			int a2 = tile1.getNumber2();
			
			if(a2 == b1){
				x = this.dtiles[i];
				break;
			}
			else if (a2 == b2){
				x = this.dtiles[i];
				break;
			}
			else if (a1 == b2){
				x = this.dtiles[i];
				break;
			}
			else if (a1 == b1){
				x = this.dtiles[i];
				break;
			}
			else 
				x = new DominoTiles(0,0);
				break;
		
		}
		return x;	
	}

	/**
	Compares the tile of the game with all the player set
	@param tile1 of the current game
	@param tile2 of the current game
	@paramm player set for the next player
	@return the tile for the next turn
	*/
	public String compare2To(DominoTiles tile1, DominoTiles tile2){
		String x = "";
        for (int i = 0; i<this.dtiles.length; i++){
			int b1 = this.dtiles[i].getNumber1();
			int b2 = this.dtiles[i].getNumber2();
			int a1 = tile1.getNumber1();
			int a2 = tile2.getNumber2();
			
			if(a2 == b1){
				//x = tile1.toString();
				x = this.dtiles[i].toString();

				break;
			}
			else if (a2 == b2){
				//x = tile1.toString();
				this.dtiles[i] = new DominoTiles(b2,b1);
				x = dtiles[i].toString();
				break;
			}
			else if (a1 == b2){
				//x = tile1.toString();
				x = this.dtiles[i].toString();
				break;
			}
			else if (a1 == b1){
				this.dtiles[i] = new DominoTiles(b2,b1);
				//x = tile1.toString();
				x = this.dtiles[i].toString();
				
				break;
			}
			else 
				x = "No hay fichas compatibles";
		}
		
		return x;	
	}

	public boolean compare22To(DominoTiles tile1, DominoTiles tile2){
		boolean x = false;
        for (int i = 0; i<this.dtiles.length; i++){
			int b1 = this.dtiles[i].getNumber1();
			int b2 = this.dtiles[i].getNumber2();
			int a1 = tile1.getNumber1();
			int a2 = tile2.getNumber2();
			
			if(a2 == b1){
				x = true;
				break;
			}
			else if (a2 == b2){
				x = true;
				break;
			}
			else if (a1 == b2){
				x = true;
				break;
			}
			else if (a1 == b1){
				x = true;				
				break;
			}
			else 
				x = false;
		}
		
		return x;	
	}

	public DominoTiles compare222To(DominoTiles tile1, DominoTiles tile2){
		DominoTiles x = new DominoTiles(0,0);
        for (int i = 0; i<this.dtiles.length; i++){
			int b1 = this.dtiles[i].getNumber1();
			int b2 = this.dtiles[i].getNumber2();
			int a1 = tile1.getNumber1();
			int a2 = tile2.getNumber2();
			
			if(a2 == b1){
				x = this.dtiles[i];
				break;
			}
			else if (a2 == b2){
				x = this.dtiles[i];
				break;
			}
			else if (a1 == b2){
				x = this.dtiles[i];
				break;
			}
			else if (a1 == b1){
				x = this.dtiles[i];				
				break;
			}
			else 
				x = new DominoTiles(0,0);
		}
		
		return x;	
	}
	
	/**
	Add a new title in the set of the player
	@param int number of new tiles
	@return the new set
	*/
	public void addTile( DominoTiles[] tilesToAdd ){
        DominoTiles[] newPlayerSet = new DominoTiles[this.dtiles.length  + tilesToAdd.length ];

        int i = 0; 
        for ( ; i < this.dtiles.length; i++)
        {
                newPlayerSet[i] = this.dtiles[i];
        }

        int j = 0; 
        for ( ; i < newPlayerSet.length; i++)
        {
                newPlayerSet[i] = tilesToAdd[j];
                j++;
        }

        this.dtiles = newPlayerSet;
        //return this.dtiles.toString();
	}
		

}