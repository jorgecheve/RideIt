package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LD.clsAlquiler;
import LD.clsEstacion;
import LN.gestorLN;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
/**
 * 
 * clase que contiene el historial de alquileres de los usuarios de la aplicación
 * La clase extiende de JFrame
 */
public class UserHistory extends JFrame {

	private JPanel contentPane;
	protected DefaultListModel<clsAlquiler> modelo;
	private JList <clsAlquiler> jListaAlquileres;
	private ArrayList<clsAlquiler>lista;
	private JLabel lblElImporteAcumulado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHistory frame = new UserHistory("HOlaa");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserHistory(String dni) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("Listado de alquileres");
		label.setBounds(25, 11, 217, 14);
		contentPane.add(label);
		
		modelo=new DefaultListModel<clsAlquiler>();
		jListaAlquileres=new JList<clsAlquiler>(modelo);
		jListaAlquileres.setBounds(25, 44, 380, 169);
		contentPane.add(jListaAlquileres);
		
		lista = gestorLN.getAlquileresUser(dni);
		
		for(clsAlquiler al:lista) 
		{
			modelo.addElement(al);
		}
		
		lblElImporteAcumulado = new JLabel("El importe acumulado es de: "+gestorLN.getCosteAlquileres(lista, 0.2)+" €.");
		lblElImporteAcumulado.setBounds(25, 236, 227, 14);
		contentPane.add(lblElImporteAcumulado);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCerrar.setBounds(316, 232, 89, 23);
		contentPane.add(btnCerrar);
		
	}
}
