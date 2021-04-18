package br.com.augustogiacomini.loja.imposto;

import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Utilizado Padrão Decorator - para poder decorar (compor) um objeto com outro, ou seja,
 * permite adicionar novos comportamentos a um objeto, tornando o código bastante flexível e dinâmico.
 * Neste caso, conseguimos flexibilizar o cálculo de deferentes impostos de um orçamento,
 * posso passar quantos impostos for necessário para calcular o imposto.
 */
public abstract class Imposto {

    private Imposto outroImposto;

    public Imposto(Imposto outroImposto) {
        this.outroImposto = outroImposto;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento) {
        BigDecimal valorImposto = realizarCalculo(orcamento);
        BigDecimal valorOutroImposto = outroImposto != null ? outroImposto.realizarCalculo(orcamento) : BigDecimal.ZERO;

        return valorImposto.add(valorOutroImposto);
    }
}
