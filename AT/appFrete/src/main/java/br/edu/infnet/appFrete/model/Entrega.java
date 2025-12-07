package br.edu.infnet.appFrete.model;

import java.math.BigDecimal;

public class Entrega {
	 private final String endereco;
	    private BigDecimal peso;
	    private final TipoFrete tipoFrete;
	    private final String destinatario;
	    
	    public Entrega(String endereco, BigDecimal peso, TipoFrete tipoFrete, String destinatario) {
	        validarParametros(endereco, peso, destinatario);
	        
	        this.endereco = endereco.trim();
	        this.peso = peso;
	        this.tipoFrete = tipoFrete;
	        this.destinatario = destinatario.trim();
	    }
	    
	    private void validarParametros(String endereco, BigDecimal peso, String destinatario) {
	        if (endereco == null || endereco.trim().isEmpty()) {
	            throw new IllegalArgumentException("Endereço não pode ser vazio");
	        }
	        if (peso.compareTo(BigDecimal.ZERO) < 0) {
	            throw new IllegalArgumentException("Peso deve ser maior que zero");
	        }
	        if (destinatario == null || destinatario.trim().isEmpty()) {
	            throw new IllegalArgumentException("Destinatário não pode ser vazio");
	        }
	    }
	    
	    
	    public String getEndereco() { return endereco; }
	    public BigDecimal getPeso() { return peso; }
	    public TipoFrete getTipoFrete() { return tipoFrete; }
	    public String getDestinatario() { return destinatario; }
}
