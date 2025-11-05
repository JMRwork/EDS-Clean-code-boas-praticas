package Exercicios.Ex05;

public class Conta {
	private String titulo;
	private double saldo;
	
	public Conta(String titulo, double saldo) {
		this.titulo = titulo;
		this.saldo = saldo;
	}

	public String getTitulo() {
		return titulo;
	}


	public double getSaldo() {
		return saldo;
	}

	public void creditar(double valor) {
		this.saldo += valor;
	}
	
	public void debitar(double valor) {
		this.saldo -= valor;
	}
	
	
}
