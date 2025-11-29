package br.edu.infnet.app.repository;

import java.io.ObjectInputFilter.Status;
import java.util.List;
import java.util.Optional;

import br.edu.infnet.app.model.Tarefa;

public interface TarefaRepository {
	    Optional<Tarefa> findByTitulo(String Titulo);
	    Tarefa save(Tarefa task);
	    List<Tarefa> findByStatus(Status status);
	    List<Tarefa> findByAssignee(String assigneeId);
}
