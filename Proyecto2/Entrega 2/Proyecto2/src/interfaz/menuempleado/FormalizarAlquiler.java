package interfaz.menuempleado;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import clases.Reserva;
import clases.SistemaAlquiler;
import interfaz.Navegador;

public class FormalizarAlquiler extends JPanel {
  private final Navegador nav;
  private final SistemaAlquiler sistemaAlquiler;

  public FormalizarAlquiler(Navegador nav, SistemaAlquiler sistemaAlquiler) {
    this.nav = nav;
    this.sistemaAlquiler = sistemaAlquiler;

    ArrayList<Reserva> reservas = sistemaAlquiler.getReservas();
    reservas.forEach(null);
    ArrayList<Reserva> sinFormalizar = new ArrayList<Reserva>();

    setLayout(new GridLayout(0, 2));

  }
}
