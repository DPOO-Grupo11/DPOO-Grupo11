package interfaz.registro;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import clases.SistemaAlquiler;
import interfaz.Navegador;
import interfaz.componentes.Texto;

public class RegistrarCliente extends JPanel {
  private final Navegador nav;
  private final SistemaAlquiler sistemaAlquiler;

  public RegistrarCliente(Navegador nav, SistemaAlquiler sistemaAlquiler) {
    this.nav = nav;
    this.sistemaAlquiler = sistemaAlquiler;
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    // nombre
    add(new Texto("Nombre y Apellido", false));
    add(new Texto("Nombre y Apellido", true));
    // numero
    add(new Texto("Numero Telefonico", false));
    add(new Texto("Numero Telefonico", true));
    // direccion
    add(new Texto("Direccion", false));
    add(new Texto("Direccion", true));
    // nudireccionmero
    add(new Texto("Direccion", false));
    add(new Texto("Direccion", true));

  }
}
