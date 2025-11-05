package Exercicios.Ex03;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	private List<Produto> produtos;
	
	public CarrinhoDeCompras() {
		this.produtos = new ArrayList<Produto>();
	}
	
	public void adicionarProduto(String nome, double preco, int quantidade) {
		this.produtos.add(new Produto(nome, preco, quantidade));
	}
	
	public double calcularTotal() {
		double total = 0D;
		
		for(Produto produto: this.produtos) {
			total += produto.obterValor();
		}
		
		return total;
	}
	
	public void exibirTotal(Exibidor exibidor) {
		exibidor.exibir(calcularTotal());
	}
}
