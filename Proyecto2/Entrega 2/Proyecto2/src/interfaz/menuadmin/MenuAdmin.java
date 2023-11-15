package interfaz.menuadmin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Admin;

import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class MenuAdmin extends JPanel {
	
	
	public MenuAdmin(Admin adminActual) {
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
        if (adminActual.getSede() == null)
        {
            addButton(buttonPanel, "Agregar Carro");
            addButton(buttonPanel, "Crear Sede");
            addButton(buttonPanel, "Modificar Sede");
            addButton(buttonPanel, "Consultar Informacion Vehiculo");
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

}

