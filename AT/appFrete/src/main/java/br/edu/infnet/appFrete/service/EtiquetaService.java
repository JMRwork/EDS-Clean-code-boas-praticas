package br.edu.infnet.appFrete.service;

import java.math.BigDecimal;

import br.edu.infnet.appFrete.model.Entrega;
import br.edu.infnet.appFrete.service.calculadora.CalculadoraFrete;
import br.edu.infnet.appFrete.service.etiqueta.Etiqueta;

public class EtiquetaService {
	private CalculadoraFrete calculadoraFrete;

	public EtiquetaService(CalculadoraFrete calculadora) {
		this.calculadoraFrete = calculadora;
	}

	public String gerarEtiqueta(Entrega entrega) {
		Etiqueta etiqueta = builder(entrega);
		return etiqueta.gerarEtiqueta();
	}

	public String gerarResumo(Entrega entrega) {
		Etiqueta etiqueta = builder(entrega);
		return etiqueta.gerarResumo();
	}

	public Etiqueta builder(Entrega entrega) {
		String destinatario = entrega.getDestinatario();
		String endereco = entrega.getEndereco();
		String codigoFrete = entrega.getTipoFrete().getCodigo();
		double valorFrete;
		if (calculadoraFrete.verificaTipo(codigoFrete)) {
			if (PromocaoService.isFreteGratis(entrega)) {
				valorFrete = BigDecimal.ZERO.doubleValue();
			} else {
				valorFrete = calculadoraFrete.calcular(entrega.getPeso()).doubleValue();
			}
			return new Etiqueta(destinatario, endereco, codigoFrete, valorFrete);
		} else {
			throw new IllegalArgumentException("Conflito entre tipo de frete e tipo de calculadora.");
		}
	}
}
