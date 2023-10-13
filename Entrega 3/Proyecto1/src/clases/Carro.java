import java.time.LocalDate;
import java.util.ArrayList;

class Carro {
  private String placa;
  private String marca;
  private String modelo;
  private String color;
  private String tipoDeTransmision;
  private String categoria;
  private Sede sede;
  private String estado;
  private Cliente cliente;
  private LocalDate fechaRegresoMantenimiento;
  private ArrayList<Alquiler> historial;

  public Carro(String placa, String marca, String modelo, String color, String tipoDeTransmision, String categoia, Sede sede, String estado, Cliente cliente) {
    this.placa = placa;
    this.marca = marca;
    this.modelo = modelo;
    this.color = color;
    this.tipoDeTransmision = tipoDeTransmision;
    this.categoia = categoia;
    this.sede = sede;
    this.estado = estado;
    this.cliente = cliente;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public void setFechaRegresoMantenimiento(LocalDate fecha) {
    this.fechaRegresoMantenimiento = fecha;
  }

  public String getEstado() {
    return this.estado;
  }

  public Cliente getClienteInfo() {
    return this.cliente;
  }

  public Sede getSede() {
    return this.sede;
  }
}