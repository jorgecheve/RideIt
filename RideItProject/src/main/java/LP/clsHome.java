package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LD.clsAlquiler;
import LD.clsBicicleta;
import LD.clsEstacion;
import LD.clsUsuario;
import LN.gestorLN;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class clsHome extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtContrasea;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		gestorLN.iniciarListas();
		gestorLN.probarListaUs();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsHome frame = new clsHome();
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
	public clsHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("");
		txtUsuario.setBounds(97, 83, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 83, 64, 14);
		contentPane.add(lblUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setBounds(97, 47, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 47, 64, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 118, 64, 14);
		contentPane.add(lblApellidos);
		
		txtApellido = new JTextField();
		txtApellido.setText("");
		txtApellido.setBounds(97, 118, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblRegstrate = new JLabel("REGÍSTRATE");
		lblRegstrate.setBounds(100, 11, 83, 14);
		contentPane.add(lblRegstrate);
		
		txtDni = new JTextField();
		txtDni.setText("");
		txtDni.setBounds(97, 149, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 149, 46, 14);
		contentPane.add(lblDni);
		
		txtContrasea = new JTextField();
		txtContrasea.setText("");
		txtContrasea.setBounds(97, 180, 86, 20);
		contentPane.add(txtContrasea);
		txtContrasea.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(10, 180, 70, 14);
		contentPane.add(lblContrasea);
		
		JButton btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.setBounds(80, 211, 118, 23);
		contentPane.add(btnRegistrarme);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setBounds(315, 47, 83, 14);
		contentPane.add(lblLogIn);
		
		textField = new JTextField();
		textField.setBounds(312, 83, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario_1 = new JLabel("Usuario");
		lblUsuario_1.setBounds(234, 86, 64, 14);
		contentPane.add(lblUsuario_1);
		
		JLabel lblContrasea_1 = new JLabel("Contraseña");
		lblContrasea_1.setBounds(234, 122, 75, 14);
		contentPane.add(lblContrasea_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(312, 119, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(309, 211, 89, 23);
		contentPane.add(btnLogIn);
		btnRegistrarme.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				if(txtUsuario.getText().isEmpty() || txtDni.getText().isEmpty() || txtContrasea.getText().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "Hay algún campo de texto vacío, rellénelo");
				}else {
					gestorLN.altaUsuario(txtNombre.getText(), txtApellido.getText(), txtDni.getText(), txtUsuario.getText(), txtContrasea.getText());
					repaint();
				}
				
			}
		});
		
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{ 
				
				boolean acceso = gestorLN.autenticacion(textField.getText(), textField_1.getText());
				
				if(acceso==true) 
				{
					try {
						HomeUser frame = new HomeUser(textField.getText());
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Acceso denegado");
				}
				
			}
		});
		
	}
}
