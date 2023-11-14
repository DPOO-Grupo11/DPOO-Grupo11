package interfaz.menuempleado;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import interfaz.componentes.Boton;

public class CrearAlquiler extends JPanel {
  public CrearAlquiler() {
    setLayout(new GridBagLayout());
    add(new Boton("Categoria", () -> {
      return null;
    }),
        new GridBagConstraints(0, 0,
            1, 1,
            0, 0,
            0, 0,
            null,
            0, 0));
  }

}
