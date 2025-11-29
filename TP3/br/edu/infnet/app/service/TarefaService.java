package br.edu.infnet.app.service;

import java.util.Optional;

import br.edu.infnet.app.model.Tarefa;
import br.edu.infnet.app.repository.TarefaRepository;

public class TarefaService {
	TarefaRepository repositorio;
	
	public TarefaService(TarefaRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public Tarefa obterTarefaPorTitulo(String Titulo) throws Exception {
		Optional<Tarefa> tarefa = repositorio.findByTitulo(Titulo);
		if(tarefa.isPresent()) {
			return tarefa.get();
		} else {
			throw new Exception();
		}
	}
}
