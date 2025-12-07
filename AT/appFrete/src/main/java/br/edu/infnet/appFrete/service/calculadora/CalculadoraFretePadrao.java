package br.edu.infnet.appFrete.service.calculadora;

import java.math.BigDecimal;

import br.edu.infnet.appFrete.model.TipoFrete;

public class CalculadoraFretePadrao implements CalculadoraFrete {
	
	@Override
	public BigDecimal calcular(BigDecimal peso) {
		return peso
				.multiply(TipoFrete.PADRAO.getMultiplicador());
	}
	
	@Override
	public boolean verificaTipo(String codigoFrete) {
		return TipoFrete.fromCodigo(codigoFrete).equals(TipoFrete.PADRAO);
	}
}
