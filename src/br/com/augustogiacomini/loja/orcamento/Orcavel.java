package br.com.augustogiacomini.loja.orcamento;

import java.math.BigDecimal;

/**
 * Utilizado Padrão Composite - Ao implementar uma interface que permita representar ItemOrcamentos e Orcamentos
 * de forma semelhante, podemos percorrer essa lista de Orcavels facilmente, para calcular o valor do orçamento,
 * que é a raiz da árvore.
 */
public interface Orcavel {

    BigDecimal getValor();
}
