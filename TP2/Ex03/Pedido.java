package Ex03;

public class Pedido {
	private Cliente cliente;

	public Pedido(Cliente cliente) {
		// Caso o Cliente usado para criar o pedido seja Nulo
		if (cliente != null) {
			this.cliente = cliente;
		} else {
			this.cliente = new NullCliente();
		}
	}

	public String getNomeCliente() {
		return cliente.getNome();
	}
}
