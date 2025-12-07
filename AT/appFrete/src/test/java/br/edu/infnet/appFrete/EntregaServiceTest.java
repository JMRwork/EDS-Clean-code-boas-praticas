package br.edu.infnet.appFrete;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.edu.infnet.appFrete.model.Entrega;
import br.edu.infnet.appFrete.model.TipoFrete;
import br.edu.infnet.appFrete.service.EntregaService;

public class EntregaServiceTest {
	public Entrega entrega;	
	
	@Test
	void entregaCalculoExpressValido() {
		entrega = new Entrega("endereco teste", BigDecimal.valueOf(8), TipoFrete.EXPRESS, "destinatario teste");
		EntregaService service = new EntregaService(entrega);
		assertTrue(service.calcularFrete().compareTo(BigDecimal.valueOf(22.0)) == 0);
	}
	
	@Test
	void entregaCalculoPadraoValido() {
		entrega = new Entrega("endereco teste", BigDecimal.valueOf(8), TipoFrete.PADRAO, "destinatario teste");
		EntregaService service = new EntregaService(entrega);
		assertTrue(service.calcularFrete().compareTo(BigDecimal.valueOf(9.6)) == 0);
	}
	
	@Test
	void entregaCalculoEconomicoValido() {
		entrega = new Entrega("endereco teste", BigDecimal.valueOf(8), TipoFrete.ECONOMICO, "destinatario teste");
		EntregaService service = new EntregaService(entrega);
		assertTrue(service.calcularFrete().compareTo(BigDecimal.valueOf(3.8)) == 0);
	}	
	
	@Test
	void entregaCalculoPadraoComDescontoPesoValido() {
		entrega = new Entrega("endereco teste", BigDecimal.valueOf(11), TipoFrete.PADRAO, "destinatario teste");
		EntregaService service = new EntregaService(entrega);
		assertTrue(service.calcularFrete().compareTo(BigDecimal.valueOf(12.0)) == 0);
	}
	
}
