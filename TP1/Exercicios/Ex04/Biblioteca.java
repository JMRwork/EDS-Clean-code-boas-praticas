package Exercicios.Ex04;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	Exibidor display;
	List<Livro> livros;
	
	public Biblioteca(Exibidor display) {
		this.display = display;
		this.livros = new ArrayList<Livro>();
	}
	
	public void adicionarLivro(String titulo) {
		Livro novoLivro = new Livro(titulo, true);
		livros.add(novoLivro);
		this.display.exibir("Livro adicionado: " + titulo);
	}
	
	public void emprestarLivro(String titulo) {
		for(Livro livro: livros) {
			if(livro.getTitulo() == titulo && livro.estaDisponivel()) {
				livro.setDisponibilidade(false);
				this.display.exibir("Livro emprestado: " + livro.getTitulo());
				return;
			}
		}
		this.display.exibir("Livro não disponível");
	}
	
	public void devolverLivro(String titulo) {
		for(Livro livro: livros) {
			if(livro.getTitulo() == titulo) {
				livro.setDisponibilidade(true);
				this.display.exibir("Livro devolvido: " + livro.getTitulo());
				return;
			}
		}
		this.display.exibir("Livro não encontrado no sistema");
	}
}
