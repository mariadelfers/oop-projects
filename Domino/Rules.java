import java.util.Arrays;
/**
	@author Ma. Fernanda Hernández Enriquez
	@author Diana Claudia Aranda Soriano
	
	class Rules
	This class provides the definition of some rules and condition during the game, with all domine tiles involves and the set player
*/
public class Rules{
		//private DominoTiles[] dtiles;
		private PlayerSet[] playSet;
	
	/**
	Empty constructor
	*/
	public Rules(){
		//this.dtiles = new DominoTiles[6];
		this.playSet = new PlayerSet[2];
	}

	/**
	Constructor with parameters
	*/
	public Rules(PlayerSet[] playSet){
		//this.dtiles = dtiles;
		this.playSet = playSet;
	}

	/**
	Select the biggest tile of the sets of the players
	@param tile1 	Tile of one of the players
	@param tile2	Tile of the other player
	@return the biggest tile
	*/
	public DominoTiles  bigTileGame(DominoTiles tile1, DominoTiles tile2){
		 
		int t1 = tile1.getNumber1() + tile1.getNumber2();
		int t2 = tile2.getNumber1() + tile2.getNumber2();
		 
		if (t1 < t2)
			return tile2;
		
		else 
			return tile1;
	}

	/**
	Gives the turn of the players depending of the value
	@param tile1
	@paramm tile2
	@return int for whose was the turn
	*/
	public int getTurn(DominoTiles tile1, DominoTiles tile2){
		 
		int t1 = tile1.getNumber1() + tile1.getNumber2();
		int t2 = tile2.getNumber1() + tile2.getNumber2();
		 
		if (t1 < t2) 
			return 2;
		
		else 
			return 1;
	}

	/**
	Add a new tile in the set of the player
	@param int number of new tiles
	@return the new set
	*/
	public String tilesGame(DominoTiles title, int posicion){
		DominoTiles[] tilessGame  = new DominoTiles[28];
		tilessGame [posicion] = title;

		int i = 0;
		String set = "\n____Game Board_____________________________________________\n";
		while (i <= 28){
			set += tilessGame[i].toString();
			i++;
		}
		set += "_______________________________________________________________";
		return set;
	}

	/**
  	Add tile to left in an array
   @param left Domino tile to add
 	*/
	public void tileLeft( DominoTiles left){
        DominoTiles[] x = new DominoTiles[ this.dtiles.length + 1 ];
        x[0] = left;
        for( int i = 0; i < this.dtiles.length; i++){
                x[i + 1] = this.dtiles[i]; 
        }
        this.dtiles = x;
	}

	/**
   Add tile to right in an array
   @param right Domino tile to add
 	*/
	public void tileRight( DominoTiles right){
        DominoTiles[] y = new DominoTiles[ this.dtiles.length + 1 ];
        y[y.length - 1] = right;
        for( int i = 0; i < this.dtiles.length; i++){
                y[i] = this.dtiles[i];
        }
        this.dtiles = y;
	}

	/**
	Method to add the tile, depending if the numbers are equals 
	*/
	public void addTile( Domino toAdd )
	{
        int num1 = this.dtiles[0].getNumber1()[0];
        int num2 = this.dtiles[this.dtiles.length-1].get()[1];
        if( toArrange.getValues()[0] == leftValue && toArrange.getValues()[1] != leftValue )
                addPieceLeftUsedPieces(this.players.get(this.turn).getHand().invert(toArrange));

        else if( toArrange.getValues()[1] == rightValue && toArrange.getValues()[0] != rightValue )
                addPieceRightUsedPieces(this.players.get(this.turn).getHand().invert(toArrange));

        else if( toArrange.getValues()[0] == rightValue && toArrange.getValues()[1] != rightValue )
                addPieceRightUsedPieces(toArrange);

        else if( toArrange.getValues()[1] == leftValue && toArrange.getValues()[0] != leftValue)
                addPieceLeftUsedPieces(toArrange);

        else if( toArrange.getValues()[1] == leftValue )
                addPieceLeftUsedPieces(toArrange);

        else if( toArrange.getValues()[0] == rightValue )
                addPieceRightUsedPieces(toArrange);

}
}

