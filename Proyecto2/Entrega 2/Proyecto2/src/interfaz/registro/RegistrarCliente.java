package interfaz.registro;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import clases.SistemaAlquiler;
import interfaz.Navegador;
import interfaz.componentes.Boton;
import interfaz.componentes.MostrarYEscogerImagen;
import interfaz.componentes.Texto;
import interfaz.menuempleado.MetodoDePago;

public class RegistrarCliente extends JPanel {
  private final Navegador nav;
  private final SistemaAlquiler sistemaAlquiler;

  public RegistrarCliente(Navegador nav, SistemaAlquiler sistemaAlquiler) {
    this.nav = nav;
    this.sistemaAlquiler = sistemaAlquiler;
    // panel izquierdo
    JPanel pi = new JPanel();
    pi.setLayout(new BoxLayout(pi, BoxLayout.Y_AXIS));
    // nombre
    pi.add(new Texto("Nombre y Apellido", false));
    pi.add(new Texto("Nombre y Apellido", true));
    // numero
    pi.add(new Texto("Numero Telefonico", false));
    pi.add(new Texto("Numero Telefonico", true));
    // direccion
    pi.add(new Texto("Direccion", false));
    pi.add(new Texto("Direccion", true));
    // correo
    pi.add(new Texto("Correo", false));
    pi.add(new Texto("Correo", true));
    // licencia
    pi.add(new Texto("Licencia", false));
    pi.add(new Texto("Licencia", true));
    // Cedula
    pi.add(new Texto("Cedula", false));
    pi.add(new Texto("Cedula", true));
    // panel derecho
    JPanel pd = new JPanel();
    pd.setLayout(new BorderLayout());
    //pd.add(new MostrarYEscogerImagen(), BorderLayout.CENTER);
    JPanel box = new JPanel();
    box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
    pd.add(box, BorderLayout.SOUTH);
    box.add(new Boton("Tarjeta de Credito", () -> {
      return null;
    }));
    box.add(new Boton("Finalizar", () -> {
      return null;
    }));
    // organizar
    setLayout(new GridLayout(1, 2));
    add(pi);
    add(pd);
  }
}

class PanelIzquierda extends JPanel {
  PanelIzquierda() {
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
    // correo
    add(new Texto("Correo", false));
    add(new Texto("Correo", true));
    // licencia
    add(new Texto("Licencia", false));
    add(new Texto("Licencia", true));
    // Cedula
    add(new Texto("Cedula", false));
    add(new Texto("Cedula", true));
  }
}