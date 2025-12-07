package br.edu.infnet.appFrete.service.etiqueta;

public class Etiqueta {
	private String destinatario;
	private String endereco;
	private String codigoFrete;
	private double valorFrete;

	public Etiqueta(String destinatario, String endereco, String codigoFrete, double valorFrete) {
		this.destinatario = destinatario;
		this.endereco = endereco;
		this.codigoFrete = codigoFrete;
		this.valorFrete = valorFrete;
	}
	
	public Etiqueta getEtiqueta() {
		return this;
	}

	public String gerarEtiqueta() {
		if (valorFrete == 0) {
			return String.format("""
					Destinatário: %s
					Endereço: %s
					Tipo de Frete: %s
					Valor do Frete: GRÁTIS
					""", destinatario, endereco, codigoFrete);
		}

		return String.format("""
				Destinatário: %s
				Endereço: %s
				Tipo de Frete: %s
				Valor do Frete: R$%.2f
				""", destinatario, endereco, codigoFrete, valorFrete);
	};

	public String gerarResumo() {
		if (valorFrete == 0) {
			return String.format("Pedido para %s com frete %s GRÁTIS", destinatario, codigoFrete);
		}

		return String.format("Pedido para %s com frete %s no valor de R$%.2f", destinatario, codigoFrete,
				valorFrete);
	}
}
