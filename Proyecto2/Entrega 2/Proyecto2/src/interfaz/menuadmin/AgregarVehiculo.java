package interfaz.menuadmin;

import javax.swing.*;
import java.awt.*;

public class AgregarVehiculo extends JPanel {
    private JTextField placaTextField;
    private JTextField marcaTextField;
    private JTextField colorTextField;
    private JComboBox<String> transmisionComboBox;
    private JComboBox<String> categoriaComboBox;

    public AgregarVehiculo() {
        setLayout(new GridLayout(7, 2, 10, 10)); // 7 filas, 2 columnas

        // Etiquetas y campos de texto
        add(new JLabel("Placa:"));
        placaTextField = new JTextField();
        add(placaTextField);

        add(new JLabel("Marca:"));
        marcaTextField = new JTextField();
        add(marcaTextField);

        add(new JLabel("Color:"));
        colorTextField = new JTextField();
        add(colorTextField);

        // Etiquetas y combos
        add(new JLabel("Transmisión:"));
        String[] transmisionOptions = {"Automático", "Mecánico"};
        transmisionComboBox = new JComboBox<>(transmisionOptions);
        add(transmisionComboBox);

        add(new JLabel("Categoría:"));
        String[] categoriaOptions = {"SUV", "Pequeños", "Lujo", "Otros"};
        categoriaComboBox = new JComboBox<>(categoriaOptions);
        add(categoriaComboBox);

        // Botón para agregar vehículo
        JButton agregarVehiculoButton = new JButton("Agregar Vehículo");
        agregarVehiculoButton.setBackground(Color.GREEN);
        add(agregarVehiculoButton);
    }

}
