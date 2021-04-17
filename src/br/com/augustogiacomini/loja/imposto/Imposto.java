package br.com.augustogiacomini.loja.imposto;

import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public interface Imposto {

    BigDecimal calcular(Orcamento orcamento);
}
