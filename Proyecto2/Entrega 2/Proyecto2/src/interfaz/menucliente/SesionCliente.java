package interfaz.menucliente;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SesionCliente extends JFrame {
	
	public SesionCliente() {
		
		JPanel panel= new JPanel();
		panel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panel.add(new JLabel("Usuario"));
		JTextField usuario= new JTextField();
		panel.add(usuario);
		
		panel.add(new JLabel("Contraseña"));
		JPasswordField contraseña= new JPasswordField();
		panel.add(contraseña);
		
		JPanel cerrar = new JPanel();
		JButton ingresar= new JButton("INGRESAR");
		cerrar.add(ingresar);
	}

}
