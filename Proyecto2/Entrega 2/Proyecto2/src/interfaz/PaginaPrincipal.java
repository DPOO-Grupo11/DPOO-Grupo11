package interfaz;

import interfaz.registro.Login;
import interfaz.menuadmin.*;
import interfaz.menucliente.*;
import interfaz.menuempleado.*;

import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import clases.Admin;
import clases.Empleado;
import clases.Usuario;

/**
 * El login se hace aca
 */
public class PaginaPrincipal extends JFrame {

  private Usuario usuario;
  private Navegador navegador;

  public static Navegador getNavegador() {
    return (Navegador) Window.getWindows()[0].getComponents()[0];
  }

  public PaginaPrincipal() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(new BorderLayout());
    navegador = new Navegador();
    add(navegador, BorderLayout.CENTER);
    if (usuario != null) {
      if (usuario instanceof Admin) {
        navegador.agregarPagina(new MenuAdmin());
      } else if (usuario instanceof Empleado) {
        navegador.agregarPagina(new MenuEmpleado());
      } else if (usuario instanceof Cliente) {
        navegador.agregarPagina(new MenuCliente());
      }
    }

  }

  public static void main(String[] args) {
    PaginaPrincipal pp = new PaginaPrincipal();
    pp.setExtendedState(JFrame.MAXIMIZED_BOTH);
    // pp.setUndecorated(true);
    pp.setResizable(false);
    pp.setVisible(true);
  }
}

/**
 * se encarga de agregar y quitar paginas
 */
class Navegador extends JLayeredPane {
  private int indicePagina;

  public Navegador() {
    setLayout(new BorderLayout());
    this.indicePagina = 0;
    add(new Login(), indicePagina);
  }

  void agregarPagina(JPanel panel) {
    getComponentsInLayer(indicePagina)[0].setVisible(false);
    indicePagina++;
    add(panel, indicePagina);
  }

  void removerUltimaPagina() {
    if (indicePagina <= 0) {
      return;
    }
    remove(indicePagina);
    indicePagina--;
    getComponentsInLayer(indicePagina)[0].setVisible(true);
  }

}