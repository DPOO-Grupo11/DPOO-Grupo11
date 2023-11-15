package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import clases.SistemaAlquiler;
import clases.Usuario;

/**
 * se encarga de agregar y quitar paginas
 */
public class Navegador extends JLayeredPane {
  private final boolean modoPruebaActivado = true;
  private int indicePagina;

  private Usuario usuario;
  private final SistemaAlquiler sistemaAlquiler;

  public Navegador(
      Usuario usuario,
      SistemaAlquiler sistemaAlquiler) {
    this.usuario = usuario;
    this.sistemaAlquiler = sistemaAlquiler;
    this.indicePagina = 1;
    // amarillo
    setBackground(new Color(255, 255, 0));
    setOpaque(true);
    // add(new Login(), indicePagina);
    // if (modoPruebaActivado) {
    // // TODO: aca agregar paginas que se van a probar
    // agregarPagina(new MenuEmpleado(this, sistemaAlquiler, null));
    // }
  }

  public void agregarPagina(JPanel panel) {
    // getComponentsInLayer(indicePagina)[0].setVisible(false);
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