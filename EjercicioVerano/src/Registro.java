import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Registro extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuarioRegistro;
	private JPasswordField txtContrasena;
	private String usuario;
	private String contrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setModal(true);
		setTitle("Registro");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UsuarioRegistro = new JLabel("Usuario");
		UsuarioRegistro.setBounds(41, 63, 45, 13);
		contentPane.add(UsuarioRegistro);
		
		JLabel ContrasenaRegistro = new JLabel("Contraseña");
		ContrasenaRegistro.setBounds(38, 111, 63, 13);
		contentPane.add(ContrasenaRegistro);
		
		txtUsuarioRegistro = new JTextField();
		txtUsuarioRegistro.setBounds(131, 60, 96, 19);
		contentPane.add(txtUsuarioRegistro);
		txtUsuarioRegistro.setColumns(10);
		
		JButton btnAceptarRegistro = new JButton("Aceptar");
		btnAceptarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			     usuario = txtUsuarioRegistro.getText();
				 contrasena = new String(txtContrasena.getPassword());
				 
				 
				 dispose();
				
			}
		});
		btnAceptarRegistro.setBounds(139, 161, 85, 21);
		contentPane.add(btnAceptarRegistro);
		
		JLabel lblNewLabel = new JLabel("VENTANA DE REGISTRO");
		lblNewLabel.setBounds(131, 20, 167, 13);
		contentPane.add(lblNewLabel);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(131, 108, 96, 19);
		contentPane.add(txtContrasena);
	}
		
		 public String getUsuario() {
		        return usuario;
		    }

		    public String getContrasena() {
		        return contrasena;
		    }
	
	}

