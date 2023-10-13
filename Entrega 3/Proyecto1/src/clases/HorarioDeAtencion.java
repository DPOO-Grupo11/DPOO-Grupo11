package clases;

public class HorarioDeAtencion {
	private String dia;
	private Range<Integer> horas;
	
	public HorarioDeAtencion(String dia, Range<Integer> horas) {
		this.dia = dia;
		this.horas = horas;
	}
	
	public Range<Integer> getHoras() {
		return  this.horas;
	}
	
	public String getDia() {return this.dia;
	}
}
