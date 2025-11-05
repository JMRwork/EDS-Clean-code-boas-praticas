package Exercicios.Ex08;

/*
Pedidos com descrição geral do pedido e valor total.
*/

public class Pedido {
	private int id;
	private String descricao;
	private double valor;

	public Pedido(int id, String descricao, double valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
