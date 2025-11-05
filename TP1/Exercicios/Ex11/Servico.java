package Exercicios.Ex11;

public class Servico {
	public void processar(String dado) {
		try {
			System.out.println("Processando: " + dado.toUpperCase());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
