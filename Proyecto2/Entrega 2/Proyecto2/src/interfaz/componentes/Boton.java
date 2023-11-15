package interfaz.componentes;

import java.util.concurrent.Callable;

import javax.swing.JButton;

public class Boton extends JButton {
  public Boton(String texto, Callable<Void> action) {
    addActionListener(e -> {
      try {
        action.call();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    });
  }
}
