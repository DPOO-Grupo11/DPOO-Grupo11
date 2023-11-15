package interfaz.registro;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import clases.SistemaAlquiler;
import interfaz.Navegador;
import interfaz.componentes.Boton;

public class Login extends JPanel {
  private final Navegador nav;
  private final SistemaAlquiler sistemaAlquiler;

  public Login(Navegador nav, SistemaAlquiler sistemaAlquiler) {
    this.nav = nav;
    this.sistemaAlquiler = sistemaAlquiler;
    // morado
    setBackground(new Color(153, 50, 204));
    setOpaque(true);
    setLayout(new BorderLayout());
    add(new Boton("Iniciar Sesion", () -> {
      return null;
    }), BorderLayout.CENTER);
    add(new Boton("Registrar Cliente", () -> {
      nav.agregarPagina(new RegistrarCliente(nav, sistemaAlquiler));
      return null;
    }), BorderLayout.CENTER);
    add(new Boton("Registrar Empleado", () -> {
      return null;
    }), BorderLayout.CENTER);
  }
}
