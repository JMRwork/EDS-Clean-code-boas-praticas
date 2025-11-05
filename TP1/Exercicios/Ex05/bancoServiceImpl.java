package Exercicios.Ex05;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class bancoServiceImpl implements bancoService {
	List<Conta> contas = new ArrayList<Conta>();

	@Override
	public void criarConta(String titulo, double saldoInicial) {
		Conta novaConta = new Conta(titulo, saldoInicial);
		contas.add(novaConta);
	}

	@Override
	public Optional<Conta> buscarConta(String titulo) {
		return contas.stream().filter(conta -> conta.getTitulo().equals(titulo)).findFirst();
	}

	@Override
	public void transferir(String tituloOrigem, String tituloDestino, double valor) {
		Optional<Conta> contaOrigem = buscarConta(tituloOrigem);
		Optional<Conta> contaDestino = buscarConta(tituloDestino);
		if (contaOrigem.isPresent() && contaDestino.isPresent() && contaOrigem.get().getSaldo() >= valor) {
			contaOrigem.get().debitar(valor);
			contaDestino.get().creditar(valor);
			System.out.println("Transção realizada com sucesso.");
		} else {
			System.out.println("Erro na transferencia.");
		}
	}

}
