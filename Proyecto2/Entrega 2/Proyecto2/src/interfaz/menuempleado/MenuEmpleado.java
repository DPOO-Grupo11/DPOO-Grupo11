package interfaz.menuempleado;

import java.util.concurrent.Callable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import clases.Empleado;
import clases.SistemaAlquiler;
import interfaz.Navegador;

public class MenuEmpleado extends JPanel {
  private final Navegador nav;
  private final SistemaAlquiler sistemaAlquiler;
  private final Empleado empleado;

  public MenuEmpleado(Navegador nav, SistemaAlquiler sistemaAlquiler, Empleado empleado) {
    this.nav = nav;
    this.empleado = empleado;
    this.sistemaAlquiler = sistemaAlquiler;
    setLayout(new BoxLayout(this.getRootPane(), BoxLayout.Y_AXIS));
    add(new Boton("Formalizar Alquiler", () -> {
      return null;
    }));
    add(new Boton("Crear Alquiler", () -> {
      return null;
    }));
    add(new Boton("Cerrar Sesion", () -> {
      nav.paginaAnterior();
      return null;
    }));
  }
}

class Boton extends JButton {
  Boton(String texto, Callable<Void> action) {
    addActionListener(e -> {
      try {
        action.call();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    });
  }
}
