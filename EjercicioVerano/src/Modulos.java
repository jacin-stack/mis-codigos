import java.util.ArrayList;

public class Modulos {

	protected String nombre;
	protected double horas, calificacion;
	protected ArrayList<Modulos>listaModulos = new ArrayList<Modulos>();
	
	
	public Modulos() {
		
	}
	

	public Modulos(String nombre) {
		this.nombre = nombre;
	}


	public Modulos(String nombre, double horas) {
		this.nombre = nombre;
		this.horas = horas;
	}

	public Modulos(String nombre, double horas, double calificacion) {
		this.nombre = nombre;
		this.horas = horas;
		this.calificacion = calificacion;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected double getHoras() {
		return horas;
	}

	protected void setHoras(double horas) {
		this.horas = horas;
	}

	protected double getCalificacion() {
		return calificacion;
	}

	protected void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
}
