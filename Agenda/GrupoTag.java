/**
Clase que modela una etiqueta de un grupo de contactos en una agenda
@author Ma.Fernanda Hernandez Enriquez
*/
public class GrupoTag implements GrupoTagDef{

	public int id;

	/**
	Contructor por default
	*/
	public GrupoTag(){
		id = 0;
	}
	/**
	Constructor con parametros
	@param int id 	el id del grupo
	*/
	public GrupoTag(int id){
		this.id = id;
	}

	/**
	Mutador para id del grupo
	@param id
	*/
	public void setId(int id){
		this.id = id;
	}
	/**
	Accesor para id del grupo
	@return id
	*/
	public int getId(){
		return this.id;
	}

	/**
	Metodo para saber si dos grupos son iguales
	@param GrupoTag
	@return boolean, true para si y false para no
	*/
	public boolean esIgual(GrupoTag otroGrupo){
		if (this.id == otroGrupo.getId()){
			return true;
		}
		else
			return false;
	}
}