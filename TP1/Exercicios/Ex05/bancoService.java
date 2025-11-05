package Exercicios.Ex05;

import java.util.Optional;

public interface bancoService {
	public void criarConta(String titulo, double saldo);
	public Optional<Conta> buscarConta(String titulo);
	public void transferir(String origem, String destino, double valor);
}
