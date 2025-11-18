package Ex02;

public class Desconto {
	final double FRACAO_DESCONTO = 0.1;
	final double VALOR_LIMITE = 1000;
	
	public double calcular(double preco) {
        return alcancouValorLimite(preco) ? preco * (1 - FRACAO_DESCONTO) : preco;
    }
	
	public boolean alcancouValorLimite(double preco) {
		return preco >= VALOR_LIMITE;
	}
}
