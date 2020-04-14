public interface GrupoDef{

	public void setNombre(String s);

	public String getNombre();

	public void setTag(GrupoTag gt);

	public GrupoTag getTag();

	public int getActual();

	public String imprimir();

	public int agregar(int n);

	public int eliminar(int n);
	
	public Contacto[] filtrar(Contacto[] c);
	
	public boolean esIgual(Grupo g);

	public int compararCon(Grupo g);

}