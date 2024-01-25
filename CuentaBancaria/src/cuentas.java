
public class cuentas {
	String IBAN, titular, pin;
	double saldo;
	
	
	public cuentas() {
		
	}


	public cuentas(String iBAN, String titular) {
		IBAN = iBAN;
		this.titular = titular;
	}


	public cuentas(String iBAN, String titular, double saldo) {
		IBAN = iBAN;
		this.titular = titular;
		this.saldo = saldo;
	}


	public cuentas(String iBAN, String titular, String pin, double saldo) {
		IBAN = iBAN;
		this.titular = titular;
		this.pin = pin;
		this.saldo = saldo;
	}


	public String getIBAN() {
		return IBAN;
	}


	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void ingresarDinero(double cantidad) {
		saldo+=cantidad;
	}
	
	public void retirarDinero(double cantidad) {
		saldo-=cantidad;
	}
	
	
}
