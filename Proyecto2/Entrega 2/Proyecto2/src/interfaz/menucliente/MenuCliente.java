package interfaz.menucliente;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuCliente extends JPanel {
	
	public MenuCliente() {
		
		JLabel titleLabel = new JLabel("Menu Cliente", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		JPanel buttonPanel= new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(new JButton("Iniciar Sesion"));
		add(new JButton("Registrarse"));
		add(new JButton("Salir"));
	}

}
