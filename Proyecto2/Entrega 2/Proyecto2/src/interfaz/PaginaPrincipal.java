package interfaz;

import interfaz.menuadmin.*;
import interfaz.menucliente.*;
import interfaz.menuempleado.*;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import clases.Admin;
import clases.Cliente;
import clases.Empleado;
import clases.SistemaAlquiler;
import clases.Usuario;

/**
 * El login se hace aca
 */
public class PaginaPrincipal extends JFrame {

  private Usuario usuario;
  private final Navegador navegador;
  private final SistemaAlquiler sistemaAlquiler;

  public PaginaPrincipal() throws FileNotFoundException, ClassNotFoundException, IOException {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(new BorderLayout());
    sistemaAlquiler = new SistemaAlquiler();
    sistemaAlquiler.cargarDatos();
    navegador = new Navegador(usuario, navegador, sistemaAlquiler);
    add(navegador, BorderLayout.CENTER);
    if (usuario != null) {
      if (usuario instanceof Admin) {
        navegador.agregarPagina(new MenuAdmin());
      } else if (usuario instanceof Empleado) {
        navegador.agregarPagina(new MenuEmpleado(navegador, sistemaAlquiler, (Empleado) usuario));
      } else if (usuario instanceof Cliente) {
        navegador.agregarPagina(new MenuCliente());
      }
    }

  }

  public static void main(String[] args) {
    PaginaPrincipal pp;
    try {
      pp = new PaginaPrincipal();
      pp.setExtendedState(JFrame.MAXIMIZED_BOTH);
      // pp.setUndecorated(true);
      pp.setResizable(false);
      pp.setVisible(true);
    } catch (ClassNotFoundException | IOException e) {
      System.out.println("Carga de datos fallida");
      e.printStackTrace();

    }
  }
}
