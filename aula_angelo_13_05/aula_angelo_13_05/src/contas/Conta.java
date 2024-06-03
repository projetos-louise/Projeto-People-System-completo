package contas;

public class Conta {
	private int numero;
	private double saldo;
	
	public Conta() {
		System.out.println("Conta vazia criada!");
	}

	public Conta(int numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public boolean sacar(double valor) {
		if(this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean depositar(double valor) {
		if(valor >= 0) {
			this.saldo = this.saldo + valor;
			return true;
		} else {
			return false;
		}
	}
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;
	}
	
	
}


