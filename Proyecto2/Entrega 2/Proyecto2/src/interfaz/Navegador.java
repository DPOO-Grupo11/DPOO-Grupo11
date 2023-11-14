package interfaz;

import java.awt.BorderLayout;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import interfaz.registro.Login;

/**
 * se encarga de agregar y quitar paginas
 */
public class Navegador extends JLayeredPane {
  private int indicePagina;

  public Navegador() {
    setLayout(new BorderLayout());
    this.indicePagina = 0;
    add(new Login(), indicePagina);
  }

  public void agregarPagina(JPanel panel) {
    getComponentsInLayer(indicePagina)[0].setVisible(false);
    indicePagina++;
    add(panel, indicePagina);
  }

  public void paginaAnterior() {
    if (indicePagina <= 0) {
      return;
    }
    remove(indicePagina);
    indicePagina--;
    getComponentsInLayer(indicePagina)[0].setVisible(true);
  }

}