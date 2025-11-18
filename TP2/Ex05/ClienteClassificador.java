package Ex05;

import java.util.List;
import java.util.NoSuchElementException;

public class ClienteClassificador {
	private final List<CategoriaCliente> categoriasCliente;

	public ClienteClassificador() {
		this.categoriasCliente = CategoriasClienteFactory.getCategorias();
	}

	public String classificarCliente(int idade, double renda, int compras, String localizacao) {
		try {
			return categoriasCliente.stream()
					.takeWhile(categoria -> categoria.aplicavel(idade, renda, compras, localizacao))
					.findFirst()
					.get()
					.getCategoria();
		} catch (NoSuchElementException e) {
			return "Categoria Indefinida";
		}
	}
}
