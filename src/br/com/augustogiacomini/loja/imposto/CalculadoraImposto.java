package br.com.augustogiacomini.loja.imposto;

import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Utilizado Padrão Strategy - para evitar validação de tipo de imposto.
 */
public class CalculadoraImposto {

    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
        return imposto.calcular(orcamento);
    }
}
