package br.edu.infnet.appFrete.service;

import java.math.BigDecimal;

import br.edu.infnet.appFrete.factory.CalculadoraFreteFactory;
import br.edu.infnet.appFrete.model.Entrega;
import br.edu.infnet.appFrete.service.calculadora.CalculadoraFrete;

public class EntregaService {
	private final Entrega entrega;
	
	public EntregaService(Entrega entrega) {
		this.entrega = entrega;
	}

	public BigDecimal calcularFrete() {
		if(PromocaoService.isFreteGratis(entrega)) {
			return BigDecimal.ZERO;
		}	
		CalculadoraFrete calculadora = CalculadoraFreteFactory.getCalculadora(entrega.getTipoFrete());
        return calculadora.calcular(PromocaoService.getPesoComDesconto(entrega.getPeso()));
		
    }
}
