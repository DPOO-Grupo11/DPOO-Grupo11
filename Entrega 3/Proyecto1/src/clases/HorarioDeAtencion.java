package clases;

import java.io.Serializable;

public class HorarioDeAtencion implements Serializable {
	private static final long serialVersionUID = 6340839134383635203L;
	/**
	 * 
	 */
	private String dia;
	private Range<Integer> horas;

	public HorarioDeAtencion(String dia, Range<Integer> horas) {
		this.dia = dia;
		this.horas = horas;
	}

	public Range<Integer> getHoras() {
		return this.horas;
	}

	public String getDia() {
		return this.dia;
	}
	public void setHoras(Range<Integer> hora){
		this.horas = hora;
	}
	public void setDia(String d_dia){
		this.dia = d_dia;
	}
}
