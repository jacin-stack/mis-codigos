
public abstract class Personas {
	
	protected String nombre, apellidos, dni, contrasena;

	public Personas() {
		
	}
	

	public Personas(String nombre) {
		super();
		this.nombre = nombre;
	}


	public Personas(String nombre, String apellidos, String dni, String contrasena) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.contrasena = contrasena;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}
	
	protected String getContrasena() {
		return contrasena;
	}

	protected void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + ", Apellidos: " + this.apellidos + ", DNI: " + this.dni + ", Contrasena: " + this.contrasena;
	}
	
}
