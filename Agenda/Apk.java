import java.util.*;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Apk{
	public static Scanner x;
	public static void main (String[] args){
		x = new Scanner (System.in);
		
		Calendar fechaActual = Calendar.getInstance();
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(1997, 6, 2);
		Calendar fecha2 = Calendar.getInstance();
		fecha2.set(2000, 6, 2);

		ListaContactos agenda = new ListaContactos(3);
		Contacto a = new Contacto( "Fernanda", "Hernandez", true, 3, "fer.peace97@gmail.com", "foto", fechaActual,1);
		Contacto b = new Contacto("Fabian", "Lima", true, 2, "A013293@hotmai.com", "fotos", fecha2,1);
		Contacto c = new Contacto("Jorge", "Marroquin", false, 23, "jfehr@live.com.mx", "foto34", fecha1,1);
		Contacto d = new Contacto("Ricardo", "Reyes", false, 3, "jdfhe@hotmail.com", "imagen", fechaActual,1);
		agenda.agregarContacto(a);
		agenda.agregarContacto(b);
		agenda.agregarContacto(c);
		System.out.println("##############1###############");
		System.out.println(agenda.imprimir());
		System.out.println("##############################");
		agenda.eliminarContacto(1);
		System.out.println("##############2###############");
		System.out.println(agenda.imprimir());
		System.out.println("##############################");
		agenda.cambiarContacto(d, 1);
		System.out.println("##############3###############");
		System.out.println(agenda.imprimir());
		System.out.println("##############################");
		agenda.agregarContacto(b);
		System.out.println("##############4###############");
		System.out.println(agenda.imprimir());
		System.out.println("##############################");
		/*POR_NOMBRE = 0;
		POR_APELLIDO = 1;
		POR_CELULAR = 2;
		POR_EMAIL = 3;
		POR_FECHANAC = 4;*/
		//System.out.println("BUSCAR_fer");
		//System.out.println(agenda.buscarI("fer", 0));
		System.out.println("BUSCAR_FECHA_CUMPLEAÑOS");
		System.out.println(agenda.buscarI(fechaActual));
		System.out.println("ORDERNAR_");
		//agenda.ordenar(2);
		System.out.println(agenda.imprimir());
		System.out.println("LISTA_CUMPLE");
		System.out.println(agenda.listaCumpleI());
		System.out.println("BUSCAR_");
		System.out.println("Escirbe lo que quieres buscar");
		String f = x.nextLine();
		System.out.println(agenda.buscarI(f, 2));

	}
}