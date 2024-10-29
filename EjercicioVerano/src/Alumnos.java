import java.util.ArrayList;
import java.util.Scanner;

public class Alumnos extends Personas {

	protected String idAlumno, clase;
	protected ArrayList<Modulos>modulosMatriculados = new ArrayList<Modulos>();
	protected ArrayList<Alumnos>listadoAlumnos = new ArrayList<Alumnos>();
	Scanner sc = new Scanner(System.in);
	
	
	public Alumnos() {
	
	}

	public Alumnos(String nombre, String apellidos, String dni, String contrasena) {
		super(nombre, apellidos, dni, contrasena);
	}

	public Alumnos(String nombre, String apellidos, String dni, String contrasena, String idAlumno, String clase) {
		super(nombre, apellidos, dni, contrasena);
		this.idAlumno = idAlumno;
		this.clase = clase;
	}

	protected String getIdAlumno() {
		return idAlumno;
	}

	protected void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	protected String getClase() {
		return clase;
	}

	protected void setClase(String clase) {
		this.clase = clase;
	}
			

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + ", Apellidos: " + this.apellidos + ", DNI: " + this.dni + ", Contrasena: " + this.contrasena + ", ID: " + this.idAlumno + ", Clase: " + this.clase;
	}
}
