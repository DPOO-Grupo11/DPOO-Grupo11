<<<<<<< HEAD
package clases;

import java.io.Serializable;

public class Inventario implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
}
=======
package clases;

import java.io.Serializable;

public class Inventario implements Serializable {
	private static final long serialVersionUID = 9987630713456293001L;
	/**
	 * 
	 */
	private List<String> prioridadCategoria;
	private Map<String, Vehiculo> vehiculos;
    private Map<String, Reserva>  reservas;
    private String archivoInventario;
    private Map<String, List<Range<LocalDateTime>>> calendario;

	public HorarioDeAtencion(List<String> prioridadCategoria,  Map<String, Vehiculo> vehiculos, Map<String, Reserva>  reservas, String archivoInventario, Map<String, List<Range<LocalDateTime>>> calendario) {
		this.prioridadCategoria = prioridadCategoria;
		this.vehiculos = vehiculos;
        this.reservas = reservas;
        this.archivoInventario = archivoInventario;
        this.calendario = calendario;
	}

	public List<String> getCategoria(){
        return this.prioridadCategoria;
    }

    public Map<String, Vehiculo> getVehiculo(){
        return this.vehiculos;
    }
    public  Map<String, Reserva> getReserva(){
        return this.reservas;
    }
    public String getArchivoInventario(){
        return this.archivoInventario;
    }
    public  Map<String, List<Range<LocalDateTime>>> getCalendario(){
        return this.calendario;
    }


    public void setCategoria(List<String> Cate){
        this.prioridadCategoria = Cate;
    }

    public void setVehiculo(Map<String, Vehiculo> Vehi){
        this.vehiculos = Vehi;
    }
    public  void setReserva(Map<String, Reserva> reser){
        this.reservas = reser;
    }
    public void setArchivoInventario(String Archivo){
        this.archivoInventario = Archivo;
    }
    public  void getCalendario(Map<String, List<Range<LocalDateTime>>> calen){
        this.calendario = calen;
    }
}
>>>>>>> c65afe1b52775a58aabbc4669ddd4072ce7d0a11
