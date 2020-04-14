import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.net.URL;
import java.lang.Exception;
/**
Clase Agenda que modela una agenda
@author Ma. Fernanda Hernandez Enriquez 
*/
public class Agenda{

	ListaContactos lc;
	Grupo[] g;
	JFrame f;
	
	public String palabra;
	
	public JTextField searchText;
	JComboBox<String> options;
	JComboBox<String> optionss;

	public JPanel panelG;
	public JPanel panel3;
	public JPanel topPanel;
	public JPanel toolsPanel;
	public JPanel panelBuscar;
	public JPanel lista;

	public JButton buscar;
	public JButton ordenarPor;
	public JButton addCon;
	public JButton deleteCon;
	public JButton editarCon;

	public JButton grupo1;
	public JButton grupo2;
	public JButton grupo3;

	/**
	Constructor sin parametros
	@return Frame la pantalla de la agenda
	*/
	public Agenda(){
		/*readIO read = new readIO();
		g = read.crearGrupos("groups.txt");
		lc = read.crearListaContactos("contacts.txt",g);        
		g = read.actualizarGrupos(lc,g);*/
        this.palabra = "Buscar";
		g = new Grupo[3];
		Calendar fechaActual = Calendar.getInstance();
		lc = new ListaContactos(5);


		f = new JFrame("Agenda de contactos v1.0");
		f.setSize(800,600); //tamaño ventana
		f.setResizable(false); //Para que el usuario no mueva el tamaño de la ventana
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//TOP PANEL
		topPanel = new JPanel();
		topPanel.setBounds(0,0,800,50); //posx- posy- largo- ancho
		topPanel.setBackground(new Color(81,192,191));
		topPanel.setLayout(null);
		f.getContentPane().add(topPanel); 

		/*String path = "C:/Users/Hippie/Desktop/PO/TercerParcial/Agenda/Icono.png";  
		URL url = this.getClass().getResource(path);  
		ImageIcon icon = new ImageIcon(url); 
		//ImageIcon icon = new ImageIcon(getClass().getResource(""));
		JLabel figura = new JLabel();
		figura.setIcon(icon);
		figura.setBounds(0,0,50,50);
		topPanel.add(figura);*/	

		JLabel titulo = new JLabel("AGENDA DE CONTACTOS");
		titulo.setBounds(10,5,800,50);
		titulo.setForeground(new Color(255,255,255));
		titulo.setFont(new Font("Comic Sans Ms", Font.BOLD, 24));
		topPanel.add(titulo);

		//TOOLS PANEL
		toolsPanel = new JPanel();
		f.setLayout(null);
		toolsPanel.setBounds(0,50,200,300);
		toolsPanel.setBackground(new Color(112,149,225));
		toolsPanel.setLayout(null); //para que setBounds funcione
		f.getContentPane().add(toolsPanel);

		JLabel herramientas = new JLabel("Herramientas");
		herramientas.setLayout(null);
		herramientas.setBounds(10,8,200,20);
		herramientas.setForeground(new Color (255,255,255));
		herramientas.setFont(new Font("Comic Sans Ms", Font.ITALIC, 20));
		toolsPanel.add(herramientas);
		JLabel linea1 = new JLabel("______________________");
		linea1.setLayout(null);
		linea1.setBounds(10,12,200,30);
		linea1.setForeground(new Color(255,255,255));
		linea1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		toolsPanel.add(linea1);

		searchText = new JTextField(20);
		//this.palabra = searchText.getText(); 
		searchText.setLayout(null);
		searchText.setBounds(10,45,170,25);
		toolsPanel.add(searchText);
		
		JLabel buscarPor = new JLabel("Buscar por: ");
		buscarPor.setLayout(null);
		buscarPor.setBounds(10,70,200,50);
		buscarPor.setForeground(new Color(255,255,255));
		buscarPor.setFont(new Font("Arial", Font.PLAIN,15));
		toolsPanel.add(buscarPor);
		final String[] opt = { "Nombre", "Apellido", "Celular","Email","Fecha nacimiento"};
		options = new JComboBox<String>(opt);
		options.setLayout(null);
		options.setBounds(10,110,150,25);
		toolsPanel.add(options);

		JButton buscar = new JButton("Buscar");
		buscar.setLayout(null);
		buscar.setBounds(10,140,100,25); 
		buscar.setActionCommand("Search");
		buscar.addActionListener(new ButtonListener());
		toolsPanel.add(buscar);

		JLabel ordenarPor = new JLabel("Ordenar por: ");
		ordenarPor.setLayout(null);
		ordenarPor.setBounds(10,160,200,50);
		ordenarPor.setForeground(new Color(255,255,255));
		ordenarPor.setFont(new Font("Arial", Font.PLAIN,15));
		toolsPanel.add(ordenarPor);
		final String[] optt = { "Nombre", "Apellido", "Celular","Email","Fecha nacimiento"};
		optionss = new JComboBox<String>(optt);
		optionss.setLayout(null);
		optionss.setBounds(10,200,150,25);
		toolsPanel.add(optionss);

		JButton sort = new JButton("Ordenar");
		sort.setLayout(null);
		sort.setBounds(10,230,100,25);
		sort.setActionCommand("sort");
		sort.addActionListener(new ButtonListener());
		toolsPanel.add(sort);

		
		//GRUPOS PANEL
		panelG = new JPanel();
		f.setLayout(null);	
		panelG.setBounds(0,350,200,250);
		panelG.setBackground(new Color(159,163,227));
		panelG.setLayout(null);
		f.getContentPane().add(panelG);

		JLabel label2 = new JLabel("<html>Grupos<br>______________</html>");
		label2.setBounds(10,10,200,50);
		label2.setForeground(new Color(255,255,255));
		label2.setLayout(null);
		label2.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		panelG.add(label2);

		grupo1 = new JButton("Grupo1");
		grupo1.setLayout(null);
		grupo1.setBounds(10,70,100,25); 
		grupo1.setActionCommand("g1");
		grupo1.addActionListener(new ButtonListener());
		panelG.add(grupo1);

		grupo2 = new JButton("Grupo2");
		grupo2.setLayout(null);
		grupo2.setBounds(10,100,100,25); 
		grupo2.setActionCommand("g2");
		grupo2.addActionListener(new ButtonListener());
		panelG.add(grupo2); 

		grupo3 = new JButton("Grupo3");
		grupo3.setLayout(null);
		grupo3.setBounds(10,130,100,25); 
		grupo3.setActionCommand("g3");
		grupo3.addActionListener(new ButtonListener());
		panelG.add(grupo3);

		//LISTACONTACTOS PANEL
		lista = new JPanel();
		lista.setLayout(null);
		lista.setBounds(200,50, 600,50);
		lista.setBackground(new Color(201,147,212));
		f.getContentPane().add(lista);

		JLabel label3 = new JLabel("Lista de contactos");
		label3.setBounds(40,10,200,25);
		label3.setForeground(new Color(255,255,255));
		label3.setFont(new Font("Comic Sans Ms", Font.BOLD, 22));
		lista.add(label3);

		addCon = new JButton("Agregar");
		addCon.setLayout(null);
		addCon.setBounds(280,15,100,25);
		addCon.setActionCommand("agregarContacto");
		addCon.addActionListener(new ButtonListener());
		lista.add(addCon);

		deleteCon = new JButton("Eliminar");
		deleteCon.setLayout(null);
		deleteCon.setBounds(380,15,100,25);
		deleteCon.setActionCommand("eliminarContacto");
		deleteCon.addActionListener(new ButtonListener());
		lista.add(deleteCon);

		editarCon = new JButton("Editar");
		editarCon.setLayout(null);
		editarCon.setBounds(480,15,100,25);
		editarCon.setActionCommand("editarContacto");
		editarCon.addActionListener(new ButtonListener());
		lista.add(editarCon);

		panel3 = new JPanel();
		panel3.setBounds(200,90,600,495);
		panel3.setBackground(new Color(241,195,208));
		panel3.setLayout(null); 	
		panel3 = imprimirContactos(panel3, lc.getContactos(),lc.getNoContactos());
		f.getContentPane().add(panel3);


		/*JPanel panelBuscar = new JPanel();
		panelBuscar.setBounds(200,600,600,100);
		panelBuscar.setLayout(null);
		panelBuscar = imprimirContactos(panel3,lc.buscar("fer",1),lc.getNoContactos());*/

		f.setVisible(true);
	}

	/**
	Metodo que imprimer un array de contactos en GUI
	@param JPanel panel de cada contacto
	@param Contacto[]	arreglo de contactos
	@param int noContactos 	el número de contactos totales a imprimir
	*/
	public JPanel imprimirContactos(JPanel parent, Contacto[] c, int noContactos){
		int x = 10;
		int y = 30;
		int width = parent.getWidth()-25;
		int height = 60;
		for(int i = 0; i < c.length; i++){
			JPanel aux = c[i].imprimirGUI(x,y,width,height,g);
			y += height;
			parent.add(aux);
		}
		return parent;
	}

	public static void main (String[] args){
		Agenda agenda = new Agenda();
	}

	/**
	Metodo que invoca la clase ButtonListener
	Para asignarle funciones a los botones de la agenda
	*/
	public class ButtonListener implements ActionListener{
 		public void actionPerformed(ActionEvent e){
			
			Contacto[] aux = new Contacto[lc.getNoContactos()];
			String cmd = e.getActionCommand();
			if (cmd.equals("Search")){
				String palabra = searchText.getText();
				String bandera = options.getSelectedItem().toString();
				String x ="Buscar: "+palabra;
				x+="\nPor: "+bandera;
				JOptionPane.showMessageDialog(f,x);
				if (bandera == "Nombre"){
					try{
						aux = lc.buscar(palabra,0);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux,lc.getNoContactos());
						panel3.updateUI();
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f, "No hay coincidencias");	
					}
				}
				else if(bandera == "Apellido"){
					try{
						aux = lc.buscar(palabra,1);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux,lc.getNoContactos());
						panel3.updateUI();
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f,"No hay coincidencias");
					}
				}
				else if(bandera.equals("Celular")){
					try{
						aux = lc.buscar(palabra,3);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux,lc.getNoContactos());
						panel3.updateUI();
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f,"No hay coincidencias");
					}
				}
				else if(bandera == "Email"){
					try{
						aux = lc.buscar(palabra,3);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux,lc.getNoContactos());
						panel3.updateUI();
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f,"No hay coincidencias");
					}
				}
				else if(bandera == "Fecha nacimiento"){
					try{
						aux = lc.buscar(palabra,4);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux, lc.getNoContactos());
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f,"No hay coincidencias");
					}
				}
				else
					JOptionPane.showMessageDialog(f,"Opción no válida"); 

			
			}
			if(cmd.equals("sort")){
				String bandera = optionss.getSelectedItem().toString();
				String x ="Ordenar por: " + bandera;
				JOptionPane.showMessageDialog(f,x);
				if (bandera == "Nombre"){
					try{
						aux = lc.ordenar(0);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux,lc.getNoContactos());
						panel3.updateUI();
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f, "No hay conincidencias");	
					}
				}
				else if(bandera == "Apellido"){
					try{
						aux = lc.ordenar(1);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux,lc.getNoContactos());
						panel3.updateUI();
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f,"No hay conincidencias");
					}
				}
				else if(bandera.equals("Celular")){
					try{
						aux = lc.ordenar(2);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux,lc.getNoContactos());
						panel3.updateUI();
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f,"No hay conincidencias");
					}
				}
				else if(bandera == "Email"){
					try{
						aux = lc.ordenar(3);
						panel3.removeAll();
						panel3 = imprimirContactos(panel3, aux,lc.getNoContactos());
						panel3.updateUI();
					}
					catch(WrongParameterException wpe){
						JOptionPane.showMessageDialog(f,"No hay conincidencias");
					}
				}
				else
					JOptionPane.showMessageDialog(f,"Opción no válida");
			}
			if(cmd.equals("agregarContacto")){
					boolean sexo  = false;
  					String nombre = JOptionPane.showInputDialog("Nombre: ");
  					String apellido = JOptionPane.showInputDialog("Apellido: ");
  					String sexo1 = JOptionPane.showInputDialog("Sexo Femenino(F)/Masculino(M): ");
  					sexo1.toLowerCase();
  					if (sexo1 == "f"){
  						sexo = true;
  					}
  					else 
  						sexo = false;

	  				String cel = JOptionPane.showInputDialog("Celular: ");
	  				int celular = Integer.parseInt(cel); 
	  				String email = JOptionPane.showInputDialog("Email: ");
	  				String foto = "foto";
					Calendar fechaUsuario = Calendar.getInstance();
					//fechaUsuario = JOptionPane.showInputDialog("Fecha de nacimiento: ");
					Contacto c = new Contacto(nombre,apellido,sexo,celular,email,foto,fechaUsuario,1);
					lc.agregarContacto(c);

					/**int x = lc.getNoContactos()+1;
					Contacto[] agr = lc.getContactos();
					Contacto [] result = new Contacto[x];
						for (int i = 0; i <= x ; i++){
							result[i] = agr[i];
						}
					Contacto[] salvacion = 
					for(int i = 0; i<=result.length; i++){
					if (result[i] == null){
						[i] = nuevoContacto;
						break;
					}

					for(int i=0;i<array.length;i++){ 
						if (array[i]!=null) 
							{ 
								System.out.println(array[i]);*/
		
					panel3.removeAll();
					panel3 = imprimirContactos(panel3, lc.getContactos(),lc.getNoContactos());
					panel3.updateUI();
			
			}
			if(cmd.equals("eliminarContacto")){
					String num = JOptionPane.showInputDialog("Posicion del contacto: ");
					int posi = Integer.parseInt(num);
					posi = posi - 1;
					lc.eliminarContacto(posi);

					/*int x = lc.getNoContactos()-1;
					Contacto[] eli = lc.getContactos();
					Contacto [] result = new Contacto[x];
						for (int i = 0; i <= x ; i++){
							result[i] = eli[i];
						}*/

					panel3.removeAll();
					panel3 = imprimirContactos(panel3, lc.getContactos(), lc.getNoContactos());
					panel3.updateUI();
			}
			if(cmd.equals("editarContacto")){
					boolean sexo  = false;
  					String posicion = JOptionPane.showInputDialog("Posicion del contacto: ");
  					int pos = Integer.parseInt(posicion);
  					pos =  pos - 1;
  					String nombre = JOptionPane.showInputDialog("Nombre: ");
  					String apellido = JOptionPane.showInputDialog("Apellido: ");
  					String sexo1 = JOptionPane.showInputDialog("Sexo Femenino(F)/Masculino(M): ");
  					sexo1.toLowerCase();
  					if (sexo1 == "f"){
  						sexo = true;
  					}
  					else 
  						sexo = false;

	  				String cel = JOptionPane.showInputDialog("Celular: ");
	  				int celular = Integer.parseInt(cel); 
	  				String email = JOptionPane.showInputDialog("Email: ");
	  				String foto = "foto";
					Calendar fechaUsuario = Calendar.getInstance();
					//fechaUsuario = JOptionPane.showInputDialog("Fecha de nacimiento: ");
					Contacto c = new Contacto(nombre,apellido,sexo,celular,email,foto,fechaUsuario,1);
					lc.cambiarContacto(c,pos);
					panel3.removeAll();
					panel3 = imprimirContactos(panel3, lc.getContactos(),lc.getNoContactos());
					panel3.updateUI();
			}
			if(cmd.equals("g1")){
				JOptionPane.showMessageDialog(f,"Contactos del grupo: ");
			}
			if(cmd.equals("g2")){
				JOptionPane.showMessageDialog(f,"Contactos del grupo: ");
			}
			if(cmd.equals("g3")){
				JOptionPane.showMessageDialog(f,"Contactos del grupo: ");
			}
		}
	}

}