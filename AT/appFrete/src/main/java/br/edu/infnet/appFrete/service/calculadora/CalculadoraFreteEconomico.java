package br.edu.infnet.appFrete.service.calculadora;

import java.math.BigDecimal;

import br.edu.infnet.appFrete.model.TipoFrete;

public class CalculadoraFreteEconomico implements CalculadoraFrete {

	@Override
	public BigDecimal calcular(BigDecimal peso) {
		return peso
				.multiply(TipoFrete.ECONOMICO.getMultiplicador())
				.add(TipoFrete.ECONOMICO.getAjuste());
	}
	
	@Override
	public boolean verificaTipo(String codigoFrete) {
		return TipoFrete.fromCodigo(codigoFrete).equals(TipoFrete.ECONOMICO);
	}
}
