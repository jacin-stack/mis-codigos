import java.util.ArrayList;
import java.util.Scanner;

public class Profesores extends Personas{

	protected String idProfesor;
	protected ArrayList<Modulos>modulos = new ArrayList<Modulos>();
	Scanner sc = new Scanner(System.in);
	
	
	public Profesores() {

	}

	public Profesores(String nombre) {
		super(nombre);
	}

	public Profesores(String nombre, String apellidos, String dni, String contrasena) {
		super(nombre, apellidos, dni, contrasena);
	}

	public Profesores(String nombre, String apellidos, String dni, String contrasena, String idProfesor) {
		super(nombre, apellidos, dni, contrasena);
		this.idProfesor = idProfesor;
	}

	public Profesores(String nombre, String apellidos, String dni, String contrasena, String idProfesor, ArrayList<Modulos> modulos) {
		super(nombre, apellidos, dni, contrasena);
		this.idProfesor = idProfesor;
		this.modulos = modulos;
	}

	protected String getIdProfesor() {
		return idProfesor;
	}

	protected void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}

	protected ArrayList<Modulos> getModulos() {
		return modulos;
	}

	protected void setModulos(ArrayList<Modulos> modulos) {
		this.modulos = modulos;
	}
	
	

}
