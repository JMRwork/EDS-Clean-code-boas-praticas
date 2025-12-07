package br.edu.infnet.appFrete.factory;

import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appFrete.model.TipoFrete;
import br.edu.infnet.appFrete.service.calculadora.CalculadoraFrete;
import br.edu.infnet.appFrete.service.calculadora.CalculadoraFreteEconomico;
import br.edu.infnet.appFrete.service.calculadora.CalculadoraFreteExpresso;
import br.edu.infnet.appFrete.service.calculadora.CalculadoraFretePadrao;

public class CalculadoraFreteFactory {
	private static final Map<TipoFrete, CalculadoraFrete> calculadoras = new HashMap<>();

	static {
		calculadoras.put(TipoFrete.EXPRESS, new CalculadoraFreteExpresso());
		calculadoras.put(TipoFrete.PADRAO, new CalculadoraFretePadrao());
		calculadoras.put(TipoFrete.ECONOMICO, new CalculadoraFreteEconomico());
	}

	public static CalculadoraFrete getCalculadora(TipoFrete tipo) {
	        CalculadoraFrete calculadora = calculadoras.get(tipo);
	        if (calculadora == null) {
	            throw new IllegalArgumentException("Tipo de frete não suportado: " + tipo);
	        }
	        return calculadora;
	 }
}
