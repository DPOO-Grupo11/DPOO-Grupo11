package interfaz.menuadmin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Admin;
import clases.Empleado;
import clases.SistemaAlquiler;
import interfaz.Navegador;
import interfaz.componentes.Boton;
import interfaz.menuempleado.FormalizarAlquiler;

import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class MenuAdmin extends JPanel {
	
	private final Navegador nav;
	 private final SistemaAlquiler sistemaAlquiler;
	  private final Admin admin;
	
	public MenuAdmin(Navegador nav, SistemaAlquiler sistemaAlquiler, Admin adminActual) {
		this.nav = nav;
	    this.admin = adminActual;
	    this.sistemaAlquiler = sistemaAlquiler;
        setLayout(new BorderLayout());

        // Etiqueta del título
        JLabel titleLabel = new JLabel("Menu Adminitrador", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 16));

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5, 10, 10)); // 1 fila, 5 columnas

        // Etiqueta de opciones
        JLabel optionsLabel = new JLabel("Opciones", SwingConstants.CENTER);

        // Añadir la etiqueta al panel de botones
        buttonPanel.add(optionsLabel);

        // Agregar botones según el tipo de usuario
        if (admin.getSede() == null)
        {
        	
        	add(new Boton("Agregar Carro", () -> {
        	      nav.agregarPagina(new AgregarVehiculo());
        	      return null;
        	    }));
            addButton(buttonPanel, "Crear Sede");
            addButton(buttonPanel, "Modificar Sede");
            add(new Boton("Consultar informacion vehiculo", () -> {
            	mostrarVentanaInformacionVehiculo();
      	      return null;
      	    }));
            addButton(buttonPanel, "Cerrar Sesión");
        } 
        else 
        {
            addButton(buttonPanel, "Añadir Empleado");
            addButton(buttonPanel, "Eliminar Empleado");
            addButton(buttonPanel, "Consultar Informacion Vehiculo");
            addButton(buttonPanel, "Cerrar Sesión");
        }

        // Agregar componentes al panel principal
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void addButton(JPanel panel, String buttonText) {
        JButton button = new JButton(buttonText);
        panel.add(button);
    }
    
    private void mostrarVentanaInformacionVehiculo() 
    {
        JFrame frame = new JFrame("Información Vehículo");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel placaLabel = new JLabel("Placa:");
        JTextField placaTextField = new JTextField();
        JButton aceptarButton = new JButton("Aceptar");

    }
}

