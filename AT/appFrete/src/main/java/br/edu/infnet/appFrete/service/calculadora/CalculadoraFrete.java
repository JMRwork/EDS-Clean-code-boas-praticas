package br.edu.infnet.appFrete.service.calculadora;

import java.math.BigDecimal;

import br.edu.infnet.appFrete.model.TipoFrete;

public interface CalculadoraFrete {
	BigDecimal calcular(BigDecimal peso);
	boolean verificaTipo(String codigoFrete);
}
