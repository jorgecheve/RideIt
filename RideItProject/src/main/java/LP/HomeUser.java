package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LD.clsBicicleta;
import LD.clsEstacion;
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
	protected DefaultListModel<clsEstacion> modelo2;
	private JList <clsBicicleta> jListaBicis;
	private JList <clsEstacion> jListaEstaciones;
	private ArrayList <clsBicicleta> lista;
	private ArrayList <clsEstacion> listaEst;
	
	/**
	 * Create the frame.
	 */
	public HomeUser(String usuario) {
		
		
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
		
		JButton historial = new JButton("Mi historial");
		historial.setBounds(299, 10, 110, 23);
		contentPane.add(historial);
		historial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					UserHistory frame = new UserHistory(dni);
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
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
		//lista=gestorLN.bicisDisp();
		
		
		modelo1= new DefaultListModel<clsBicicleta>();
		jListaBicis= new JList<clsBicicleta>();
		
		jListaBicis= new JList<clsBicicleta>(modelo1);
		jListaBicis.setBounds(230, 46, 177, 182);
		contentPane.add(jListaBicis);
		
		modelo2=new DefaultListModel<clsEstacion>();
		jListaEstaciones=new JList<clsEstacion>(modelo2);
		jListaEstaciones.setBounds(20, 46, 177, 182);
		contentPane.add(jListaEstaciones);
		listaEst = new ArrayList<clsEstacion>();
		listaEst = gestorLN.getEstacionBD();
		
		for(clsEstacion e:listaEst) {
			modelo2.addElement(e);
		}
		
		
		JButton btnEstacion = new JButton("Elegir estación");
		btnEstacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jListaEstaciones.getSelectedValue()!=null) 
				{
					modelo1.removeAllElements();
					repaint();
					int cod= jListaEstaciones.getSelectedValue().getIdEstacion();
					lista=gestorLN.getBicisEstacion(cod);
					
					for(clsBicicleta b: lista) {
						modelo1.addElement(b);
						System.out.println(b);
					}
					repaint();
				}
			}
		});
		btnEstacion.setBounds(40, 232, 130, 23);
		contentPane.add(btnEstacion);
		
		JButton btnAlquilarBicicleta = new JButton("Alquilar bici");
		btnAlquilarBicicleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jListaBicis.getSelectedValue()!=null) 
				{
					gestorLN.cogerBici(dni, jListaBicis.getSelectedValue().getBici_id());
					JOptionPane.showMessageDialog(null, "Bicicleta alquilada con éxito.");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "No hay bicicletas disponibles en la estación seleccionada.");
				}
				
				
				//CUANDO SE HAGA CON ESTACIONES HABRÁ QUE USAR METODO COGERBICI PARA QUE AFECTE A ESTACIONES
			}
		});
		btnAlquilarBicicleta.setBounds(259, 232, 130, 23);
		contentPane.add(btnAlquilarBicicleta);
	}
	
	public void devolver(final String dni) 
	{
		
		JLabel lblDev = new JLabel("Tienes una bicicleta pendiente de devolver");
		lblDev.setBounds(10, 40, 400, 14);
		contentPane.add(lblDev);
		
		modelo2=new DefaultListModel<clsEstacion>();
		jListaEstaciones=new JList<clsEstacion>(modelo2);
		jListaEstaciones.setBounds(10, 60, 400, 160);
		contentPane.add(jListaEstaciones);
		listaEst = new ArrayList<clsEstacion>();
		listaEst = gestorLN.getEstacionBD();
		for(clsEstacion e:listaEst) {
			modelo2.addElement(e);
		}
		
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CAMBIAR PARA INDICAR LA ESTACION EN LA QUE QUEREMOS DEPOSITAR LA BICI
				if(jListaEstaciones.getSelectedValue()!=null) 
				{
					if(gestorLN.comprobarEstacion(jListaEstaciones.getSelectedValue().getIdEstacion())) 
					{
						int duracion = gestorLN.dejarBici(dni,jListaEstaciones.getSelectedValue().getIdEstacion());
						double precio = duracion*0.20;
						JOptionPane.showMessageDialog(null, "El alquiler ha durado: "+duracion+" minutos. El precio resultante es de: "+
						precio+" €.");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "La estación seleccionada no tiene plazas de aparcamiento disponibles");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Selecciones la estación donde desea estacionar la bicicleta.");
				}
				
				//CUANDO SE HAGA CON ESTACIONES HABRÁ QUE USAR METODO COGERBICI PARA QUE AFECTE A ESTACIONES
			}
		});
		btnDevolver.setBounds(289, 225, 95, 23);
		contentPane.add(btnDevolver);
	}
}
