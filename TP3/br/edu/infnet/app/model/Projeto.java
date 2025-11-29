package br.edu.infnet.app.model;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	String nome;
	String descricao;
	List<Sprint> sprints;
	
	public Projeto(String nome, String descricao, List<Sprint> sprints) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.sprints = sprints;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescrição() {
		return descricao;
	}
	
	public Projeto adicionarSprint(Sprint sprint) {
		List<Sprint> novosSprints = new ArrayList<Sprint>(this.sprints);
		novosSprints.add(sprint);
		return new Projeto(this.nome, this.descricao, novosSprints);
	}
	
	public Projeto removerSprint(Sprint sprint) {
		List<Sprint> novosSprints = new ArrayList<Sprint>(this.sprints);
		novosSprints.add(sprint);
		return new Projeto(this.nome, this.descricao, novosSprints);
	
	}
	
	public String listarSprints() {
		String lista = "Lista de Sprints:\n";
		sprints.stream().forEach(sprint -> {
			lista
				.concat(sprint.toString())
				.concat("\n");
		});
		return lista;
	}
	
}
