import java.util.*;

public interface ContactoDef{

	public String getNombre();

	public void setNombre(String s);

	public String getApellido();

	public void setApellido(String s);

	public boolean getSexo();

	public void setSexo(boolean b);

	public Calendar getFechaNac();

	public void setFechaNac(Calendar d);

	public int getCelular();

	public void setCelular(int i);

	public String getEmail();

	public void setEmail(String s);

	public String getFoto();

	public void setFoto(String s);

	public boolean esCumple();

	public String imprimir();

	public boolean esIgual(Contacto c);
	
	public boolean perteneceAlGrupo(Grupo g);

}