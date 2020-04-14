/**
	@author Ma. Fernanda Hernández Enriquez
	
	class Square
	This class provides the definition of the square of the game
*/
public class Square{

	private String space;
	
	/**
	Emnpty constructor: Initiates a blank object
	*/
	public Square(){
		this.space = "-";
	}

	/**
	Constructor with parameters
	@param  sapce		The string of the space
	*/
	public Square(String space){
		this.space = space;
	}

	/**
	Accesor for space
	@return String space of the square
	*/
	public String getSpace(){
		return this.space;
	}

	/**
	Mutator for space
	@param 	New space of the square
	*/
	public void setSpace(String space){
		this.space = space;
	}


	/**
	Stringify representation of the object
	@string Space represented as: "x/o/ " " "
	*/
	public String toString(int player){
		if (player == 1)
			this.space = " X ";
		else if (player == 2)
			this.space = " O ";
		else if (player == 0)
			this.space = " - ";
		else 
			this.space = " - ";
	return this.space;
	}
}
