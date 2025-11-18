package Ex08;

public class ContaBancaria {
	private double saldo;

	public ContaBancaria(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	public boolean podeComprar(double valor) {
		return saldo >= valor;

	}

	public boolean efetuarCompra(double valor) {
		if (podeComprar(valor)) {
			saldo -= valor; 
			return true;
		}
		return false;
	}
}
