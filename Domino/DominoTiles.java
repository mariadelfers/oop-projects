/**
	@author Ma. Fernanda Hernández Enriquez
	@author Diana Claudia Aranda Soriano
    @version 1.0

	class DominoTiles
	This class provides the definition of a poker card, defined by two numbers
*/

public class DominoTiles{

	private int number1;
	private int number2;

	/**
		Empty constructos: Initiate a blan object
	*/
	public DominoTiles(){
		this.number1 = 0;
		this.number2 = 0;
	}

	/**
	Constructor with parameters
	@param number1 Int representation of the one number of the tile
	@param number2 Int representation of the other number of the title
	*/
	public DominoTiles(int number1, int number2){
		this.number1 = number1;
		this.number2 = number2;
	}

	/**
	Accesor for number1
	@return Int representation of the number of the tile
	*/
	public int getNumber1(){
		return this.number1;
	}

	/**
	Mutator for number1
	@param number1 New number of the tile
	*/
	public void setNumber1(int number1){
		this.number1 = number1;
	}

	/**
	Accesor for number2
	@return Int representation of the number of the tile
	*/
	public int getNumber2(){
		return this.number2;
	}

	/**
	Mutator for number2
	@param number2 New number of the tile
	*/
	public void setNumber2(int number2){
		this.number2 = number2;
	}

	/**
	Stringify representation of the object
	@string Card represented as: number1 / number2
	*/
	public String toString(){
		return " [" + this.number1 + "|" + this.number2 + "] ";
	}

}