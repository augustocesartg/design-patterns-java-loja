package br.com.augustogiacomini.loja.orcamento;

import java.math.BigDecimal;

public class OrcamentoItem implements Orcavel {

    private BigDecimal valor;

    public OrcamentoItem(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }
}
