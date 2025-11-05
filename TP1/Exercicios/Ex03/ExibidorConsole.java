package Exercicios.Ex03;

public class ExibidorConsole implements Exibidor{
	@Override
	public void exibir(double valorTotal) {
		System.out.println("Total da compra: R$ " + valorTotal);
	}
}
