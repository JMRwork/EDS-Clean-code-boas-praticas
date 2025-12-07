package br.edu.infnet.appFrete;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.edu.infnet.appFrete.model.Entrega;
import br.edu.infnet.appFrete.model.TipoFrete;

public class EntregaTest {
	@Test
	void novoPedidoValido() {
		assertDoesNotThrow(() -> {new Entrega("endereco", BigDecimal.valueOf(15.0), TipoFrete.PADRAO, "destinatrio");});
	}
	
	@Test
	void novoPedidoEnderecoVazioExcecao() {
		assertThrows(IllegalArgumentException.class, () -> {new Entrega("", BigDecimal.valueOf(15.0), TipoFrete.PADRAO, "destinatrio");});
	}
	
	@Test
	void novoPedidoPesoNegativoExcecao() {
		assertThrows(IllegalArgumentException.class, () -> {new Entrega("endereco", BigDecimal.valueOf(-5.0), TipoFrete.PADRAO, "destinatario");});
	}
	
	@Test
	void novoPedidoDestinatarioVazioExcecao() {
		assertThrows(IllegalArgumentException.class, () -> {new Entrega("endereco", BigDecimal.valueOf(15.0), TipoFrete.PADRAO, "");});
	}
	
}