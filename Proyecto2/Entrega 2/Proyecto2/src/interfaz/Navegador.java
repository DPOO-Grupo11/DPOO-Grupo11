package interfaz;

import java.awt.BorderLayout;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import clases.SistemaAlquiler;
import clases.Usuario;
import interfaz.menucliente.MenuCliente;
import interfaz.registro.Login;

/**
 * se encarga de agregar y quitar paginas
 */
public class Navegador extends JLayeredPane {
  private final boolean modoPruebaActivado = true;
  private int indicePagina;

  private Usuario usuario;
  private final Navegador navegador;
  private final SistemaAlquiler sistemaAlquiler;

  public Navegador(
      Usuario usuario,
      Navegador navegador,
      SistemaAlquiler sistemaAlquiler) {
    this.usuario = usuario;
    this.navegador = navegador;
    this.sistemaAlquiler = sistemaAlquiler;
    setLayout(new BorderLayout());
    this.indicePagina = 0;
    add(new Login(), indicePagina);
    if (modoPruebaActivado) {
      // TODO: aca agregar paginas que se van a probar
      add(new MenuCliente());
    }
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