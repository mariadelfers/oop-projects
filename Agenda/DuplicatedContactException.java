/**
Clase que modela un exception cuando se comete el error de ingresar un contacto ya creado
@author Ma. Fernanda Hernandez Enriquez
*/
public class DuplicatedContactException extends Exception{

	/**
	Constructor con parametros
	@param Cadena de texto del error
	*/
	public DuplicatedContactException(String err){
		super(err);
	}

	public DuplicatedContactException(String err, Throwable t){
		super(err, t);
	}
}