public class Apk1{
	public static void main(String[] args){
		ListaContactos 1 = new ListaContactos();
		try{
			1.buscar("Juan", -1);	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}