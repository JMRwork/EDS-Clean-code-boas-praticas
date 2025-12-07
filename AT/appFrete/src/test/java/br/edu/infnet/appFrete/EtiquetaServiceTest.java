package br.edu.infnet.appFrete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.edu.infnet.appFrete.model.Entrega;
import br.edu.infnet.appFrete.model.TipoFrete;
import br.edu.infnet.appFrete.service.EntregaService;
import br.edu.infnet.appFrete.service.EtiquetaService;
import br.edu.infnet.appFrete.service.calculadora.CalculadoraFreteEconomico;
import br.edu.infnet.appFrete.service.calculadora.CalculadoraFreteExpresso;

public class EtiquetaServiceTest {
	public Entrega entrega;
	
	
	@Test
	void geraEtiquetaEntregaValido() {
		entrega = new Entrega("endereco teste", BigDecimal.valueOf(8), TipoFrete.EXPRESS, "destinatario teste");
		EtiquetaService service = new EtiquetaService(new CalculadoraFreteExpresso());
		assertEquals("""
	            Destinatário: destinatario teste
	            Endereço: endereco teste
	            Tipo de Frete: EXP
	            Valor do Frete: R$22,00
	            """, service.gerarEtiqueta(entrega));
	}
	
	@Test
	void gerarResumoEntregaValido() {
		entrega = new Entrega("endereco teste", BigDecimal.valueOf(8), TipoFrete.EXPRESS, "destinatario teste");
		EtiquetaService service = new EtiquetaService(new CalculadoraFreteExpresso());
		assertEquals("Pedido para destinatario teste com frete EXP no valor de R$22,00", service.gerarResumo(entrega));
	}
	
	@Test
	void geraEtiquetaEntregaGratisValido() {
		entrega = new Entrega("endereco teste", BigDecimal.valueOf(1), TipoFrete.ECONOMICO, "destinatario teste");
		EtiquetaService service = new EtiquetaService(new CalculadoraFreteEconomico());
		assertEquals("""
	            Destinatário: destinatario teste
	            Endereço: endereco teste
	            Tipo de Frete: ECO
	            Valor do Frete: GRÁTIS
	            """, service.gerarEtiqueta(entrega));
	}
	
	@Test
	void gerarResumoEntregaGratisValido() {
		entrega = new Entrega("endereco teste", BigDecimal.valueOf(1), TipoFrete.ECONOMICO, "destinatario teste");
		EtiquetaService service = new EtiquetaService(new CalculadoraFreteEconomico());
		assertEquals("Pedido para destinatario teste com frete ECO GRÁTIS", service.gerarResumo(entrega));
	}
}
