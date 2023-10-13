import java.time.LocalTime;
import java.util.ArrayList;

class Sede {
  private String nombre;
  private String ubicacion;
  private LocalTime horaApertura;
  private LocalTime horaCierre;
  private ArrayList<String> diasApertura;

  public Sede(String nombre,
      String ubicacion,
      LocalTime horaApertura,
      LocalTime horaCierre,
      ArrayList<String> diasApertura) {
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.horaApertura = horaApertura;
    this.horaCierre = horaCierre;
    this.diasApertura = diasApertura;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public void setHoraApertura(LocalTime horaApertura) {
    this.horaApertura = horaApertura;
  }

  public void setHoraCierre(LocalTime horaCierre) {
    this.horaCierre = horaCierre;
  }

  public void setDiasApertura(String diasApertura) {
    this.diasApertura = diasApertura;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getUbicacion() {
    return this.ubicacion;
  }

  public LocalTime getHoraApertura() {
    return this.horaApertura;
  }

  public LocalTime getHoraCierre() {
    return this.horaCierre;
  }

  public ArrayList<String> getDiasApertura() {
    return this.diasApertura;
  }
}