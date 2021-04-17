package br.com.augustogiacomini.loja.desconto;

import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoValorOrcamento extends Desconto {

    public DescontoValorOrcamento(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }
}
