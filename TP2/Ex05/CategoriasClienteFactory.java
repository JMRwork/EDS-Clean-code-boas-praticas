package Ex05;

import java.util.Arrays;
import java.util.List;

public class CategoriasClienteFactory {
	public static List<CategoriaCliente> getCategorias() {
		return Arrays.asList(
				new SenioridadePremium(),
				new SenioridadeRegular(),
				new SenioridadeBaixaRenda(),
				new JovemPremium(),
				new JovemRegular(),
				new JovemBaixaRenda()
		);
	}
}
