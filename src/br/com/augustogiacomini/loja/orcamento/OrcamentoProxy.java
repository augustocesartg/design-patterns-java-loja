package br.com.augustogiacomini.loja.orcamento;

import java.math.BigDecimal;

/**
 * Utilizado Padrão Proxy - para melhorar performance, criando um cache do valor do orçamento.
 */
public class OrcamentoProxy implements Orcavel {

    private BigDecimal valor;

    private Orcamento orcamento;

    public OrcamentoProxy(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getValor() {
        if (valor == null) {
            this.valor = orcamento.getValor();
        }
        return this.valor;
    }


}
