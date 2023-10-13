package clases;

import java.io.Serializable;

public class TarjetaDeCredito implements Serializable {
	private static final long serialVersionUID = 2599490462876986299L;
	/**
	 * 
	 */
	private int numero;
	private String fechaVencimiento;
	private int cvv;

	public TarjetaDeCredito(int numero, String fechaVencimiento, int cvv) {
		this.numero = numero;
		this.fechaVencimiento = fechaVencimiento;
		this.cvv = cvv;
	}

	/**
	 * getters
	 */

	public int getNumero() {
		return numero;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public int getCvv() {
		return cvv;
	}

	/**
	 * setters
	 */

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
}
