package br.edu.infnet.appFrete;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.edu.infnet.appFrete.model.TipoFrete;

public class TipoFreteTest {
	@Test
	void tipoFreteFromCodigoValido() {
		assertDoesNotThrow(() -> {TipoFrete.fromCodigo("EXP");});
	}

	@Test
	void tipoFreteFromCodigoInvalido() {
		assertThrows(IllegalArgumentException.class, ()->{TipoFrete.fromCodigo("CODINX");});
	}
}
