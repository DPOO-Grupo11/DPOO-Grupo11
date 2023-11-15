package interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.TabbedPaneUI;

import clases.SistemaAlquiler;
import clases.Usuario;
import interfaz.registro.Login;

/**
 * se encarga de agregar y quitar paginas
 */
public class Navegador extends JPanel {
  private final boolean modoPruebaActivado = true;

  private Usuario usuario;
  private final SistemaAlquiler sistemaAlquiler;

  private ArrayList<JPanel> paneles;

  public Navegador(
      Usuario usuario,
      SistemaAlquiler sistemaAlquiler) {

    this.usuario = usuario;
    this.sistemaAlquiler = sistemaAlquiler;
    paneles = new ArrayList<JPanel>();

    // amarillo
    setBackground(new Color(255, 255, 0));
    setOpaque(true);
    setLayout(new CardLayout());

    add(new Login(this, sistemaAlquiler));
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
}