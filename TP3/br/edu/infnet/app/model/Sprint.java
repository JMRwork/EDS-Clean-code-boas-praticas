package br.edu.infnet.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sprint {
	String nome;
	Date dataInicio;
	Date dataFim;
	List<Tarefa> tarefas;
	public Sprint(String nome, Date dataInicio, Date dataFim, List<Tarefa> tarefas) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tarefas = tarefas;
	}
	public String getNome() {
		return nome;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}

	public Sprint adicionarTarefa(Tarefa tarefa) {
		List<Tarefa> novasTarefas = new ArrayList<Tarefa>(this.tarefas);
		novasTarefas.add(tarefa);
		return new Sprint(this.nome, this.dataInicio, this.dataFim, this.tarefas);
	}
	
	public Sprint removerSprint(Tarefa tarefa) {
		List<Tarefa> novasTarefas = new ArrayList<Tarefa>(this.tarefas);
		novasTarefas.remove(tarefa);
		return new Sprint(this.nome, this.dataInicio, this.dataFim, this.tarefas);
	}
	
	public String listarSprints() {
		String lista = "Lista de Tarefas:\n";
		tarefas.stream().forEach(tarefa -> {
			lista
				.concat(tarefa.exibirDetalhes())
				.concat("\n\n");
		});
		return lista;
	}
	
	@Override
	public String toString() {
		return "%s - Quantidade de tarefas: %s\nData de Início: %s\nData de Fim: %s"
				.formatted(nome, tarefas.toArray().length, dataInicio, dataFim);
		
	}
	
}
