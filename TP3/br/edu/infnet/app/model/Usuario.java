package br.edu.infnet.app.model;

public class Usuario {
	String nome;
	String email;
	String cargo;
	
	public Usuario(String nome, String email, String cargo) {
		super();
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void atualizarEmail(String novoEmail) {
		setEmail(novoEmail);
	}
	
	public void definirCargo(String novoCargo) {
		setCargo(novoCargo);
	}
}
