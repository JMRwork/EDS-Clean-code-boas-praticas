package br.edu.infnet.app.model;


public class Tarefa {
	private final String titulo;
	private final String descricao;
	private final Status status;
	private final Usuario responsavel;
	
	public Tarefa(String titulo, String descricao,Status status, Usuario responsavel) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.responsavel = responsavel;
	}	
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public Usuario getResponsavel() {
		return responsavel;
	}
	
	public Tarefa atribuirResponsavel(Usuario novoResponsavel) {
		return new Tarefa(this.titulo, this.descricao, this.status , novoResponsavel);
	}
	
	public Tarefa alterarStatus(Status novoStatus) {
		return new Tarefa(this.titulo, this.descricao, novoStatus , this.responsavel);
	}
	
	public String exibirDetalhes() {
		return "%s - %s\n%s\nResponsável:%s".formatted(titulo, status.toString(), descricao, responsavel.toString());
	}
	
}
