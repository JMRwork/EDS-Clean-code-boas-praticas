package Exercicios.Ex04;

public class Livro {
	private String titulo;
	private boolean disponibilidade;
	
	public Livro(String titulo, boolean disponibilidade) {
		this.titulo = titulo;
		this.disponibilidade = disponibilidade;
	}

	public String getTitulo() {
		return titulo;
	}

	public boolean estaDisponivel() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	
}
