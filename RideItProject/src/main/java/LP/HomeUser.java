package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LD.clsBicicleta;
import LN.gestorLN;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeUser extends JFrame {

	private JPanel contentPane;
	
	protected DefaultListModel<clsBicicleta> modelo1;
	private JList <clsBicicleta> jListaBicis;
	private ArrayList <clsBicicleta> lista;
	
	/**
	 * Create the frame.
	 */
	public HomeUser(String usuario) {
		
		gestorLN.altaBicicleta(7, "Rojo", "Standard", "Boulevard");
		gestorLN.altaBicicleta(5, "Amarillo", "Tandem", "Plaza gipuzkoa");
		gestorLN.altaBicicleta(6, "Azul", "Mountain", "Monte Ulia");
		gestorLN.altaUsuario("IGNACIO", "SAEZ", "7255296T", "igna", "aaaa2");
		gestorLN.altaUsuario("Martin", "Odegaard", "21212121R", "martin", "134a2");
		
		final String dni = gestorLN.getUsuario(usuario).getDni();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido "+usuario);
		lblBienvenido.setBounds(10, 11, 162, 14);
		contentPane.add(lblBienvenido);
		
		if(gestorLN.estadoUser(dni)) 
		{
			devolver(dni);
			
		}else {
			alquilar(dni);
		}
		
	}
	
	public void alquilar(final String dni) 
	{
		lista=new ArrayList<clsBicicleta>();
		lista=gestorLN.bicisDisp();
		
		modelo1= new DefaultListModel<clsBicicleta>();
		jListaBicis= new JList<clsBicicleta>();
		
		jListaBicis= new JList<clsBicicleta>(modelo1);
		jListaBicis.setBounds(230, 26, 177, 202);
		contentPane.add(jListaBicis);
		
		for(clsBicicleta b: lista) {
			modelo1.addElement(b);
		}
		
		
		
		JButton btnAlquilarBicicleta = new JButton("Alquilar bicicleta");
		btnAlquilarBicicleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gestorLN.altaAlquiler(jListaBicis.getSelectedValue().getBici_id(), dni);
				JOptionPane.showMessageDialog(null, "Bicicleta alquilada con éxito.");
				dispose();
				
				//CUANDO SE HAGA CON ESTACIONES HABRÁ QUE USAR METODO COGERBICI PARA QUE AFECTE A ESTACIONES
			}
		});
		btnAlquilarBicicleta.setBounds(289, 239, 89, 23);
		contentPane.add(btnAlquilarBicicleta);
	}
	
	public void devolver(final String dni) 
	{
		
		JLabel lblDev = new JLabel("Tienes una bicicleta pendiente de devolver");
		lblDev.setBounds(10, 40, 400, 14);
		contentPane.add(lblDev);
		
		JButton btnDevolver = new JButton("Devolver bicicleta");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int duracion = gestorLN.dejarBici(dni);
				
				double precio = duracion*0.20;
				
				JOptionPane.showMessageDialog(null, "El alquiler ha durado: "+duracion+" minutos. El precio resultante es de: "+
				precio+" €.");
				
				dispose();
				//CUANDO SE HAGA CON ESTACIONES HABRÁ QUE USAR METODO COGERBICI PARA QUE AFECTE A ESTACIONES
			}
		});
		btnDevolver.setBounds(289, 200, 89, 23);
		contentPane.add(btnDevolver);
	}
}
