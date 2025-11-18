package Ex11;

public class PedidoService {
	public void atualizarStatus(StatusPedido status) {
		String mensagem = switch (status) {
			case PENDENTE -> "O pedido está pendente.";
			case PROCESSANDO -> "O pedido está sendo processado.";
			case ENVIADO -> "O pedido foi enviado.";
			case ENTREGUE -> "O pedido foi entregue.";
		};
		System.out.println(mensagem);
	}
}
