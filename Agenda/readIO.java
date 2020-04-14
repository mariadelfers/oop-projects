import java.util.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.io.*;

public class readIO{

	public readIO(){
		
	}

	public ListaContactos crearListaContactos(String url, Grupo[] g){
		Charset charset = Charset.forName("US-ASCII");
		Path file = FileSystems.getDefault().getPath(url);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
				int n = Integer.parseInt(reader.readLine());
				System.out.println("Attempt to read " + n + " contacts");
				ListaContactos res = new ListaContactos();
    			String line = null;
				String[] arr, arr2;
				Contacto c;
				for(int i = 0; i < n; i++){
					line = reader.readLine();
					arr = line.split(",");
					c = new Contacto();
					c.setNombre(arr[0]);
					c.setApellido(arr[1]);
					c.setSexo(false);/////////
					c.setEmail(arr[3]);
					c.setCelular(Integer.parseInt(arr[4]));
					arr2 = arr[5].split("-");
					c.setFechaNac(new GregorianCalendar(Integer.parseInt(arr2[2]),Integer.parseInt(arr2[1]),Integer.parseInt(arr2[0])));
					c.setFoto(arr[6]);
					arr2 = arr[7].split("-");
					for(int k = 0; k < arr2.length; k++){
						for(int j = 0; j < g.length; j++){
							if(g[j].getTag().getId() == Integer.parseInt(arr2[k])){
								if(c.agregarGrupo(g[j]))
									System.out.println("Se agrega al contacto el grupo con tag " + g[j].getTag().getId());
							}
						}
					}
					System.out.println("El contacto tiene ahora " + c.getNoGrupos() + " grupos");
					res.agregarContacto(c);
					System.out.println((i+1) + " contacts added");
				}
				return res;
		} catch (Exception x) {
    			System.out.println("ERROR: " + x.getMessage());
				return null;
		}
	}
	
	public Grupo[] crearGrupos(String url){
		Charset charset = Charset.forName("US-ASCII");
		Path file = FileSystems.getDefault().getPath(url);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
				int n = Integer.parseInt(reader.readLine());
				System.out.println("Attempt to read " + n + " groups");
				Grupo[] res = new Grupo[n];
    			String line = null;
				String[] arr;
				Grupo g;
				GrupoTag tg;
				for(int i = 0; i < n; i++){
					line = reader.readLine();
					arr = line.split(",");
					tg = new GrupoTag(Integer.parseInt(arr[1]));
					g = new Grupo();//////////
					res[i] = g;
					System.out.println((i+1) + " groups added: " + g.imprimir());
				}
				return res;
		} catch (Exception x) {
    			System.out.println("ERROR: " + x.getMessage());
				return null;
		}
	}
	
	public Grupo[] actualizarGrupos(ListaContactos ls, Grupo[] g){
		Contacto[] c = ls.getContactos();
		for(int i = 0; i < g.length; i++){			
			for(int j = 0; j < ls.getNoContactos(); j++){
				if(c[j].perteneceAlGrupo(g[i]))
						g[i].agregar(1);
			}
		}
		return g;
	}

}