public class WrongParameterException extends Exception{
/**
Clase que modela una excepcion 
@author Ma.Fernanda Hernandez Enriquez
*/
	/**
	Constructor con parametros
	@param Cadena de texto del error
	*/
	public WrongParameterException(String err){
		super(err);
	}

	public WrongParameterException(String err, Throwable t){
		super(err, t);
	}
}