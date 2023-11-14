package interfaz.menuempleado;

import java.util.concurrent.Callable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import clases.Empleado;
import clases.SistemaAlquiler;
import interfaz.Navegador;
import interfaz.componentes.Boton;

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
      nav.agregarPagina(new FormalizarAlquiler());
      return null;
    }));
    add(new Boton("Crear Alquiler", () -> {
      nav.agregarPagina(new CrearAlquiler());
      return null;
    }));
    add(new Boton("Cerrar Sesion", () -> {
      nav.paginaAnterior();
      return null;
    }));
  }
}
