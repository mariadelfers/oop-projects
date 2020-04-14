import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Agenda1{
    
    ListaContactos lc;
    Grupo[] g;
    JFrame f;
    
    public Agenda1(){
		readIO read = new readIO();
		g = read.crearGrupos("groups.txt");
		lc = read.crearListaContactos("contacts.txt",g);        
		g = read.actualizarGrupos(lc,g);
        
        f = new JFrame("Agenda de contactos v1.0");
        f.setSize(800,600);
        f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topPanel = new JPanel();
        f.setLayout(null);
		topPanel.setBounds(0,0,800,75);
		topPanel.setBackground(new Color(58,36,3));
		topPanel.setLayout(null);
		f.getContentPane().add(topPanel);
		
		final String[] opt = { "Nombre", "Apellido", "Celular","Email","Fecha nacimiento"};

		JComboBox<String> options = new JComboBox<String>(opt);
		options.setBounds(10,25,120,25);
		topPanel.add(options);
		
		JTextField searchText = new JTextField();
		searchText.setBounds(140,25,350,25);
		topPanel.add(searchText);
		
		JButton search = new JButton("Buscar");
		search.setBounds(500,25,90,25);
		search.setActionCommand("search");
		search.addActionListener(new ButtonListener());
		topPanel.add(search);
		
		JButton sort = new JButton("Ordenar");
		sort.setBounds(600,25,90,25);
		sort.setActionCommand("sort");
		sort.addActionListener(new ButtonListener());
		topPanel.add(sort);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0,75,550,725);
		leftPanel.setBackground(new Color(255,255,179));
		leftPanel.setLayout(null);
		f.getContentPane().add(leftPanel);
		
		JLabel title1 = new JLabel("Lista de contactos:");
		title1.setBounds(10,10,150,20);
		leftPanel.add(title1);
        
        JPanel rightPanel = new JPanel();
		rightPanel.setBounds(550,75,250,725);
		rightPanel.setBackground(new Color(204,255,230));
		rightPanel.setLayout(null);
		f.getContentPane().add(rightPanel); 

		JLabel title2 = new JLabel("Grupos:");
		title2.setBounds(10,10,100,20);
		rightPanel.add(title2);		
        
        f.setVisible(true);
    }
    
    public static void main(String[] args){
        Agenda agenda = new Agenda();
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String cmd = e.getActionCommand();
            if(cmd.equals("search")){
                JOptionPane.showMessageDialog(f,"Busqueda");
            }
			if(cmd.equals("sort")){
                JOptionPane.showMessageDialog(f,"Ordenamiento");
            }
        }
    }
}