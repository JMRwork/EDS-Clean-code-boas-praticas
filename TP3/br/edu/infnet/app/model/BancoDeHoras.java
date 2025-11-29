package br.edu.infnet.app.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class BancoDeHoras {
	private final String Id;
	private final String descricao;
	private final int quantidade;
	private final BigDecimal custoUnidade;
	private final BigDecimal custoTotal;

	private BancoDeHoras(String Id, String descricao, int quantidade, BigDecimal custoUnidade) {
	        if (Id == null || Id.trim().isEmpty()) {
	            throw new IllegalArgumentException("ID do Banco de Horas não pode ser nulo ou vazio");
	        }
	        if (quantidade < 0) {
	            throw new IllegalArgumentException("Quantidade não pode ser negativa");
	        }
	        if (custoUnidade == null || custoUnidade.compareTo(BigDecimal.ZERO) < 0) {
	            throw new IllegalArgumentException("Custo unitário não pode ser nulo ou negativo");
	        }

	        this.Id = Id.trim();
	        this.descricao = descricao != null ? descricao.trim() : "";
	        this.quantidade = quantidade;
	        this.custoUnidade = custoUnidade;
	        this.custoTotal = custoUnidade.multiply(BigDecimal.valueOf(quantidade));
	    }

	public static BancoDeHoras create(String Id, String descricao, int quantidade, BigDecimal custoUnidade) {
		return new BancoDeHoras(Id, descricao, quantidade, custoUnidade);
	}

	
	public String getId() {
		return Id;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getCustoUnidade() {
		return custoUnidade;
	}

	public BigDecimal getCustoTotal() {
		return custoTotal;
	}

	
	public BancoDeHoras alterarQuantidade(int novaQuantidade) {
		return new BancoDeHoras(this.Id, this.descricao, novaQuantidade, this.custoUnidade);
	}

	public BancoDeHoras alterarCustoUnidade(BigDecimal novoCustoUnidade) {
		return new BancoDeHoras(this.Id, this.descricao, this.quantidade, novoCustoUnidade);
	}

	public BancoDeHoras alterarDescricao(String newDescription) {
		return new BancoDeHoras(this.Id, newDescription, this.quantidade, this.custoUnidade);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BancoDeHoras bancoDeHoras = (BancoDeHoras) o;
		return Objects.equals(Id, bancoDeHoras.Id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public String toString() {
		return String.format("%s - %d horas a R$%.2f = R$%.2f]", Id, quantidade, custoUnidade, custoTotal);
	}
}
