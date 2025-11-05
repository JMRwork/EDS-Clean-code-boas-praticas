package Exercicios.Ex07;

public class SaldoInvalido extends IllegalArgumentException{
	public SaldoInvalido(String message) {
		super(message);
	}

}

public class ValorInvalido extends IllegalArgumentException{
	public ValorInvalido(String message) {
		super(message);
	}

}

public class TitularInvalido extends IllegalArgumentException{
	public TitularInvalido(String message) {
		super(message);
	}

}