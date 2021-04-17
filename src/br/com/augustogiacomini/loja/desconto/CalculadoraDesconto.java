package br.com.augustogiacomini.loja.desconto;

import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Utilizado Padrão Chain of Responsability - para evitar vários if's chamndo o cálculo do desconto.
 */
public class CalculadoraDesconto {

    public BigDecimal calcular(Orcamento orcamento) {
        Desconto desconto = new DescontoQuantidadeItens(
                new DescontoValorOrcamento(
                        new SemDesconto()
                )
        );

        return desconto.efetuarCalculo(orcamento);
    }
}
