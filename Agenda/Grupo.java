/**
Clase que modela una grupo de contactos en una agenda
@author Ma.Fernanda Hernandez Enriquez
*/
public class Grupo implements GrupoDef{

	public String nombre;
	public int actual;
	public GrupoTag tag;

	/**
	Constructor por default
	*/
	public Grupo(){
		this.nombre = "";
		this.actual = 0;
		this.tag = new GrupoTag(0);
	}
	/**
	Constructor con parametros
	@param String nombre 	Nombre del grupo
	@param int actual 		Número actual de contactos en el grupo
	@param GrupoTag			Tag que tiene el grupo
	*/
	public Grupo(String nombre, int actual, GrupoTag tag){
		this.nombre = nombre;
		this.actual = actual;
		this.tag = tag;
	}
	/**
	Accesor para nombre
	@return nombre
	*/
	public String getNombre(){
		return this.nombre;
	}
	/**
	Mutador para nombre
	@param nombre
	*/
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	/**
	Accesor para actual
	@return actual
	*/
	public int getActual(){
		return this.actual;
	}
	/**
	Mutador para actual
	@param actual
	*/
	public void setActual(int actual){
		this.actual = actual;
	}
	/**
	Accesor para tag
	@return tag
	*/
	public GrupoTag getTag(){
		return this.tag;
	}
	/**
	Mutador para tag
	@param tag
	*/
	public void setTag(GrupoTag tag){
		this.tag = tag;
	}
	/**
	Versión como cadena de Grupo
	@return Grupo como texto
	*/
	public String imprimir(){
		String x = " " + this.tag.getId() + " - "+this.nombre+" ("+this.actual+"miembros).";
		return x;
	}
	/**
	Metodo para agregar un contacto al grupo
	@param int n
	*/
	public int agregar(int agregar){
		this.actual = this.actual+agregar;
		return this.actual;
	}
	/**
	Metodo para eliminar un contacto del grupo
	@param int n
	*/
	public int eliminar(int eliminar){
		this.actual = this.actual-eliminar;
		return this.actual;	
	}
	/**
	Metodo para filtrar un contacto
	@param Arrgelo de contactos c
	@return Arreglo de contactos ya filtrados
	*/
	public Contacto[] filtrar(Contacto[] contactos){
		Contacto[] x = new Contacto[contactos.length];
		int i = 0;
		for (int j = 0; j<contactos.length; i++){
			for (int k = 0; j<contactos[i].getNoGrupos();k++){
				if(contactos[i].getGrupos()[k].equals(this.tag)){
					x[i] = contactos[j];
					i++;
					continue;
				}
			}
		}
		Contacto[] result = new Contacto[i];
		for(int j = 0; j<i; j++){
			result[j] = x[j];
		}
		return result;
	}
	/**
	Metodo para saber si dos grupos son iguales
	@param Grupo g
	@return boolean true si son iguales, false no son iguales
	*/
	public boolean esIgual(Grupo otroGrupo){
		boolean x = false;
		if (this.tag.equals(otroGrupo.getTag())){
			x = true;
		}
		else
			x = false;
		return x;
	}
	/**
	Metodo para comprar este grupo con otro
	@param Grupo g
	@return  int
	*/
	public int compararCon(Grupo otroGrupo){
		int x = 0;
		if(this.nombre.toLowerCase() == otroGrupo.getNombre().toLowerCase()){
				x = 1;
		}
		else{
			x = 2;
		}
		return x;
	}

	
}
