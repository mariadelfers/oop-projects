/**
	@author Ma. Fernanda Hernández Enriquez
	
	class Board
	This class provides the definition of the Board of the game
*/
public class Board{

	private Square[][] squares;
	private String square;
	private int col;
	private int row;

	/**
	Emnpty constructor: Initiates a blank object
	*/
	public Board(){
		this.squares = new Square[3][3];
		squares[0][0] = new Square("-");
		squares[0][1] = new Square("-");
		squares[0][2] = new Square("-");
		squares[1][0] = new Square("-");
		squares[1][1] = new Square("-");
		squares[1][2] = new Square("-");
		squares[2][0] = new Square("-");
		squares[2][1] = new Square("-"); 
		squares[2][2] = new Square("-");
		this.col = 0;
		this.row = 0;
	}

	/**
	Constructor with parameters
	@param 		The amount of points that the has accumulated
	*/
	public Board(int a, int b, int col, int row){
		this.squares = new Square[a][b];
		this.col = col;
		this.row = row;
	}

	/**
	Accesor for square
	@return square of the board
	*/
	public Square[][] getSquare(){
		return this.squares;
	}
	/**
	Mutator for square
	@param squares 	New array of the square
	*/
	public void setSquare(Square[][] squares){
		this.squares = squares;
	}
	/**
	Accesor for col
	@return colum of the board
	*/
	public int getCol(){
		return this.col;
	}
	/**
	Mutator for col
	@param int 	New col of the square
	*/
	public void setCol(int col){
		this.col = col;
	}

	/**
	    Stringify version of the player set
		@return The player set stringified as [number | number]
		
	*/
	public String toString(int player){
		String s = this.squares[0][0].toString(player);
		s+= this.squares[0][1].toString(player);
		s+= this.squares[0][2].toString(player);
		s+= "\n"+this.squares[1][0].toString(player);
		s+= this.squares[1][1].toString(player);
		s+= this.squares[1][2].toString(player);
		s+= "\n"+ this.squares[2][0].toString(player);
		s+= this.squares[2][1].toString(player);
		s+= this.squares[2][2].toString(player);
					
		return s;
	}
}