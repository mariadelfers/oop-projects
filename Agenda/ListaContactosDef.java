import java.util.Calendar;
import java.util.*;
public interface ListaContactosDef{

	public static final int POR_NOMBRE = 0;
	public static final int POR_APELLIDO = 1;
	public static final int POR_CELULAR = 2;
	public static final int POR_EMAIL = 3;
	public static final int POR_FECHANAC = 4;

	public Contacto[] getContactos();

	public void setContactos(Contacto[] c);

	public int getMaxContactos();

	public int agregarContacto(Contacto c) throws DuplicatedContactException;

	public boolean eliminarContacto(int pos);

	public boolean cambiarContacto(Contacto c, int pos);

	public int getNoContactos();

	public Contacto[] buscar(String s, int f) throws WrongParameterException;

	public Contacto[] buscar(Calendar d);

	public Contacto[] ordenar(int f) throws WrongParameterException;

	public String imprimir();

	public Contacto[] listaCumple();

}