package Exercicios.Ex07;

public class ContaBancaria  {
	private String titular;
	private double saldo;

	public ContaBancaria(String titular, double saldo) throws SaldoInvalido {
		if (titular == null || titular == "") {
			throw new TitularInvalido("O titular não pode ser nulo ou vazio.");
		}
		this.titular = titular;
		if (saldo < 0) {
			throw new SaldoInvalido("O saldo deve ser positivo ou zero.");
		}
		this.saldo = saldo;
	}

	public void depositar(double valor) throws ValorInvalido {
		if (valor <= 0) {
			throw new ValorInvalido("O valor do método depositar deve ser positivo.");
		}
		this.saldo += valor;
	}

	public void sacar(double valor) {
		if (valor <= 0) {
			throw new ValorInvalido("O valor do método depositar deve ser positivo.");
		}
		saldo -= valor;
	}

	public double getSaldo() {
		return saldo;
	}
}
