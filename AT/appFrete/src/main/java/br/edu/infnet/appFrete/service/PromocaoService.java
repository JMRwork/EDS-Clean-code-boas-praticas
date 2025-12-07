package br.edu.infnet.appFrete.service;

import java.math.BigDecimal;

import br.edu.infnet.appFrete.model.Entrega;
import br.edu.infnet.appFrete.model.TipoFrete;

public class PromocaoService {
	private static final BigDecimal PESO_LIMITE_DESCONTO = BigDecimal.valueOf(10.0);
    private static final BigDecimal DESCONTO_PESO = BigDecimal.valueOf(1.0);
    private static final BigDecimal PESO_LIMITE_GRATUIDADE = BigDecimal.valueOf(2.0);
    
    public static BigDecimal getPesoComDesconto(BigDecimal peso) {
        if (peso.compareTo(PESO_LIMITE_DESCONTO) > 0) {
            return peso.subtract(DESCONTO_PESO).setScale(1);
        }
        return peso;
    }
    
    public static boolean isFreteGratis(Entrega entrega) {
        return entrega.getTipoFrete() == TipoFrete.ECONOMICO && entrega.getPeso().compareTo(PESO_LIMITE_GRATUIDADE) < 0;
    }
}
