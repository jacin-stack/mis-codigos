import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		String iban, nombre, pin;
		double saldo;
		Scanner sc = new Scanner (System.in);
		
		cuentas c1 = new cuentas();
		c1.setTitular("Jacinto es el mejor");
		System.out.println("Iban: "+c1.getIBAN());
		System.out.println("Titular: "+c1.getTitular());
		
		
		System.out.println("Dime el iban: ");
		iban=sc.next();
		System.out.println("Dime el titular: ");
		nombre=sc.next();
		cuentas c2 = new cuentas(iban,nombre);
		System.out.println("Iban2: "+c2.getIBAN());
		System.out.println("Titular2: "+c2.getTitular());
		System.out.println("Saldo2: "+c2.getSaldo());
		
		
	}

}
