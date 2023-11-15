package interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.TabbedPaneUI;

import clases.Admin;
import clases.Cliente;
import clases.Empleado;
import clases.SistemaAlquiler;
import clases.Usuario;
import interfaz.menuadmin.MenuAdmin;
import interfaz.menucliente.MenuCliente;
import interfaz.menuempleado.MenuEmpleado;
import interfaz.registro.LandingPage;

/**
 * se encarga de agregar y quitar paginas
 */
public class Navegador extends JPanel {
  private final boolean modoPruebaActivado = true;

  private final SistemaAlquiler sistemaAlquiler;

  private ArrayList<JPanel> paneles;

  public Navegador(
      SistemaAlquiler sistemaAlquiler) {

    this.sistemaAlquiler = sistemaAlquiler;
    paneles = new ArrayList<JPanel>();

    // amarillo
    setBackground(new Color(255, 255, 0));
    setOpaque(true);
    setLayout(new CardLayout());
    setSize(new Dimension(25, 25));

    add(new LandingPage(this, sistemaAlquiler));
    login();
    // if (modoPruebaActivado) {
    // // TODO: aca agregar paginas que se van a probar
    // agregarPagina(new MenuEmpleado(this, sistemaAlquiler, null));
    // }
  }

  public void agregarPagina(JPanel panel) {
    paneles.add(panel);
    add(panel);
  }

  public void paginaAnterior() {
    int i = paneles.size() - 1;
    if (i <= 0)
      return;
    remove(paneles.remove(i));
  }

  public void login() {
    Usuario usuario = sistemaAlquiler.getUsuarioActual();
    if (usuario != null) {
      System.out.println("sesion iniciada abriendo menu correspondiente");
      if (usuario instanceof Admin) {
        agregarPagina(new MenuAdmin(this, sistemaAlquiler, (Admin) usuario));
      } else if (usuario instanceof Empleado) {
        agregarPagina(new MenuEmpleado(this, sistemaAlquiler, (Empleado) usuario));
      } else if (usuario instanceof Cliente) {
        agregarPagina(new MenuCliente());
      }
    } else {
      System.out.println("sesion no iniciada");
    }
  }
}