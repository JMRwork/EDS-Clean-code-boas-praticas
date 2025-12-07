package br.edu.infnet.appFrete.model;

import java.math.BigDecimal;

public enum TipoFrete {
    EXPRESS("EXP", BigDecimal.valueOf(1.5), BigDecimal.valueOf(10.0)),
    PADRAO("PAD", BigDecimal.valueOf(1.2), BigDecimal.valueOf(0.0)),
    ECONOMICO("ECO", BigDecimal.valueOf(1.1), BigDecimal.valueOf(-5.0));
    
    private final String codigo;
    private final BigDecimal multiplicador;
    private final BigDecimal ajuste;
    
    TipoFrete(String codigo, BigDecimal multiplicador, BigDecimal ajuste) {
        this.codigo = codigo;
        this.multiplicador = multiplicador;
        this.ajuste = ajuste;
    }
    
    public String getCodigo() { return codigo; }
    public BigDecimal getMultiplicador() { return multiplicador; }
    public BigDecimal getAjuste() { return ajuste; }
    
    public static TipoFrete fromCodigo(String codigo) {
        for (TipoFrete tipo : values()) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de frete inválido: " + codigo);
    }
}