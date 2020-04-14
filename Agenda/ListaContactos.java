import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
Clase que modela una Lista de contactos
@author Ma.Fernanda Hernandez Enriquez
*/
public class ListaContactos implements ListaContactosDef{

	public Contacto[] contactos;
	public int maxContactos;
	public int noContactos;

	/**
	Constructor por default
	*/
	public ListaContactos(){
		this.contactos = new Contacto[0];
		this.maxContactos = 0;
		this.noContactos = 0;
	}
	/**
	Construtor por parametros
	@param Contacto[] Arreglo de contactos
	@param maxContacto Número maximo de contactos
	@param noContacto Número de contactos
	*/
	public ListaContactos(int tamanoAgenda){
		this.contactos = new Contacto[tamanoAgenda];
		for(int i=0; i<this.contactos.length; i++){
			Contacto c = new Contacto();
			this.contactos[i] = c;
		}
		this.maxContactos = tamanoAgenda;
		this.noContactos = 0;
	}
	/**
	Accesor para contactos
	@return Arreglo de los contactos de la lista
	*/
	public Contacto[] getContactos(){
		return this.contactos;
	}
	/**
	Mutador para contactos
	@param contactos Nuevo arreglo de contactos
	*/
	public void setContactos (Contacto[] contactos){
		this.contactos = contactos;
	}
	/**
	Accesor para número maximo de contactos
	@return maxContactos
	*/
	public int getMaxContactos(){
		return this.maxContactos;
	}
	/**
	Mutador para número de máximo de contactos
	@parama número Nuevo numero para maxContactos
	*/
	public void setMaxContactos(int setMaxContactos){
		this.maxContactos = maxContactos;
	}
	/**
	Accesor para número de contactos
	@return noContactos
	*/
	public int getNoContactos(){
		return this.noContactos;
	}
	/**
	Mutador para número de contactos
	@param número Nuevo número para noContactos
	*/
	public void setNoContactos(int noContactos){
		this.noContactos = noContactos;
	}

	/**
	Metodo para agregar un contacto a la lista
	@param Contacto a agregar
	@return la posición
	*/
	public int agregarContacto(Contacto nuevoContacto){
		int x = 0;
		if (this.noContactos < this.maxContactos){
			/**for(int i = 0; i<this.contactos.length; i++){
				if (this.contactos[i] == null){
					this.contactos[i] = nuevoContacto;
					this.noContactos++;
					x = i;
					break;
				}
			}*/
			this.contactos[this.noContactos] = nuevoContacto;
			this.noContactos++;
			x = this.noContactos;
		}
		else{ 
			x = -1;
		}
		return x;
	}

	/**
	Metodo para eliminicar un contacto de la lista
	@param posicion del contacto
	@return true si se borro, false que ya esta vacio
	*/
	public boolean eliminarContacto(int posicion){
		if (this.contactos[posicion] != null){
			for(int i = posicion; i < (this.contactos.length-1); i++){
				this.contactos[i] = this.contactos[i+1];
			}
			Contacto c = new Contacto();
			this.contactos[posicion] = c;
			this.noContactos--;
		 	return true;
		}
		else 
			return false;
	}

	/**
	Metodo para cambiar un contacto
	@param 	Contacto
	@param  Posicion
	@return true si fue cambiado, false si no
	*/
	public boolean cambiarContacto(Contacto nuevoContacto, int posicion){
		if (posicion <= this.contactos.length){
			this.contactos [posicion] = nuevoContacto;
			return true;
		}
		else
			return false;
	}

	/**
	Metodo para buscar un contacto
	@param String puede ser Nombre, Apellido, Email, foto del contacto
	@param int Número de celular del contacto a buscar
	@return Contacto que conincida con los paramentros
	*/	
	public Contacto[] buscar(String s, int bandera) throws WrongParameterException{
		if (bandera < 0 || bandera > 3){
			throw new WrongParameterException("Flag is not valid: " + bandera);
		}
		else{
			s = s.toLowerCase();
			Contacto[] listaBuscar = new Contacto[this.maxContactos];
			int ind = -1;
	
			for(int i = 0; i < this.noContactos; i++){
				switch (bandera){
					case POR_NOMBRE:
						String n = this.contactos[i].getNombre().toLowerCase();
						if (n.contains(s)){
							ind++;
							listaBuscar[ind] = this.contactos[i];
						}
						break;
					case POR_APELLIDO:
						n = this.contactos[i].getApellido().toLowerCase();
						if (n.contains(s)){
							ind++;
							listaBuscar[ind] = this.contactos[i];
						}
						break;
					case POR_CELULAR:
						n = String.valueOf(this.contactos[i].getCelular());
						if (n.equals(s)){
							ind++;
							listaBuscar[ind] = this.contactos[i];
						}
						break;
					case POR_EMAIL:
						n = this.contactos[i].getEmail().toLowerCase();
						if (n.contains(s)){
							ind++;
							listaBuscar[ind] = this.contactos[i];
						}
						break;						
				}
			}
			Contacto [] result = new Contacto[ind + 1];
			for (int i = 0; i <= ind; i++){
				result[i] = listaBuscar[i];
			}
		return result;
		}
	}

	public String buscarI(String s, int bandera) throws NullPointerException{
		if (bandera < 0 || bandera > 3){
			throw new NullPointerException();
		}
		else{
			s = s.toLowerCase();
			Contacto[] listaBuscar = new Contacto[this.maxContactos];
			int ind = -1;
	
			for(int i = 0; i < this.noContactos; i++){
				switch (bandera){
					case POR_NOMBRE:
						String n = this.contactos[i].getNombre().toLowerCase();
						if (n.contains(s)){
							ind++;
							listaBuscar[ind] = this.contactos[i];
						}
						break;
					case POR_APELLIDO:
						n = this.contactos[i].getApellido().toLowerCase();
						if (n.contains(s)){
							ind++;
							listaBuscar[ind] = this.contactos[i];
						}
						break;
					case POR_CELULAR:          
						n = String.valueOf(this.contactos[i].getCelular());
						if (n.equals(s)){
							ind++;
							listaBuscar[ind] = this.contactos[i];
						}
						break;
					case POR_EMAIL:
						n = this.contactos[i].getEmail().toLowerCase();
						if (n.contains(s)){
							ind++;
							listaBuscar[ind] = this.contactos[i];
						}
						break;						
				}
			}
			Contacto [] result = new Contacto[ind + 1];
			for (int i = 0; i <= ind; i++){
				result[i] = listaBuscar[i];
			}
			String q = "";
			for(int i = 0; i < result.length; i++){
			q += "\n" + result[i].imprimir();
			q += "\n______________________________";
		}
		return q;
		}
	}

	/**
	Metodo para buscar el cumpleaños de un contacto
	@param Calendar Fecha de nacimiento del contacto
	@return Contacto que coincida con la fecha
	*/
	public Contacto[] buscar(Calendar c){
		Contacto[] aux = new Contacto[this.maxContactos];
		int ind = -1;
		for(int i = 0; i < this.noContactos; i++){
			if (c.get(Calendar.DAY_OF_MONTH)== this.contactos[i].getFechaNac().get(Calendar.DAY_OF_MONTH) && c.get(Calendar.MONTH)==this.contactos[i].getFechaNac().get(Calendar.MONTH)){
				ind++;
				aux[ind] = this.contactos[i];
			}
		}
		Contacto [] result = new Contacto[ind + 1];
			for (int i = 0; i <= ind; i++){
				result[i] = aux[i];
			}
		return result;
		
	}
	public String buscarI(Calendar c){
		Contacto[] aux = new Contacto[this.maxContactos];
		int ind = -1;
		for(int i = 0; i < this.noContactos; i++){
			if (c.get(Calendar.DAY_OF_MONTH)== this.contactos[i].getFechaNac().get(Calendar.DAY_OF_MONTH) && c.get(Calendar.MONTH)==this.contactos[i].getFechaNac().get(Calendar.MONTH)){
				ind++;
				aux[ind] = this.contactos[i];
			}
		}
		Contacto [] result = new Contacto[ind + 1];
			for (int i = 0; i <= ind; i++){
				result[i] = aux[i];
			}
		String q = "";
			for(int i = 0; i < result.length; i++){
			q += "\n" + result[i].imprimir();
			q += "\n______________________________";}

		return q;
	}
	/**
	Metodo para ordernar los contacto por nombre, apellido, celular, email o fecha de nacmiento
	@param numero que indica cómo se va a order
	@return Arreglo de contactos ordenado
	*/
	public Contacto[] ordenar(int tipo) throws WrongParameterException{
		if (tipo < 0 || tipo > 4){
			throw new WrongParameterException("This flag is not valid: " + tipo);
		}
		else{
			Contacto[] aux = new Contacto[this.maxContactos];
			boolean swap;
			for(int i = 0; i<= this.noContactos; i++){
				for(int j = i+1; j < this.noContactos; j++){
					swap = false;
					switch(tipo){
						case POR_NOMBRE:
							if(this.contactos[i].getNombre().compareToIgnoreCase(this.contactos[j].getNombre()) > 0)
								swap = true;
							break;
						case POR_APELLIDO:
							if(this.contactos[i].getApellido().compareToIgnoreCase(this.contactos[j].getApellido()) > 0)
								swap = true;
							break;
						case POR_CELULAR:
							if(this.contactos[i].getCelular() > this.contactos[j].getCelular())
								swap = true;
							break;	
						case POR_EMAIL:
							if(this.contactos[i].getEmail().compareToIgnoreCase(this.contactos[j].getEmail()) > 0)
								swap = true;
							break;
						case POR_FECHANAC:
							if (this.contactos[i].getFechaNac().compareTo(this.contactos[j].getFechaNac()) == 0 )
								swap = true;
							break;
					}
					if(swap){
						Contacto aux2 = this.contactos[i];
						this.contactos[i] = this.contactos[j];
						this.contactos[j] = aux2;
					}
				}
			}
			Contacto [] result = new Contacto[this.noContactos];
			for(int i = 0; i < this.noContactos; i++){
				result[i] = this.contactos[i];
			}
		}
		return this.contactos;
	}


	/**
	Versión en texto del arrego de Contacto
	@return cadena de texto de lista de contactos
	*/
	public String imprimir(){
		String s = "";
		for(int i = 0; i <= (this.noContactos-1); i++){
			s += "\nCONTACTO no." + (i+1);
			s += "\n" + this.contactos[i].imprimir();
			s += "\n______________________________";
		}
		return s;
	}
	/**
	Metodo para buscar los contactos que cumplen años en el día actual
	@return Arreglo
	*/
	public Contacto[] listaCumple(){
		Contacto[] aux = new Contacto[this.maxContactos];
		for(int i = 0 ; i < this.noContactos; i++){
			Calendar fechaActual = Calendar.getInstance();
			if (this.contactos[i].getFechaNac().compareTo(fechaActual) == 0){
				aux[i] = this.contactos[i];
			}
		}
		return aux;
	}
	public String listaCumpleI(){
		Contacto[] aux = new Contacto[this.maxContactos];
		Calendar c = Calendar.getInstance();
		int ind = -1;
		for(int i = 0; i < this.noContactos; i++){
			if (c.get(Calendar.DAY_OF_MONTH)== this.contactos[i].getFechaNac().get(Calendar.DAY_OF_MONTH) && c.get(Calendar.MONTH)==this.contactos[i].getFechaNac().get(Calendar.MONTH)){
				ind++;
				aux[ind] = this.contactos[i];
			}
		}
		Contacto [] result = new Contacto[ind + 1];
			for (int i = 0; i <= ind; i++){
				result[i] = aux[i];
			}
		
		String q = "";
			for(int i = 0; i < result.length; i++){
			q += "\n" + result[i].imprimir();
			q += "\n______________________________";}

		return q;
	}

			
}