package br.com.augustogiacomini.loja.desconto;

import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoQuantidadeItens extends Desconto {

    public DescontoQuantidadeItens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQtItens() > 5;
    }
}
