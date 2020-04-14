import java.lang.Object;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
Clase que modela un Contacto
@author Ma.Fernanda Hernandez Enriquez
*/
public class Contacto implements ContactoDef{
	
	public String nombre;
	public String apellido;
	public boolean sexo;
	public String sexo1;
	public Calendar fechaNac = Calendar.getInstance();
	public int celular;
	public String email;
	public String foto;

	public GrupoTag[] grupos;
	public int noGrupos;

	/**
	Constructor por default
	*/
	public Contacto(){
		this.nombre = "-";
		this.apellido = "-";
		this.fechaNac = new GregorianCalendar(1,1,1900);
		this.sexo = false;
		this.celular = 0;
		this.email = "-";
		this.foto = "-";
		this.grupos = new GrupoTag[1];
		this.noGrupos = 0;
	}

	/**
	Constructor con parametros
	@param nombre 		Nombre del contacto
	@param apellido 	Apellido del contacto
	@param sexo 		Sexo del contacto
	@param celular 		Número de celular del contacto
	@param email 		Email del contacto
	@param foto 		Foto del contacto
	*/
	public Contacto (String nombre, String apellido, boolean sexo, int celular, String email, String foto, Calendar fechaNac, int noGrupos)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		if (sexo == true){
			this.sexo1 = "Femenino";
		}
		else
			this.sexo1 = "Masculino";
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.email = email;
		this.foto = foto;
		this.grupos = new GrupoTag[noGrupos];
		this.noGrupos = 0;
	}

	/**
	Accesor para el nombre del contacto
	@return nombre 
	*/
	public String getNombre(){
		return this.nombre;
	}
	/**
	Mutador para el nombre del contacto
	@param nombre Nuevo nombre del contacto
	*/
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	/**
	Accesor para el apellido contacto
	@return apellido
	*/
	public String getApellido(){
		return this.apellido;
	}
	/**
	Mutador para el apellido del contacto
	@param apellido Nuevo apellido del contacto
	*/
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	/**
	Accesor para el sexo del contacto
	@return sexo
	*/
	public boolean getSexo(){
		return this.sexo;
	}
	/**
	Mutador para el sexo del contacto
	@param sexo Nuevo sexo del contacto
	*/
	public void setSexo(boolean sexo){
		this.sexo = sexo;
		if (sexo == true){
			this.sexo1 = "Femenino";
		}
		else
			this.sexo1 = "Masculino";
	}
	/**
	Accesor para la Fecha de nacimiento del contacto
	@return fecha
	*/
	public Calendar getFechaNac(){
		return this.fechaNac;
	}
	/**
	Mutador para la fecha de nacimiento del contacto
	@param fecha Nueva fecha de nacimiento del contacto
	*/
	public void setFechaNac(Calendar fechaNac){
		this.fechaNac = fechaNac;
	}
	/**
	Accesor para el número de celular del contacto
	@return celular
	*/
	public int getCelular(){
		return this.celular;
	}
	/**
	Mutador para el número de celular del contacto
	@param celular Nuevo numero de celular del contacto
	*/
	public void setCelular(int celular){
		this.celular = celular;
	}
	/**
	Accesor para el email del contacto
	@return email
	*/
	public String getEmail(){
		return this.email;
	}
	/**
	Mutador para el email del contacto
	@param email Nuevo email del contacto
	*/
	public void setEmail(String email){
		this.email = email;
	}
	/**
	Accesor para la foto del contacto
	@return foto
	*/
	public String getFoto(){
		return this.foto;
	}
	/**
	Mutador para la foto del contacto
	@param foto Nueva foto del contacto
	*/
	public void setFoto(String foto){
		this.foto = foto;
	}

	/**
	Version como cadena de texto del contacto
	@return contacto como texto
	*/
	public String imprimir(){
		String x = "Nombre: " + this.nombre;
		x += "\nApellido: " + this.apellido;
		x += "\nCelular: " + this.celular;
		x += "\nEmail: " + this.email;
		x += "\nSexo: " + this.sexo1;
		SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy");
		x += "\nCumpleanos: " + f.format(fechaNac.getTime());
		x += "\nFoto: " + this.foto;
		return x;
	}

	/**
	Metodo para saber si hoy es cumpleaños del contacto
	@return boolean true si es el cumpleaños del conacto, false si no lo es
	*/
	public boolean esCumple(){
		Calendar fechaActual = Calendar.getInstance();
		if ( fechaNac.compareTo(fechaActual) == 0 ){
			return true;
		}
		else
			return false;
	}

	/**
	Metodo para saber si este contacto es igual a otro
	@return true si los contactos son iguales, false si son diferentes
	*/
	public boolean esIgual(Contacto c){
		boolean x = false;
		if (this.nombre == c.getNombre()){
			if(this.apellido == c.getApellido()){
				if(this.celular == c.getCelular()){
					x = true;
				}
			}
		}
		else{
			x = false;
		}
		return x;
	}

	/**
	Accesor para GrupoTags
	@return Arreglo del GrupoTag
	*/
	public GrupoTag[] getGrupos(){
		return this.grupos;
	}

	/**
	Mutador para GrupoTags
	@param  Arreglo del GrupoTag
	*/
	public void setGrupos(GrupoTag[] grupos){
		this.grupos = grupos;
	}

	/**
	Metodo para agregar el contacto a un grupo
	@param GrupoTag
	@return boolean true para saber si se agrego, false para no
	*/
	public boolean agregarGrupo(Grupo nuevoGrupo){		
		if (this.noGrupos < this.grupos.length){
			this.grupos[this.noGrupos] = nuevoGrupo.getTag();
			this.noGrupos++;
			return true;
		}
		else{ 
			return false;
		}
	}

	/**
	Metodo para borrar el contacto de un grupo
	@param GrupoTag
	@return boolean true saber si se agrego, false para no
	*/
	public boolean eliminarGrupo(Grupo quitarGrupo){
		boolean x = false;
		GrupoTag grupoT = quitarGrupo.getTag();
		for (int i = 0; i < this.noGrupos; i++){
			if (this.grupos[i].equals(grupoT)){
				this.grupos[i] = this.grupos [this.noGrupos];
				this.noGrupos--;
				x = true;
				break;
			}
			else{ 
				x = false;
			}
		}
		return x;
	}

	/**
	Metodo para saber si el contacto pertence a un grupo
	@param GrupoTag
	@return boolean true si esta en ese grupo, false no esta
	*/
	public boolean perteneceAlGrupo(Grupo otroGrupo){
		boolean x = false;
		for (int i = 0; i < this.noGrupos; i++){
			if (this.grupos[i].equals(otroGrupo.getTag())){
				x = true;
				break;
			}
			else{
				x = false;
			}
		}
		return x;
	}

	/**
	Metodo para saber que grupos comparten dos contactos
	@param otro contacto
	@return Arreglo GrupoTag
	*/
	public GrupoTag[] interseccion(Contacto otroContacto){
		GrupoTag[] gruposCompartidos = new GrupoTag[this.grupos.length];
		int x = 0;
		for (int i = 0; i < this.noGrupos; i++){
			for(int j = 0; j < otroContacto.getNoGrupos();j++){
				if(this.grupos[i].equals(otroContacto.getGrupos()[j])){
					gruposCompartidos[x]= this.grupos[i];
					x++;
					continue;
				}
			}
		}
		GrupoTag[] result = new GrupoTag[x];
		for(int i = 0; i < x; i++){
			result[i] = gruposCompartidos[i];
		}

		return result;
	}

	/**
	Metodo para saber en cuantos grupos esta incluido el contacto
	@return int Numero total de grupos
	*/
	public int getNoGrupos(){
		return this.noGrupos;
	}

	/**
	Metodo convertir FechaNac a cadena de texto
	@return String
	*/
	public String imprimirFechaNac(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		return sdf.format(this.fechaNac.getTime());
	}

	/**
	Metodo para imprimir contactos en una interfaz graficas
	@param x Entero de la posicion x
	@param y Entero de la posicion y
	@param w Entero para el largo
	@param h Entero para el alto
	*/
	public JPanel imprimirGUI(int x, int y, int w, int h, Grupo[] gr){
		int x1, y1, w1, h1;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(209,141,178));
		panel.setBounds(x,y,w,h);

		JLabel nombre = new JLabel("Nombre: " + this.nombre + " " +this.apellido);
		nombre.setForeground(new Color(255,255,255));
		nombre.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		x1 = (int)Math.round(w*.01);
		y1 = (int)Math.round(h*.01);
		w1 = (int)Math.round(w*.5);
		h1 = (int)Math.round(h*.49);
		nombre.setBounds(x1,y1,w1,h1);
		panel.add(nombre);

		JLabel celular = new JLabel("Telefono: " + this.celular+"");
		celular.setForeground(new Color(255,255,255));
		celular.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		x1 = (int)Math.round(w*.50);
		y1 = (int)Math.round(h*.01);
		w1 = (int)Math.round(w*.4);
		h1 = (int)Math.round(h*.49);
		celular.setBounds(x1,y1,w1,h1);
		panel.add(celular);

		JLabel sexo = new JLabel("("+ this.sexo1 + ")");
		sexo.setForeground(new Color(255,255,255));
		sexo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		x1 = (int)Math.round(w*.80);
		y1 = (int)Math.round(h*.01);
		w1 = (int)Math.round(w*.30);
		h1 = (int)Math.round(h*.49);
		sexo.setBounds(x1,y1,w1,h1);
		panel.add(sexo);

		JLabel email = new JLabel("Email: " + this.email);
		email.setForeground(new Color(255,255,255));
		email.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		x1 = (int)Math.round(w*.01);
		y1 = (int)Math.round(h*.45);
		w1 = (int)Math.round(w*.40);
		h1 = (int)Math.round(h*.49);
		email.setBounds(x1,y1,w1,h1);
		panel.add(email);

		String g = "Grupos: ";	
		for(int j = 0; j< gr.length; j++){
			if (this.perteneceAlGrupo(gr[j]))
					g += gr[j].getNombre() + ", ";
		}
		JLabel grupos = new JLabel(g);
		grupos.setForeground(new Color(255,255,255));
		grupos.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		x1 = (int)Math.round(w*.80);
		y1 = (int)Math.round(h*.45);
		w1 = (int)Math.round(w*.30);
		h1 = (int)Math.round(h*.49);
		grupos.setBounds(x1,y1,w1,h1);
		panel.add(grupos);


		JLabel fechaNac = new JLabel("Cumple: " + this.imprimirFechaNac());
		fechaNac.setForeground(new Color(255,255,255));
		fechaNac.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		x1 = (int)Math.round(w*.50);
		y1 = (int)Math.round(h*.45);
		w1 = (int)Math.round(w*.50);
		h1 = (int)Math.round(h*.49);
		fechaNac.setBounds(x1,y1,w1,h1);
		panel.add(fechaNac);

		JLabel separar = new JLabel("<html><br>________________________________________________________________________________________________<br></html>");
		separar.setForeground(new Color(241,195,208));
		separar.setFont(new Font("Times New Roman", Font.BOLD,12));
		x1 = (int)Math.round(w*.0);
		y1 = (int)Math.round(h*.50);
		w1 = (int)Math.round(w*1);
		h1 = (int)Math.round(h*.49);
		separar.setBounds(x1,y1,w1,h1);
		panel.add(separar);


		return panel;
	}
}