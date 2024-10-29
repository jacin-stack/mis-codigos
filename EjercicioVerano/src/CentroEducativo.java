import java.util.ArrayList;
import java.util.Scanner;

public class CentroEducativo {

	ArrayList<Personas>listadoPersonas = new ArrayList<Personas>();
	Scanner sc = new Scanner(System.in);
	
	
	public CentroEducativo() {
		
	}


	public CentroEducativo(ArrayList<Personas> listadoPersonas) {
		this.listadoPersonas = listadoPersonas;
	}


	protected ArrayList<Personas> getListadoPersonas() {
		return listadoPersonas;
	}


	protected void setListadoPersonas(ArrayList<Personas> listadoPersonas) {
		this.listadoPersonas = listadoPersonas;
	}
	
	
	public Personas buscarPersona(String nombre, String contrasena) {
		Personas p = null;
		for(Personas p1: this.listadoPersonas) {
			if (p1 instanceof Alumnos && p1.getNombre().equals(nombre) && p1.getContrasena().equals(contrasena)) {
				p = p1;
				System.out.println(p.getNombre() + " es un alumno.");
			}
			if (p1 instanceof Profesores && p1.getNombre().equals(nombre) && p1.getContrasena().equals(contrasena)) {
				p = p1;
				System.out.println(p.getNombre() + " es un profesor.");
			}
		}
		return p;
	}

	
	public Alumnos buscarAlumnos(String id) {
		Personas p = null;
		for (Personas p1: this.listadoPersonas) {
			if (p1 instanceof Alumnos && ((Alumnos) p1).getIdAlumno().equals(id)) {
				p = p1;
			}
		}
		return (Alumnos) p;
	}
	
	public Profesores buscarProfesor(String id) {
		Personas p = null;
		for (Personas p1: this.listadoPersonas) {
			if(p1 instanceof Profesores && ((Profesores) p1).getIdProfesor().equals(id)) {
				p = p1;
			}
		}
		return (Profesores) p;
	}
	
	public void darAltaAlumno() {
		System.out.println("Escriba su nombre:");
		String nombre = sc.next();
		System.out.println("Escriba sus apellidos:");
		String apellidos = sc.next();
		System.out.println("Escriba su DNI:");
		String dni = sc.next();
		System.out.println("Escriba su contrasena:");
		String contrasena = sc.next();
		System.out.println("Escriba su ID de alumno:");
		String id = sc.next();
		System.out.println("Indique la clase a la que pertenece:");
		String clase = sc.next();
		Alumnos a = buscarAlumnos(id);
		if (a != null) {
			System.out.println("Este alumno ya esta dado de alta.");
			System.out.println("Vuelva a intentarlo.");
		} else {
			Alumnos a1 = new Alumnos(nombre, apellidos, dni, contrasena, id, clase);
			this.listadoPersonas.add(a1);
			System.out.println("El alumno ha sido dado de alta correctamente.");
		}
	}
	
	
	public void darAltaProfesor() {
		System.out.println("Escriba su nombre:");
		String nombre = sc.next();
		System.out.println("Escriba sus apellidos:");
		String apellidos = sc.next();
		System.out.println("Escriba su DNI:");
		String dni = sc.next();
		System.out.println("Escriba su contrasena:");
		String contrasena = sc.next();
		System.out.println("Escriba su ID de profesor:");
		String id = sc.next();
		System.out.println("¿De cuantos módulos será usted docente?");
		int numero = sc.nextInt();
		sc.nextLine();
		ArrayList<Modulos>nombreModulos = new ArrayList<Modulos>();
		for (int i = 1; i<=numero; i++) {
			System.out.println("Introduce el nombre del módulo " + i + ":");
			String modulos1 = sc.nextLine();
			Modulos alta = new Modulos(modulos1);
			nombreModulos.add(alta);
		}		
		Profesores p = buscarProfesor(id);
		if (p != null) {
			System.out.println("Este profesor ya está dado de alta en el sistema.");
			System.out.println("Vuelva a intentarlo.");
		} else {
		Profesores p1 = new Profesores(nombre, apellidos, dni, contrasena, id, nombreModulos);
		this.listadoPersonas.add(p1);
		System.out.println("Profesor dado de alta correctamente.");
		}
	}

	public void verModulosMatriculados(Alumnos a) {
		if (a.modulosMatriculados.isEmpty()) {
			System.out.println("Usted no está matriculado en ningún módulo");
		} else {
			System.out.println("Usted está matriculado en los siguientes módulos:");
		for (Modulos m: a.modulosMatriculados) {
			System.out.println("- " + m.getNombre());
		}
		}
	}
	
	public void perfilAlumno(Alumnos a) {
		int opcion = 0;
	  do {
	   System.out.println("¿Desea matricularse de alguna asignatura o ver las notas de las asignaturas matriculadas?");
 	   System.out.println("1.- Matricularme.");
 	   System.out.println("2.- Ver modulos matriculados");
 	   System.out.println("3.- Ver notas");
 	   System.out.println("4.- Salir");
 	   opcion = sc.nextInt();
 	   
 	   switch (opcion) {
 	   case 1:
 		  matricula(sc, a);
 		  break;
 	   case 2:
 		  verModulosMatriculados(a);
 		  break;
 	   case 3:
 		  for (Modulos m: a.modulosMatriculados) {
 			 System.out.println(m.getNombre() + ": " + m.getCalificacion());
 		  }
 		  break;
 	   } 
	  }while (opcion != 4);
	}
	
	public void matricula(Scanner sc, Alumnos a) {
	
		System.out.println("Marque con un 1 si se quiere matricular y con un 2 si no quiere hacerlo.");
		System.out.println("Lengua");
		int m = sc.nextInt();
		while (m != 1 && m != 2) {
			System.out.println("Seleccione una opción válida.");
			m = sc.nextInt()
;		}
			if (m == 1) {
				Modulos mo1 = new Modulos("lengua", 200);
				a.modulosMatriculados.add(mo1);
				System.out.println("Modulo matriculado correctamente");
			} else if (m == 2){
				System.out.println("No te matricularas de este modulo.");
			}
		
			System.out.println("Matematicas");
			int m2 = sc.nextInt();
			while (m2 != 1 && m2 != 2) {
				System.out.println("Seleccione una opción válida.");
				m2 = sc.nextInt()
	;		}
				if (m2 == 1) {
					Modulos mo2 = new Modulos("matematicas", 100);
					a.modulosMatriculados.add(mo2);
					System.out.println("Modulo matriculado correctamente");
				} else if (m2 == 2){
					System.out.println("No te matricularas de este modulo.");
				}
				
				System.out.println("Ingles");
				int m3 = sc.nextInt();
				while (m3 != 1 && m3 != 2) {
					System.out.println("Seleccione una opción válida.");
					m3 = sc.nextInt()
		;		}
					if (m3 == 1) {
						Modulos mo3 = new Modulos("ingles", 200);
						a.modulosMatriculados.add(mo3);
						System.out.println("Modulo matriculado correctamente");
					} else if (m3 == 2){
						System.out.println("No te matricularas de este modulo.");
					}
	}
	
	public void perfilProfesor(Profesores p) {
		
		int opcion = 0;
		do {
			System.out.println("¿Qué desea hacer?.");
			System.out.println("1.- Ver tus modulos.");
			System.out.println("2.- Calificar a alumnos en tus modulos.");
			System.out.println("3.- Salir.");
			opcion = sc.nextInt();
			
			switch (opcion) {
			
			case 1:
				for (Modulos m: p.getModulos()) {
					System.out.println(m.getNombre());
				}
				break;
				
			case 2: 
				System.out.println("Escribe el id del alumno al que quieres calificar.");
				String id = sc.next();
				int contador = 0;
				Alumnos a = buscarAlumnos(id);
				if (a == null) {
					System.out.println("Este alumno no está dado de alta.");
				} else {
					System.out.println("¿De que módulo deseas calificar a este alumno?");
					for (Modulos m: a.modulosMatriculados) {
						contador ++;
						System.out.println(contador + ".-" + m.getNombre());
					}	
					System.out.println("Escriba el nombre del módulo tal y como aparece en la lista.");
					String n = sc.next();
					for (Modulos m: p.getModulos()) {
						if (m.getNombre().equals(n)) {
							System.out.println("Escribe la nota de la calificacion:");
							double nota = sc.nextDouble();
							for (Modulos m1: a.modulosMatriculados) {
								if (m1.getNombre().equals(n)) {
									m1.setCalificacion(nota);
								} else {
									System.out.println("Esta calificaion no es valida.");
								}
							}
						} else {
							System.out.println("Ese modulo no le corresponde a usted como profesor.");
						}
					}
				}
				break;
			}
			
		} while (opcion != 3);
	}
	
}
