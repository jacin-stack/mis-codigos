import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Modulos m = new Modulos();
		CentroEducativo c = new CentroEducativo();
		Registro r = new Registro();
		Alumnos a = new Alumnos();
		Profesores p = new Profesores();
		int flujo = 0;
		
        
        Alumnos a1 = new Alumnos("jacinto", "gomez", "1234", "1234", "01", "1d");
        c.listadoPersonas.add(a1);
        
        
        do {
        System.out.println("¿Deseas empezar o continuar?");
        System.out.println("1.- Si");
        System.out.println("2.- No");
        flujo = sc.nextInt();
      
        r.setVisible(true);
        
        String nombre = r.getUsuario();
        String contrasena = r.getContrasena();
        
        Personas personas = c.buscarPersona(nombre, contrasena);
       if(personas != null) {
    	   System.out.println("Ya estas dado de alta.");
    	   System.out.println("Entrando en tu perfil.");
    	   if (personas instanceof Alumnos) {
    		   c.perfilAlumno((Alumnos) personas);
    	   } else if (personas instanceof Profesores) {
    		   c.perfilProfesor((Profesores) personas);
    	   }
       } else {
    	   System.out.println("Esta persona no esta dada de alta.");
    	   System.out.println("¿Desea darla de alta en el sistema?");
    	   System.out.println("1.- Si");
    	   System.out.println("2.- No");
    	   int respuesta = sc.nextInt();
    	   if (respuesta == 1) {
    		   System.out.println("¿Eres alumno o profesor?");
    		   System.out.println("1.- Alumno");
        	   System.out.println("2.- Profesor");
        	   int respuesta1 = sc.nextInt();
        	   if (respuesta1 == 1) {
        		   c.darAltaAlumno();
        	   } if (respuesta1 == 2) {
        		   c.darAltaProfesor();
        	   } else {
        		   System.out.println("Opción incorrecta.");
        	   }
    	   } else if (respuesta == 2) {
    		   System.out.println("Saliendo del sistema");
    	   } else {
    		   System.out.println("Opción incorrecta.");
    	   }
       }
        } while (flujo != 2);
	}
}
